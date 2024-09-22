package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application =  request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			
			for(Cookie c : cookies) 
			if(c.getName().equals("value")) {
				x = Integer.parseInt(c.getValue());
				break;
				}
			
			int y = v;
			
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			
			String operator = "";
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result=0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			response.getWriter().printf("result is %d\n", result);
		}
		//저장	
		else {
//		application.setAttribute("value", v);
	//	application.setAttribute("op", op);
//		session.setAttribute("value", v);
//		session.setAttribute("op", op);
		Cookie valueCookie = new Cookie("value", String.valueOf(v)); //value값이 반드시 문자열 형태(url에 사용할 수 있는 형태)로 보내야한다
		Cookie opCookie = new Cookie("op", op);
		valueCookie.setPath("/calc2");//이 쿠키가 어느경우의 사용자로부터 전달되어야 하는지의 경로
		valueCookie.setMaxAge(24*60*60); //이 쿠키를 보내면 그 시간으로부터 하루동안 쿠키값을 유지한다.
		opCookie.setPath("/calc2"); 
		response.addCookie(valueCookie); //사용자에게 쿠키를 보냄
		response.addCookie(opCookie);
		
		response.sendRedirect("calc2.html");
		}
		
		
		
	}
}
