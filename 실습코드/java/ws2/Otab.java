package ws2;

public class Otab extends Mobile {
	
	public Otab() {

	}

	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	public int operate(int time) { // 1�� ��� �� ���͸� 12 ���� �� �ܿ� ���͸� return
		// get : ������ ���� ��ȯ�� �� set : ������ ���ο� ���� ���� �� ����
		int result = this.getBatterySize();
		result -= time*12;
		this.setBatterySize(result);
		return result;
	}

	public int charge(int time) { // 1�� ��� �� ���͸� 8 ���� �� �ܿ� ���͸� return
		int result = this.getBatterySize();
		result += time*8;
		this.setBatterySize(result);
		return result;
	}

}
