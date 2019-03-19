package com.delta.soft_manage_system.config;

import com.delta.soft_manage_system.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname WebMvcConfig
 * @Description
 * @Date 2019/3/19 17:07
 * @Author LIZONG.WEI
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private GlobalInterceptor globalInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor)
                .addPathPatterns("/**");
    }
}
