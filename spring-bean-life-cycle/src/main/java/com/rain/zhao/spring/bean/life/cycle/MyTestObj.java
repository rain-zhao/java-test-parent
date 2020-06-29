package com.rain.zhao.spring.bean.life.cycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Slf4j
public class MyTestObj implements InitializingBean, DisposableBean {

    @PostConstruct
    public void postConstruct(){
        log.info("PostConstruct:MyTestObj");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("PreDestroy:MyTestObj");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet:MyTestObj");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy:MyTestObj");
    }
}

