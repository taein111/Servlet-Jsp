package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class HelloServlet extends HttpServlet { //���� Ŭ���� ���������ڴ� public�̾���Ѵ�. httpServlet�� ��� �޾ƾ���
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                            throws ServletException, IOException { // ��ûó��, ����ó��, ����ó��
response.setContentType("text/html"); //���䰴ü�� ������ Ÿ�� �����ϱ�
PrintWriter out=response.getWriter(); //��� ��Ʈ�� ������

out.print("<html><body><h1>");  //Ŭ���̾�Ʈ���� html���� ���·� ��� ����ϱ�
out.print("Hello Servlet");
out.print("</h1></body></html>");

out.close();
}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
