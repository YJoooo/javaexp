package javaexp.a06_class;

public class A11_ParamField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드 매개변수와 필드값의 처리.
		1. 객체의 메서드의 매개변수를 통해서 필드값을 할당/수정/누적 연산처리 가능하다.
		2. 필드값이 변경되면 다른 메서드를 통해서 해당 필드값에 대한 여러가지 연산이나 기능 처리를 할 수 있다.
		
		 */
		ParamField pf = new ParamField();
		System.out.println("초기 num01:"+pf.getNum01());
		pf.setNum01(25);
		System.out.println("기능메서드 처리 후 num01:"+pf.getNum01());
		// ex1) num02를 할당하는 메서드 선언, num02의 값을 가져오는 메서드 선언 호출
		pf.setNum02(30);
		System.out.println(pf.getNum01());
		int retNum = pf.getNum02();
		System.out.println("변수(retNum):"+retNum);
		// ex2) 필드값으로 String name을 선언하고, name을 저장/호출 메서드 선언 처리.
		pf.setname("김연주");
		System.out.println("이름:"+pf.getName());
		String name = pf.getName();
		System.out.println("name:"+name);
		// ex3) class Fruit 선언, 필드 과일종류, 메서드로 과일종류를 저장, 과일종류를 호출 선언하세요.
		Fruit f01 = new Fruit();
		f01.setKind("키위");
		System.out.println(f01.getKind());
		f01.setPrice(5000);
		f01.showFruitInfo();
	}

}
class ParamField{
	int num01;// 50
	int num02;
	String name;// "김연주"
	void setNum01(int num01) {
		this.num01 = num01;
		System.out.println(":매개변수를 통해 필드값 할당.");
	}
	int getNum01() {
		System.out.println("현재 필드 num01 리턴");
		return num01;
	}
	void setNum02(int num02) { // int num02 = 50;
		this.num02 = num02; // 지역변수에 있는 50이 전역변수에 있는 num01에 할당.
	}
	int getNum02() {
		return num02; // 필드에 있는 num02값을 리턴처리.
	}
	void setname(String name) { // String name = "김연주";
		this.name = name; // 필드에 있는 name : this.name
		
	}
	String getName() {
		return name;
	}
}
class Fruit{
	String kind;
	int price;
	void showFruitInfo() {
		System.out.println("과일종류:"+kind);
		System.out.println("과일가격:"+price);
	}
	void setPrice(int price) {
		this.price = price;
	}
	int getPrice() {
		return price;
	}
	void setKind(String kind) {
		this.kind = kind;
		System.out.println("kind 저장:"+kind);
	}
	String getKind() {
		System.out.println("저장된kind를 호출하는 곳으로 리턴");
		return kind;
	}
}