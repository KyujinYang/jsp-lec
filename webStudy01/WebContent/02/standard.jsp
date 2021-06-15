<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/Standard.jsp</title>
</head>
<body>
<h4>JSP(Java Server Page)표준 구성요소</h4>

<pre>
	1. 정적 테스트(Front-End, client side module) : HTML, JavaScript, CSS
	2. Back-End, Server side
		1) scriptlet:<% //java code %>, (변수선언시)지역 코드화
		2) expression : <%="출력 데이터" %>
		3) directive : <%-- <%--@ 지시자명 %> --%>
			-page	 : 현재 jsp 페이지에 대한 설정정보(mime, import, errorPage..)
			-include : 정적 내포
			-taglib : 커스텀 태그 라이브러리 로딩
		4) declaration : <%! //전역멤버선언 %>
		5) comment : <%-- --%>ctrl + shift + c
			-client side comment : HTML, Javascript, css
<!-- 			<div></div> ctrl + shift + c-->
			<script type = "text/javascript">
				자바스크립트 주석
			</script> 
			<style type ="text/css">
/* 				table{ */
/* 				} */
			</style>
			-server side comment**********
			<%
				//single line
				/* multi line주석 */
				/** document */
				
			%>
			<%--
				jsp comment 
			--%>
	3. 기본객체
	4. 액션태그
	5. EL(표현언어)
	6. JSTL(tag library)
	
	이번달 이 나타나야해 전달, 후달, 달력받아오기
	년도 달나타나기
</pre>
</body>
</html>

<!-- //갑자기 궁금.
텍스트 html이랑 이미지파일이랑 같이 출력하고싶을때는 ?ㅇㅅㅇ...?????????????????????????????? -->