package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---Before Advice run..");
	}
	/**
	 *  '*'모든 리턴타입 
	 *  public등 접근자는 생략 가능 
	 *   
	 *  '*..*' 여러 패키지를 한번에 줄일때.
	 *  |-- 여기선 com.douzone.aoptest <<
	 *  
	 *  보통 parameter는 명시를 하지 않음. 
	 *  
	 */
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---After Advice run..");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice run..");
	}
	
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice : " + ex + "------");
	}
	
	@Around(value="execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// Before Advice
		System.out.println("@Around(Before) Advice run...");
			
		// PointCut Method 실행
		// 여기선 ProductService의 메소드인 find가 실행
//		Object ob = pjp.proceed();
		
		// prameter 가로채기(바꿔치기)
		// 남용하면 안됌. 
		// 특수한 경우. 
		// 공통된 부분을 지속적으로 수정 및 처리해야하는 경우
		// 어떤게 올지 모르니, 배열로 받아야함. 
		Object[] params = {"Camera"};
		Object ob = pjp.proceed(params);
		
		// After Advice 
		System.out.println("@Around(After) Advice run...");
		
		
		// return 필수 !!
		return ob;
	}
	
	
}
