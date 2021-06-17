package kr.or.ddit.servlet05;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	@Test
	public void bundleTest() throws JsonProcessingException {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.servlet05.message");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bundle);
		System.out.println(json);
				
		
	}

}
