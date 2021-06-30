package kr.or.ddit.vo;

import java.io.Serializable;

public class DataBasePropertyVO implements Serializable{
//조회된 레코드 1건에 대한 정보 담기  // imple로 직렬화 자바bean vo규약
	//3개의 데이터
	private String property_name;
	private String property_value;
	private String description;
	
	//gettersetter
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public String getProperty_value() {
		return property_value;
	}
	public void setProperty_value(String property_value) {
		this.property_value = property_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//tostring
	@Override
	public String toString() {
		return "DataBasePropertyVO [property_name=" + property_name + ", property_value=" + property_value
				+ ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((property_name == null) ? 0 : property_name.hashCode());
		return result;
	}
	
	
	//같은 데이터  이름으로 확인하기. property_name
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataBasePropertyVO other = (DataBasePropertyVO) obj;
		if (property_name == null) {
			if (other.property_name != null)
				return false;
		} else if (!property_name.equals(other.property_name))
			return false;
		return true;
	}
	
	
	//vo목적 : 데이터 주고받을 때 , 하나의 그릇에 담아 하나의 목적으로 사용하기 위해 담음. 
	//		: 데이터 전송!! (Stream) 따라서 vo는 stream형태로 변환가능해야해 (직렬화serialize)
	
	
	//vo를 collection형태로 만들어야해 ->>>>> JSP List<DataBasePropertyVO> propList = new ArrayList<>();
	
	

	
	
}
