package Threads;

/**
 * Reference: http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
 */
public class SingleThread_ExtendsThreads_Implementation extends Thread {
    private int count = 0;
    SingleThread_ExtendsThreads_Implementation(int count) {
        this.count = count;
    }

    public void run() {
        for(int i = 0; i < count; i++ ){
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        for(int i = 0; i < count; i++ ){
            System.out.print(i);
        }

        System.out.println();
    }

}
