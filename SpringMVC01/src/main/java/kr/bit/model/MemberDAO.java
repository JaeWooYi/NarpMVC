package kr.bit.model;

// JDBC -> myBatis, JPA

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@ -> 어노테이션(전처리) -> Spring Container에서 관리를 해준다.
@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// 회원전체 리스트 보기.
	public List<MemberVO> memberList() {
		// [Connection + Statement] -> sqlSession
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("memberList");
		session.close();
		return list;
	}
	
	// 회원가입 기능.
	public int memberInsert(MemberVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	// 회원삭제 기능
	public int memberDelete(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("memberDelete",num);
		session.commit();
		session.close();
		return cnt;
	}
	
	// 회원상세 보기 기능
	public MemberVO memberContent(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = session.selectOne("memberContent", num);
		session.commit();
		session.close();
		return vo;
	}
	
	// 회원정보 수정하기 기능
	public int memberUpdate(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}
}