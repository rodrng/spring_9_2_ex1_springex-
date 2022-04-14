package com.javagyeongmin.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString(); // Ÿ�� �޼ҵ��� signature ���� 
		System.out.println(signatureStr + "�޼ҵ� ȣ��");
		long st = System.currentTimeMillis(); // �޼ҵ� ȣ�� "��"�� ���� �ð�
		
		try {
		Object obj = joinPoint.proceed(); // Ÿ���� �޼ҵ�(�ٽɱ��)�� ȣ��
		return obj;
		}finally {
			long et = System.currentTimeMillis(); // �޼ҵ� ȣ�� "��"�� ���� �ð�
			System.out.println(signatureStr + "�޼ҵ� ����");
			System.out.println(signatureStr + "�޼ҵ��� �۾� ����ð�" + (et-st) + "ms");
		}
		
	}
	
}
