package javaexp.a06_class;

public class A06_ConstructorInitData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자의 필드값 초기화
		1. 생성자의 가장 핵심 기능으로 필드값을 할당하여 처리할 수 있다.
		2. 기본 예제
			class Person{
				String name;
				int age;
				Person(String name, int age{
				this.name = name; // 입력된 매개변수명과 필드명이 같을 때는 this 키워드를 통해 구분해준다. ==> this.필드명
				this.age = age;
		 */
		Person04 p01 = new Person04("홍길동",25);
		System.out.println(p01.name);
		System.out.println(p01.age);
		
		// ex) 아래 내용으로 생서자의 필드값을 초기화하고 해당 필드를 출력하세요.
		//		1) Product05 : 물건명 가격 갯수
		Product05 pro01 = new Product05("마우스",16000,2);
		System.out.println(pro01.thing);
		System.out.println(pro01.price);
		System.out.println(pro01.cnt);
		//		2) Calculator : 숫자1, 숫자2, 연산자
		Calculator c01 = new Calculator(15,28,"+");
		System.out.println(c01.num01);
		System.out.println(c01.num02);
		System.out.println(c01.cal);
		//		3) Book :도서명, 가격, 저자
		Book b01 = new Book("연놈", 23000, "김길동");
		System.out.println(b01.book);
		System.out.println(b01.bPrice);
		System.out.println(b01.writer);
	}

}
class Book{
	String book;
	int bPrice;
	String writer;
	Book(String book,int bPrice,String writer){
		this.book=book;
		this.bPrice=bPrice;
		this.writer=writer;
	}
}
class Calculator{
	int num01;
	int num02;
	String cal;
	Calculator(int num01, int num02, String cal){
		this.num01 = num01;
		this.num02 = num02;
		this.cal = cal;
	}
}
class Product05{
	String thing;
	int price;
	int cnt;
	Product05(String thing, int price, int cnt){
		this.thing = thing;
		this.price = price;
		this.cnt = cnt;
	}	
}
class Person04{
	String name;
	int age;
	Person04(String name, int age){
		this.name = name;
		this.age = age;
	}
}