package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.bit.model.MemberVO;

@Mapper	// MyBatis(SqlSessionFactory + SqlSession)	-> 생략해도 된다.
public interface MemberMapper {
	
	// 어노테이션에 쿼리를 작성해 사실상 MemberMapper이 필요없어져서 kr.bit.mybatis로 옮겨 놈. ( kr.bit.mybatis 사용하는데 없지만 아깝자나 )
	
	// 회원 리스트 보기
	@Select("select * from member")
	public List<MemberVO> memberList();
	
	// 회원 가입 기능
	@Insert("insert into member(id, pass, name, age, email, phone) \n" + 
			"        values(#{id}, #{pass}, #{name}, #{age}, #{email}, #{phone})")
	public int memberInsert(MemberVO vo);
	
	// 회원삭제 기능
	@Delete("delete from member where num=#{num}")
	public int memberDelete(int num);
	
	// 회원상세 보기 기능
	@Select("select * from member where num=#{num}")
	public MemberVO memberContent(int num);
	
	// 회원정보 수정하기 기능
	@Update("update member \n" + 
			"        set age=#{age}, email=#{email}, phone=#{phone}\n" + 
			"        where num=#{num}")
	public int memberUpdate(MemberVO vo);
	
}
