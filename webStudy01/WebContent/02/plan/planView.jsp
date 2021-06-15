<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file = "../plan/certificate.jsp" %>
  <%@ include file = "../plan/dbCon.jsp" %>

<%
String pdate = request.getParameter("pdate");
if(pdate == null){
%>
	<script>
	alert("잘못된 경로의 접근");
	self.close();
	</script>
<%
}

String sql = "select title,content from plan";
	   sql = "where user='"+USERID+"' and pdate='"+pdate+"'";
ResultSet rs = stmt.executeQuery(sql);   

String title = "";
String content = "";

if(rs.next()){
	title = rs.getString("title");
	content = rs.getString("content");
}else { 
%>
	<script>
	alert("잘못된 경로의 접근");
	self.close();
	</script>
<%
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<script>
$(function(){
	$("#pdate").datepicker({
		changeMonth : true,
		changeYear : true
	})
})

function fn_modify() {
	
	
}

function fn_delete(){
	if(confirm("정말 삭제하시겠습니까?")){ //확인, 취소
		//?pdate : javascript
		// < % = jsp변수 pdate%>
		location = "planDelete.jsp?pdate=<%=pdate%>";
		
	}
	
}
</script>
<style>
table{
	width : 380px;
	border-collapse : collapse; /*셀간격 없어짐*/
	
	}
	
th,td{
	border : 1px solid #cccccc; 
	padding : 5px;
}
.div1{
	width : 380px;
	text-align : center;
	margin-top : 10px;
	}
body{
	font-size : 9pt;
	font-family : 맑은 고딕;
	color : #333333;
}
caption {
	font-size : 30px;
	font-weight : bold;
	margin-bottom:5px;
	}
</style>
<body>
	<form name = "frm" method = "post" action ="planWriteSave.jsp">
	<table>
	<caption>일정등록</caption>
		<tr>
			<th width ="20%">날짜</th>
			<td width = "80%"><%=pdate %></td>
		</tr>
		<tr>
			<th >제목</th>
			<td><%=title %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td height = "150" valign="top"><%=content %></textarea></td>
		</tr>
	
		
	</table>
		<div class = "div1">
			<button type = "fn_modify();">수정</button>
			<button type = "fn_delete();">삭제</button>
			
			<button type = "button" onclick ="self.close();">닫기</button>
		</div>
	
	</form>
</body>
</html> 