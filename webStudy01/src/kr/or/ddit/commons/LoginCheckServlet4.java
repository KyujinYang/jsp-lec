package kr.or.ddit.commons;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("//ㅇㅇ.do")
public class LoginCheckServlet4 extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1. 파라미터확보
//      2. 검증
//         필수파미터 누락 여부 확인(400-bad request)
//      3. 인증
//         1) 성공 : welcome page로 이동(redirect)
//   
//         2) 실패 : login form page로 이동(dispatch -forward, include 결정 : forward가 효율적)
//
        request.setCharacterEncoding("utf-8");
         String userid = request.getParameter("userid"); //userid값 가져오기
         String pass = request.getParameter("pass"); //pass값 가져오기
         
         //id: admin, pass: 1234 ==> 사용가능 회원
         if(userid != null && pass != null) {
            if("admin".equals(userid) && "1234".equals(pass)) {
               HttpSession session = request.getSession();
               session.setAttribute("loginId", userid); //세션에 로그인Id 저장
            }
         }
         
         RequestDispatcher rd = 
               request.getRequestDispatcher("/07/sessionLogin.jsp");
         rd.forward(request, response);
               
      }

}