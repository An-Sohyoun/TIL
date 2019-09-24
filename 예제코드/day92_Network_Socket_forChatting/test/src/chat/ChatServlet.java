package chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/ChatServlet", "/chat" }) // ��ü�� ����� �� �� ���� ���۵Ǵ� �κ�
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Client client;
	
    public ChatServlet() { // ���� �� ��
    	try {
    		client = new Client("70.12.60.110",1234);
		} catch (IOException e) {
			e.printStackTrace();
		}       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �޽����� ����� ����
		String msg = request.getParameter("msg");
		client.sendMsg(msg);
	}


}
