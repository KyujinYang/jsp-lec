package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice-reg")
public class Noticereg extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//GET에서 요청시 response
		resp.setCharacterEncoding("UTF-8"); //UTF-8로 보내기
		resp.setContentType("(text/html);charset=UTF-8"); //브라우저에게 UTF-8로해석해라 라고 알려줌. CONTENT의 자의석 해석도 없어짐
		//post로 요청시  request
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		//임시변수
		String title= req.getParameter("title");
		String content= req.getParameter("content");

		out.print(title);
		out.print(content);
		
	}
}


//클라이언트에게 웹으로 인식했기에 html에서는 내려쓰기시 <br>태그 포함해서 작성 필요