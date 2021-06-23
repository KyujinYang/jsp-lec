<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션(HttpSession)</title>
</head>
<body>
<h4>세션(HttpSession)</h4>
<pre>
	: Http가가진 Stateless의 단점을 보완하기 위한 최소한의 상태정보를 저장하는 개념
	단, 해당 상태정보가 서버에 저장된 경우 : session
		클라이언트에 저장된 경우 : Cookie

	

	session lifecycle :
	1. 클라이언트로부터 최초의 요청이 발생하면 생성.(ID가 부여)
	ID : <%=session.getId() %>, <%=new Date(session.getCreationTime()) %>
	2. 최초의 요청에 대한 응답에 ID가 실려서 클라이언트로 전송.
	3. 다음요청이 발생할 때 서버로 ID가 재전송되면 세션이 유지됨.
	<%=new Date(session.getLastAccessedTime()) %>
	
	2번과 3번 단계에서 세션ID를 주고 받는 방법(Tracking-mode)
	- COOKIE : JSSESION와 같은 형태의 쿠키로 세션 아이디를 주고받는 방법.
				(저장을 하지 않으면 유지되지 않는다)
	- URL	 : jssesioned와 같은 세션 파라미터의 형태로 주고받는 방법.
					<a href="sessionDesc.jsp;jssessionid=<%=session.getId()%>">세션을 유지하는 방법</a></hr>
			  단점:  sessionhijacking의 위험성이 있음. 제한적으로 사용될 때 사용. 
<!-- 			http://localhost/webStudy01/08/sessionDesc.jsp;jssessionid=EF1218C8F7771A90342A1FF4C4F65E77 -->
	- SSL 	 :  -쿠키나 URL 단점 보완
				(SSL)(Secure Socket Layer - > Transfer Layer Secure TLS)
				
				-OpenSSL 툴사용해 사용해야함(공인인증서 등 공인된 상위기관이 인증해줄 때 보강 )
				
	 4. 세션의 소멸 이벤트 : timeout 이내의 새로운 요청이 발생하지 않으면 소멸
	 	1) 명시적 로그아웃
	 	2) 브라우저 종료
	 	3) 쿠키 삭제
	 	4) timeout에 의해서


</pre>


1.세션-쿠키 의 차이점	: 
클라-서버 대화 : 둘다 저장공간을 갖고 있다.
어떤 상태 정보가 있을 경우 
1)상태유지하기위한 저장공간을 서버가 관리하면 세션
2)상태유지하기위한 저장공간을 클라이언트가 관리하면 쿠키

 

2. 세션-쿠키 의 동질성 : http가 가지고 있는  ---의 단점을 보완하기 위해 만들어짐
//http의 단점 : 질문 -> 응답이 저장되어있지 않음. (대화, 상태유지불가)
1) 사용목적이 같음.

책검색 
http request -> 검색하면 상태유지가 안됨. 책1과 책2는 같은 장바구니에 넣을 수 가 없다. stateless방식이기에 x
session -> 똑같은 장바구니에 2개 이상의 상품을 집어넣으려면 request방식이 아닌 session으로 저장

+
3.servletContext : (*싱글톤) 1개의 어플안에서 1서블릿공간을 저장.
그게 단점. 1개만하니까..

불특정 다수 1사람을 위해 저장
a가 as에게 요청을 발생했을 때 세션발생
마지막요청을 했을 경우 세션 끝 (그래서. 만료시간 -톰캣, 서버세션만료(timeout) 마지막요청과-경과시간을 두고 일정시간이 흐르면 종료)

1:다 세션 가능하므로 세션으로 구분이 가능해야한다.
(1pc - asdfasdfkl;kl;qk 세션id부여)
(1phone - asdfqtbkxl;kl;ks 세션id부여)

1pc - id 2222 들고 다시 클라에게 갔다가 나옴

세션트래킹모드 - 세션, 쿠키 
id가 잇냐없냐를 가지고 첨에 클라에서 서버로 세션이동 (id없음)
서버에서 클라로 갈때 (id있음..)

---------------
---------------------------
</body>
</html>