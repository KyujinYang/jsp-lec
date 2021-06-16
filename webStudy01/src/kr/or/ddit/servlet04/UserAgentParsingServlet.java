package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumtype.BrowserType;

@WebServlet ("/04/getBrowserName")
public class UserAgentParsingServlet extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String accept = req.getHeader("Accept");
      String userAgent = req.getHeader("user-agent").toUpperCase();
      
      
      String browser = BrowserType.parseUserAgent(userAgent);
      
      Map<String, Object> target = new HashMap<>();
      target.put("browser",browser);
      
      
      
      StringBuffer json = new StringBuffer();
      String PROPPTRN = "\"%s\" : \"%s\" , ";
   
      //1.
      //Mashalling - 네이티브로 표현 된 데이터를 공통 표현방식(xml, json)으로 바꿔주는 과정
      //Unmarshalling : 공통표현방식으로 표현된 데이터를 native 형식으로 바꾸는 과정.
      
      json.append("{");
      for(Entry<String, Object> entry : target.entrySet()) {
      		json.append(String.format(PROPPTRN, entry.getKey(), entry.getValue(), 
      				Objects.toString(entry.getValue(),"")));
      }
      json.append("}");
      
      int lastIdx = json.lastIndexOf(",");
      if(lastIdx >= 0) {
    	  json.deleteCharAt(lastIdx);
      } //마샬링 끝!
      
      //2.
      //직렬화
      
      
      
      String mime = MimeType.findMimeText(accept);
      Object data = null;
      
      if(accept.contains("json")) {
    	  
      }else {
    	  data = browser;
      }
      
      
      
      resp.setContentType(mime);
      try(
            PrintWriter out = resp.getWriter();
      ){
         out.println(browser);
      }
   }
}