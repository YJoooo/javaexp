package javaexp.a09_inherit;

import java.util.ArrayList;

public class A04_Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다형성(polymorphism)
		1. 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질을 말한다.
			- 부모 타입에는 모든 자식 객체가 대입가능
			- 자식 타입은 부모 타입으로 자동 타입변환
			ex) 타이어의 공통적인 내용에서 사용시
					한국타이어, 금호타이어, 광폭타이어 등 여러가지 형태로 재정의 메서드에 따라서 활용되는 것을 사용할 수 있다.
				컴퓨터의 부품(ComPart)이라는 공통 클래스에서
					Ram, Cpu, Hdd 등의 기능에 따라서 여러가지 내용을 사용할 수 있다.
					이때, 상위에 있는 공통 필드나 메서드를 선언하고, 하위에 재정의하여 활용하면 프로그램을 효과적으로 처리할 수 있다.
		2. 자동 타입 변환(promotion)
			- 프로그램 실행 도중에 자동 타입 변환이 일어나는 것
				부모클래스 변수 = 자식클래스타입
				class Animal{}
				class Cat extends Animal{}
				Animal an01 = new Cat();
				
		ex) 상위 Animal 메서드 sound() 재정의
			하위 Cat, Dog, Bird
				다형성 처리로 출력하세요
				Amimal a1 = new Cat();
			
		 */
		Animal a1 = new Cat();
		a1.eatFood(); a1.sound();
		ArrayList<Animal> anList = new ArrayList<Animal>();
		anList.add(new Cat());
		anList.add(new Dog());
		anList.add(new Bird());
		System.out.println("#다중객체의 기능을 배열로 처리#");
		for(Animal an:anList) {
			an.eatFood();an.sound();
		}
		System.out.println("임의의 객체 호출");
		int ranIdx = (int)(Math.random()*3);
		anList.get(ranIdx).sound();
		
		Animal a2 = new Dog();
		a2.sound();
		Animal a3 = new Bird();
		a3.sound();
		// 부모 객체가 형변환이 일어나서 하위 객체로 생성
		Larba l1 = new Dron();
		l1.attack();
		Larba l2 = new Zerggling();
		l2.attack();
		// ex) 상속을 Hydra 클래스를 선언하고 attack()메서드 공격력 +3으로 원거리 하다 처리하세요.
		Larba l3 = new Hydra();
		l3.attack();
	}

}
class Animal{
	private String kind;
	
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	public void eatFood() {// 공통기능메서드
		System.out.println(kind+"가 음식을 먹다");
	}
	public void sound() {// 하위에서 다양하게 처리할 메서드
		System.out.println(kind + "가 소리를 내다");
	}
}
class Cat extends Animal{
	
	public Cat() {
		super("고양이");
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
		System.out.println("냐옹");
	}
	
}
class Dog extends Animal{
	public Dog() {
		super("강아지");
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
		System.out.println("왈왈");
	}
	
}
class Bird extends Animal{
	public Bird() {
		super("새");
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
		System.out.println("짹쨱");
	}
	
}
// Starcraft
// Zerg(외계종족-파충류)
//	Larba ==> Dron
//		==> Zerggling
//		==> Hydra
class Larba{
	public void attack() {
		System.out.println("공격을 하다");
	}
}
class Dron extends Larba{
	@Override
	public void attack() {
		super.attack();
		System.out.println("공격력 +1로 원거리");
	}
	
}
class Zerggling extends Larba{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		super.attack();
		System.out.println("공격력 +1로 빠르게 근접 공격하다");
	}
	
}
class Hydra extends Larba{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		super.attack();
		System.out.println("공격력 +3으로 원거리하다");
	}
	
}