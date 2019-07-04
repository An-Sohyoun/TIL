package w3;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		// 190520 workshop �� : �η縶��(2�ο�)-�⺻
	 
		/*
		 * 1.8X8 ��������� ����� (�׵θ��� ǥ��) 
		 * 2.�÷��̾�1,2���� ���� ����Ʈ�� �ش�. (1000P) 
		 * 3.�׵θ��� 1~100������ ���ڸ� �����ϰ� �迭�Ѵ�. 
		 * 4.�� �÷��̾ �ֻ����� �ѹ��� ���� ���� ���ڸ�ŭ �̵� 
		 * 5.�ش� ��ġ�� �ִ� ���ڸ�ŭ ����Ʈ ���� 
		 * 6.����ؼ� ������ �� ����Ʈ�� 0���ϰ� �� �÷��̾� �й�
		 */

	  // 1. 8x8 game map ����
	  // 1~100�� ���ڸ� �����ϰ� �迭
	  
	  int map[][] = new int[8][8]; // 8x8 map �迭 ����
	  Random r = new Random();
	  
	  for(int i=0; i<map.length; i++) {
	   for(int j=0; j<map[i].length; j++) {
	    map[i][j] = r.nextInt(100)+1;
	   }
	  }
	  
	  // �׵θ����� ���ڸ� �迭�ؾ� �ϹǷ� ����� ǥ�� ����
	  for(int i=1; i<map.length-1; i++) {
	   for(int j=1; j<map[i].length-1; j++) {
	    map[i][j] = 0;
	   }
	  } 
	  
	  // game map ���
	  for(int i=0; i<map.length; i++) {
	   for(int j=0; j<map[i].length; j++) {
	    System.out.print(map[i][j]+"\t");
	   }
	   System.out.println();
	  }
	 
	  
	  // 2. �÷��̾�� ����Ʈ ����
	  int point1 = 1000;
	  int point2 = 1000; // 1,000����Ʈ�� ������ �����ϴϱ� �ʱⰪ�� 1,000
	  System.out.println("������ �����մϴ�.");
	  
	  // 3. ���� ���� (���� ����Ʈ ǥ��, �ֻ��� ������ �̵�, ����Ʈ����)
	  
	  // player1�� player2�� ������ġ�� map[0][0]
	   int a = 0; // player1�� ������ġ
	   int b = 0; // map[a][b]
	   int c = 0; // player2�� ������ġ
	   int d = 0; // map[c][d]
 
	  while(true) {
	   System.out.println("---------------------------------------------");
	   System.out.println("���� ����Ʈ : ");
	   System.out.println("player1 : "+ point1 +" "+"player2 : "+ point2);
	   System.out.println("---------------------------------------------");
	   
	   // player1 ���� ����
	   Scanner sc = new Scanner(System.in);
//	   Thread.sleep(1000);
	   System.out.println("player1 �����Դϴ�. ���͸� ���� �ֻ����� �����ּ���.");
	   String start1 = sc.nextLine();
	   int data1 = r.nextInt(6)+1; // ������ ������ �������� �ֻ��� ���� ����(1~6)
	   // �ֻ����� �� 'data1'��ŭ �̵��ϱ�
	   System.out.println("player1�� �ֻ��� �� : "+data1); // ���� �ֻ����� ��
	   
	   if(a==0) { // ��
		   if((b+data1)>map.length-1) { // ��
			   int dist = map.length - 1 - b; 
			   a = (data1-dist);
			   b=7;
		   }else {
			   b += data1;
		   }
	   }
	   
	   else if(b==7) { // ��
		   if((a+data1)>map.length-1) {
			   int dist = map.length -1 - a;
			   b = map.length-1-(data1-dist);
			   a=7;
		   } else {
			   a += data1;
		   }
	   }
	   
	   else if(a==7) {
		   if((b-data1)>=0){
			   b -= data1;
		   } else {
		   a = map.length-1-(data1-b);		
			   b=0;
		   }
	   }
	   
	   else if(b==0) {
		   if((a-data1)>=0) {
			   a -= data1;
		   } else {
			   b = map.length-1-(data1-a);
			   a=0;
		   }
	   }
	   
	   point1 -= map[a][b];
	   
	   System.out.println("player1�� ���� ��ġ : "+a+" "+b); // ���� ��ġ ǥ��
	   System.out.println("player1�� ���� ����Ʈ : "+map[a][b]); // ���� ��ġ�� ��
	   System.out.println("player1�� ���� ����Ʈ : "+point1);
	   System.out.println();
	   
	   // plater2 ���� ����
//	   Thread.sleep(1000);
	   System.out.println("player2 �����Դϴ�. ���͸� ���� �ֻ����� �����ּ���.");
	   String start2 = sc.nextLine();
	   int data2 = r.nextInt(6)+1;
	   System.out.println("player2�� �ֻ��� �� : "+data2); // ���� �ֻ����� ��
	   // �ֻ����� �� 'data2'��ŭ �̵��ϱ� (������ c�� d�̿�)
	   
	   if(c==0) { // ��
		   if((d+data2)>map.length-1) { // ��
			   int dist = map.length - 1 - d; 
			   c = (data2-dist);
			   d=7;
		   }else {
			   d += data2;
		   }
	   }
	   
	   else if(d==7) { // ��
		   if((c+data2)>map.length-1) {
			   int dist = map.length -1 - c;
			   d = map.length-1-(data2-dist);
			   c=7;
		   } else {
			   c += data2;
		   }
	   }
	   
	   else if(c==7) {
		   if((d-data2)>=0){
			   d -= data2;
		   } else {
		   c = map.length-1-(data2-d);
			   d=0;
		   }
	   }
	   
	   else if(d==0) {
		   if((c-data2)>=0) {
			   c -= data2;
		   } else {
			   d = map.length-1-(data2-c);
			   c=0;
		   }
	   }
	   
	   
	   point2 -= map[c][d];
	   
	   System.out.println("player2�� ���� ��ġ : "+c+" "+d); // ���� ��ġ ǥ��
	   System.out.println("player2�� ���� ����Ʈ : "+map[c][d]); // ���� ��ġ�� ��
	   System.out.println("player2�� ���� ����Ʈ : "+point2);
	   System.out.println();
	   
	   // ������ 0 ���ϰ� �Ǵ� ����� ������ ������ ����Ǹ鼭 ���� ����� �˸�
	   if(point1 <= 0 || point2 <= 0) {
		   if(point1>point2) {
			   System.out.println("palyer2�� �¸��Ͽ����ϴ�."); 
		   }else {
			   System.out.println("palyer1�� �¸��Ͽ����ϴ�."); 
	   }
		   System.out.println("������ ����Ǿ����ϴ�."); 
		   sc.close();
		   break;
	  }
	  
	  
	  	  }

	}
}
