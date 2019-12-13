package com.zhao.springboot.aysnc;

import jdk.nashorn.internal.objects.annotations.Function;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @program: springboot
 * @description 测试异步框架，特别疯狂
 * @author: zhaohuan
 * @create: 2019-12-08 23:39
 **/
@Service
public class ScoreService {

    long time = System.currentTimeMillis();

    @Async("scorePoolTaskExecutor")
    public Future<String> sendRedPacket() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("send  red  packet " + Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis() - time);
        return new AsyncResult<>("恭喜你，红包发送完成");
    }

    @Async("scorePoolTaskExecutor")
    public Future<String> sendSoce() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("send  red  socre " + Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis() - time);
        return new AsyncResult<>("恭喜你，积分领取成功");
    }


}
