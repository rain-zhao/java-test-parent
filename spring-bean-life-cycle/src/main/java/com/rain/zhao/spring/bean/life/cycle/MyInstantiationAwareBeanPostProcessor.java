package com.rain.zhao.spring.bean.life.cycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.LazyInitializationBeanFactoryPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyTestObj){
            log.info("postProcessAfterInstantiation触发bean："+beanName);
        }
        return true;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass == MyTestObj.class){
            log.info("postProcessBeforeInstantiation触发bean："+beanName);
        }
        return null;
    }
}
