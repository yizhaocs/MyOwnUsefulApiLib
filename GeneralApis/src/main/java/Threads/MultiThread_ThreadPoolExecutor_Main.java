package main.java.Threads;

/**
 * Created by yizhao on 12/19/14.
 */
public class MultiThread_ThreadPoolExecutor_Main {
    public static void main(String[] args) {
        MultiThread_ThreadPoolExecutor_Implementation mMultiThread_Implementation = new MultiThread_ThreadPoolExecutor_Implementation();
        mMultiThread_Implementation.multiThreadDemoForSingleThread_ExtendsThreads();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMultiThread_Implementation.multiThreadDemoForSingleThread_Runnable();
    }

}
