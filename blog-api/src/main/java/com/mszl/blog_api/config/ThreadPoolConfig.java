package com.mszl.blog_api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {


    @Bean("taskExecutor")
    public Executor asyncServiceExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        //设置核心线程池
        executor.setCorePoolSize(5);

        //设置最大线程池
        executor.setMaxPoolSize(20);

        //配置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);

        //设置线程活跃时间
        executor.setKeepAliveSeconds(60);

        //设置线程默认名称
        executor.setThreadNamePrefix("blog project");

        //等待所有任务结束后关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        //线程初始化
        executor.initialize();
        return executor;
    }
}
