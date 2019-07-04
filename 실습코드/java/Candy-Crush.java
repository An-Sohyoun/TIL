package ws2;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// 190520 workshop �� : ĵ��ũ����

		/*
		 * 1. 9 x 9 ĵ���� ���� 
		 * 2. ĵ���ǿ� ABCDE�� ���� ���� �ٸ� ���� 4�� �̻��� ����ؼ� �������� ĵ���ǿ� �ִ´�. 
		 * 3. ���� ���� �� ����ڰ� ���� ���� �ٲٰ� �;��ϴ� ���ĺ��� ��ǥ�� �����ϰ�, �� ���ĺ��� �̿� ���ĺ��� ��ǥ�� �Է��ؼ� �ڸ��� �ٲ� 
		 * �ڴ�, �̿��� ���ڸ� �ٲ� �� ���� �̿��� ��� ���� �޽��� ��¡� 
		 * 
		 * 4. 3���� ���ڰ� �̿��Ǹ� �������� ���� ī��Ʈ �߰�
		 * 5. �̿��Ǽ� ������ ��ĭ�� �������� ���ڸ� �����ؼ� �ֱ� 
		 * 6, ����, ���� �Ŀ� ���� ����
		 */
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int score = 0;
		
		
		// 1. 9x9 ĵ���� ����
		
		char map[][] = new char [9][9]; // 9x9 2�����迭�� ����
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				map[i][j] = (char)(r.nextInt(5)+65); // +65�ϸ� �빮��, +97�ϸ� �ҹ���
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("");
		System.out.println("������ ���� �� �غ� �Ǿ����ϴ�.");
//		System.out.println("���Ͻô� ������ǥ�� �Է����ּ���. ex) 1,2,3,4 �� (1 1), (2 3)");
		
		
		while(true) {
			System.out.println();
			
			while(true) { 
				// 3. �̿��� ���� �� ���� ���ڰ� �� �� �̻� �Ǹ� �ҰŵǸ鼭 ����++ 
				// & ������ �ٸ� ���ڷ� ä���ֱ�
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length-2; j++) {
					if(map[i][j] == map[i][j+1] && map[i][j+1] == map[i][(j+2)]) {
						map[i][j] = (char)(r.nextInt(5)+65);
						map[i][j+1] = (char)(r.nextInt(5)+65);
						map[i][j+2] = (char)(r.nextInt(5)+65);
						score ++;
					}
					}
				}
			// �Ұ� ��, ���� �Ϸ� �� ĵ������ �����ϸ� �ٽ� ���� ����	
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					System.out.print(map[i][j]+"\t");
				}
				System.out.println();
			}
			break;
			}
			// �� �� ���� ������ �Բ� ��µ�
			System.out.println("���� ���� : "+score+"\n"); 
			
			// ���� ��ǥ �� ������ ��ǥ �Է�
			System.out.println("���ϴ� ��ǥ�� �Է����ּ���. ex) 1,2,3,4 �� (1 1), (2 3)");
			int data1 = sc.nextInt(); 
			int data2 = sc.nextInt();
			System.out.println(map[data1][data2]);
	
			int data3 = sc.nextInt();
			int data4 = sc.nextInt();
			char temp = 0;
			
			// ��ǥ����

		if((data1 == data3) && (data4 == (data2)+1)){
			temp = map[data1][data2];
			map[data1][data2] = map[data3][data4];
			map[data3][data4] = temp;
			System.out.println(map[data3][data4]);
		}else if((data1 == data3) && (data4 == (data2)-1)) {
			temp = map[data1][data2];
			map[data1][data2] = map[data3][data4];
			map[data3][data4] = temp;
			System.out.println(map[data3][data4]);
		}else if((data2 == data4) && (data3 == (data1)+1)) {
			temp = map[data1][data2];
			map[data1][data2] = map[data3][data4];
			map[data3][data4] = temp;
			System.out.println(map[data3][data4]);
		}else if((data2 == data4) && (data3 == (data1)-1)) {
			temp = map[data1][data2];
			map[data1][data2] = map[data3][data4];
			map[data3][data4] = temp;
			System.out.println(map[data3][data4]);
		}else {
			System.out.println("�̿��� ��ǥ�� ���� �Է����ּ���.");
			continue;
		}
		// ����� ��ǥ�� �� �ݿ��Ͽ� ���
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
			System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
		}

	}

}
