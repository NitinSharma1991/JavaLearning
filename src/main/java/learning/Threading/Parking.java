package learning.Threading;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class Parking {

    // Parking place occupied = true; free - false
    private static final boolean[] PARKING_PLACES = new boolean[5];
    // Set fair to true that for method acquire() guarantee order
    private static final Semaphore SEMAPHORE = new Semaphore(5, true);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }


    public static class Car implements Runnable {

        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.printf("Car #%d drive to parking \n", carNumber);

            try {
                SEMAPHORE.acquire();
                int parkingNumber = -1;
                synchronized (PARKING_PLACES) {
                    for (int i = 0; i < 5; i++) {
                        if (!PARKING_PLACES[i]) {
                            PARKING_PLACES[i] = true;
                            parkingNumber = i;
                            System.out.printf("Car #%d Parked on %d place.\n", carNumber, i);
                            break;
                        }
                    }
                }
                //Shopping!
                Thread.sleep(5000);

                synchronized (PARKING_PLACES) {
                    //Free space for car
                    PARKING_PLACES[parkingNumber] = false;
                }

                SEMAPHORE.release();
                System.out.printf("Car #%d leave the parking.\n", carNumber);
            } catch (InterruptedException ignored) {
            }
        }
    }
}