package com.jayus.Concurrency.example.atomic;

import com.jayus.Concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: wangjiajun
 * @date: 2020-06-16 10:04
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {
    private static AtomicReference<Integer> reference = new AtomicReference<>(0);

    public static void main(String[] args) {
        reference.compareAndSet(0,1);
        reference.compareAndSet(0,3);
        reference.compareAndSet(3,1);
        reference.compareAndSet(1,1);
        reference.compareAndSet(1,5);
        log.info("count:{}",reference.get());
    }
}
