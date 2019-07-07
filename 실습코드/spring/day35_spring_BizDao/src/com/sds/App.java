package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("register.xml");
		// ���Ͻý��� ���� �ִ� xml ���� ȣ�� (�����̳� ����)
		
		System.out.println("Spring Started");
		
		// UserOracleDao
		Biz biz = (Biz)factory.getBean("ub1"); 
		biz.register(); 
		
		// UserMariaDao
		Biz biz2 = (Biz)factory.getBean("ub2"); 
		biz2.register();
		


}
}
