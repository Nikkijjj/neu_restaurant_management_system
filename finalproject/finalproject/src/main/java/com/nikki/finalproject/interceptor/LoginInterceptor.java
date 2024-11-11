package com.nikki.finalproject.interceptor;

import com.nikki.finalproject.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("begin preHandle");
        HttpSession session = request.getSession();//获取请求的对象以及当前用户的HttpSession
        User user = (User) session.getAttribute("login_user");//从session中获取该属性（用于标识当前登录的用户）
        System.out.println("login user: "+user);
        if(user==null) {
            response.setStatus(401);
            // 错误，未登录或登录失效，请重新登录后再执行
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("end Interceptor");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
