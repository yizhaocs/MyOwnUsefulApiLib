package main.java.Threads;

/**
 * Reference: http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
 */
public class SingleThread_Runnable_Implementation implements Runnable {
    private int count;

    SingleThread_Runnable_Implementation(int count) {
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        for (int i = 0; i < count; i++) {
            System.out.print(i);
        }

        System.out.println();
    }
}