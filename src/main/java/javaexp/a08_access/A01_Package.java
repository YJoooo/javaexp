package javaexp.a08_access;

import javaexp.a07_multiObj.A06_Food;
import javaexp.a07_multiObj.A07_Bus;

public class A01_Package {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 패키지란 ?
		1. 클래스를 기능별로 묶에서 그룹 이름을 붙여 놓은 것을 말한다.
			1) 파일들을 관리하기 위해 사용하는 폴드(디렉토리)와 비슷한 개념이다.
			2) 패키지의 물리적인 형태는 파일 시스템의 폴드이다.
			
			cf) 같은 패키지하위에 있는 클래스의 멤버(구성요소-필드/생성자/메서드)는 접근제어자 default(x)이상일때, 제한없이 접근해서
				사용할 수 있다.
			주의) 패키지는 계층구조를 인정하지 않는다. javaexp 패키지 javaexp.pack01 패키지는 다른 패키지로 인정한다.
		2. 클래스 이름의 일부
			1) 클래스를 유일하게 만들어 주는 식별자
			2) 전체클래스 이름 = 상위패키지,하위패키지.클래스
				ex) 현재 클래스명 : javaexp.a08_access.A01_Package
			3) 클래스명이 같아도 패키지명이 다르면 다른 클래스로 취급한다.
				ex) 같은 클래스명이지만 다른 클래스로 취급
					javaexp.a07_multiObj.A01_Package
		3. 클래스 선언할 때, 패키지 결정
			1) 클래스 선언할 때 포함될 패키지 선언.
			 	package 패키지명
			 	class 클래스명
			 	ex)
			 		package javaexp.a08_access;
			 		public class A01_Package {
			 2) 클래스 파일(.class) 선언된 패키지와 동일한 폴더 안에서 동작
			 3) 클래스 파일(.class) 다른 폴더 안에 넣으면 동작하지 않음.		
		 */
		System.out.println("현재 패키지 클래스의 객체:"+new A01_Package());
		// javaexp.a08_access.A01_Package@182decdb
		// 패키지명.클래스면@주소값
		// 동일한 클래스의 다른 패키지의 클래스를 객체로 사용할 때는 패키지명을 지정하여 호출한다.
		javaexp.a07_multiObj.A01_Package pk = new javaexp.a07_multiObj.A01_Package();
		System.out.println("다른 패키지 클래스의 객체:"+pk);
		// ex) javaexp.a07_multiObj 안에 A05_Person.java 선언하고
		//		현재 패키지(javaexp.a08_access)에서 A05_Peraon.java를 선언하여 두 객체를 생성하고, 참조 변수의 주소값을 확인하세요.
		javaexp.a07_multiObj.A05_Person pk01 = new javaexp.a07_multiObj.A05_Person();
		javaexp.a08_access.A05_Person pk02 = new javaexp.a08_access.A05_Person();
		System.out.println("a07_multiObj 패키지"+pk01);
		System.out.println("a08_access 패키지"+pk02);
		
		//같은 패키지에 있는 클래스는 패키지명을 생략하여도 호출되어 사용할수 있다.
		A05_Person p001 = new A05_Person();
		System.out.println(p001);
		System.out.println(p001.name);
		// 다른 패키지에 있는 클래스는 패키지명. 클래스명으로 호출하여 사용할 수 있다.
		// # 같은 클래스명을 호출하는 곳 (main()이나 다른 클래스 내부에서) 사용할때.
		// 반드시 패키지명으로 구분해서 사용하여야 한다.
		javaexp.a07_multiObj.A05_Person p002 = new javaexp.a07_multiObj.A05_Person();
		System.out.println(p002.name);
		/*
		# 클래스명이 한 곳에서 동일한 것이 호출되지 않을 때는 패키지명을 생략가능하다.
		1. import 패키지명.클래스명으로 상단에 선언하고,
		2. public 접근제어자 범위 안에 있으면 객체를 사용할 수 있다.
		 */
		// import 하면 패키지명 없이도 사용이 가능하다.
		//import javaexp.a07_multiObj.A06_Food;
		A06_Food f01 = new A06_Food();
		System.out.println(f01);
		System.out.println(f01.name);
		
		// ex) 외부 패키지 javaexp.a07_multiObj에 A07_Bus를 선언하고, import를 이용해서 객체의 참조값으로 호출하고,
		//		다시 필드값을 public을 선언하여 번호를 할당하고, 호출하여 출력하세요.
		// import javaexp.a07_multiObj.*;
		// => 해당 패키지에 소속되어 있는 모든 클래스를 모두 다 import하여 사용할 수 있다.
		A07_Bus b01 = new A07_Bus();
		System.out.println(b01.num);
		
	}

}
