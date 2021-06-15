<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/requestDesc.jsp</title>
</head>
<body>
<h4>HttpSevletRequest request</h4>
<pre>
	: 클라이언트와 그로부터 발생한 요청에 대한 모든 정보를 가진 객체.
	
	http request spec
	
	1.Request Line : Protocol URL Method - 명령 식별
	  Method : 요청을 발생시킨 목적 (의도)
	  R - GET
	  C - POST
	  U - PUT/PATCH
	  D - DELETE
	  options : preflight 요청으로 특정 메소드의 지원 여부를 확인할 목적의 요청에 사용.
	  head : response 를 받아 올 때 body를 제외하고 싶은 요청에 사용
	  trace : server debugging
	  
	2.Request Header : 클라이언트에 대한 메타 정보 영역.(meta data영역) 이름과 값의 쌍
	3.Request Body(Message Body, Contents Body) //get방식 때 body 존재하지 않음.
		: 서버로 전송할 메시지 영역,
	
	Line ==> <%=request.getProtocol() %><%=request.getRequestURI() %><%=request.getMethod() %>
	<%=request.getHeaderNames() %>
	Body ==> <%=request.getInputStream().available() %>
			<%=request.getCharacterEncoding() %>
			<%=request.getContentLength() %> 
<!-- 			contents에서의 size -->
			<%=request.getContentType() %>
<!-- 			post일경우에만 받아올 수 있음 body영역 -> 2진데이터 excel -> line -->

</pre>
<table>
	<thread>
		<tr>
			<th>헤더명</th>
			<th>헤더값</th>
		</tr>	
	</thread>
	
	<tbody>
		<%
			Enumeration<String> names = request.getHeaderNames();
			while(names.hasMoreElements()){
		%>
				<tr>
				<%
				//이름과 값의 쌍 찾기
				String headerName = names.nextElement();
				String headerValue = request.getHeader(headerName);
				%>
				<th><%=headerName %></th>
				<th><%=headerValue %></th>
				</tr>
			<%	
			//max-age가 0이면 캐시데이터를 저장하지마라.
			}
			%>
	</tbody>
</table>
</body>
</html>