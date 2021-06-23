package kr.or.ddit.commons;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.servlet06.request;
@WebServlet("/login/logout.do")
public class LogoutServlet extends HttpServlet{
	//폼 구성 안하면 get방식

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		if(session==null || session.isNew()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"로그아웃이 최초의 요청????");
			return;
		}
		
//	session.removeAttribute("authId");	
	session.invalidate();
	resp.sendRedirect(req.getContextPath()+"/");
	String message = URLEncoder.encode("로그아웃 성공","utf-8");
	session.setAttribute("message",message);
	resp.sendRedirect(req.getContextPath() + "/?message="+message);
	
	}

}
