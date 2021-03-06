<%@page import="com.sun.org.apache.xalan.internal.xsltc.runtime.Operators"%>
<%@page import="kr.or.ddit.enumtype.OperatorType"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
//마샬링이용

<form name = "calForm" method = "post" action = "<%=request.getContextPath() %>/calculate.do">
	<input type ="radio" name= "mime"value="plain"
	data-type="text" checked  data-success="parsePlain"/>PLAIN
	<input type ="radio" name= "mime"value="json"
	data-type="json" data-success="parseJson"/>JSON/>JSON
	<input class ="form-control" type= "number" name="left" />
	<%
		OperatorType[] operators = OperatorType.values();
	%>
	
	<select name = "operator">
		<%
			for(OperatorType tmp : operators){
				%>
				<option value = "<%=tmp.name()%>"><%=tmp.getSign()%></option>
				<%
			}
		%>
	</select>
	
	연산자 UI : operator
	<input class ="form-control" type= "number" name="right" />
	<input type = "submit" value = "="/>
	<span id="resultArea"></span>
</form>



<script>
	let resultArea = $("#resultArea");
	let functions = { //function이 응답데이터 가지고 놀기
			//누굴 쓸건지 결정해
			parsePlain:function(resp){
				resultArea.text(resp);
			},
			parseJson:function(resp){
				resultArea.text(resp.expression);
			}
	}
	$("[name='calForm']").on('submit',function(event){
		event.preventDefault();	
		let url= this.action;
		let formData = new FormData(this); //폼태그넘기기.ㅌㅌ
		let data = {};
		for(let key of formData.keys()){
			console.log(key)
			console.log(formData.getAll(key));
			let values = formData.getAll(key);
			data[key] = values && values.length > 1 ? values:values[0];
			
		}
		console.log(data);

	    let method = this.method;
        let dataType = $(this).find("[name='mime']:checked").data("type");
        let success = $(this).find("[name='mime']:checked").data("success");
        let options = {};
        options.url = url;
        options.method = "post"; 

//		options.data = data;
		options.dataType = dataType;
 		options.data = JSON.stringify(data);
 		options.contentType = "application/json;charset = utf-8";
		options.success = functions[success];
		$.ajax(options);
		return false
	});
</script>