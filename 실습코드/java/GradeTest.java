package ws;

import java.util.Arrays;
import java.util.Scanner;

import calc.Calc;

public class GradeTest {

	public static void main(String[] args) {
		
		int score[] = new int[4];
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ ������ �Է����ּ���.");
		for(int i=0; i<score.length; i++) {
			score[i] = sc.nextInt();
		}
		Grade g = new Grade(score);
		System.out.println("������ �հ� : "+g.sum()); // ��
		System.out.println("��� : "+g.avg()); // ���
		System.out.println("��� : "+g.grade()); // ���
		System.out.println("�ְ� ���� : "+g.max()); // �ְ���
		System.out.println("���� ���� : "+g.min()); // ������
		System.out.println(Arrays.toString(g.asort())); // ��������
		System.out.println(Arrays.toString(g.dsort())); // ��������
		
		sc.close();
		
	}
	

}
