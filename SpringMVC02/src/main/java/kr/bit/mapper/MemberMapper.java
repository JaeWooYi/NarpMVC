package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.model.MemberVO;

@Mapper	// MyBatis(SqlSessionFactory + SqlSession)
public interface MemberMapper {
	
	// 회원 리스트 보기 
	public List<MemberVO> memberList();
	
	// 회원 가입 기능
	public int memberInsert(MemberVO vo);
	
	// 회원삭제 기능
	public int memberDelete(int num);
	
	// 회원상세 보기 기능
	public MemberVO memberContent(int num);
	
	// 회원정보 수정하기 기능
	public int memberUpdate(MemberVO vo);
	
}
