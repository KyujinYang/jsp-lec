<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${name }님 <br>
<h4><%=session.getAttribute("memId") %>님 로그인 성공 </h4>
로그인 성공하였습니다 

</body>
</html>