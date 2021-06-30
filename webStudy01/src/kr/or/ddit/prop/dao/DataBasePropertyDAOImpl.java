package kr.or.ddit.prop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyDAOImpl implements DataBasePropertyDAO {



	   @Override
	   public List<DataBasePropertyVO> selectDataBasePropertyList(
	         DataBasePropertyVO param) {
	      StringBuffer sql = new StringBuffer();
	      sql.append("SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
	      sql.append(" FROM DATABASE_PROPERTIES ");
	      if(param!=null) {
	         
	         StringBuffer searchSql = new StringBuffer();
	         if(StringUtils.isNoneBlank(param.getProperty_name())) {
	            searchSql.append(" OR INSTR(PROPERTY_NAME, ? ) > 0");
	         }
	         if(StringUtils.isNotBlank(param.getProperty_value())) {
	            searchSql.append(" OR INSTR(PROPERTY_VALUE, ? ) > 0");
	         }
	         if(StringUtils.isNotBlank(param.getDescription())) {
	            searchSql.append(" OR INSTR(DESCRIPTION, ? ) > 0");
	         }
	         
	         int index = -1;
	         if((index=searchSql.indexOf("OR"))!= -1) {
	            searchSql.delete(index, index+2);
	            sql.append(" WHERE ");
	         }
	         sql.append(searchSql.toString());
	      }
	      System.out.println(sql);
	      
	      try(   Connection conn = ConnectionFactory.getConnection();
	            PreparedStatement stmt =  conn.prepareStatement(sql.toString());){
	         
	         if(param!=null) {
	            int idx = 1;
	            if(StringUtils.isNoneBlank(param.getProperty_name()))
	               stmt.setString(idx++, param.getProperty_name());
	            if(StringUtils.isNoneBlank(param.getProperty_value()))
	               stmt.setString(idx++, param.getProperty_value());
	            if(StringUtils.isNoneBlank(param.getDescription()))
	               stmt.setString(idx++, param.getDescription());
	         }
//	         5. 쿼리 실행
	            ResultSet rs = stmt.executeQuery();// set - 데이터의 중복을 막음
	            List<DataBasePropertyVO> propList = new ArrayList<>();
	            while(rs.next()){
	               DataBasePropertyVO vo= new DataBasePropertyVO();
	               propList.add(vo);
	               vo.setProperty_name(rs.getString("PROPERTY_NAME"));
	               vo.setProperty_value(rs.getString("PROPERTY_VALUE"));
	               vo.setDescription(rs.getString("DESCRIPTION"));
	            }
	            rs.close();
	            return propList;
	         }catch(SQLException e) {
	            throw new RuntimeException(e);
	         }
	   }

	}