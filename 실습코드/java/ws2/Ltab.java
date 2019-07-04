package ws2;

public class Ltab extends Mobile {
	
	public Ltab() 
    {
        super();
    }
 
    public Ltab(String mobileName, int batterSize, String osType) 
    {
        super(mobileName, batterSize, osType);
    }
	
	public int operate(int time) { // 1�� ��� �� ���͸� 10 ���� �� �ܿ� ���͸� return
		// get : ������ ���� ��ȯ�� �� set : ������ ���ο� ���� ���� �� ����
		int result = this.getBatterySize();
		result -= time*10;
		this.setBatterySize(result);
		return result;
	}

	public int charge(int time) { // 1�� ���� �� ���͸� 10 ���� �� �ܿ� ���͸� return
		int result = this.getBatterySize();
		result += time*10;
		this.setBatterySize(result);
		return result;
	}

}
