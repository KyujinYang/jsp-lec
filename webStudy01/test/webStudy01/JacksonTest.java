package webStudy01;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	@Test
	public void test() throws JsonProcessingException {
			//마샬링하기전 원본데이터 필요
			//1.원본데이터만들기
			Map<String, Object> target = new HashMap<>();
			target.put("prop1", "텍스트");//String
			target.put("prop2", 12345); //int
			target.put("prop3", true); //boolean
			target.put("prop4", null); //null
			target.put("prop5", new String[] {"value1","value2"}); //배열
			target.put("prop6", Collections.singletonMap("innerProp","내부 맵데이터"));
			
			
			//잭슨데이터이용 마샬링하기
			//1.잭슨
			ObjectMapper mapper = new ObjectMapper();
			// 대상선택하기
			//IOException이 가장 최상의 입출력대상
			String json= mapper.writeValueAsString(target);
			System.out.println(json);
			
			Map<String, Object> destMap = mapper.readValue(json, Map.class);
			System.out.println(destMap);

	}

	@Test
	public void bundleTest() throws JsonProcessingException {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.servlet05.message");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bundle);
		System.out.println(json);
				
		
	}



}


