package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberVO selectMemberById(String mem_id) {
		String sql = "select* from member where mem_id =? ";
		 try(
       	Connection conn = ConnectionFactory.getConnection(); //커넥션객체 닫으면 resultset도 자동으로 닫힘 
        PreparedStatement stmt = conn.prepareStatement(sql);
		       ){
			 	stmt.setString(1,mem_id);
			 	ResultSet rs = stmt.executeQuery();
			 	MemberVO memVO = null;
	
//		          5. 쿼리 실행
		           
          if(rs.next()){
           	   memVO = new MemberVO(); 
               memVO.setMem_id(rs.getString("mem_id"));
               memVO.setMem_pass(rs.getString("mem_pass"));
               memVO.setMem_name(rs.getString("mem_name"));
            } 
		   return memVO;
		            
		            
         }catch (SQLException e) {
            throw new RuntimeException(e);
         }
	}	
}
