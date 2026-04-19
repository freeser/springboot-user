package com.fyfe.config;

import com.fyfe.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()). //添加拦截器
                addPathPatterns("/**"). // 拦截映射规则
                excludePathPatterns("/user/helloworld"); // 设置排除的映射规则


        /*
        * 排除多个路径
        * List list = new ArrayList();
        list.add("/user/toIndex");
        list.add("/user/loginUser");
        list.add("/user/toRegister");
        list.add("/user/register");
        registry.addInterceptor(new UserIntercetor()).addPathPatterns("/**").excludePathPatterns(list);
        *
        * */

    }
}