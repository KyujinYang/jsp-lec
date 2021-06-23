<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 세션의 값을 확인하여 로그인 관련 정보를 가져온다 -->
<%
   //JSP문서에서 세션은 'session'이라는 이름으로 저장되어 있다.
   String userId = (String)session.getAttribute("loginId");
   
   //위의 'loginId'가 세션에 저장되어 있지 않으면 null이 반환된다.
%>

<%
   if(userId == null){//세션값이 없을 때
   %>


<!--로그인이 안되었을 때 보여줄 내용   -->
   <form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
   <table border = "1" style="margin:0 auto;">
   <ul>
   
      <li> 아이디
      			 </td>
      <td><input type = "text" name = "userid" placeholder="ID 입력하세요"></td>
   </tr>
   <tr>
      <td> PASS: </td>
      <td><input type = "password" name = "pass" placeholder="PassWord 입력하세요"></td>
   </tr>
   <tr>
      <td colspan = "2" style="text-align:center;">
      <input type = "submit" value = "Login">
   </tr>
   </table>
   </form>
<!-- ++++++++++++++++++ -->

<%
}else{ //세션값이 있을 때
%>
   <!--로그인이 되었을 때 보여줄 내용   -->
   <h3><%=userId %>님 반갑습니다.</h3>
   <a href = "<%=request.getContextPath() %>/sessionLogout.do">로그아웃</a>
<%
   }
%>
</body>
</html>