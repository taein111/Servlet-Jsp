//package com.newlecture.web.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//@WebFilter("/*")
//public class CharacterEncodingFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest arg0,
//			ServletResponse arg1,
//			FilterChain arg2)
//			throws IOException, ServletException {
//		System.out.println("before Filter");
//		arg0.setCharacterEncoding("UTF-8");
//
//		arg2.doFilter(arg0, arg1);
//		System.out.println("after Filter");
//	}
//
//}
