package com.nsu.movie2023.interceptor;

import com.nsu.movie2023.bean.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Customer customer;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        customer=(Customer)request.getSession().getAttribute("customer");
        if(customer!=null)
            return true;
        response.sendRedirect(request.getContextPath()+"/tologin");
        return false;
    }
}