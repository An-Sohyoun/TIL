package ws2;

public class MobileTest {

	public static void main(String[] args) {

		// ������ Mobile ��ü ����
		// ������ ��ü�� ���� ���
		Mobile m[] = new Mobile[2];
		m[0] = new Ltab("Ltab", 500, "AP-01");
		m[1] = new Otab("Otab", 1000, "AND-20");

		for(Mobile mm : m) {
			System.out.println(mm.toString());
		}

		// ������ Mobile ��ü�� 10�о� ����
		// 10�� ���� �� ��ü ���� ���
		System.out.println("----------------------------------------");
		System.out.println("10������");
		
		for(Mobile mm : m) {
			mm.charge(10);
		}
		
		for(Mobile mm : m) {
			System.out.println(mm.toString());
		}

		// ������ Mobile ��ü�� 5�о� ��ȭ
		// 5�� ��ȭ �� ��ü ���� ���
		System.out.println("----------------------------------------");
		System.out.println("5����ȭ");
		
		for(Mobile mm : m) {
			mm.operate(5);
		}
		
		for(Mobile mm : m) {
			System.out.println(mm.toString());
		}


	}

}
