package day01;

// Sub Thread 
// Thread ����� ����� : implements Runnable
/* Java������ ���ϻ�� �ۿ� �� �ǹǷ� ���� ���� Thread �� ����� 
 * �� ���� ���� Thread ����� ���Ͽ� interface ���Ͽ� ���� */
class MyThread2 implements Runnable{
	String name;
	
	public MyThread2(String name) {
		this.name = name;
	} // Thread ������ �� �̸� �־��� ����

	@Override
	public void run() {
		// Thread�� ������ �Ͼ�� ��
		for(int i=0; i<30; i++) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+":"+i);
		}
	}
	
}

// Main Thread
public class Th2 {

	public static void main(String[] args) {
		// Interface���� �޾��� ��, Thread ��ü �Ʒ� ������� ��
		Thread t1 = new Thread(new MyThread2("T1"));
		Thread t2 = new Thread(new MyThread2("T2"));
		t1.start();
		t2.start();


	}

}
