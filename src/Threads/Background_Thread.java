package Threads;

/**
 * Reference: https://www.youtube.com/watch?v=Z2YogvILjvo
 */
public class Background_Thread {
    Task mTask;

    public Background_Thread() {
        mTask = new Task();
    }

    private class Task implements Runnable {
        Thread t = null;
        boolean isItOk = false;

        private Task() {

        }

        @Override
        public void run() {
            while (isItOk) {

            }
        }

        public void pause() {
            isItOk = false;
            while (true) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            }
        }
    }
}
