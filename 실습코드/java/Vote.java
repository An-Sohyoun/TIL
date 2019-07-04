package ws;

import java.util.Arrays;
import java.util.Random;

public class Vote {

	public static void main(String[] args) {
		// 190517 workshop �� : �����ĺ���ǥ

		/* ���ӱ�Ģ 
		 * 1������ 5�������� �����ĺ� ���� ��� �� 50���� ��ǥ �ο��� 5���� ��ǥ�� ���� �Ͽ���.
		 * 
		 * 1. ���� ���� ��ǥ�� ���� �ĺ��� ������ ��� �Ͻÿ� 
		 * 2. ���� ���� ��ǥ�� ���� �ĺ��� ������ ��� �Ͻÿ�
		 * 3. ��ǥ ��� ���� ǥ�� ���� ���� ���� ������ ���� �Ͽ� ��� �ϰ� 
		 * 4. ��ǥ ��� ���� ǥ�� ���� ���� ������ ���� �Ͽ� ��� �Ͻÿ�
		 */

		// 50���� ������� ���� ��ǥ ���� �������� �迭 vote�� ����
		int vote[] = new int[50];
		Random r = new Random(); // ������ ����ϱ� ���� ����
		for (int i = 0; i < vote.length; i++) { // for���� ���� �� ĭ�� �������� ���ڸ� ����
			vote[i] = r.nextInt(5) + 1; // (0,1,2,3,4) +1�� ���� �� 1,2,3,4,5�� ��ǥ
		}

		System.out.println("50���� ��ǥ���� : ");
		System.out.println(Arrays.toString(vote)); // �迭�� �� ��Ÿ��
		System.out.println("--------------------");

		// �� ��ȣ �� �� ���� ��ǥ�� �����ߴ��� ��Ÿ���� count �迭
		int count[] = new int[6]; // ��ǥ�� �� ��Ÿ���� �迭
		for (int i = 0; i < vote.length; i++) { // �迭 vote�� �о�鿩 � ���� ��ǥ�� �ߴ��� �д� for��
			for (int k = 1; k < count.length; k++) { // �迭 count�� �о� ī��Ʈ�� �ϱ� ����
				if (vote[i] == k) {
					count[k]++;
				}
			}

		}
		System.out.println("�� ��ȣ �� ��ǥ�ο� : ");
		for (int k = 1; k < count.length; k++) {
			System.out.println(k + "��" + " : " + count[k] + "��");
			// count �迭�� ���� ��Ÿ�� �� �� ���� �� ���� ǥ���ߴ��� ��Ÿ��
			// 41�� ���� k�� �� ��° �迭����, count[k]�� k��° �迭�� ���� �������� ��Ÿ��
		}
		System.out.println("--------------------");

		// ���� ���� ǥ�� ���� �ĺ��� ���� ��� : �迭 �� �ִ밪 ���ϱ�
		// ���� ���� ǥ�� ���� �ĺ��� ���� ��� : �迭 �� �ּҰ� ���ϱ�

		int max = count[1]; // �ִ��ּҸ� ���ϱ� ���Ͽ� ���� ���� ���ؾ� ��
		int min = count[1]; // �� �迭�� �� ���� ���� count[0]�� �������� ���ϰ� ���� ���� �������� ����

		for (int i = 1; i < count.length; i++) { // count �迭�� �� �д� for��
			if (count[i] > max) { // count[i]�� ���� �� ���� ���� ��� ���Ͽ� �ִ밪�� ������
				max = count[i];
			} else if (count[i] < min) { // count[i]�� ���� ���� �� ���Ͽ� �ּҰ� ����
				min = count[i]; // ���Ͽ� ���� ���� min�� �����Ͽ� ���������� ���� min ���� �ּҷ� ���
			}
		}

		System.out.println("���� ���� ���� ǥ�� �� : " + max);
		System.out.println("���� ���� ���� ǥ�� �� : " + min);
		System.out.println("--------------------");

		// ��ǥ ����� ǥ�� ���� ���� ���� ������ ���� (��������)

		for (int i = 1; i < count.length; i++) { // ������ ���ϱ� ���Ͽ� count �迭�� ��� �о����
			for (int j = 1; j < count.length - 1 - i; j++) { // �̹� ���� �ڸ��� ���� �ڸ��� ���� ������ �ʾƵ� �ǹǷ� '-1-i'�� �ʿ���
				if (count[j] < count[j + 1]) {
					int temp = count[j]; // �ڸ� �ٲٱ� ���Ͽ� �ӽú����� temp ����
					count[j] = count[j + 1]; // count[j+1]�� ���� �� ũ�Ƿ� �� �ڸ��� count[j]�� ���� �����ϸ� ������ �̵�
					count[j + 1] = temp; // �ռ� ������ �� temp(count[j]���� �ڷ� ������ ���Ͽ� count[j+1]�� ������

				}
			}
		}

		System.out.println("���� ���� ���� ǥ ������ ���� : ");
		for (int i = 1; i < count.length; i++) {
			System.out.print(count[i] + " ");
		}

		System.out.println("");

		// ��ǥ ����� ǥ�� ���� ���� ���� ������ ���� (��������)

		for (int i = 1; i < count.length; i++) {
			for (int j = 1; j < count.length - 1 - i; j++) {
				if (count[j] > count[j + 1]) { // count[j-1]�� �Ǹ� ������ �� j=0�� ��, count[0]�� count[-1]�� ���� �� �����Ƿ�!
					int temp = count[j + 1];
					count[j + 1] = count[j];
					count[j] = temp;

				}
			}
		}

		System.out.println("���� ���� ���� ǥ ������ ���� : ");
		for (int i = 1; i < count.length; i++) {
			System.out.print(count[i] + " ");
		}

		System.out.println("");

	}

}
