package kr.or.ddit.enumtype;

public enum BrowserType {
	// 열거형상수 enum안에 상수들
	MSIE("익스플로러 구버전"), TRIDENT("익스플로러 최근버전"), OPERA("오페라"), FIREFOX("파이어폭스"), EDGE("엣지"), CHROME("크롬"), SAFARI("사파리"),
	OTHER("기타");
	// 자기타입에 해당하는 상수를 배열의 형태로 갖고있는 클래스(8개짜리 length배열)
	private String browserName; // 생성자, set -상수가만들어진 시점에 이미 브라우저의 이름은 정해져있으니까..
	// 생성자 만들기

	private BrowserType(String browserName) {// -기본생성자는 enum의 특성(상수선언외생성불가) public이 안돼. 생성자 private로만들어!
		this.browserName = browserName;
	}

	public String getBrowserName() {
		return this.browserName;
	}

	public static String parseUserAgent(String userAgent) {
		BrowserType finded = BrowserType.OTHER;
		if (userAgent != null) {
			userAgent = userAgent.toUpperCase();

			// 상수의 집합 배열
			// 상수는 values로 받아올 수 있다
			// enum안에 상수를 사용하게 되면 상수의 name의 property를 갖고 있다.
			for (BrowserType tmp : BrowserType.values()) { // return -> BrowserType
				if (userAgent.indexOf(tmp.name()) >= 0) {
					finded = tmp;
					break;
				}
			}
		}
		return finded.getBrowserName();
	}
}