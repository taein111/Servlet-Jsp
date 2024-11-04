package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int id = Integer.parseInt(request.getParameter("id"));	//여기서 getParameter를 통해 
 		//가져오는 값은 list 페이지의 제목을 클릭했을때 하이퍼링크 url (detail.jsp?id=)  를 통해 가져오는 것
 
 		String url = "jdbc:oracle:thin:@localhost:1521/xe";
 		String sql = "SELECT * FROM NOTICE WHERE ID=?"; //물음표에다가 값을 넣어줘야 한다. 
 		
 		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
	 		PreparedStatement st = con.prepareStatement(sql); //prepared는 는 쿼리문을 미리 준비한다 
	 		st.setInt(1, id); //첫번째 물음표에다가  id를 꽂아 넣겠다.
	 		ResultSet rs = st.executeQuery();
	 		
	 		rs.next();
	 		
			String title = rs.getString("TITLE");
			Date regdate  = rs.getDate("REGDATE");
			String writerId = rs.getString("WRITER_ID");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			Notice notice = new Notice(
					id,
					title,
					regdate,
					writerId,
					hit,
					files,
					content
					);
			
			request.setAttribute("n", notice);
			
			/*
	 		request.setAttribute("title", title);
	 		request.setAttribute("regdate", regdate);
	 		request.setAttribute("writerId", writerId);
	 		request.setAttribute("hit", hit);
	 		request.setAttribute("files", files);
	 		request.setAttribute("content", content);
			*/
	    
	    	rs.close();
	       	st.close();
	        con.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		//redirect(페이지요청 시 아예 다른페이지로 보내버리는 방식) 
 		
 		
 		//forward (작업했던 내용을 이어받아 처리하는 방식)
 		request
 		.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
 		.forward(request, response);//notice안에있는 detail.jsp를 요청하면서
 		//현재 사용하고 있는 저장소 객체와 출력도구를 같이 공유함 
 		
	}
}
