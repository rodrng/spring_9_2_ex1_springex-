package com.javagyeongmin.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString(); // 타켓 메소드의 signature 정보 
		System.out.println(signatureStr + "메소드 호출");
		long st = System.currentTimeMillis(); // 메소드 호출 "전"의 현재 시간
		
		try {
		Object obj = joinPoint.proceed(); // 타겟의 메소드(핵심기능)를 호출
		return obj;
		}finally {
			long et = System.currentTimeMillis(); // 메소드 호출 "후"의 현재 시간
			System.out.println(signatureStr + "메소드 종료");
			System.out.println(signatureStr + "메소드의 작업 실행시간" + (et-st) + "ms");
		}
		
	}
	
}
