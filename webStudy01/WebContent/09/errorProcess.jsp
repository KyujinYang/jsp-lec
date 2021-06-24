<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!--     errorPage="/error/errorView.jsp" -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom error page</title>
</head>
<body>
    //특수한 부분에만 이 방법을 사용한다. errorPage = "/error/errorView.jsp" %>
1.지역적 에러 처리 : Page지시자 활용
<% 
	if(1==1)
		throw new SQLException("강제 발생 예외");
%>	
	2.전역적 에러 처리 : web.xml 파일활용
		- 발생한 예외 타입별 처리 : exception-type(2tnsdnl)
		- 에러 상태 코드별 처리 : error-code
</body>
</html>