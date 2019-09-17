package day01;

// Sub Thread 
//Thread ����� ����� : Thread���� ��� �޾� ����
class MyThread extends Thread{
	String name;
	
	public MyThread(String name) {
		this.name = name;
	} // Thread ������ �� �̸� �־��� ����

	@Override
	public void run() {
		// Thread�� ������ �Ͼ�� ��
		for(int i=0; i<1000; i++) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yield(); // �켱������ �����ϰ� t3�� ���ôٹ������� ���� �����ϴ� �� ����?
			System.out.println(name+":"+i);
		}
	}
	
}

// Main Thread
public class Th1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");

		t1.setPriority(1); // t1 thread�� run()�� ����
		t2.setPriority(2);
		t3.setPriority(10);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
