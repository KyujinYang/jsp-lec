<%@page import="kr.or.ddit.enumtype.BrowserType"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/userAgent.jsp</title>
<script tpye = "text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	const PATTERN = "당신의 브라우저는<span> %s </span>입니다. OS의 종류는<span> %o </span>입니다.";
	let resultArea = $("#resultArea");
		$("a:first").on("click",function(){
			event.preventDefault();
			//비동기 요청 발생시키기
		$.ajax({
			url : "<%=request.getContextPath()%>/04/getBrowserName",
			dataType : "json",  //request header(Accept) /reponse header(Content-Type)
								//text : text/plain, html : text/html, json : application/json, script : text/javascript
	//보낸 data
			success : function(resp) {
				
				let message = null;
				let Os = null;
				if(typeof resp == "string"){
					message = resp;
					Os =resp;
					
				}else{
					message = resp.browser;	
					Os = resp.Os;
				}
				//비동기 요청 stack 비우기
				resultArea.empty();
				resultArea.append(
					$("<p>").html(PATTERN.replace("%s", message).replace("%o", Os))
				)
			},
			error : function(errorResp) {	
				console.log(errorResp);
			}
		});
		return false;
	});
});
</script>
</head>
<body>
<a href="#">브라우저의 이름 받아오기 비동기로</a>
<div id = "resultArea"></div>
<pre>


<!-- String pattern = "<p>당신의 브라우저는 %s 입니다.</p>";		//대문자로 변환  -->
<!-- String userAgent = request.getHeader("user-agent").toUpperCase(); -->
<!-- out.println(pattern);		 --> 
<!-- out.println(userAgent);		 --> 

<!-- String browser = BrowserType.parseUserAgent(userAgent);  -->
<!-- 	Map<String, String> browserMap = new LinkedHashMap<>();  -->
<!-- browserMap.put("MSIE", "익스플로러 구버전");  -->
<!-- browserMap.put("TRIDENT", "익스플로러 최근버전");  -->
<!-- browserMap.put("OPERA", "오페라");  -->
<!-- browserMap.put("FIREFOX", "파이어폭스");  -->
<!-- browserMap.put("EDGE", "엣지");  -->
<!-- browserMap.put("CHROME", "크롬");  -->
<!-- browserMap.put("SAFARI", "사파리");  -->
<!-- browserMap.put("OTHER", "기타");  -->
<!--  */  -->


<!-- out.println(String.format(pattern,browser));  -->
	
</pre>
</body>
</html>