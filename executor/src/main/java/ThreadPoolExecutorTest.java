import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countdown = new CountDownLatch(10);

        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = (r, executor) -> {
            System.err.println(r.toString() + " rejected");
            countdown.countDown();
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    System.out.println("new Task name:" + finalI + " is running!");
                    Thread.sleep(3000);
                    System.out.println("new Task name:" + finalI + " is completed!");
                    countdown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        countdown.await();
        System.out.println("all task completed");

    }

    private static class NameTreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("new thread:" + thread.getName());
            return thread;
        }
    }


}
