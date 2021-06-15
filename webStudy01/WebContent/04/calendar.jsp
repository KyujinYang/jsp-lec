<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@page import="sun.util.locale.LanguageTag"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>
<%@page import="static java.util.Calendar.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//현재서버시간 출력하기
//getInstance(TimeZone zone); - 
//1.클라이언트가 타임존 선택할수잇는 ui제공
//2.출력되는 서버시간 



	//  1. 클라이언트가 보내는 데이터에 특수문자가 있는지 확인
	request.setCharacterEncoding("UTF-8");
	// 	2. 파라미터꺼내기
	String yearStr = request.getParameter("year");
	String monthStr = request.getParameter("month");
	//lang
	String lan = request.getParameter("language");

	String sunday = request.getParameter("sunday");
	//우선순위가 가장높은 로케일 정보가 들어옴. Accept-Language : ko-KR; q=0.9, en-US; ..
	Locale locale = request.getLocale();
	//lan 파라미터 있으면...기본로케일
	if (lan != null && !lan.isEmpty()) {
		locale = Locale.forLanguageTag(lan);
	}
	//언어의 따른 value처리
	DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);

	//  3. 클라이언트의 데이터는 믿어서는 안된다. 검증이 필요!
	Calendar cal = getInstance();
	if (yearStr != null && yearStr.matches("\\d{4}")) {
		//int currentYear = Integer.parseInt(yearStr);
		cal.set(YEAR, Integer.parseInt(yearStr));
	}
	if (monthStr != null && monthStr.matches("\\d{1,2}")) {
		//Integer.parseInt(monthStr);
		cal.set(MONDAY, Integer.parseInt(monthStr));
	}

	cal.set(DAY_OF_MONTH, 1);
	int offset = cal.get(DAY_OF_WEEK) - 1;
	int lastDate = cal.getActualMaximum(DAY_OF_MONTH);

	int year = cal.get(YEAR);
	int month = cal.get(MONTH);
	//전달력
	cal.add(MONTH, -1);
	int beforeYear = cal.get(YEAR);
	int beforeMonth = cal.get(MONTH);

	//다음달
	cal.add(MONTH, 2);
	int nextYear = cal.get(YEAR);
	int nextMonth = cal.get(MONTH);

	//현재달력으로 바꾸기
	cal.add(MONTH, -1);
	
	cal.add(DAY_OF_WEEK, 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/calendar</title>
<style type = "text/css">
	.sunday{
		color : red;
	}
	
	.saturday{
		color : blue;
	}
	
	.current{
		color : green;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script>
	var sunday = 
</script>
</head>
<body>
	<h4>현재 서버의 시각 : <%=String.format(locale, "%tc", cal) %></h4>
	<%-- <%=String.format("%tc", cal) %> --%>
	<h4>
		<!-- 	(calendar.jsp)? -->
		<a
			href="#" class="moveA" data-year="<%=beforeYear %>" data-month="<%=beforeMonth%>">이전달</a>
		<!-- 시간연도 4글자, (t시간)b(로케일에따른'월'데이터), cal, cal  -->
		<%=String.format(locale, "%1$tY, %1$tB", cal)%>
		<a href="#" class="moveA"data-year="<%=nextYear %>" data-month="<%=nextMonth %>">다음달</a>
	</h4>
	<form id="calendarForm">
		<input type="number" name="year" placeholder="<%=year%>"
			value="<%=year%>" /> <select name="month">
			<option value>월선택</option>
			<%
				String optionPtrn = "<option %s value='%s'>%s</option>";
				String[] months = dfs.getMonths();
				for (int tmp = 0; tmp < 12; tmp++) {
					String selected = (tmp) == month ? "selected" : "";
					out.println(String.format(optionPtrn, selected, tmp, months[tmp]));
				}
			%>

		</select> <select name="language">
			<%
				Locale[] locales = Locale.getAvailableLocales();

				for (Locale tmpLoc : locales) {
					//국가마다 사용하는 언어가 같아도 코드(tag)값이 달라진다.
					String tag = tmpLoc.toLanguageTag();
					String name = tmpLoc.getDisplayName();
					//문자열이 비어있는지 확인
					//String selected = tag.equals(locale.toLanguageTag())?"selected":"";
					String selected = (tmpLoc.equals(locale)) ? "selected" : "";
					if (name.isEmpty())
						continue;
					out.println(String.format(optionPtrn, selected, tag, name));

				}
			%>
		</select>

	</form>

	<table>
		<thead>
			<tr>
				<%
					String[] weekDays = dfs.getWeekdays();
					String thPtrn = "<th>%s</th>";
					for (int idx = SUNDAY ; idx <= SATURDAY; idx++) {
						out.println(String.format(thPtrn, weekDays[idx]));
					
					}
	
				%>
				
				
			</tr>
		</thead>
		<tbody>
			<%
				//폼만들기!
				//현재 달의 달력
				String pattern = "<td>%s</td>";
				int number = 1;
				for (int row = 1; row <= 6; row++) {
					out.print("<tr>");
					for (int col = SUNDAY; col <= SATURDAY; col++) {
						int dateNumber = number++ - offset;
						String printNumber = dateNumber >= 1 && dateNumber <= lastDate ? dateNumber + "" : "&nbsp;";
						out.println(String.format(pattern, printNumber));
					
				}
				
					
				}
			%>

		</tbody>
	</table>
	<script type="text/javascript">
		// "change", "-- ", function(){ descendent 구조 사용
		// :input모든 input 태그 사용
		let calForm = $("#calendarForm").on("change", ":input", function() {
			console.log(this.form);
			console.log(calForm[0]);
			this.form.submit() //html 엘리먼트가 갖고있는 submit
			//sumit 이벤트 줄 건 form태그 
			//		calForm.submit(); //j쿼리 엘리먼트가 갖고있는 submit
		}).on("submit", function() {
			console.log("-----------------------")
			return true;
		});
		
		$(".moveA").on("click",function(event){
			//요청 취소
			event.preventDefault();
			let year = $(this).data("year")
			let month = $(this).data("month")
			
			calForm.find("input[name='year']").val(year);
			//calForm.find("select[name='month']").val(year);
//			calForm.get(0).month//html엘리먼트
			$(calForm.get(0).month).val(month);//jquery
			calForm.submit();
			//이전달,다음달 클릭시 가지고 놀아야해...ㅠ_ㅠ..
			
			return false;
		});
		
	</script>
</body>
</html>