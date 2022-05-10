package kr.bit.model;

// JDBC -> myBatis, JPA

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;	
	
	// static 블록 -> 초기화 블록 : 프로그램 실행시 딱 한번만 실행 되는 코드 영역 
	static {
		try {
		String resource = "kr/bit/mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원전체 리스트 보기
	public List<MemberVO> memberList() {
		// [Connection + Statement] -> sqlSession
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("memberList");
		session.close();
		return list;
	}
	
	// 회원가입 기능
	public int memberInsert(MemberVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
}