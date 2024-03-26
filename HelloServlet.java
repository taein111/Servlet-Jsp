package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class HelloServlet extends HttpServlet { //서블릿 클래스 접근제한자는 public이어야한다. httpServlet의 상속 받아야함
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                            throws ServletException, IOException { // 요청처리, 응답처리, 예외처리
response.setContentType("text/html"); //응답객체에 컨텐츠 타입 지정하기
PrintWriter out=response.getWriter(); //출력 스트림 얻어오기

out.print("<html><body><h1>");  //클라이언트한테 html문서 형태로 결과 출력하기
out.print("Hello Servlet");
out.print("</h1></body></html>");

out.close();
}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
