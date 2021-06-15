package kr.or.ddit.servlet02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ReadTmlServlet extends HttpServlet{
	ServletContext application;
	@Override
	public void init() throws ServletException {
		super.init();
		application = getServletContext();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//req.getServletPath(req)
		
		StringBuffer template = readTemplate(req);
		makeData(req);
		String mime = getMime();
		resp.setContentType(mime);
		makeResponseContents(template, req, resp);
	}
	protected abstract String getMime();
		//1.tmpl 읽기
		private StringBuffer readTemplate(HttpServletRequest req) 
				throws IOException{ 
			StringBuffer template = null;
			String tmplPath = req.getServletPath();
			InputStream is = application.getResourceAsStream(tmplPath);
			//BufferedReader reader = null;//1.7부터는 안써도됌.
			if(is!=null) {
				try(//1.7부터 스는법
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				) {
				template = new StringBuffer();
				String tmp = null;
				while((tmp=reader.readLine())!=null) {
					template.append(String.format("%s\n",tmp));
				}				
				reader.close();
			
				}//finally { //1.7부터는 안써도됌.
					//if(reader!=null)
						//reader.close();
				//}
			}
			return template;
	}
		
		
	//2.데이터 만들기(**)
		protected abstract void makeData(HttpServletRequest req);
	//3.실제 데이터로 구멍을 치환가능
	//4.콘텐츠로 응답전송
		private void makeResponseContents(StringBuffer template, 
				HttpServletRequest req, 
				HttpServletResponse resp
	    ) throws IOException{
			if(template ==null) {return;}
			if(resp.isCommitted()) {return;}
			String tmplSrc = template.toString();
			//정규표현식{} 메타데이터이므로 이스케이프문자로 바꿔줘 ->일반문자화
			//[] 한글자의 문자패턴을 괄호안에서만 찾겟다.[a-zA-Z0-9] ==>[\\w_] / *는 0글자도 가능 +는 한글자 이상
			Pattern regex = Pattern.compile("#\\{([\\w_]+)\\}");
			//자바스크립트는 \w 자바는 \\w
			Matcher matcher= regex.matcher(tmplSrc);
			StringBuffer html = new StringBuffer();
			while(matcher.find()) {
				String name = matcher.group(1);
				Object data = req.getAttribute(name);
				//matcher.appendReplacement(html, data.toString());
				//null에안전하게 코드 구현 가능
				matcher.appendReplacement(html, Objects.toString(data, ""));
			}
		
		
		matcher.appendTail(html);
		
		try(
				PrintWriter out = resp.getWriter()
		){
			out.print(html);
		}
			resp.getWriter().print(html);
		
		
		//#{test1}, #{test2}
		//req.getAttribute("test1");
		//req.getAttribute("test2");
		}
}
