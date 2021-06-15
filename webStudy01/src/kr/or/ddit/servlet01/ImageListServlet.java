package kr.or.ddit.servlet01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Application;

public class ImageListServlet extends HttpServlet{
	String contentsPath;
	ServletContext application;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		application = getServletContext();
		contentsPath = application.getInitParameter("contentsPath");
		System.out.printf("%s 서블릿 초기화됨\n", getClass().getName());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get이든 post든 do계열의 메소드를 신경쓰지않겠다. 
		resp.setContentType("text/html;charset=utf-8");
		
		
		ServletContext context = getServletContext();
		
		
		
		
		File contentsFolder = new File(contentsPath);
		String[] imageList = contentsFolder.list(new FilenameFilter() {
			
			@Override //MIME
			
			public boolean accept(File dir, String name) {
				//main/sub;charset= encoding
				String mimeText = application.getMimeType(name);
				return mimeText != null && mimeText.startsWith("image/");
			}
		});
		//html
		
		String pattern = "<option>%s</option>";
		StringBuffer options = new StringBuffer();
		for(String name :imageList) {
			options.append(String.format(pattern, name));
		}
		
		// '/imageView' 상대경로 'imageView'절대경로 
	
		InputStream is = getClass().getResourceAsStream("imageList.tmpl");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String tmp = null;
		StringBuffer tmplsource = new StringBuffer();

		while((tmp = reader.readLine())!=null){//null을 만날 때 까지(널이 아닌동안) 
			tmplsource.append(tmp+"\n");
		}

		
		String html = tmplsource.toString().replace("#{data}",options);
		resp.getWriter().println(html);
		
		//웹에서 String을 사용하면 안되는이유!
		//String변수 -> 상수풀 (x)한 번 메모리공간을 사용하면 회수가안됨
		//StringBuffer는 회수가 가능
		
		
	}
}
