<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello");//페이지 개
%>
<body>
	<%=request.getAttribute("result") %>
	${requestScope.result}<br>
	${names[1]}<br>
	${notice.title}<br>
	${result}<br>
	${empty param.n? '값이 비어 있습니다.' : param.n}<br>
	${param.n == null || param.n == ''}<br> 
	${param.n/2}<br>
	${header.accept}
</body>
</html>