package learning.Threading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        int i = 0;
        while (!blockingQueue.isEmpty()) {
            try {

                System.out.println("In Consumer -> " + ++i + " " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
