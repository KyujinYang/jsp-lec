package kr.or.ddit.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * Factory Object[Method] Pattern
 * : 객체의 생성을 전담하는 factory객체운영.
 */
public class ConnectionFactory {
	//클래스 로딩될때 클래스 static블록실행
	static {	
		Properties dbProps = new Properties();
		//class로더. this는 못쓴다.static이라
		InputStream is = ConnectionFactory.class.getResourceAsStream("/kr/or/ddit/db/dbinfo.properties");
		try {
			dbProps.load(is);
			Class.forName(dbProps.getProperty("driverClassName"));
			url = dbProps.getProperty("url");
			user = dbProps.getProperty("user");
			password = dbProps.getProperty("password");
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e) ;
		}
	}
	private static String url;
	private static String user;
	private static String password;
	
	
	public static Connection getConnection() throws SQLException {
//		2. 드라이버 클래스 로딩
//x			Class.forName("oracle.jdbc.OracleDriver");
		//거의 유일 클래스형태제공	//thin형태 .: 계정,위치정보 mysql = 3306

//		3. 필요한 Connection 생성
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
	}
}
