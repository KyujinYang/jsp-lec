package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="serviceInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceInfoVO implements Serializable { //직렬화, 역직렬화
	
	@XmlElementWrapper
	@XmlElementRefs(@XmlElementRef)
	private List<MenuVO> menuList;

	public List<MenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "ServiceInfoVO [menuList=" + menuList + "]";
	}

	
}
