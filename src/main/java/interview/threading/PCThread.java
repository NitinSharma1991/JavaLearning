package interview.threading;

public class PCThread {

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource(10);

        Thread t1 = new Thread(() -> {
            try {
                sharedResource.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                sharedResource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        System.out.println("Main Thread will be running to find who is running");
    }
}
