package ws;

import java.util.Arrays;
import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		// 190517 workshop �� : String Test

		/*
		 * 1. �ҹ��ڷ� �� ���ڿ��� �Է� �޾� ��� �Ѵ�. 
		 * 2. �Է� ���� ���ڿ��� �빮�ڷ� ����� ������ ���ٷ� �Ͽ� ��� �Ѵ�. 
		 * 3. 2������ ������� ���ڿ��� �� char�� +5�� �Ͽ� ��ȣȭ �Ͽ� ��� �Ѵ�. 
		 * 4. 3������ ������� ���ڿ��� ��ȣȭ �Ͽ� ���� �Է� ���� ���ڿ��� ��� �Ѵ�.
		 */

		// 1. ���ڿ� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		System.out.println("�ҹ��ڷ� �� ���ڿ��� �Է����ּ���.");
		String input = sc.nextLine(); // �����Է´��

		char[] abc;
		abc = input.toCharArray(); // �Է� ���� ���ڿ��� �迭�� ������
		System.out.println("�Է��Ͻ� �ҹ��ڷ� �� ���ڿ� : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]); // �迭�� ���� �� �Է� ���� ���ڿ� ���
		}

		System.out.println("");
		char a[] = abc; // �ʱ� �Է� �� �迭 ������ ����

		// 2-1. �Է� ���� ���ڿ��� �빮�ڷ� �����

		for (int i = 0; i < abc.length; i++) {
			if (97 <= abc[i] && abc[i] <= 122) { // �ҹ��� a���� z������ ����
				abc[i] = (char) (abc[i] - 32); // �ҹ��ڸ� �빮�ڷ� ��ȯ
			}
		} // ���⼭ abc[i]�� �빮�ڿ�

		char b[] = abc; // �빮�ڷ� �ٲ� �迭 ������ ����

		// 2-2. �빮�ڷ� ���� ���ڿ��� ������ �迭�� �Ųٷ� ����ϱ�

		char temp = 0;
		int j = abc.length - 1;

		for (int i = 0; i < abc.length / 2; i++, j--) {
			temp = abc[i];
			abc[i] = abc[j];
			abc[j] = temp;
		}

		System.out.println("�빮�ڷ� ��ȯ�Ͽ� �������� ����� ���ڿ� : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);
		}

		System.out.println("");

		char c[] = abc; // �빮�� �Ųٷ� ������ �迭 ������ ����

		// 3. �� char�� +5 �Ͽ� ��ȣȭ �ϱ�

		for (int i = 0; i < abc.length; i++) {
			abc[i] = (char) (abc[i] + 5);
		} // char�� +5 �Ͽ� ��ȣȭ

		System.out.println("�� ���ڿ� '+5'�� �Ͽ� ��ȣȭ : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);
		}

		System.out.println("");

		char d[] = abc; // +5 ��ȣȭ ������ ����

		// 4. ��ȣȭ

		for (int i = 0; i < abc.length; i++) {
			abc[i] = (char) (abc[i] - 5);
		} // char�� �ٽ� -5�� �Ͽ� ��ȣȭ

		System.out.println("�� ���ڿ� '-5'�� �Ͽ� ��ȣȭ : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);
		}

		System.out.println("");

		char e[] = abc; // ��ȣȭ ������ ����

		// ���� �ٽ� �Ųٷ�

		char temp2 = 0;
		int k = abc.length - 1;

		for (int i = 0; i < abc.length / 2; i++, k--) {
			temp2 = abc[i];
			abc[i] = abc[k];
			abc[k] = temp2;
		}

		System.out.println("�ٽ� �������� ����� ���ڿ� : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);

		}

		System.out.println("");

		// �빮�ڸ� �ٽ� �ҹ��ڷ�

		for (int i = 0; i < abc.length; ++i) {
			if (65 <= abc[i] && abc[i] <= 90) { // �빮���� ����
				abc[i] = (char) (abc[i] + 32); // �ҹ��ڸ� �빮�ڷ� ��ȯ
			}
		} // ���⼭ �ٽ� �ʱ�ȭ ������

		System.out.println("�ʱ� ���ڿ��� ���� : ");
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);

			sc.close();
		}
	}
}
