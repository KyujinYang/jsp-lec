package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumtype.BrowserType;
import kr.or.ddit.enumtype.OsType;
import kr.or.ddit.servlet04.MimeType;

@WebServlet("/05/factorial")
public class CalFactorial extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      String accept = req.getHeader("Accept");
	      String userAgent = req.getHeader("user-agent").toUpperCase();

	      
	      Map<String, Object> target = new HashMap<>();
	      target.put("json",json);
	      target.put("xml",xml)
	      target.put("plain",plain)
	      
	      ObjectMapper mapper = new ObjectMapper();
	      String json = mapper.writeValueAsString(target);
	      String xml = mapper.writeValueAsString(target);
	      String plain = mapper.writeValueAsString(target);
	      
	      
	      MimeType mime = MimeType.findMimeType(accept);
	      Object data = null;
	      
	      if(MimeType.JSON.equals(mime)) {
	    	  	data = json;
	      }else if (MimeType.PLAIN.equals(mime) {
   	    	    data = plain;
	      }else {
	    	  	data = xml;
	      }
	      

	      
	      resp.setContentType(mime.getmimeText());
	      try(
	            PrintWriter out = resp.getWriter();
	      ){
	         out.println(data);
	      }
	   }
}

