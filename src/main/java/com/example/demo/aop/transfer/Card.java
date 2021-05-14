package com.example.demo.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	@Around("execution(* com.example.demo.aop.transfer.Transfer.*())")//join point: before
	public Object cardCheck( ProceedingJoinPoint joinPoint ) throws Throwable{//최상위 부모 exception보다 부모
		System.out.println("-------승차시 카드 체크-------");
		
		//joinPoint 핵심메서드(버스, 지하철)를 객체화
		Object obj = joinPoint.proceed();
		
		System.out.println("-------하차시 카드 체크-------");
		
		return obj;
	}
	
	@AfterReturning("execution(* com.example.demo.board.notice.NoticeService.*(..))")
	public void selectCheck() {
		System.out.println("Select Query(get) 정상 종료");
	}
}
