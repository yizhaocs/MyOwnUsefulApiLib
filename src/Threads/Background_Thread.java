package Threads;

/**
 * Reference: https://www.youtube.com/watch?v=Z2YogvILjvo
 */
public class Background_Thread {
    Task mTask;

    public Background_Thread(){
        mTask = new Task();
    }

    private class Task implements Runnable {
        private Task(){

        }

        @Override
        public void run() {

        }
    }
}
