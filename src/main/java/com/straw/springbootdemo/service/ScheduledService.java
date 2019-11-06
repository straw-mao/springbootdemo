package com.straw.springbootdemo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * author: straw
 * desc: 实现定时任务
 */

@Service
public class ScheduledService {

    /**
     * fixedRate表示上一个执行开始后再一次执行的时间(但是必须要等上一次执行完成后才能执行)
     */
    @Scheduled(fixedRate = 1000 * 2)
    public void fixedRate() throws Exception {

        System.out.println("fixedRate开始执行时间:" + new Date(System.currentTimeMillis()));
        //休眠8秒
        Thread.sleep(1000);
        System.out.println("fixedRate执行结束时间:" + new Date(System.currentTimeMillis()));
    }

    /**
     * fixedDelay注解表示上一次执行结束后再一次执行的时间
     */
    @Scheduled(fixedDelay = 1000)
    public void fixedDelay() throws Exception {

        System.out.println("fixedDelay开始执行时间:" + new Date(System.currentTimeMillis()));
        //休眠两秒
        Thread.sleep(1000 * 2);
        System.out.println("fixedDelay执行结束时间:" + new Date(System.currentTimeMillis()));
    }

    /**
     * initialDelay表示项目启动后延迟多久执行定时任务
     */
    @Scheduled(initialDelay = 1000*3, fixedDelay = 1000)
    public void initialDelay() throws Exception {

        System.out.println("initialDelay开始执行时间:" + new Date(System.currentTimeMillis()));
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void cron() {

        System.out.println("cron开始执行时间:" + new Date(System.currentTimeMillis()));
    }

}
