package com.fyfe.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 加上注解，之后在配置类中直接注入
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 返回为true对请求放行，反之拒接
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("请求处理之前进行调用（Controller方法调用之前）");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理之后进行调用，主要是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("请求结束之后被调用，在DispatcherServlet渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}