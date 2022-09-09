package com.sph.aop;

import org.springframework.aop.ClassFilter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/14:10
 * @Description:
 */
public class LogClassFilter implements ClassFilter {
    final private String regx = "com.sph.*.controller.*";
    @Override
    public boolean matches(Class<?> clazz) {
        return clazz.getName().matches(regx);
    }
}
