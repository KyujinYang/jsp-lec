package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.servlet04.MimeType;

@WebServlet("/05/messageService")
public class MessageServiceServlet extends HttpServlet {
	// 전역화
	ResourceBundle bundle;
	Map<String, Object> dataMap;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String basename = config.getInitParameter("basename");
		bundle = ResourceBundle.getBundle("kr.or.ddit.servlet05.message");
		// <1.7버전이상부터 <>안에안써줘도돼 sTIRNG,OBJECT>
		dataMap = new HashMap<>();
		for (String key : bundle.keySet()) {
			dataMap.put(key, bundle.getObject(key));
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.servlet05.message");
		// 1.비동기에대한 응답데이터로 보낸다.
		/**
		 * mime 설정 : Content-Type : 요청안에서
		 */
		String accept = req.getHeader("Accept");
		MimeType mime = MimeType.findMimeType(accept);
		
		if (!MimeType.JSON.equals(mime)) {
			//요청말구 응답! responseline	
			//415번 상태코드 - 400번은 클라이언트 쪽의 문제
			resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
			return;
		}

		// 1)java를 json으로 마샬링 -> (Jackson으로 확인)
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dataMap);

		// 2)직렬화(json을 콘텐츠로 내보낸다.)
		resp.setContentType(mime.getmimeText());
		

		
		


		try (PrintWriter out = resp.getWriter();) {
			//out.println(json);
			//마샬링과 직렬화 한번에 하기.
			mapper.writeValue(out, dataMap);
		}
	}

}
