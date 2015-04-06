package main.java.Threads;

/**
 * Created by yizhao on 12/19/14.
 */
public class SingleThread_Runnable_Main {
    public static void main(String[] args){
        SingleThread_Runnable_Implementation singleThread_Runnable_Implementation_1 = new SingleThread_Runnable_Implementation(10);
        SingleThread_Runnable_Implementation singleThread_Runnable_Implementation_2 = new SingleThread_Runnable_Implementation(20);
        SingleThread_Runnable_Implementation singleThread_Runnable_Implementation_3 = new SingleThread_Runnable_Implementation(30);
        SingleThread_Runnable_Implementation singleThread_Runnable_Implementation_4 = new SingleThread_Runnable_Implementation(40);
        new Thread(singleThread_Runnable_Implementation_1).start();
        new Thread(singleThread_Runnable_Implementation_2).start();
        new Thread(singleThread_Runnable_Implementation_3).start();
        new Thread(singleThread_Runnable_Implementation_4).start();
    }
}
