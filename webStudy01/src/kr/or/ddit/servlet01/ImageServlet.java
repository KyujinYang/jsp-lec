package kr.or.ddit.servlet01;

// qualified name
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

// 단 , context name : third
// service name : /imageView
// service name : /imageList - 이미지 목록 제공, 요청 파라미터 명 : imageName

// 한글 주석

public class ImageServlet extends HttpServlet{
	ServletContext application;
	File contentsFolder;
	@Override
		public void init() throws ServletException {
			super.init();
			application = getServletContext(); //request나 여기나 똑같은 context
			String contentsPath = application.getInitParameter("contentsPath");
			contentsFolder = new File(contentsPath);
		}
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
      
      String mime = "image/jpeg";
      resp.setContentType(mime);
      String imageName = req.getParameter("image");
      if(imageName ==null || imageName.isEmpty()) {
    	  resp.sendError(HttpServletResponse.SC_BAD_REQUEST);//400번
    	  return;
      }
      // MIME : mainType/subType; charset=인코딩
      resp.setContentType(mime);
//      String source = "C:/contents/sampel.jpg"; // 파라미터 값으로 변형
      
      
      File srcFile = new File(contentsFolder, imageName);
      FileInputStream fis = new FileInputStream(srcFile);
      OutputStream os = resp.getOutputStream();
      byte[] buffer = new byte[1024];
      int pointer = -1;
      while((pointer = fis.read(buffer)) != -1){
         os.write(buffer, 0, pointer);
      }
      fis.close();
      os.close();
   }
}