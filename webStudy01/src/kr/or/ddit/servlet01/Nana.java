package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hi")
public class Nana extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setCharacterEncoding("UTF-8"); //UTF-8로 보내기
		resp.setContentType("(text/html);charset=UTF-8"); //브라우저에게 UTF-8로해석해라 라고 알려줌. CONTENT의 자의석 해석도 없어짐
		
		PrintWriter out = resp.getWriter();
		
		//임시변수
		String cnt_= req.getParameter("cnt");
		
		//기본값
		int cnt = 100;
		if(cnt_ != null && cnt_.equals(""));
		cnt = Integer.parseInt(cnt_);
		
		for(int i = 0; i<cnt; i ++)
			out.println("안녕 Servlet<br />");
	}
}


//클라이언트에게 웹으로 인식했기에 html에서는 내려쓰기시 <br>태그 포함해서 작성 필요