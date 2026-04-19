package com.fyfe.config;

import com.fyfe.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    /**
     * 全局CORS配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/*");   // 映射服务器中那些http接口运行跨域访问
        //.allowedOrigins("http://localhost:8082")     // 配置哪些来源有权限跨域
        //.allowedMethods("GET","POST","DELETE","PUT");   // 配置运行跨域访问的请求方法


        /*
        标准配置
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH");
        */
    }
}