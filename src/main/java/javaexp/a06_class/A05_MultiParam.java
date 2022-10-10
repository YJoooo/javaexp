package javaexp.a06_class;

public class A05_MultiParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 여러개의 매개변수가 있을 때 처리
		1. 생성자나 메서드는 여러개의 매개변수를 처리할 수 있고, 해당 type 유형과 매개변수의 갯수에 따라 호출한다.
			Person(String name, String loc){
			}
			==>
			new Person("홍길동", "서울 신림동");
			Person(String name, int age){
			
			}
			==>
			new Person("홍길동", 25);
		 */
		Person02 p01 = new Person02("홍길동", "서울신림동");
		Person02 p02 = new Person02("홍길동", 27);
		// ex) 여러개의 매개변수 처리
		//		Bicycle 클래스를 선언하고, 생성자로 매개변수1개, 매개변수2개(데이터 유형 변경)을 선언하고 호출하세요.
		Bicycle b01 = new Bicycle(50);
		Bicycle b02 = new Bicycle("삼천리자전거", "홍길동");
		Bicycle b03 = new Bicycle("삼천리자전거", 2015);
		Bicycle b04 = new Bicycle("홍길동"); // 홍길동 = 매개변수
		/* 
		생성자나 매개변수는
		 1) 매개변수의 타입의 유형이 다를때,
		 2) 매개변수의 갯수가 다를때,
		 3) 매개변수의 갯수가 동일하더라도 타입의 순서가 다른때
		 	다른 생성자나 메서드로 인식하여 선언이 가능하다 ==> 오버로딩 규칙이라고 한다.
		 # 궁극적으로 생성자나 매개변수에 데이터를 넘겨줄 때, 식별이 가능한한 선언이 가능하다.
		 # 오버로딩
		 1. 생성자나 메서드에 동일한 이름으로도 선언하여 사용할 수 있는 선언 규칙을 말한다.
		 	1) 궁극적인 핵심 원리는 이 내용을 호출하는 곳에서 매개변수로 식별할 수 있을때 선언이 가능하다.
		 	2) 매개변수의 갯수가 다를 때
		 	3) 매개변수의 갯수가 같더라도
		 	
		*/
	}

}
class Bicycle{
	Bicycle(String name){
		System.out.println("이름:" + name);
	}
	Bicycle(int maxSpeed){
		System.out.println("최고속도:" + maxSpeed);
	}
	Bicycle(String comp, String own){
		System.out.println("제조사:"+comp);
		System.out.println("소유주:"+own);
	}
	Bicycle(String comp, int buyYear){
		System.out.println("제조사:"+comp);
		System.out.println("구매연도 : "+ buyYear);
	}
}
class Person02{
	Person02(String name, String loc){
		System.out.println("# 생성자1 #");
		System.out.println("이름:"+name);
		System.out.println("사는 곳:"+loc);
	}
	Person02(String name, int age){
		System.out.println("# 생성자2 #");
		System.out.println("이름:"+name);
		System.out.println("사는 곳:"+age);
	}
}