<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="javax.swing.JFileChooser"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/applicationDesc</title>
</head>
<body>
<h4>ServletContext application</h4>

<pre>
	: Servlet Container(WAS)와 해당 컨테이너 내에서 운영되는
	어플리케이션(context)에 대한 정보를 가진 객체
	 *파라미터 종류 - Request, 어플, 
	 *파라미터 전달 - xml
		1. 컨텍스트 초기화 파라미터 확보 
		<%= application.getInitParameter("contentsPath") %>
		2. 로그 기록.
		<% application.log("명시적으로 기록할 로그 데이터"); %>

		3. 서버나 컨텍스에 대한 정보 확인
		<%=application.getServerInfo() %>,
		<%=application.getMajorVersion() %>
		<%=application.getMinorVersion() %>
		4. 웹 리소스 확보(****)
		/resources/images/2.jpg
		/08/2.png
		
		<%
		//반드시 기억해라
		
		//1.파일읽기
 		String imageURL = "/resources/images/2.jpg";
// 		String realPath = application.getRealPath(imageURL);
// 		File readFile = new File(realPath);
// 		FileInputStream fis = new FileInputStream(readFile);
		//입력스트림
		//1-application
		String destURLStr = "/08/2.jpg";
		
		
		
		URL destURL = application.getResource(destURLStr);
		Path target =null;
		if(destURL==null){
			String destRP = application.getRealPath(destURLStr); //파일시스템상의 절대경로로 돌아간다.
			target = Paths.get(destRP);
		}else{ //파일이존재하면
			target = Paths.get(destURL.toURI()); //url->uri로 변환
			
		}		
		InputStream is = application.getResourceAsStream(imageURL);
		//2.dest로 복사
		Files.copy(is, target);
			
		%>
</pre>
	<img src="<%=application.getContextPath() %>/08/2.jpg"/>
</body>
</html>