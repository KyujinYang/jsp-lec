<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4><%=session.getAttribute("authId") %>님 로그인 실패 </h4>
<h4><%=session.getAttribute("mem_pass") %>님 로그인 실패 </h4>
</body>
</html>