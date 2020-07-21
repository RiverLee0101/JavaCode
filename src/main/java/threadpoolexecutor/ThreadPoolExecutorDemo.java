package threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5; // 核心数
    private static final int MAX_POOL_SIZE = 10; // 等待队列满了以后最大核心数
    private static final int QUEUE_CAPACITY = 10; // 等待队列长度
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 20; i++) {
            Runnable worker = new MyRunnable(" " +i);
            executor.execute(worker);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            //
        }
        System.out.println("Finished all threads");
    }

}
