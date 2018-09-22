package com.tszsoft.lbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MemberInterceptor implements HandlerInterceptor {

	public final static String LOGIN_USER = "userid";

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的路径
		String contextPath = request.getContextPath();
		// String url = request.getServletPath().toString();
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute(LOGIN_USER);

		if (StringUtils.isEmpty(loginUser)) {
			response.sendRedirect(contextPath + "/toLoginForm");
		}
		return false;
	}

}
