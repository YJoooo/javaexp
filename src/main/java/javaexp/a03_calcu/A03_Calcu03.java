package javaexp.a03_calcu;

public class A03_Calcu03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 대입연산자
		1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당이 된다.
		 */
		int num01 = 25;
		int num02; int num03; int num04; //선언
		num02 = num03 = num04 = 5; // 동일한 데이터를 한번에 할당
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		/*
		2. +=, -=, *=, /=, %=
		 기존 변수에서 누적하여 다시 데이터를 할당할때, 활용된다.
		 2이상의 증가하거나 감소 등 연산식을 처리할때, 활용된다.
		 */
		num01 = num01 + 5;
		System.out.println("기존에 데이터를 합산한값:"+num01);
		num01 += 5;
		System.out.println("누적 합산값:"+num01);
		num01-= 5;
		System.out.println("누적 뺀값:"+num01);
		/*
		ex) 변수 cnt01~cnt05에 데이터 5를 한번에 선언과 할당을 하고, 누적증감연산자에 의해서
		cnt01~cnt05, 2,3,4,5,6,증가 처리 하여 출력하세요.
		 */
		int cnt01; int cnt02; int cnt03; int cnt04; int cnt05;
		// 같은 방법으로 int cnt01, cnt02, cnt03, cnt04, cnt05; 정수형 데이터 선언
		cnt01 = cnt02 = cnt03 = cnt04 = cnt05 = 5;
		cnt01 += 2;
		cnt02 += 3;
		cnt03 += 4;
		cnt04 += 5;
		cnt05 += 6;
		System.out.println(cnt01);
		System.out.println(cnt02);
		System.out.println(cnt03);
		System.out.println(cnt04);
		System.out.println(cnt05);
		
	}

}
