package kr.or.ddit.servlet02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/01/gugudan.tmpl")
public class GugudanServlet extends ReadTmlServlet{

   @Override
   protected String getMime() {
      return "text/html;charset=utf-8";
   }

// 1. ui변경, 디자인변경
// 2. 클라이언트가 요구하고 있는 단의 범위를 파라미터로 설정할 수 있도록 하여 그 범위의 데이터만 응답데이터로 나오게 하라

   @Override
   protected void makeData(HttpServletRequest req) {
      
      String minStr = req.getParameter("minDan");
      String maxStr = req.getParameter("maxDan");
      
      int minDan=2;
      if(minStr!=null&&minStr.matches("[\\d{1,2}]")) {
    	  minDan = Integer.parseInt(minStr);
      }
      
      int maxDan = 9;
      if(maxStr!=null && maxStr.matches("[0-9]+"))
      maxDan = Integer.parseInt(maxStr);
      
      StringBuffer gugudan = new StringBuffer();
      
      
      for(int i = minDan; i <= maxDan; i ++) {
         gugudan.append("<tr><td>"+i + "단</td>");
         for(int j = 1; j <= 9; j++) {
            String result = Integer.toString(i *j);
            gugudan.append("<td>" + i + " * " + j + " = " + result + "</td>");
         }
         gugudan.append("</tr>");
      }
      
      req.setAttribute("gugudan", gugudan);
   }
}