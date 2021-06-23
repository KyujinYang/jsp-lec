<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer = "1kb" autoFlush="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/bufferDesc.jsp</title>
</head>
<body>
<h4>웹어플리케이션에서 버퍼 제어</h4>
<pre>
현재 512문자
	buffer : 속도차이를 보완하기 위한 임시 저장 공간(8kb)
	page 지시자의 buffer 속성으로 설정 변경.
	현재 버퍼의 서정 크기 : <%=out.getBufferSize() %>
	버퍼의 잔여크기 : <%=out.getRemaining() %>
	
	<%
		for(int i =1; i<=100; i++){
			if(out.getRemaining()<100){
// 				out.flush();//응답 전송
				out.clear();//한번 이상 flush된 이후에는 에러
				out.clearBuffer();
			}
// 			if(i==99){
// 				throw new NullPointerException("강제 발생 예외");
// 			}
 			out.println(i+"번째 반복");
		}
	//버퍼크기 잘못 설정, 버퍼 예외처리
	//스트림의 종류, 분류방법, 분류단계
	
	%>

</pre>
</body>
</html>