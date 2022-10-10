package javaexp.a09_inherit;

public class A05_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 추상클래스(abstract class)
		1. 추상클래스 개념
			1) 추상(abstract)
				- 실체들 간의 공통되는 특성을 추출하는것
				ex) 새, 곤충, 물고기 ==> 동물(추상)
					삼성, 현대, LG ==> 회사(추상)
			2) 추상 클래스(abstract class)
				- 실체 클래스들의 공통되는 필드와 메소드 정의한 클래스
				- 추상 클래스는 실제 클래스의 부모 클래스 역할(단독 객체 X)
				cf) 추상 클래스 법칙
				1. 추상메서드(abstract)가 하나라도 있으면, 추상클래스(abstract class 클래스명)으로 선언되어야 하며,
					ex) 추상 메서드는 재정의가 목적이기에 body{()}가 없다.
				2. 추상클래스가 가지고 있는 추상메서드는 상속받는 하위 클래스에서 반드시 재정의 하여야한다.
				3. 추상클래스는 혼자 생성하지 못하고, 다형성에 의해서 생성할 수 있다.
					추상클래스 참조 = new 추상클래스(); (x)
					추상클래스 참조 = new 하위실체클래스(); (ㅇ)
		2. 추상 클래스의 용도
			1) 실체 클래스의 공통된 필드와 메소드의 이름 통일 목적
				- 실체 클래스를 설계자가 여러 사람일 경우
				- 실체 클래스마다 필드와 메소드가 제각기 다른 이름을 가질 수 있음
			2) 실체 클래스를 작성할 때 시간 절약
				- 실체 클래스는 추가적인 필드와 메서드만 선언
			3) 실체 클래스 설계 규격을 만들고자 할 때
				- 실체 클래스가 가져야 할 필드와 메소드를 추상 클래스에 미리 정의
				- 실체 클래스는 추상 클래스를 무조건 상속 받아 작성.
		3. 기본 코드
			1) 추상 클래스 선언.
				public abstract class 클래스명{
					public abstract 리턴값 메소드명();
					// 메소드명(); {}body가 없음, 궁극적으로 재정의를 목적이기 때문
				}
			2) 추상 클래스를 상속받은 하위 클래스(실체클래스)
				class 클래스 extends 클래스명{
					// 추상메서드는 반드시 재정의 하여야 한다. : (강제) - 컴파일 에러 발생
					 public 리턴값 상위에 선언된 추상메서드(){
					 
					 }
		 */
//		Larba01 l01 = new Larba01(); // 추상클래스 혼자 객체생성을 하지 못한다.
		Larba01 l02 = new Mutal(); // 추상클래스 = 실체클래스 형태로 객체 생성이 가능
		l02.move();
		l02.attack();
		// ex) 삼성, 현대, LG ==> 회사(추상)
		// Company 추상클래스 선언, 공통메서드 : 돈을 벌다(earnMoney), 추상메서드 : working()
		Company01[] coms = {new Samsaung(),new Hyundae(), new Lg()};
		for(Company01 com:coms) {
			com.earnMoney();com.working();
		}
	}

}
abstract class Company01{
	private String name;
	public Company01(String name) {
		super();
		this.name = name;
	}
	void earnMoney() {
		System.out.println(name+" 돈을벌다");
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + "]";
	}
	public abstract void working();
}
class Samsaung extends Company01{
	public Samsaung() {
		super("삼성");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println("핸드폰을 팔다");
	}
	
}
class Hyundae extends Company01{
	public Hyundae() {
		super("현대");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(getName()+"자동차를 팔다");
	}
	
}
class Lg extends Company01{
	public Lg() {
		super("엘지");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println("가전제품을 팔다");
	}
	
}
abstract class Larba01{
	void move() {// 공통메서드
		System.out.println("이동하다.");
	}
	abstract void attack(); // body가 없는 추상 메서드 : 재정의할 메서드.
	
}
class Mutal extends Larba01{
	// 추상클래스를 상속한 하위 클래스는 추상메서드를 반드시 재정의하여야 한다.(메서드 통일을 유지 가능)
	@Override
	void attack() {
		System.out.println("공중 원거리 공격하다!");
	}
}
class Ultra extends Larba01{
	@Override
	void attack() {
		System.out.println("근접 공격하다!");
	}
	
}
