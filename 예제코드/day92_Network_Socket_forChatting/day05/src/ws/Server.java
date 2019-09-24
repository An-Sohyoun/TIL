package ws;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class SThread extends Thread {
	int port;
	Socket socket;
	OutputStream out;
	DataOutputStream dout;
	InputStream in;
	DataInputStream din;

	public SThread(Socket socket) throws IOException {
		this.socket = socket;
		out = socket.getOutputStream();
		dout = new DataOutputStream(out);
		in = socket.getInputStream();
		din = new DataInputStream(in);
	}

	public void run() {
		try {
			String str = din.readUTF();
			System.out.println(socket.getInetAddress() + " : " + str);			
			dout.writeUTF("This Feeling is hard to find");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dout != null)
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (din != null)
				try {
					din.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}

public class Server {
	boolean flag = true;
	ServerSocket serverSocket;
	Map<String, DataOutputStream> map = new HashMap<>();
	
	// 명령어 'l' 입력하면 접속 중인 userlist 뜨도록
	ArrayList<String> userList = new ArrayList<String>();
//	ObjectOutputStream oos = new ObjectOutputStream();
	// 'l'을 누르면 현재의 map이 userlist에 들어감
	// userlist를 ObjectOutputStream으로 출력
	
	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server Start..");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					while (flag) {
						System.out.println("Server Ready");
						Socket socket = serverSocket.accept();
						new ReCThread(socket).start();
						System.out.println(socket.getInetAddress() + " Connected");
						sendMsg(socket.getInetAddress() + " Connected");
					}
					System.out.println("Server Dead...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(r).start();
	}

	public void start() throws IOException {
		Scanner sc = new Scanner(System.in);
		try {
			boolean inflag = true;
			System.out.println("Input Msg");
			while (inflag) {
				String instr = sc.next();				
				sendMsg(instr);
				if (instr.equals("q"))
					break;

			}
		} catch (Exception e) {
			throw e;
		} finally {
			sc.close();
		}
	}

	public void sendMsg(String msg) {
		SendThread s = new SendThread();
		s.setMsg(msg);
		s.start();
	}

	class SendThread extends Thread {
		String msg;

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void run() {
			Collection<DataOutputStream> col = map.values();
			Iterator<DataOutputStream> it = col.iterator();
			while (it.hasNext()) {
				try {
					it.next().writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();					
				}
			}
		}
	}

	class ReCThread extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream din;
		OutputStream out;
		DataOutputStream dout;
		boolean rflag = true;
		String ip;

		public ReCThread() {
		}

		public ReCThread(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(in);
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
			ip = socket.getInetAddress().toString();
			map.put(ip, dout);
			System.out.println("접속자 수: "+map.size());
		}

		public void run() {
			try {
				while (rflag) {
					String str = din.readUTF();							
					if(str.equals("q")) {
						map.remove(ip);
						System.out.println("나간후접속자수:"+map.size());
						break;
					}
					if(str.equals("l")) {
						// 'l'을 입력하면 현재 접속 중인 사용자 리스트 출력
						sendMsg(map.keySet().toString());
					}
					System.out.println(str);
					sendMsg(ip+": "+str);
				}
				
			}catch(Exception e) {
				//e.printStackTrace();
				System.out.println("비정상 아웃:"+ip);
				map.remove(ip);
				System.out.println("나간후접속자수:"+map.size());

				if(din != null) {
					try {
						din.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Server s = new Server(1234);
		s.start();
	}
}
