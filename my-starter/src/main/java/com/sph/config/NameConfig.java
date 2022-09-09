package com.sph.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/10:00
 * @Description:
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "com.my-starter")
public class NameConfig {
    private String name;
}
