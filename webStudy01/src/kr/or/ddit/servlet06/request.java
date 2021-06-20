package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/06/sessionTimer")
public class request extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("#yesBtn".equals(action)) {
			HttpSession session = req.getSession();
			String idKey = (String)session.getAttribute("#yesBtn");
 
			HashMap<String, Object> map = new HashMap<String, Object>();
			if(idKey != null && idKey.length() > 0) {
				map.put("result", "success");
				map.put("message", "시간이 연장되었습니다..");
			} else {
				map.put("result", "fail");
				map.put("message", "세션이 만료되었습니다..");
			}
 
	}

	}
}
