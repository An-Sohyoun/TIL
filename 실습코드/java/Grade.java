package ws;

public class Grade {
//	4������ ������ �Է� �޴´�.����, ����, ����, ����
//	�Է� ��: 89 92 89 100
//
//	�Է� ���� ������ �̿��Ͽ� ������ ��� �Ͻÿ�
//	1. ���� ��� �Ͻÿ�
//	2. ����� ��� �Ͻÿ�
//	3. ����� 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, ���ϸ� F
//	4. �ְ����� ������ ��� �Ͻÿ�
//	5. �������� ������ ��� �Ͻÿ�
//	6. �������� ���� 
//	7. �������� ����
	
	 private int [] data;

	 public Grade() {
	 }

	 public Grade(int[] data) {
	  this.data = data;
	 }
	 
	 // 1. ��
	 public int sum() {
		 int sum = 0;
		 for(int a:data) {
			sum += a; 
		 }
		 return sum;
	 }
	 
	 // 2. ���
	 public double avg() {
		 double avg = sum();
		 avg = sum() / data.length;
		 return avg;
	 }
	 
	 // 3. ������ ���� ����
	 public String grade() {
		 String grade = "";
		 if(avg()>=90){ 
			 grade = "A";
		 }else if(avg()>=80) {
			 grade = "B";
		 }else if(avg()>=70) {
			 grade = "C";
		 }else if(avg()>=60) {
			 grade = "D";
		 }else {
			 grade = "F";
		 }
		 return grade;
	 }
	 
	 // 4. �ְ����� ���� ����
	 public String max() {
		 int a[] = data;
		 int max = a[0];
		 int b = 0;
		 for(int i=0; i<a.length;i++) {
			 if(max<a[i]) {
				 max = a[i];
				 b = i;
			 }
		 }
		 switch(b) {
		 case 0:
			 return "����";
		 case 1 :
			 return "����";
		 case 2 :
			 return "����";
		 default : 
			 return "����";
		 }
		
	 }
	 
	 // 5. �������� ���� ����
	 public String min() {
		 int a[] = data;
		 int min = a[0];
		 int b = 0;
		 for(int i=0; i<a.length; i++) {
			 if(a[i]<min) {
				 min = a[i];
				 b = i;
			 }
		 }
		 switch(b) {
		 case 0:
			 return "����";
		 case 1 :
			 return "����";
		 case 2 :
			 return "����";
		 default : 
			 return "����";
		 }
	 }
	 
	 // 6. �������� ����
	 public int[] asort() {
		 int a[] = data;
		 for(int i=0; i<a.length; i++) {
			 for(int j=0; j<a.length-1-i; j++) {
				 if(a[j+1]<a[j]) {
					 int temp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = temp;
				 }
			 }
		 }
		 return a;
	 }
	 // 7. �������� ����
	 public int[] dsort() {
		 int a[] = data;
		 for(int i=0; i<a.length; i++) {
			 for(int j=0; j<a.length-1-i; j++) {
				 if(a[j]<a[j+1]) {
					 int temp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = temp;
				 }
			 }
		 }
		 return a;
	 }
	

}
