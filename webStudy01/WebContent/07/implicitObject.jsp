<%@page import="com.sun.xml.internal.ws.client.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/implicitObject.jsp</title>
</head>
<body>
<h4>기본객체(기본객체)</h4>
<pre>
<%-- <%=request.getContextPath()%> --%>
<%-- <%//<%=request.getContextPath()와 <%=pageContext.getRequest() 는 같다%> --%>
<%-- <%=((HttpServletRequest)pageContext.getRequest()).getContextPath() %> --%>
<%-- ${request.getContextPath()} --%>
<%-- ${pageContext.request.contextPath} --%>
	: jsp container에 의해 서블릿 소스가 파싱될 때 자동으로 생성되는 객체
	가장빈번하게 사용되는 순서
	(*)1.request	  : client와 request에 대한 정보를 가진객체
	(*)2.response	  : client로 전송될 response에 대한 정보를 가진 객체
	(*)3.out(JspWriter) : 응답데이터를 버퍼에 기록할 출력 스트림.
		:  buffer를 제어하거나 상태를 확인할 때도 활용됨.
	(*)4.session(HttpSession) :하나의 클라이언트가 하나의 브라우저를 사용할 때, 
							해당 클라이언트를 식별할 용도로 사용됨. (세션-쿠키)
		<a href = "../08/sessionDesc.jsp" ></a>
	(**)5.application(ServletContext) : 현재 서버와 어플리케이션 자체에 대한 정보를 가진 객체. 싱글톤
	<a href = "../08/applicationDesc.jsp" ></a>
	6.config(SevletConfig) : rightsidecallback requestcallback? 
	7.page(object)==this : jsp인스턴스 자체
	8.exception(Throwable) : (pageEncoding="UTF-8" 뒤) isErrorPage="true" 추가
			에러나 예외가 발생했을 때 그 상황을 처리할 목적의 페이지에서 사용됨.
		page지시자의 isErrorPage = "true"인 경우에만 활성화 됨.
	(*****)9.pageContext : 모드든 기본객체 쭝 가장 먼저 생성도되고, 나머지 기본객체에 대한 참조를 가짐.
	
	7번 9번 공통객체 - 둘다 하나의 jsp객체를 필요로함
	2.요청들어올 때 생성, 나갈때 종료
	
</pre> 
</body>
</html>