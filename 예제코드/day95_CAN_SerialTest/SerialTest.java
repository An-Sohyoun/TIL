package can;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {

	private BufferedInputStream bin;
	private InputStream in;
	// ���� ���� can�� serial�� �����Ƿ� buffered �̿� ����

	private OutputStream out;
	// ���� ���� java�� �ƴ� ���� �־ OutputStream ���
	// buffered �ν� �� �� ���� ����

	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;

	public SerialTest() {
	}

	// SerialTest ������ ��, portName �޾ƿ�
	public SerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName); // ����ִ��� ����
		System.out.println("Connect Com Port!");
		try {
			// ������ ���
			connectSerial();
			System.out.println("Connect OK !!");
		    (new Thread(new SerialWriter())).start(); // canvas(CAN-bus)�� �����ϰڴ� �ǹ�
		} catch (Exception e) {
			// ��Ʈ�� �����ְų�, ������� �� �� ���
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}

	public void connectSerial() throws Exception {
		// ����ִ��� Ȯ�� ��, ������ �ִ��� Ȯ��
		if (portIdentifier.isCurrentlyOwned()) { // �ٸ� �ʿ��� ����ϰ� �ִ��� Ȯ��
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				// addEventListener�� serial���� event�� ���� ���� data�� ������
				// TCP/IP�� �׳� �޴µ�, �̰� data�� ���� ���� ����??? data ���� ����(?)����
				// Android���� ��ư�� ������ ���� ���� ��ư�� ����Ǵ� �Ͱ� ���� ����

				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(38400, // CAN ��żӵ�
						SerialPort.DATABITS_8, // ������ ��Ʈ
						SerialPort.STOPBITS_1, // stop ��Ʈ
						SerialPort.PARITY_NONE); // �и�Ƽ (������ ����)
				in = serialPort.getInputStream(); // in, bin, out �� stream
				bin = new BufferedInputStream(in);
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			this.data = ":G11A9\r";
			// CAN-bus�� ����ϰڴٴ� �޽���
		}

		public SerialWriter(String serialData) {
			// W28 00000000 000000000000 (���� �� ������)
			// :W28 00000000 000000000000 53 \r (���۵����� ��ȯ�ϱ�)
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}

		// ���۵����� ��ȯ�ϴ� ��
		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			serialData = serialData.substring(4,serialData.length()+1); 
			// 4�� °���� ������ cut
			// checksum�� ����� id�� data��! �׷��� checksum �����ϰ� ����
			
			System.out.println("serialData : " + serialData);
			
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}
			cdata = (cdata & 0xFF);

			// ������ ��ȯ
			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {

				byte[] inputData = data.getBytes();
				// byte�� �ٲ� ������ ����
				// this.data�� run�� ���Ͽ� write
				out.write(inputData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Thread
	public void sendData(String data) {
		SerialWriter sw = new SerialWriter(data);
		new Thread(sw).start();
	}
	
	public static void main(String[] args) {
		try {
			SerialTest st = new SerialTest("COM7"); // COM7 ��Ʈ�� ����
			// ������ ������
			st.sendData("W28000000010000000000000001"); 
			// ���۵�����
			// �տ� '00000001'�� ���̵� & '0000000000000001'�� ������
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		}
	}

	// ������ ����
	@Override
	public void serialEvent(SerialPortEvent event) {
		// ������ �޴� ����
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128]; // BufferedInputStream

			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer); // byte�� data�� ����
				}

				// ���� ������
				String ss = new String(readBuffer);
				boolean result = checkSerialData(ss.trim());
				System.out.println("Result:" + result);
				// �����Ͱ� 10 byte �� �����ϰ� ������ �����Ƿ� check �ʿ�
				System.out.println("Receive Low Data:" + ss + "||");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	// ������ üũ
	public boolean checkSerialData(String data) {
		boolean check = false;
		// :U28 00000001 0000000000010000  46
		// ���� ���·� �����Ͱ� ���� (�۽ź� + ���̵� + ������) / Checksum�� '46'
		String checkData = data.substring(1, 28);
		String checkSum = data.substring(28, 30);
		System.out.println("checkData : " + checkData);
		System.out.println("checkSum : " + checkSum);

		char c[] = checkData.toCharArray();
		int cdata = 0;
		for (char cc : c) {
			cdata += cc;
		}
		cdata = (cdata & 0xFF);
		String serialCheckSum = Integer.toHexString(cdata).toUpperCase();
		if (serialCheckSum.trim().equals(checkSum)) {
			check = true;
		}
		return check;
	}
}
