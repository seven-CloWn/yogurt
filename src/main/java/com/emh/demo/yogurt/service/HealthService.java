package com.emh.demo.yogurt.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class HealthService {

    @Async
    public void sleep(int i, CountDownLatch c) throws InterruptedException {
        System.out.println("i:" + i);
        Thread.sleep((6 - i) * 1000L);
        c.countDown();
    }
}
