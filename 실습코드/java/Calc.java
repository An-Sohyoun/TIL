package calc;

public class Calc {
	// 190523 workshop �� 
	private int [] data;
	
	public Calc() {
	}
	
	public Calc(int ... data) { // �迭 ǥ�� ��� ... ���� ǥ���� �� ����
		this.data = data;
	}
	
	// 1. Sum
	public int sum() { 
		int sum = 0;
		for(int a : data) {
			 sum += a;
		}
		return sum;
	}
	
	public double avg() throws Exception {
		double avg = sum();
		if( avg <= 0) {
		throw new Exception();
		}
		avg = sum()/data.length; 
		return avg;
		}
	
	// 2. Sort Asc
	public int[] asort() { // ���� ������ ū ����
		int a[] = data;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}	
				}				
		}
		return a; // data�� a�� �޾� ����� ���
	}
	
	// 3. Sort Desc
	public int [] dsort() { // ū ������ ���� ����
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
