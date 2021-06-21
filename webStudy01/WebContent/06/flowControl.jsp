<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/flowControl.jsp</title>
</head>
<body>
<h4>웹어플리케이션에서 흐름 제어 (A->B)</h4>
흐름제어의 차이점
Http: connectess/ statless
statful

1.Request Dispatch : 도착지도 이동하는 과정에서 원본 요청에 대한 정보를 가지고 분기.
	1) foward  : 이동하기 전 버퍼의 1번 내용을 clear 시키고 이동.
	
	2) include : 이동할 때 버퍼의 1번 내용과 같이 A->B로 이동한다. 다시 A로 이동.(3번)  
				- 도착지에서 만들어진 결과데이터를 가지고 복귀한다. 내용가지고 이동
				같이 이동하는 response
				
				
<!-- 	코드화하기 destination(page)-->
<%-- 	<%	 
		//contextpath인 /webStudy01을 사용할거냐 말거냐...? 서버사이드니 필요 X 클라이언트사이드는 필요 destinationB의 qNAME 복붙
		String dest = "/07/desinationB.jsp";
		RequestDispatcher rd =  request.getRequestDispatcher(dest);
		//rd.forward(request, response);
		rd.include(request,response);
		
	%> --%>
2.Redirect	: Http의 Stateless 특성에 따라 이동하는 과정에서 원본 요청에 대한 정보가 삭제된다.
		      이동하는 과정에서 원본요청에 대한 응답이 먼저 전송(****);
	- body가 없고, 상태코드(302)+header(Location)로 구성된 응답이 전송
		---->Location 방향으로 클라이언트의 새로운 요청이 발생함
		(요청에 대한 모든 정보는 사라지게 되고 이후 새데이터로 요청.)
		<%
		
		//contextpath인 /webStudy01을 사용할거냐 말거냐...? 이건 클라이언트가 사용해서 필요해

			//String dest = "/webStudy01/07/desinationB.jsp"; 
			String dest = request.getContextPath() + "/07/desinationB.jsp";//응답데이터는 b에서나옴
			response.sendRedirect(dest);
	
			
			//각각의 특성파악하기!!! //web-inf/views폴더 
		%>
		
		
	
		
</body>
</html>