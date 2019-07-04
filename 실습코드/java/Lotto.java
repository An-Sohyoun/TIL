package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// 190516 workshop : �ζ����α׷� �����ϱ�
		
		/* ���ӱ�Ģ
		1. 6���� ���� �Է� (���� : 1~10)
		2. �� ���� ��÷��ȣ 6�� ���� (���� : 1~10) �ߺ����� �ʴ� ���� ����
		3. ��÷�� ����  (����: 10��~100��)
		4. �Է� ���� ���ڿ� ��÷��ȣ Ȯ��
		- 3�� ������ : 4�� (��÷�� 5%)
		- 4�� ������ : 3�� (��÷�� 10%)
		- 5�� ������ : 2�� (��÷�� 20%)
		- 6�� ������ : 1�� (��÷�� 50%)
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1~10�� ���� �� ���� ���� �Է����ּ���");
		
		// 6���� �ζ� ���� �Է� (�����)
		int a[] = new int[6]; 

		for(int i=0; i<a.length; i++) {
			int data = sc.nextInt();  // ���ڷ� ������ �Է¹����ϱ� �ٷ� int�� ����
			if(0<=data && data<=10) {
				a[i] = data;
			}else
			{
				i--; //a[i] ��° ä���� ���ϰ� ��������Ƿ� �ٽ� �Է��ϱ� ����
				System.out.print("�ٽ� �Է����ּ���.\n");
				continue; // �ٽ� for�� ó������
			}
				
		}
		
		// ����ڰ� �Է��� �ζ� �Է� �� ��Ÿ����
		System.out.print("�� ��ȣ: ");
		for(int j=0; j<a.length; j++) {
			System.out.print(+a[j]+" ");
		}
		
		// ��ǻ�Ͱ� ��÷��ȣ����(����)
		int Lotto[] = new int[6]; // ��ǻ�Ͱ� ���� �� �迭�� ����
		
		Random r = new Random();
		int com = 0;
		for(int i=0; i<Lotto.length; i++)
		{
			com = r.nextInt(10)+1; // (0,1,2,3,4,5,6,7,8,9) +1 ���� ��������
			Lotto[i] = com;
			for(int j=0; j<i; j++)
			{
				if(Lotto[j] != Lotto[i]) //�ߺ�����
				{
					Lotto[i] = com;
				}
				else
				{
					i--;
					break;
				}
			}
		}
		
		//��ǻ�Ͱ� ���� �ζǹ�ȣ ��Ÿ����(��÷��ȣ)
		System.out.print("\n��÷ ��ȣ��:");
		for(int i=0; i<Lotto.length; i++) {
		System.out.print(+Lotto[i]+" ");
		}
		System.out.println();
		
		// ���ù�ȣ�� �ζǴ�÷��ȣ��
		int count =0;
		for(int i=0; i<a.length; i++) 
		{ 
			for(int c=0; c<Lotto.length; c++) 
			{ 
				if(a[i] == Lotto[c]) 
				{
					count++;
				} 
					 
			}
		}	
		
		// ��÷�� ����	
		long money = 0; // �� ��÷��
		long prize = 0; // ����� ��÷��
		
		money = (r.nextInt(10)+1)*1000000000L;
		
		// ���ù�ȣ�� ��÷��ȣ�� ���� ����� ��÷�� ����
		switch(count) {
		case 3 :
			prize = (long)(money*5/100);
			System.out.println("���: 4");
			break;
		case 4 :
			prize = (long)(money*10/100);
			System.out.println("���: 3");
			break;
		case 5 :
			prize = (long)(money*20/100);
			System.out.println("���: 2");
			break;
		case 6 :
			prize = (long)(money*50/100);
			System.out.println("���: 1");
			break;
			
		default :
				System.out.println("��");
				break;
				
		}
	
		
		// ��÷�� �������
		System.out.printf("\n�� ��÷��: %d���Դϴ�.",money);
		System.out.printf("\n ��÷��: %d���Դϴ�.",prize);
		
	
	}
}


