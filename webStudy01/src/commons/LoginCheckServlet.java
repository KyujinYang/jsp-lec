package commons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login/loginCheck.do")
public class LoginCheckServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 파라미터확보
//		2. 검증
//		   필수파미터 누락 여부 확인(400-bad request)
//		3. 인증
//			1) 성공 : welcome page로 이동(redirect)
//	
//			2) 실패 : login form page로 이동(dispatch -forward, include 결정 : forward가 효율적)
//
		String mem_id = req.getParameter("mem_id");
		String mem_pass= req.getParameter("mem_pass");
	
		if(mem_id.equals(mem_pass)) {
			String name ="회원";
			req.setAttribute("name",name);
			
			req.getRequestDispatcher("/07/success.jsp").forward(req,resp);
		}else {
			req.getRequestDispatcher("/07/fail.jsp").forward(req,resp);
		}

	}

}
