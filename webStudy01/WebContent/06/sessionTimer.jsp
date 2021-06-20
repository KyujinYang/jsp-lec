<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


1. 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/sessionTimer.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
<script type="text/javascript">
	$.customAlert("메시지");
	$(function(){
		let element = $("#timerArea").sessionTimer({
			timeout : <%=session.getMaxInactiveInterval() %>
			url :"<%=request.getContextPath()%>/sessionExtend"
		
		console.log("=========");
		console.log(element);
		
	});
</script>
</head>


<body>
	<h4>세션타이머</h4>
	<%=session.getId() %>
	:
	<%=session.getMaxInactiveInterval()%>
	<h4 id="timerArea"></h4>
	1. 1초마다 출력되는 시간을 디스카운트
	<br> 2. 1분남은 시점에 메시지를 출력.
	<br> 세션 연장 여부를 확인. 
	3. 세션 연장을 선택한 경우, 
		a) 타이머 리셋 
		b) 세션 연장을 위한 새로운 요청 발생(비동기, body가 없는 응답)

	<div id="messageArea"> 세션을 연장할까요? 
	<input type="button" id="yesBtn" value="예" /> 
	<input type="button" id="noBtn" value="아니오" />


	</div>


	

	<!-- 맥시멈타임값 - 세션만료시간, inactive -->
	<!-- int-초 -->
	<!-- long - millisecond -->
</body>
</html>