package kr.or.ddit.prop.service;

import java.util.Calendar;
import java.util.List;

import kr.or.ddit.prop.dao.DataBasePropertyDAO;
import kr.or.ddit.prop.dao.DataBasePropertyDAOImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyServiceImpl implements DataBasePropertyService{
	private DataBasePropertyDAO dao = new DataBasePropertyDAOImpl(); 
		

	
	@Override
	public List<DataBasePropertyVO> retrieveDataBaseProperties(DataBasePropertyVO param) {
		//raw데이터 뒤에 조회된 날짜 덧붙여 출력해줘
		List<DataBasePropertyVO> propList = dao.selectDataBasePropertyList(param);
		// dao통해 logic 가공 - > information
		Calendar cal = Calendar.getInstance();
		String pattern = "%s, %tc";
		for(DataBasePropertyVO prop:propList) {
			String infoValue = String.format(pattern, prop.getProperty_value(),cal);
			//원래raw데이터아닌 가공된 infoValue 데이터
			prop.setProperty_value(infoValue);
		}
		return propList;
	}
}
