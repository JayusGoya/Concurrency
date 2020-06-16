package com.jayus.Concurrency.example.atomic;

import com.jayus.Concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangjiajun
 * @date: 2020-06-15 17:16
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {
    private static Lock lock = new ReentrantLock(false);
    //请求总数
    private static int clientTotal = 5000;
    //同时并发执行的线程数
    private static int threadTotal = 200;

    private static AtomicInteger count = new AtomicInteger(0) ;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();
           /* ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                    new ThreadPoolExecutor.DiscardOldestPolicy());*/
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i <  clientTotal; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count.get());
        threadPoolExecutor.shutdown();
    }


    private static void add(){
        //先自增再获取值
        count.incrementAndGet();
        //先获取值再自增
        //count.getAndIncrement();
    }
}
