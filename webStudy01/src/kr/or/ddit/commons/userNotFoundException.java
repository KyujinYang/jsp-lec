package kr.or.ddit.commons;
/***
 * 
 * 인증처리 하는 과정에서 사용자가 존재하지 않을때 발생시킬 예외
 *
 */
public class userNotFoundException extends RuntimeException{

	public userNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public userNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public userNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public userNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}//checked Exception -무조건 묶어서 처리
	//	SQLException - 쿼리문오류 -> 요즘은.. runtimeException으로 바꺼
	
	//--> runtimeexception - > unchecked exeption

}
