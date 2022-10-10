package javaexpz01_homework;

public class A0425 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 아래 과제 결과를 카톡 text복사해서 메세지로 전달 : 양현수
 1. 코드 처리(메세지)
     1) 자바의 컴파일과 실행과정을 A0425.java를 통해서 설명하세요.
        workspace\javaexp\src\main\java\javaexpz01_homework\A0425.java
        workspace\javaexp\build\classes\javaexpz01_homework\A0425.class
     2) 변수명을 아래와 같이 선언하고 출력하세요.
         문자열 선언 방법 : string a
         정수형/실수형 선언과 할당
         int / double
         이름, 나이, 키를 변수를 선언하여 출력하세요.
         
 2. ppt 자료 작성 : 파일로	
     1) 자바 기본 환경 설정 ppt 자료로 작성하여 전달해 주세요.
        c:\a02_javaexp
           jdk 설치
           workspace
           eclipse	
**/
	
	//1) 자바의 컴파일과 실행과정을 A0425.java를 통해서 설명하세요.
		//저장시, javac A0425.java가 실행되고, A425.class 생성
		// main()가 포함되어 있으면, java A0425통해서 main()안에있는 {} 내용을 수행해준다.
     //workspace\javaexp\src\main\java\javaexpz01_homework\A0425.java
     //workspace\javaexp\build\classes\javaexpz01_homework\A0425.class
		
	//2) 변수명을 아래와 같이 선언하고 출력하세요.
	   //문자열 선언 방법
		String a = "문자";
		
       //정수형/실수형 선언과 할당
        int num;
        num = 1;
        
        double b;
        b = 1.2;
        
       //이름, 나이, 키를 변수를 선언하여 출력하세요.
		String name = "김연주";
		int age = 27;
		double height = 164.8;
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height + "cm");
		
	}

}
