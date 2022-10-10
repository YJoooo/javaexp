package javaexp.a09_inherit;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 상속
		1. 상속 개념과 활용
			1) 상속의 효과
				- 부모 클래스 재사용해 자식 클래스 빨리 개발가능
				- 반복된 코드 중복 줄임
				- 유지 보수 편리성 제공
				- 객체 다형성 구현 가능
				ex) 공통적인 DB접근 class를 만들고, 상속받아서 DB서버별(oracle, mysql...)에 맞는 처리 class 선언하여 활용.
			2) 상속 대상 제한
				- 부모 클래스의 private 접근 갖는 필드와 메소드 제외
					private자체가 해당 클래서에서만 사용할 수 있지, 직접적인 접근 및 처리를 하지 못한다,
					단, 간접적으로 다른 메서드나 생성자를 통해서 접근은 가능하다.
				- 부모 클래스가 다른 패키지에 있을 경우, default접근 갖는 필드와 메소드도 제외
		2. 상속 처리 기본 형식
			1) extends 키워드 활용
				자식 클래스가 상속할 부모 클래스를 지정하는 키워드
				class 부모{}
				class 자식 extends 부모{}
		 */
		Father f = new Father();
		System.out.println(f.shape);
		f.show();
		System.out.println("#상속받은 아들 객체#");
		Son s1 = new Son();
		System.out.println(s1.shape);
		s1.show();
		System.out.println("추가 기능 필드 :"+s1.running);
		// ex) Mother : 필드 : 요리를 잘한다, 온화하다. 메서드 : 위 내용을 출력.
		// 		상속받은 Daughter 필드 : 수영을 잘한다. 메삳, : 수영을 잘한다 출력
		Mother m01 = new Mother();
		System.out.println(m01.skill);
		m01.show();
		Daughter d01 = new Daughter();
		System.out.println(d01.skill);
		d01.show();
		System.out.println("딸의 특징 : "+d01.hobby);
		Daughter d1 = new Daughter();
		d1.show2();
		Daughter d2 = new Daughter("운동을 잘하다.","디자인을 잘하다","급하다.");
		d2.show2();

	}

}
class Mother{
	String skill = "요리를 잘한다.";
	String character = "온화하다";
	void show() {
		System.out.println("특징 : "+skill);
		System.out.println("성격 : "+character);
	}
}
class Daughter extends Mother{
	String hobby = "수영을 잘한다.";
	Daughter(){}
	// 자신이 선언한 것과 동일하게 호출하여 사용할 수 있다.(주의 - 접근범위 안에서)
	Daughter(String skill, String hobby, String character){
		this.skill = skill;
		this.hobby = hobby;
		this.character = character;
	}
	void show2() {
		// skill은 상속을 받았기 때문에 스스로 선언한것과 동일하게 사용 가능.
		System.out.println("특기1:"+skill);
		System.out.println("특기2:"+hobby);
		show();// 상위 선언된 메서드 호출 사용.
	}
}
class Father{
	String shape = "통통하다";
	String height = "키가 큰편이다.";
	void show() {
		System.out.println("모습:"+shape);
		System.out.println("키:"+height);
	}
}
class Son extends Father{
	String running = "달리기를 잘한다.";
}