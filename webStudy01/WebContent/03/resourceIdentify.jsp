<%@page import="kr.or.ddit.servlet01.ImageListServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4> 자원의 식별 </h4>
<pre>
	1.file system resource : c:\contents\cat01.jpg
	2.web resource : (URL/URI), http://localhost:port/contextPath/images/0.jpg
	3.res => classpath resource(파일) : /kr/or/ddit/servlet01/0.jpg
	
	<%
		File fileSystemRes = new File("c:/contents/cat01.jpg");
		//파일시스템 상의 진짜경로가 돌아온다.
		String realPath = application.getRealPath("/images/0.jpg");
		//서버사이드에서는 context패스 사용 안한다. request.getContextPath()"/images/0.jpg"
		File webRes = new File(realPath);
		
		String realPath2 = ImageListServlet.class.getResource("/kr/or/ddit/servlet01/0.jpg").getFile();
		File classPathRes = new File(realPath2);
		
		String userAgent = request.getHeader("user-agent");
		

%>

	
	
	
<!-- 1, 2, 3 출력 -->
	<%=fileSystemRes.length() %>
	<%=realPath %> : <%=webRes.length() %>
	<%= realPath2.length()%>
	
	**web resource 식별 방법
	URI(Uniform Resouce Identifier) : 자원을 식별하는 방법 총칭(포괄)
	URL(Uniform Resouce Locator) : 자원의 위치를 기준으로 식별
	URN(Uniform Resouce Name) : 자원의 등록된 이름으로 식별
	URC(Uniform Resouce Content) : 자원의 등록된 콘텐츠로 식별
	<%=request.getRequestURI() %>
	<%=request.getRequestURL() %>
	
	<%out.print ("USER AGENT IS " +userAgent);%>
		자원에 접근하는 경로 표기법
		1. 상대 경로 : 경로가 생략된 구조. wild card(., ..)
				  - 현재 위치(브라우저의 주소)를 기준으로 실제 자원의 절대 경로를 판단함.
				  
				  
		2. 절대 경로 :  "/"로 시작.
			1) client side : context root 부터 시작되는 경로 표기
		 	2) server side : context root 이후의 경로를 표기함.(서버사이드에서는 상대경로를 사용하지 않는다.)
			
</pre>
<img src="../images/1.jpg" />
<img src="http://localhost/webStudy01/images/2.jpg" />
<!-- url-> uri방식으로 바꾸기 : 
<img src="images/0.jpg" /> 했을 경우 context명이 빠짐 webStudy01
console에 document.location protocol/ host / ...하면 알고있는 정보는 나온다.
-->
<img src="<%=request.getContextPath() %>/images/0.jpg" />
<%-- <img src="${ContextPath()}/images/0.jpg "/> --%>
</body>




</html>