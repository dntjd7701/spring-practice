package com.douzone.hellospring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor01 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		System.out.println("MyInterceptor01.preHandle(...) called ");
		// return 타입이 매우 중요, false 로 리턴하면 뒤로 안감. 
		// true 로 해야 뒤로 쭉 갈 수 있음. 
		// 즉, 뒤에 Handler로 갈 수 가 없음으로 뒷 부분이 실행되지 않음. 
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor01.postHandle(...) called ");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor01.afterCompletion(...) called ");
	}

}
