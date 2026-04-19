package com.fyfe.config;

import com.fyfe.servlet.ContextLoaderListener;
import com.fyfe.servlet.HelloFilter;
import com.fyfe.servlet.UserServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyWebMvcConfigurerServlet {
    @Bean
    public ServletRegistrationBean myServlet(){
        // 声明一个servlet注册器Bean
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        // 设置相应的servlet
        servletRegistrationBean.setServlet(new UserServlet());
        // 设置名字
        servletRegistrationBean.setName("BeanServlet");
        // 添加映射规则
        servletRegistrationBean.addUrlMappings("/beanServlet");
        return servletRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean<HelloFilter> getFilter() {
        //通过FilterRegistrationBean实例设置优先级可以生效
        FilterRegistrationBean<HelloFilter> bean = new FilterRegistrationBean<HelloFilter>();
        bean.setFilter(new HelloFilter());//注册自定义过滤器
        bean.setName("flilter1");//过滤器名称
        bean.addUrlPatterns("/*");//过滤所有路径
        bean.setOrder(1);//优先级，最顶级
        // 忽略过滤格式
        bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean getListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean(new ContextLoaderListener());
        return servletListenerRegistrationBean;
    }
}
