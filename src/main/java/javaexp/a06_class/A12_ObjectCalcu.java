package javaexp.a06_class;

public class A12_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m = new Member();
		System.out.println("현재로그인:"+m.curLoginId());
		m.login("himan","7777");
		System.out.println("현재로그인:"+m.curLoginId());
		System.out.println(m.loginResult());
		// ex) 필드로 point 변수지정 setPoint() point값 할당.
		//		String isSuperUser() point 10000포인트 이상이면 MVP입니다. 리턴
		//			일반고객입니다. 문자열로 리턴하게 처리하세요.
		m.setPoint(15000);
		System.out.println("현재 고객님은 "+ m.isSuperUser());
		
	}

}
class Member{
	String id;
	String pass;
	// 포인트 필드 추가
	int point;
	// setPoint메서드 추가
	void setPoint(int point) {
		this.point = point;
	}
	// 고객구분메서드 추가
	String isSuperUser() {
		String grade = "일반고객입니다.";
		if(point>=10000) {
			grade = "MVP 입니다.";
		}
		return grade;
	}
	void login(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	String loginResult() {
		String result = "로그인실패";
		if(id.equals("himan") && pass.equals("7777")) {
			result = "로그인성공";
		}
		return result;
	}
	String curLoginId() {
		return id;
	}
}