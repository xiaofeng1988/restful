package hxk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @author Administrator
 * @description
 *2014-12-30  下午4:19:44
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	String url = request.getRequestURL().toString();  
	System.out.println("拦截器:"+url);
        return true;
     }
}
