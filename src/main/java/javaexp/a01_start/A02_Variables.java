package javaexp.a01_start;

public class A02_Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바의 메모리
		// 박스 : 용도를 적은 스티커를 붙이고, 저장물건을 저장해서 보관
		// 스티커명을 통해서 저장된 물건을 확인
		
		// 박스 : 저장할 데이터 유형을 선언
		// 적은 스티커 : 변수명을 지정
		// 저장물건을 저장 : 할당할 데이터를 저장
		
		int age; // 박스와 스티커를 붙임
		age = 25; // 적은 스티커에 실제 저장할 물건(데이터) 저장.
		//스티커를 출력 명령어(System.pit.println()) 출력 처리
		// ; 자바프로그램의 모든 명령어의 마지막에 붙여 준다.
		System.out.println(age); // 스티커로 데이터를 가져올 수 있다.
		
		int height = 170;
		// + 를 통해서 "" : 문자열 데이터와 연결해서 출력할 수 있다.
		System.out.println("키는" + height + "cm");
		// ex) 사과의 가격을 변수로 선언하고, 출력하세요.
		// ex) 바나나의 구매갯수를 아래와 같이 출력하세요.
		//     바나나의 갯수는 @@개입니다.
		
		int appleprice = 1000;
		System.out.println(appleprice + "원 입니다.");
		
		int banana = 12;
		System.out.println("바나나의 갯수는" + banana + "개입니다.");

	}

}
