package day01;

class SaveThread extends Thread{
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			save(); // 2�ʿ� �� ���� SAVE �ϵ��� ����
		}
	}
	
	public void save() {
		System.out.println("SAVE..");
	}
}

public class Th4 {

	public static void main(String[] args) {
		SaveThread st = new SaveThread();
		st.setDaemon(true);
		st.start();
		for(int i=0; i<20; i++) {
			try {
				Thread.sleep(500); // 1.2�ʿ� �� ���� �۾�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	
	}

}
