<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionLogin</title>
<style>
form{
   margin : 80px 120px; 
}
#submit{
   text-align: center;
}
</style>
</head>
<body>
<%
   String userId="";

   HttpSession se = request.getSession();
   String sessionId = (String)se.getAttribute("userId");
   String sessionPass = (String)se.getAttribute("userPass");
   if(sessionId!=null){
      userId = sessionId;
   }


   if(userId.equals("admin") && sessionPass.equals("1234")){
%> 
      <!-- 로그인 되었을때  -->
      <form>
      <h2><%= userId%>님 반갑습니다.</h2>
      <a href="<%= request.getContextPath()%>/sessionLogout.do">로그아웃</a>
      </form>
<% 
   }else{
   
%>
   <!-- 로그인 안되었을때  -->
   <form method='post' action="<%= request.getContextPath()%>/sessionLogin.do">
   <table border='1'>
   <tr>
   <td>ID:</td>
   <td><input type="text" placeholder="ID를 입력하세요" name="id" value="<%= userId %>"></td>
   </tr>
   <tr>
   <td>PASS:</td>
   <td><input type="password" placeholder="PASSWORD를 입력하세요" name="pass"></td> 
   </tr>
   <tr>
   <td colspan="2" id='submit'><input type="submit" value="Login">   </td>
   </tr>
   </table>
   </form>
<%
   }
%>   

</body>
</html>