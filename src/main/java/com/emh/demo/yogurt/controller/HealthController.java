package com.emh.demo.yogurt.controller;

import com.emh.demo.yogurt.service.HealthService;
import com.emh.demo.yogurt.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RestController
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("health")
    public String health() throws InterruptedException {
        CountDownLatch c = new CountDownLatch(3);
        System.out.println(Runtime.getRuntime().availableProcessors());
        long t = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            healthService.sleep(i, c);
        }
        c.await();
        System.out.println("total: " + (System.currentTimeMillis() - t));
        return "health";
    }

    public static void main(String[] args) throws InterruptedException {
        String url = "https://kunpeng.csdn.net/ad/json/list?positions=536,603,604,605,606,607";
        String res = HttpUtils.getWithHeaders(url, new HashMap<>());
        System.out.println(res);
    }
}
