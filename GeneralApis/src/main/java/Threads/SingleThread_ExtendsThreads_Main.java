package main.java.Threads;

/**
 * Created by yizhao on 12/19/14.
 */
public class SingleThread_ExtendsThreads_Main {
    public static void main(String[] args){
        new SingleThread_ExtendsThreads_Implementation(10).start();
        new SingleThread_ExtendsThreads_Implementation(20).start();
        new SingleThread_ExtendsThreads_Implementation(30).start();
        new SingleThread_ExtendsThreads_Implementation(40).start();
    }
}
