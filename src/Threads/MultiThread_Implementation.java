package Threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Reference: Android SDK 4.42, public class ThreadPoolExecutor extends AbstractExecutorService
 */
public class MultiThread_Implementation {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE = 1;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(128);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }
    };


    public void multiThreadDemoForSingleThread_ExtendsThreads() {
        ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        mThreadPoolExecutor.execute(new SingleThread_ExtendsThreads_Implementation(10));
        mThreadPoolExecutor.execute(new SingleThread_ExtendsThreads_Implementation(10));
        mThreadPoolExecutor.execute(new SingleThread_ExtendsThreads_Implementation(10));
        mThreadPoolExecutor.execute(new SingleThread_ExtendsThreads_Implementation(10));
    }


    public void multiThreadDemoForSingleThread_Runnable() {
        ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        SingleThread_Runnable_Implementation singleThread_Runnable_Implementation_1 = new SingleThread_Runnable_Implementation(10);

        mThreadPoolExecutor.execute(singleThread_Runnable_Implementation_1);
        mThreadPoolExecutor.execute(singleThread_Runnable_Implementation_1);
        mThreadPoolExecutor.execute(singleThread_Runnable_Implementation_1);
        mThreadPoolExecutor.execute(singleThread_Runnable_Implementation_1);
    }
}
