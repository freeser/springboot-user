package com.fyfe.config;

import com.fyfe.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()). //添加拦截器
                addPathPatterns("/**"). // 拦截映射规则
                excludePathPatterns("/user/helloworld"); // 设置排除的映射规则


        /*
        * 排除多个路径
        * */
//        List<String> list = new ArrayList<>();
//        list.add("/user/helloworld");
//        list.add("/index");
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }

    /**
     * 添加视图控制器
     * 立即访问
     * <mvc:view-controller path="/" view-name="index" />
     * @param registry
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("index");
//    }
}