package tcp1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/*class ServerThread extends Thread {
	Socket socket;
	
	// server�� socket�� �����, socket���� stream ����
	OutputStream out;
	DataOutputStream dout;
	InputStream in;
	DataInputStream din;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		out = socket.getOutputStream();
		dout = new DataOutputStream(out); // Android�� AsynTask ����
		in = socket.getInputStream();
		din = new DataInputStream(in); // Client���Լ� ���� data ����
	}

	public void run() {
		try {
			String str = null;
			str = din.readUTF();
			System.out.println(socket.getInetAddress()+" : "+str);
			dout.writeUTF("�ȳ�");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(din != null) {
				try {
					din.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(dout != null) {
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}*/

public class Server {

	boolean flag = true; // accept�� ���� ������ while�� �ȿ��� ���
	boolean rflag = true;
	Map<String,DataOutputStream> map = new HashMap<>(); // map�� data �־���� sender..?
	
	Socket socket;
	ServerSocket serverSocket;
	
	public Server() {

	}

	public Server(int port) throws IOException {
		// port�� �ָ� server�� �غ� �� (������� ����?)
		// Network �غ� �� ��Ʈ �ߺ��Ǵ� ������ ��ȭ�� ����
		serverSocket = new ServerSocket(port); // port
		System.out.println("Server Start..");
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					while(flag) {
						System.out.println("ServerReady");
						socket=serverSocket.accept();
						new Receiver(socket).start();
						System.out.println(socket.getInetAddress());
					}
					System.out.println("Server END");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(r).start();
	}

	public void start() throws IOException {
		/*
		 * while (flag) { System.out.println("Server Ready.."); Socket socket =
		 * serverSocket.accept(); new Receiver(socket).start();
		 * System.out.println(socket.getInetAddress()); // ù��° ����� ���ͼ� socket�� ��������µ�
		 * // �ٸ� ����� ������ socket�� ������ �ٲ� // ���� ������ socket�� �������� �ʰ�, �Ź� ���� ����
		 * 
		 * //new ServerThread(socket).start(); // ���⿡ �����ع����� �ð��� ���� �ɷ��� // ���� ����� �����µ�
		 * �ð��� ���� �ҿ�� // �� ������ Thread class ���� ���� }
		 */
	//	System.out.println("Server End..");
		
	    // Server������ �޽����� ����
		Scanner sc = new Scanner(System.in);
		boolean sflag = true;
		while (sflag) {
			System.out.println("Input Msg.");
			String str = sc.next();
			sendMsg(str); // message�� ���� - sendMsg �Լ��� send��� Thread?
			// Start�� �Ǹ� socket�� �����ǰ�, Thread�� ���� �ְ� ����
			if (str.contentEquals("q")) {
				break;
			}
		}
		sc.close();
		
	}
	
	public void sendMsg(String msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	
	class Sender extends Thread{

		String msg;

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void run() {
			Collection<DataOutputStream> col = map.values();
			// .values �ϸ� map�� �ִ� key �� �����ϰ� value �� ������
			Iterator<DataOutputStream> it = col.iterator();
			while(it.hasNext()) {
				try {
					it.next().writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class Receiver extends Thread{
		Socket socket;

		boolean rflag = true;
		
		InputStream in;
		DataInputStream din;
		OutputStream out;
		DataOutputStream dout;
		
		String ip;

		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(in);
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
			ip = socket.getInetAddress().toString();
			map.put(ip,dout);
			System.out.println("�����ڼ� : "+map.size());	
		}

		public void run() {
			// �޴� ���Ҹ� ����
			try {
				while (rflag) {
					String str = din.readUTF();
					if(str.equals("q")) {
						map.remove(ip);
						System.out.println("�����ڼ� : "+map.size());
						break;
					}
					System.out.println(str);
					sendMsg(str);
				}
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("������ �ƿ�:"+ip);
				map.remove(ip);
				System.out.println("�����ڼ� : "+map.size());
				if(din != null) {
				try {
					din.close();
				}catch(IOException e1) {
					e1.printStackTrace();
					}
				}
			}finally {
				if(socket != null) {
					try {
						socket.close();
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Server server = null;
		try {
			server = new Server(8888);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
