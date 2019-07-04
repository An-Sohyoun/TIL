package ws;

import java.util.Arrays;
import java.util.Random;

public class SumTest {

	public static void main(String[] args) {
		// 190517 workshop �� : Sum Test

		/*
		 * 1. 100���� ������ �迭�� 1~100������ ���ڸ� ������ �߻� ��Ų�� (�ߺ� ������� ����) 
		 * 2. ¦�� ��°�� �ִ� �����鸸 50���� �迭�� ���� 
		 * 3. Ȧ�� ��°�� �ִ� �����鸸 50���� �迭�� ���� 
		 * 4. ¦�� ��° �迭�� ù��° ���ڿ� Ȧ�� ��° �迭�� ������ ���ڸ� �ջ�, 
		 * �ٽ� ¦�� ��° �ι�° ���ڴ� Ȧ�� ��° �迭�� ���������� �ι�° ���ڿ��� �ջ� ....... 
		 * �̷������� �ջ��� ����� ��� �Ͻÿ�
		 */

		// 1. 100���� ������ �迭�� 1~100������ ���ڸ� ������ �߻�
		int num[] = new int[100];

		Random r = new Random();
		int rr = 0; // �������� ���� ��
		for (int i = 0; i < num.length; i++) {
			rr = r.nextInt(100) + 1; // 1~100������ ������ ���� �߻�
			num[i] = rr;
			for (int j = 0; j < i; j++) { // �ߺ��˻�
				if (num[j] != num[i]) { // num[i]�� ����, num[j]�� �񱳴��
					num[i] = rr; // ���� �ߺ��� ���� ������ ���� ���� rr�� ������
				} else {
					i--;
					break; // i��° �迭 ��˻� ���Ͽ� for�� ������ ����
				}
			}

		}

		System.out.println("1~100������ ������ ������ �迭");
		System.out.println(Arrays.toString(num));

		System.out.println("");

		// 2. ¦�� ��°�� �ִ� �����鳢�� �迭�� ����
		// 3. Ȧ�� ��°�� �ִ� �����鳢�� �迭�� ����

		int a[] = new int[50]; // ¦����° ������ �����ϴ� �迭
		int b[] = new int[50]; // Ȧ����° ������ �����ϴ� �迭

		for (int i = 0; i < num.length; i++) {
			if (i % 2 == 0) { // ¦��
				a[(i / 2)] = num[i];
			} else if (i % 2 == 1) { // Ȧ��
				b[(i / 2)] = num[i];
			}
		}

		System.out.println("¦�� ��°�� �ִ� ������ ������ �迭 : ");
		System.out.println(Arrays.toString(a));
		System.out.println("");
		System.out.println("Ȧ�� ��°�� �ִ� ������ ������ �迭 : ");
		System.out.println(Arrays.toString(b));
		System.out.println("");

		// 4. ¦�� 1�� + Ȧ�� 50��, ¦�� 2�� + Ȧ�� 49�� ... ������ �迭 ǥ��

		int sum[] = new int[50]; // �ջ� ���� ������ �迭 sum

		for (int i = 0; i < a.length; i++) {
			sum[i] = a[i] + b[49 - i];
		}

		System.out.println("���� �ջ��� �迭 : ");
		System.out.println(Arrays.toString(sum));

	}
}
