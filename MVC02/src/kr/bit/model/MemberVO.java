package kr.bit.model;
// 회원(Object) -> MemberVO
public class MemberVO {

	// 기본 생성자 만들
	public MemberVO() {}
	
	// 회원 관련 정보들 선언 
	private int num;
	private String id;
	private String pass;
	private String name;
	private int age;
	private String email;
	private String phone;
	
	// 게터, 세터 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// 생성자 2개 만듬.
	public MemberVO(String id, String pass, String name, int age, String email, String phone) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	public MemberVO(int num, String id, String pass, String name, int age, String email, String phone) {
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	// 디버깅 해보려고 만들어 논거
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	
	
}
