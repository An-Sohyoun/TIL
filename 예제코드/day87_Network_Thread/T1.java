package day01;

public class T1 {

	public static void main(String[] args) throws InterruptedException {
		for(int i=0; i<100; i++) {
			Thread.sleep(1000);
			System.out.println("A:"+i);
		} // for���� �����ϴ� ���� �ƹ��͵� �� �� ����
		System.out.println("end");
		for(int i=0; i<20; i++) {
			Thread.sleep(10);
			System.out.println("B:"+i);
		}

	}

}
