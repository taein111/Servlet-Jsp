package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
 		String sql = "SELECT * FROM NOTICE";
 		
 		List<Notice> list = new ArrayList<>();
 		
 		
 		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
	 		Statement st = con.createStatement();
	 		ResultSet rs = st.executeQuery(sql);
	 		
	 		while(rs.next()){  	
	 			int id = rs.getInt("ID");
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
	 			list.add(notice);
	 		}
	 		
			rs.close();
	    	st.close();
	     	con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		request.setAttribute("list", list);
 		//forward (작업했던 내용을 이어받아 처리하는 방식)
 		request
 		.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
 		.forward(request, response);//notice안에있는 detail.jsp를 요청하면서
 		//현재 사용하고 있는 저장소 객체와 출력도구를 같이 공유함 
 		
	}
}
