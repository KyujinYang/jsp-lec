/**
 * 
 */
$.validationID=function(){
	 // 영문 소문자로 시작하고, 영문 소문자와 숫자로 이루어진 아이디가 6~15글자인지 체크하는 정규식
	return /^[a-z]+[a-z0-9]{5,14}$/.test(this);
}

$.validationPASS=function(){
	// 8~20글자의 영문 대소문자, 숫자, 특수문자이고
	// 1개 이상의 특수문자 또는 숫자를 포함하는지 체크하는 정규식
	return /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,20}$/.test(this)
}