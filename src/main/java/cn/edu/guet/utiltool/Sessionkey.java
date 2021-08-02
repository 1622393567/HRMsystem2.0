package cn.edu.guet.utiltool;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessionkey {
    public final static String SESSION_KEY ="emp_id";
    public static HttpServletRequest getRequest(){
        HttpServletRequest request = null;
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null){
            request = servletRequestAttributes.getRequest();
        }
        return request;
    }
    public static HttpSession getSession(){
        return Sessionkey.getRequest().getSession();
    }
    public static String getCurrentUserId(){
        return (String) getSession().getAttribute(SESSION_KEY);
    }
}
