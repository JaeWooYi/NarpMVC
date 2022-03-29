package kr.bit.model;
import java.sql.*;
// JDBC -> myBatis, JPA로 넘어갈거야 
public class MemberDAO {
	
	// 데이터베이스 프로그래밍을 하려면 기본적으로 필요한게 있어 
	private Connection conn;
	
	// sql을 전송 할 수 있는 객체 
	private PreparedStatement ps;
	
	// 데이터베이스에 있는 데이타를 가지고와서 저장 할 수 있는 객체(결과집합을 저장하는)
	private ResultSet rs;
	
	
}
