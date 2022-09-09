package com.sph.config;

import com.sph.service.LogAopAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/13:29
 * @Description:
 */
@Configuration
@ConditionalOnProperty(prefix = "com.my-starter.aop",name = "enable",havingValue = "true",matchIfMissing = true)
public class AopAutoConfig {

    @ConditionalOnMissingBean(value = LogAopAspect.class)
    @Bean
    public LogAopAspect logAopAspect(){
        return new LogAopAspect();
    }
}
