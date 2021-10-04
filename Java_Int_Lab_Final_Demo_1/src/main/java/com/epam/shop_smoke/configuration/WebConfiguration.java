package com.epam.shop_smoke.configuration;

import com.epam.shop_smoke.interceptor.AdminInterceptor;
import com.epam.shop_smoke.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private UserInterceptor userInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**", "/registration/**", "/css/**", "/js/**");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**");
    }
}
