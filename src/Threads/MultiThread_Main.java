package Threads;

/**
 * Created by yizhao on 12/19/14.
 */
public class MultiThread_Main {
    public static void main(String[] args) {
        MultiThread_Implementation mMultiThread_Implementation = new MultiThread_Implementation();
        mMultiThread_Implementation.multiThreadDemoForSingleThread_ExtendsThreads();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMultiThread_Implementation.multiThreadDemoForSingleThread_Runnable();
    }

}
