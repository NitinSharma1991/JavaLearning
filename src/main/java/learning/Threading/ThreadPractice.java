package learning.Threading;

public class ThreadPractice {

    public static void main(String[] args) {
        String[] nitin = {"Kaka", "Nitin", "Sachin"};

        for (int i = 0; i <= nitin.length - 1; i++) {

            Thread T1 = new Thread(new MyTask());
            Thread T2 = new Thread(new MyTask());
            T1.start();
            T2.start();
            try {
                T1.join();
                T2.join();
                System.out.println("We got our names {} " + nitin[i]);
//                Thread.sleep(1000);
//                T1.interrupted();
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
        }
    }

}
