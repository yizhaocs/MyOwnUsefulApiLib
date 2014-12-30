package Threads;

/**
 * Created by yizhao on 12/29/14.
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
