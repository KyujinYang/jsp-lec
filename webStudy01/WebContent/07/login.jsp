<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
$(function(){
	$("#submit").submit(function){
		if(!$("#id")).val().validationID()){
			alert("형식이 맞지 않아요");
			return false;
	}
	}
})
	
	
	
	
})
$('#id').on('keyup',function(){
	idvalue = $(this).val().trim()
	if (idvalue.length < 4 || idvalue.length > 12) {
        	
            nopro(this, "2~5글자 사이를 입력해주세요.")
            return false;
	}
		$('#idchk').text('');
	}else{
		$('#idchk').text('숫자,문자,특수문자 1개 이상, 4~12자리입력');
		$('#idchk').css('color','red');
	}
});

//비밀번호 체크
$('#pass').on('keyup',function(){
	
	//정규식- 영문대소문자, 특수문자, 숫자가 반드시 한개 이상씩
	//입력값중 공백제거
	passvalue = $(this).val().trim()	//길이체크
    if (passvalue.length < 8 || passvalue.length > 12) {
        nopro(this, "8~12글자 사이를 입력해주세요.")
        return false;
    }
	
	//정규식- 영문대소문자,특수문자, 숫자가 반드시 한개이상
	
	//전방탐색 - 찾을 문자?= 기준문자  ht?=: (콜론앞에 문자를 찾아라)
	//* -> 0번이상문자[영문소문자]가온다.
	regpass = /^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[*!@#$%^&+=]).*$/;

	if(regpass.test(passvalue)){
		regpass.css("color","red")
		okpro(this)
	}else{
		regpass.css("color","red")
		nopro(this, "영문대소문자, 특수문자, 숫자가 1개이상 포함되어야합니다.")
	}
});



</script>
<body>
<form action = "<%=request.getContextPath() %>/login/loginCheck.do" method = "post">
	<ul>
		<li> 
			아이디 : <input type = "text" name = "mem_id" id = "id" required = "required" />
			<div class ="check" id="idchk"></div>
		</li>
		<li>
			비밀번호 : <input type = "text" name = "mem_pass" id = "pass" required = "required" />
			<input type = "submit" id = "submit" value = "로그인">
			<div class = "check" id ="passchk"></div>
		</li>
	</ul>
</form>


</body>
</html>

//조건1. 클라이언트사이드에서 검증
//조건2. 반드시 비밀번호는 영문자, 숫자 , 특수문자 포함하도록
//조건3. session 제이쿼리플러그인형태 