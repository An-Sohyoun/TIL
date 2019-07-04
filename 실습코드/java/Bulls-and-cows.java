package ws1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// 190520 workshop �� : ���ھ߱�

		/*
		 * 1. ���� 4�ڸ� ���� �ޱ� (0~9) �ߺ� x 
		 * 2. ����ڰ� 4�ڸ� ���� �Է� 
		 * 3. ���ڰ� ������ ball, �ڸ��� ������ strike
		 * 4. �ƿ� �ȸ����� out 
		 * 5. ������ ��ġ�ϰ� �Ǹ� Ȩ������ ���� ��.
		 * 
		 * ex) 
		 * �������� : 1639 
		 * ����ڼ��� : 2698 => 1S1B 
		 * ����ڼ��� : 4578 => out 
		 * ����ڼ��� : 2439 => 2S
		 * ����ڼ��� : 2461 => 2B
		 */

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("���ھ߱� ������ ���۵˴ϴ�.");
		System.out.println("1~9������ �� �ڸ��� ���ڸ� �Է����ּ���.");

		int b = 0; // ���ڸ� ������ ball
		int s = 0; // ���ڿ� �ڸ� �� �� ������ strike
		int o = 0; // �ƿ� �� ������ out

		// 1. ����ڰ� 4�ڸ� ���� �Է�
		int user[] = new int[4]; // ����ڰ� �Է��ϴ� 4�ڸ� ���ڸ� �����ϴ� �迭
		for (int u = 0; u < user.length; u++) { // ����ڰ� �Է��� ���ڸ� ���ʴ�� �迭�� ����
			int data = sc.nextInt(); // �ٷ� ���ڰ��� �Է� ���� �� �����Ƿ�, ��ȯ���� �ʰ� nextInt ���
			if (0 <= data && data <= 9) {
				user[u] = data;
			} else {
				u--; // �迭�� ��� ĭ�� ä�����ϹǷ� ä���� �� �Ͽ����� �ٽ�
				System.out.println("�ٽ� �Է����ּ���.\n");
				continue; // �ٽ� for�� �������� �̵�
			}
		}

		System.out.println("����ڰ� �Է��� ���� : ");
		for (int k = 0; k < user.length; k++) {
			System.out.print(user[k] + " ");
		}

		System.out.println(" ");

		// 2. ���� 4�ڸ� ���� �ޱ�
		int com[] = new int[4]; // ��ǻ�Ͱ� �Է� �޴� ���ڸ� �����ϴ� �迭
		int num = 0;
		for (int i = 0; i < com.length; i++) {
			num = r.nextInt(10); // 0���� 9������ ���ڸ� �������� �Է�
			com[i] = num; // �������� ���� ���� �迭 com�� ����
			for (int j = 0; j < i; j++) { // �ߺ������˻� ��
				if (com[j] != com[i])
				// ���� ����Ǿ��ִ� �迭 com[j] ���� ���� ���� �� com[i]�� ���Ͽ� ���忩�� ����
				{
					com[i] = num;
				} else {
					i--;
					break;
				}
			}
		}

		System.out.println("��ǻ���� �������� : ");
		for (int z = 0; z < user.length; z++) {
			System.out.print(com[z] + " ");
		}

		System.out.println(" ");

		// 3. ����ڰ� �Է��� ���ڿ� ��ǻ���� ���� ��

		for (int m = 0; m < com.length; m++) {
			for (int n = 0; n < user.length; n++) {
				if (com[m] == user[n] && m == n) { // ���ڿ� �ڸ� ��
					s++; // ���ڿ� �ڸ��� ��� ������ strike++
				} else if (com[m] == user[n] && m != n) {
					b++; // ���ڸ� ������ ball++
				}
			}
		}

		if (s == 0 && b == 0) {
			System.out.println("OUT");
		} else {
			System.out.println("���� ��� : ");
			System.out.println(s + " Strike " + b + " Ball ");
		}

		if (s == 4) {
			System.out.println("Ȩ���Դϴ�.");
		}

		sc.close();

	}
}
