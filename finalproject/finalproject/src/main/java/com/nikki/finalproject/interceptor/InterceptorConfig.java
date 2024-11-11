package com.nikki.finalproject.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)// 指定拦截器
                .addPathPatterns("/**")// 拦截所有
                .excludePathPatterns("/user/*")//排除拦截
                .excludePathPatterns("/manager/*")//排除拦截
                .excludePathPatterns("/staff/*")//排除拦截
                .excludePathPatterns("/food/*")//排除拦截
                .excludePathPatterns("/logout")//排除拦截
                .excludePathPatterns("/web_prac/**");
    }

    public void setLoginInterceptor(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }
}
