package kr.or.ddit.servlet03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/03/parameterProcess")
public class ParameterProcessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getparameter는 첫번째 값만 가져온다. 
		//getParameteValues와 getParameter 공통점 parameter의 key값(이름)값 return String header의 name
		System.out.printf("현재 요청 메소드 : %s \n", req.getMethod());
		Map<String,String[]>parameterMap = req.getParameterMap();
		//		순차접근이 가능한경우에 향상된 for문 오른쪽에 쓸 수 있다. 따라서 1.요소의 집합을 꺼내와.(엔트리값)->순차적접근가능
		for(Entry<String, String[]> entry :parameterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s \n",paramName, Arrays.toString(paramValues));
			
		}
	}
/*	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getparameter는 첫번째 값만 가져온다. 
		//getParameteValues와 getParameter 공통점 parameter의 key값(이름)값 return String header의 name
		//String
		Map<String,String[]>parameterMap = req.getParameterMap();
		//		순차접근이 가능한경우에 향상된 for문 오른쪽에 쓸 수 있다. 따라서 1.요소의 집합을 꺼내와.(엔트리값)->순차적접근가능
		for(Entry<String, String[]> entry :parameterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s \n",paramName, Arrays.toString(paramValues));
			
		}
	}*/
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getparameter는 첫번째 값만 가져온다. 
		//getParameteValues와 getParameter 공통점 parameter의 key값(이름)값 return String header의 name
		//String
		Map<String,String[]>parameterMap = req.getParameterMap();
		//		순차접근이 가능한경우에 향상된 for문 오른쪽에 쓸 수 있다. 따라서 1.요소의 집합을 꺼내와.(엔트리값)->순차적접근가능
		for(Entry<String, String[]> entry :parameterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s \n",paramName, Arrays.toString(paramValues));
			
		}
	}
}
