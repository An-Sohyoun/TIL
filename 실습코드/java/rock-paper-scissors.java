package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {

	public static void main(String[] args) {
		// 190515 workshop : ���������� ���� �����ϱ�
		
		// 1. ���������� ������ ���� �Ѵ�.
		// 2. ������ ������ �������� "q"�� �Է� �ϸ� ������
		// 3. ������ ���� �� ȸ���� �̱� ȸ���� ��� �Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1(����), 2(����), 3(��) ���ڸ� �Է����ּ���");
		System.out.println("�������Ḧ ���ϸ� q�� �����ּ���");
		
		// ��ǻ�� (����)
		Random r = new Random(); // �����Լ����
		int com = 0; // ��ǻ���� ���� ���� �� �ʱ�ȭ
		com = r.nextInt(3)+1; // 0,1,2�� +1 �� ��� �� 1,2,3
		
		int a=0; // ��������
		int b=0; // ��� �̰����
		
		while(true) {
			String data = sc.nextLine(); // ����ڰ� ���������� �Է�
			
			if(data.equals("q")) {
				System.out.println("Bye..");
				System.out.println("�������� "+a+"ȸ"+" �̱���� "+b+"ȸ");
				sc.close();
				break; // while�� �����Ű�� ����
			}else { // ����ڰ� ������������ �����Ѵٰ� ����
				int user = Integer.parseInt(data); // ����ڰ� �Է��� ������ ���ڷ� ����
				if(user>=4 || user<=0) {
					System.out.println("�ٽ� �Է����ּ���");
					continue; // �ٽ� while�� �������� ���ư�
				}else
				{
				switch(user-com) {
				
			case 0 : // ���º�
			a++;
			System.out.println("�������� "+a+"ȸ"+" �̱���� "+b+"ȸ");
			System.out.println("�������Ḧ ���ϸ� q�� �����ּ���");
			break;
			
			case -1: case 2: // ��ǻ�� �¸�
				a++;
				System.out.println("�������� "+a+"ȸ"+" �̱���� "+b+"ȸ");
				System.out.println("�������Ḧ ���ϸ� q�� �����ּ���");
				break;
				
		case 1: case -2: //����� �¸�
			a++;
			b++;
			System.out.println("�������� "+a+"ȸ"+" �̱���� "+b+"ȸ");
			System.out.println("�������Ḧ ���ϸ� q�� �����ּ���");
			break;
		}
			}
		}
	}
		sc.close();
}
	
}







