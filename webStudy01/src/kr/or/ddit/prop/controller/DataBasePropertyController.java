package kr.or.ddit.prop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.prop.service.DataBasePropertyService;
import kr.or.ddit.prop.service.DataBasePropertyServiceImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

/**
 * 
 * 1.요청을 받고(Servlet스펙필요),2. 요청을 분석하고, 3. 분석결과에 따라 로직을 사용, 로직으로부터 MODEL 데이터를 확보.
 * VIEW > JSP > VIEW를 선택하고 MODEL 데이터 전달 ==> 그 역할 이 Controller Layer
 * 
 * 
 *
 */
@WebServlet("/11/jdbcDesc.do")
public class DataBasePropertyController extends HttpServlet {
	//3. 로직 사용
	private DataBasePropertyService service = new DataBasePropertyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accept = req.getHeader("accept");
		String search = req.getParameter("search"); //요청받기
		DataBasePropertyVO param = new DataBasePropertyVO();
		param.setProperty_name(search);
		param.setProperty_value(search);
		param.setDescription(search);
		
		
		//가공 이후 propList 데이터
		List<DataBasePropertyVO> propList = 
				service.retrieveDataBaseProperties(param);
		if(accept.contains("json")) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			try(
				PrintWriter out = resp.getWriter();
				){
				out.println(mapper.writeValueAsString(propList));
			}
		}else {
			req.setAttribute("contentsPage", "/WEB-INF/views/11/jdbcDesc.jsp");
			String dest = "/WEB-INF/views/template.jsp";
			req.getRequestDispatcher(dest).forward(req, resp);
		}
		}
}
