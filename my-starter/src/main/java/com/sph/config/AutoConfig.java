package com.sph.config;

import com.sph.service.LogAopAspect;
import com.sph.service.NameService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/10:03
 * @Description:
 */
@EnableConfigurationProperties(value = NameConfig.class)
@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "com.my-starter",name = "enable",havingValue = "true",matchIfMissing = true)
public class AutoConfig {
    @Bean
    public NameService nameService(NameConfig nameConfig){
        NameService nameService = new NameService();
        nameService.setName(nameConfig.getName());
        return nameService;
    }
}
