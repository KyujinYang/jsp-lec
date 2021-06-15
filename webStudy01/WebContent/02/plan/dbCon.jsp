<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>    
<!-- DB연결 -->    
<%
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user= "TEST";
String pass = "java";
// 접속드라이버 연결
Class.forName("oracle.jdbc.driver.OracleDriver");
// 접속정보 세팅
Connection conn = DriverManager.getConnection(url,user,pass);
Statement stmt = conn.createStatement(); // 인스턴스화(객체화==메모리에올림)
%>

<% request.setCharacterEncoding("utf-8");  %>