package javaexp.a07_multiObj;

public class A04_Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# final 필드
		1. 최종적인 값을 갖고 있는 필드 = 값을 변경할 수 없는 필드
			
		2. final 필드는 딱 한번의 초기값 지정 방법이다.
			1) 필드 선언시 처리할 수 있고
			2) 생성자로 초기값을 지정할 수 있다.
		3. 객체 단위로 초기값을 설정하고 변경되지 못하게 할때, 주로 사용된다.
			단, 클래스 안에서 초기값을 설정하면 객체단의로도 변경이 불가능하다.
		cf)
		final : 객체별로 데이터를 초기화하고 변경하지 못하게 처리.
		static final : 클래스 단위로 초기화하고 변경하지 못하게하여, 객체의 공유 데이터 중에 변경이 불가능하게 처리.	
						이렇게 설정된 데이터는 상수라는 개념으로 사용되고, 대문자라고 선언하면, 구분자는 _(언더바)러 처리한다.
		 */
		Person p01 = new Person("951212-1802715","홍길동");
		System.out.println(p01.nation);
		System.out.println(p01.ssn);
		System.out.println(p01.name);
//		p01.nation = "일본"; final 키워드이기에 변경이 불가능 (클래스 선언고 동시에 했기때문에 다른객체로 객체생성을 하더라도 변경 불가능)
//		p01.ssn = "951212-1802714"; 에러 발생. final 객체 단위로 한번 설정이 되면 변경이 불가능하다.
		p01.name = "마길동";
		Person p02 = new Person("951212-1802714","오길동");
		System.out.println(p02.nation); // 클래스 안에서 선언했기에 변경이 불가능
		System.out.println(p02.ssn); // 다른 객체를 통해서는 변경이 가능, 하지만 변경 불가능
		System.out.println(p02.name); // 변경가능
		
		// ex) Player : 운동선수의 이름을 final로 선언. 팀명과 성적은 일반 변수로 선언하여 초기 생성자로 팀명, 이름, 초기성적으로 설정
		//		운동선수 3명에 대하여 선언하고, 해당 정보를 출력하는 메서드를 통해서 출력 처리하되 이름이 변경되지 않는 것을 확인하세요.
		Player01 play01 = new Player01("김광현","SSG",0.47);
		Player01 play02 = new Player01("반즈","롯데",1.40);
		Player01 play03 = new Player01("박세웅","롯데",1.47);
		play01.startScore = 0.51;
		play01.team = "KIA";
//		play01.name = "오길동";  final로 된 변수는 객체 단위로 한번 설정이 되면 변경이 불가능하다.
		play01.playerInfo();
		play02.playerInfo();
		play03.playerInfo();
		/*
		# 상수(static final)
		1. 상수 = static final 필드
			final 필드 : 객체마다 가지는 불변의 인스턴스 필드
			static final : 객체마다 가지고 있지 않고 클래스 단위로 설정
				메소드 영역에 클래스 별로 관리되는 불변의 정적 필드
				공용 데이터로서 사용
		2. 상수 이름을 전부 대문자로 작성을 일반적으로 한다.(네이밍 규칙)
			ex) static final double PI = 3.14;
		3. 다른 단어가 결합되면 _로 연결
			ex) static final String CUR_NATION = "한국";
			
		cf)
		final class클래스명{} : 상속하지 못하는 클래스 지정.
			ex) class 하위클래스 extends final클래스명{} (x)
		final void call(){} : 하위에 재정의 하지 못하는 메서드 지정.
		==> 하위 클래스에서는 위 메서드를 재정의하지 못한다.	
				
		 */
		System.out.println("분야 :"+Player01.KIND);
//		Player01.KIND = "축구선수"; (The final field Player01.KIND cannot be assigned 에러 => 불변)

	}

}
class Player01{
	static final String KIND = "야구선수";
	final String name;
	String team;
	double startScore;
	Player01(String name,String team,double startScore){
		this.name = name;
		this.team = team;
		this.startScore = startScore;
	}
	void playerInfo() {
		System.out.println("팀명 :"+team);
		System.out.println("이름 :"+name);
		System.out.println("초기성적 :"+startScore);
	}
}
class Person{
	// 초기값 설정 클래스 내에서 바로 선언
	final String nation = "한국";
	final String ssn; // 생성자에 의해 초기값 설정
	String name;
	Person(String ssn, String name){
		this.ssn = ssn;
		this.name = name;
	}
}
