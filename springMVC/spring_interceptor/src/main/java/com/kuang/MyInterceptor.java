package com.kuang;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
       /* HttpSession session =request.getSession();

        if(request.getRequestURI().contains("login"))
        {
            return true;
        }
        if(session.getAttribute("userloginInfo")!=null)
        {
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);*/
        return false;
    }
}
