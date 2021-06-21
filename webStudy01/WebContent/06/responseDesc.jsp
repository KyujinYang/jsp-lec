<%@ page language="java" pageEncoding="UTF-8"%>
<%--
	response.setContentType("text/plain; charset=UTF-8");
	response.setContentType("Content-type", "text/plain; charset=UTF-8");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/responseDesc.jsp</title>
</head>
<body>
<h4>HttpServletResponse (response기본객체)</h4>
<pre>
	: 서버에서 클라이언트로 전송되는 데이터를 캡슐화한 객체
	1.Response Line : protocol, status code(상태코드)
	<%--
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"강제 서버 에러");
		return;
	--%>
	
		** 상태코드 : 요청 처리의 결과를 표현하는 숫자 체계
		100~ : ing... // Http1 프로123
		
		.토콜 이상에서 사용
		200~ : 성공 OK q) 206번에러
 		300~ : 처리 완료를 위해 클라이언트로부터 추가적인 액션이 필요한 경우.
 			304 : Not Modified, 302/307 : (Moved < Location-ex:x의 자리가 오른쪽 x째줄로 변경되었어요) 
		[실패원인에 따라 구분]
		400~ : client side fail
			404 : (Not Found)
			405 : (Not suported method) 현재 메소드가 지원되지 않음 get post
 			415 : (Not supported Media type)
			400 : (Bad Request) 1.필수 파라미터 누락. 2. 파라미터 타입이 적절하지 않은 형태로 넘어왔을 때, 3. 파라미터 형태가 일정한 형식을 지키지 않았을 때 4. 파라미터 값의 길이가 맞지 않았을 경우
 			401 : (UnAuthorized- 권한 처리)
 			403 : (Forbidden - 완전히 막는다) 
 		500~ : Server side fail
 			 -코드가 잘못되었을 경우 
 		500 : Internal Server Error
 		
 			 -	 
	2.Response Header : Meta data, setHeader(name, value);
		* Content-Type : body영역의 데이터 mime
		* Cache-Control(http v1.1), Pragma(http v1.0), Expires(만료시간) : 캐시를 제어할 때 사용됨.(정보유출 보안 등)
			<a href ="cacheControl.jsp">캐시 제어 예제</a>
		
		* Refresh : auto request - 서버사이드,클라이언트사이드방식 -html,자바스크립트형태로 모두 발생가능하다.
			<a href = "autoRequest.jsp">Refresh를 통한 자동 요청</a>
		
		* Location : 페이지 이동
			<a href = "flowControl.jsp">페이지 이동</a>
		
	3.Response Body : 
	
</pre>
<img src = "<%=request.getContextPath() %>/resources/images/1.jpg" />


</body>
</html>