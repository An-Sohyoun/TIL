package day01;

public class Th3 {

	public static void main(String[] args) {
		// Class ������ �ʰ�, Runnable�� r ��ü ���� �� thread ����
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("R:" + i);
				}

			}
		};

		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("R:" + i);
				}

			}
		};

		// �� ���� Thread �ϳ��� Group���� ����
		ThreadGroup tg1 = new ThreadGroup("TG1");
		tg1.setMaxPriority(3); // �׷����� �����ϸ� �ѹ��� �����ϱ� ����
		new Thread(tg1, r, "th1").start();
		new Thread(tg1, r2, "th1").start();

	}

}
