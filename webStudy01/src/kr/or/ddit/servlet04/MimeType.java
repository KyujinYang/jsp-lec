package kr.or.ddit.servlet04;

public enum MimeType { //상수 순서-> OTHER처럼 가장 마지막에 기본적으로 사용하는 데이터 타입 html
	JSON("application/json;charset=UTF-8"),
	SCRIPT("text/javascript"), 
	PLAIN("text/plain;charset=UTF-8"),
	HTML("text/html;charset=UTF-8");
	private String  mimeText;
	
	private MimeType(String mimeText) {
		this.mimeText = mimeText;
	}
//	
//	public static MimeType findMimeType(String accept) {
//		return findMimeType(accept).getMimeText();
//	}
	
	//상수enum변경x
	public String getmimeText() {	
		return mimeText; 
	}
		
	
	
	
	
	public static MimeType findMimeType(String accept) {
		MimeType finded = MimeType.HTML;
		
		if(accept !=null) {
			accept = accept.toUpperCase();
			for(MimeType tmp : values()) {
				if(accept.indexOf(tmp.name())>=0) {
					finded = tmp;
					break;
				}
			}
		}
		return finded;
	}
	
	public static String findMimeText(String accept) {
		return findMimeType(accept).getmimeText();
	}
}

