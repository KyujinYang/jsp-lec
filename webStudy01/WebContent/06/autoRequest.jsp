<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Refresh" content="1> -->
<!-- 클라이언트 사이드 방식의 요청 -->
<!-- <meta http-equiv="Refresh" content="5;url=http://www.naver.com"> -->

<title>06/autoRequest.jsp</title>
<script type="text/javascript" src = "<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<%-- <%
   response.setIntHeader("Refresh", 1);
   //1초마다 새로고침을 수행 (서버사이드의 자동요청)
%> --%>
<h4><span id="timer"></span>초 뒤에 네이버로 이동</h4>
<h4>현재 서버의 시간: <%=new Date() %></h4>
<h4 id="watch">현재 클라이언트의 시간: <span></span></h4>
<h4> 자동요청을 통해 데이터를 갱신하는 방법 </h4>
<pre>
   1. server side : Refresh 응답 헤더를 통해 자동 요청 
   2. client side
      1) HTML : meta 태그의 http-equiv를 통해 refresh라는 html 헤더를 설정.
      2) Javascript : 스케줄링 함수의 활용
        ** 스케줄링 함수
        - setInterval : 주기적인 반복 작업에 활용
        - setTimeout  : 작업의 지연 시간을 설정하고, 한번 실행하는 구조 
</pre>
<!-- <script type="text/javascript">
let timer = $("#timer");

   //직계가 아니라도 빼낼 수 잇다
   //watch > span 직계만 가능
   
   let initValue =5;
   setInterval(function() {
      //시간데이터 discount하기
      $("#watch span").text(new Date());
      timer.html(--initValue);
         
   }, 1000); 
</script> -->
</body>
</html>.