package net.shangtech.studio.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shangtech.studio.manager.controller.ManagerController;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getRequestURI());
		if(request.getSession().getAttribute(ManagerController.SESSION_USER_KEY) != null){
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/login");
	    return false;
    }

	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
	    // TODO Auto-generated method stub
	    
    }

}
