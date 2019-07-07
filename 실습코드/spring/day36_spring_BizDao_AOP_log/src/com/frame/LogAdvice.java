package com.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// LogAdvice���� AOP ����ϱ� ���Ͽ� �Ʒ� �� �� �߰�
@Service
@Aspect
public class LogAdvice {
	public void printLog() {
		Date d = new Date();
		System.out.println(d + "[����α�]����Ͻ� ���� ����...");
	}

	@Before("execution(* com..Biz+.insert(..))") // () ���� �Լ��� ����Ǹ� Before�� ����ǰڴٴ� �ǹ�
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		// client�� ȣ���� �޼ҵ��� �ñ״�ó(����Ÿ��, �̸�, �Ű�����)������ ����� Signature ��ü ����
		Object[] args = jp.getArgs();
		// client�� �żҵ带 ȣ���� �� �Ѱ��� ���� ����� Object �迭�� ����
		System.out.println(method + " : " + args[0]);
		System.out.println("[before]����Ͻ� ���� ����...");
	}

	@AfterReturning(pointcut = "execution(* com..Biz+.select(..))", returning = "returnObj")
	// before������ pointcut�� ����� �� ����
	// Object�� ���� �̸��� �������ߵ�
	public void afterLog(JoinPoint jp, Object returnObj) {
		// returnObj�� myspring.xml�� aop:after-returning �±׷� ��
		System.out.println("[after]����Ͻ� ���� ����...");
		System.out.println("Log Result: " + returnObj);
	}

	@AfterThrowing(pointcut = "execution(* com..Biz+.select(..))", throwing = "ex")
	public void exLog(JoinPoint jp, Exception ex) {
		Date d = new Date();
		System.out.println(d + "[EX�α�]Exception...");
		System.out.println(ex.getMessage());
	}

	@Around("execution(* com..Biz+.select(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println("Before Action...");
		Object obj = pjp.proceed();
		System.out.println("After Action...");
		stopWatch.stop();

		System.out.println("Processing Time: " + stopWatch.getTotalTimeSeconds());

		return obj;

	}
}
