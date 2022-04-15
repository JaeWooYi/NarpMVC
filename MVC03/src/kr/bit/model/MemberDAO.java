package kr.bit.model;

import java.sql.*;
import java.util.ArrayList;

// JDBC -> myBatis, JPA로 넘어갈거야 
public class MemberDAO {

	// 데이터베이스 프로그래밍을 하려면 기본적으로 필요한게 있어
	private Connection conn;

	// sql을 전송 할 수 있는 객체
	private PreparedStatement ps;

	// 데이터베이스에 있는 데이타를 가지고와서 저장 할 수 있는 객체(결과집합을 저장하는)
	private ResultSet rs;

	// MySQL 저장
	// Database 연결하는 connection객체를 만들자, 메서드 만들자
	public void getConnect() {
		// 기본적으로 3개가 필요함 - 1. 접속URL, 2. user, 3. password
		String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user = "root";
		String password = "mysql";

		// MySQL Driver loading
		// web-inf에 lib에 넣어둠
		// Class.forName("com.mysql.jdbc.Driver"); 적고 마우스 위에 올려놔서 트라이 캐치문 씀.
		try {
			// 동적 로딩
			Class.forName("com.mysql.jdbc.Driver");
			conn = // 접속시도 메서드를 호출.의 연결 정보를 받을거. // Connection 생략해도 되. 위에 선언했자나.
					DriverManager.getConnection(URL, user, password); // 접속시도 메서드를 호출.
		} catch (Exception e) { // ClassNotFoundException이거였지만 부모인 Exception으로 해두면 모든 예외를 잡는다.
			e.printStackTrace();
		}

	}

	// 회원저장 동작
	public int memberInsert(MemberVO memberVO) {
		String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
		getConnect();
		// SQL문장을 전송하는 객체를 생성.
		int cnt = -1; // 그냥 초기값 -1로 함. 의미없음.
		try {
			ps = conn.prepareStatement(SQL); // 미리 컴파일을 시킨다.
			ps.setString(1, memberVO.getId());
			ps.setString(2, memberVO.getPass());
			ps.setString(3, memberVO.getName());
			ps.setInt(4, memberVO.getAge());
			ps.setString(5, memberVO.getEmail());
			ps.setString(6, memberVO.getPhone());

			// 성공 cnt가 1, 실패면 0
			cnt = ps.executeUpdate(); // 전송(실행)

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt; // 1 or 0
	}

	// Database 연결 끊기
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원(VO)전체 리스트(ArrayList) 가져오기.
	public ArrayList<MemberVO>  memberList() {
		String SQL = "select * from member";
		getConnect();
		
		// 담기 준비 
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();	// rs -> ResultSet
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				// 묶고 -> 담기로 가
				MemberVO memberVO = new MemberVO(num, id, pass, name, age, email, phone);
				
				// 담기
				list.add(memberVO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return list;
	}
	
	// 삭제메서드 
	public int memberDelete(int num) {
		String SQL = "delete from member where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt=ps.executeUpdate();	// 1 or 0
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 회원정보가져오기(memberContent)
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		getConnect();
		MemberVO memberVO = null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 회원 한명의 정보를 가져와서 -> 묶기만 하면된다(VO)
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				memberVO = new MemberVO(num, id, pass, name, age, email, phone);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return memberVO;
	}
	
	// UPDATE 메서드 만들어보자
	public int memberUpdate(MemberVO memberVO) {
		String SQL = "UPDATE member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, memberVO.getAge());
			ps.setString(2, memberVO.getEmail());
			ps.setString(3, memberVO.getPhone());
			ps.setInt(4, memberVO.getNum()); 
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return cnt;
	}
	
	
}
