package kr.or.ddit.member.dao;

import kr.or.ddit.vo.MemberVO;

/**
 * 회원관리를 위한 Persistence Layer
 * 
 */
public interface MemberDAO {
	/** 
	 * 식별자(pk)로 레코드조회
	 * @param mem_id
	 * @return 존재하지 않는 경우, null을 반환
	 */
	public MemberVO selectMemberById(String mem_id);
	
	
}
