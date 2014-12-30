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
        boolean isItOK = false;

        private Task() {

        }

        @Override
        public void run() {
            while (isItOK) {

            }
        }

        public void pause() {
            isItOK = false;
            while (true) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            }
        }

        public void resume() {
            isItOK = true;
            t = new Thread(this);
            t.start();
        }
    }
}
