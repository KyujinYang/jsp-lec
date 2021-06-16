package kr.or.ddit.enumtype;

public enum OsType {
	// 열거형상수 enum안에 상수들
	DOS("도스"), MAC("맥"), SUNOS("솔라리스"), WINDOWS("윈도우"), LINUX("리눅스"), NUI("유닉스"), NUX("유닉스"),
	AIX("유닉스"), OTHER("기타");
	
	// 자기타입에 해당하는 상수를 배열의 형태로 갖고있는 클래스(9개짜리 length배열)
	private String OsName; // 생성자, set -상수가만들어진 시점에 이미 브라우저의 이름은 정해져있으니까..
	// 생성자 만들기

	private OsType(String OsName) {// -기본생성자는 enum의 특성(상수선언외생성불가) public이 안돼. 생성자 private로만들어!
		this.OsName = OsName;
	}

	public String getOsName() {
		return this.OsName;
	}

	public static String parseOsAgent(String userAgent) {
		OsType finded = OsType.OTHER;
		if (userAgent != null) {
			userAgent = userAgent.toUpperCase();

			// 상수의 집합 배열
			// 상수는 values로 받아올 수 있다
			// enum안에 상수를 사용하게 되면 상수의 name의 property를 갖고 있다.
			for (OsType tmp : OsType.values()) { // return -> OsType
				if (userAgent.indexOf(tmp.name()) >= 0) {
					finded = tmp;
					break;
				}
			}
		}
		return finded.getOsName();
	}
}