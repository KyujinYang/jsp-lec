package kr.or.ddit.member.service;


import kr.or.ddit.commons.userNotFoundException;
import kr.or.ddit.enumtype.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements AuthenticateService {

	private MemberDAO memberDAO = new MemberDAOImpl();
	
	@Override
	public Object authenticate(MemberVO param) {
		Object resultValue = null; 
		MemberVO savedMember = memberDAO.selectMemberById(param.getMem_id());
		if(savedMember==null) {
			throw new userNotFoundException(String.format("%s 회원은 없음.",param.getMem_id()));
		}
		String savedPass = savedMember.getMem_pass();
		String inputPass = param.getMem_pass();
		boolean valid = savedPass.equals(inputPass);
		if(valid) {
			//정상작동(리턴값 없이 파라미터 값 넘길 수 있다.)
			resultValue = savedMember;
			//param.setMem_name(savedMember.getMem_name());
			//write.집어넣은거(read.꺼낸거)
		}else{
			//기본오류
			resultValue = ServiceResult.INVALIDPASSWORD;
		};
		return resultValue;
		
	}

}
