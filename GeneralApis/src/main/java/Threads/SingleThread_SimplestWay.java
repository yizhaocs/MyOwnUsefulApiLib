package main.java.Threads;

/**
 * Created by yizhao on 12/4/14.
 */
public class SingleThread_SimplestWay {

    public static void main(String[] args){
        singleThread();
    }

    public static void singleThread(){
        new Thread(new Runnable() {
            int count = 1;
            public void run() {
                while(true) {
                    System.out.println(count++);
                }
            }
        }).start();
    }
}
