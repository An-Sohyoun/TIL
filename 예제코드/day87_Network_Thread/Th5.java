package day01;

import java.util.Scanner;

/* Scanner �Է� ���� ���ڱ��� for loop �̿��Ͽ� ��� */
public class Th5 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Number..");
		int number = scanner.nextInt();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <= number; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("status:" + i);
				}
				
			}
		};
		
		new Thread(r).start();
	}

}
