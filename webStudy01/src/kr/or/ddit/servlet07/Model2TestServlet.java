package kr.or.ddit.servlet07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/innerAccess.do")

public class Model2TestServlet extends HttpServlet{
//위 서블릿을 통해 innerjsp까지 넘어가보자
//overiding 할 전송타입은 Get방식


@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		String contents = "김치찌개";
 		
 		//spoke구조 4개
 		//spoke사용 1 request.
 		req.setAttribute("contents",contents);
 		
 		//spoke사용 2 session http특성보완
 		req.getSession();
 		HttpSession session = req.getSession();
 		session.setAttribute("contents",contents);
 		
 		/**
 		 * request Spoke의 한계점
 		 * 
 		 */
 		
 		//이거 안돼.. String dest = req.getContextPath() + "/WEB-INF/views/inner.jsp"; //클라이언트 사이드방식 최초의 대상 servlet 응답데이터는 404.. //도착지의 방향이어딘가!!!!!
 		//String dest = /WEB-INF/views/inner.jsp"; //주소의 표기방식: 서버사이드 방식으로 이동 // a방향 응답데이터는 b // 서블릿과 view 분리
 		//String dest = req.getContextPath()+"/07/desinationB.jsp"; //주소의 표기방식: 서버사이드 방식으로 이동 // a방향 응답데이터는 b // 서블릿과 view 분리
 		String dest = req.getContextPath()+"/07/desinationB2.jsp"; //주소의 표기방식: 서버사이드 방식으로 이동 // a방향 응답데이터는 b // 서블릿과 view 분리
		
 		//dispatch방식만 webinf에 접근가능.. 내가 직접접근하는거니
		// RequestDispatcher rd = req.getRequestDispatcher(dest);
		// rd.forward(req,resp);
 		resp.sendRedirect(dest);
		
		
		
		//클라이언트에게 주문을받는다 (요청을받는다) -> 서블릿
		//돼지고기 말고 닭고기로 바꿔줘 요청시 (요청사항 분석)- 서블릿
		//김치찌개 주문 -> (김치찌개 조리) 서블릿
		//김치찌개 완성 상차림-> jsp
	}
}
