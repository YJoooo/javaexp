package javaexp.a03_calcu;

public class A01_CalcuStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 연산자와 연산식
		1. 연산이란?
			데이터를 처리하여 결과를 산출하는 것을 말한다.
			2. 연산자(operations)
				연산에 사용되는 표시나 기호를 말한다.
				+, -, *(곱), /, %(나머지), =, ...
			3. 피연산자(operand)
				연산 대상이 되는 데이터(리터럴, 변수)
				num01, 25, num02
			4. 연산식
				연산자와 피연산자를 이용하여 연산의 과정을 기술하는 것
				num01 + num02
				sum = num01 + num02
				연산자 : =, *
				피연산자 : sum, num01, num02
				연산식 : 연산자와 피연산자를 혼합하여 식을 만들어 가는 것
		 */
		int num01 = 25; // 연산자 =, 피연산자 num01에 리터럴 데이터 25로 할당
		int num02 = 5;
		System.out.println(num01 + "+"+ num02 + "="+(num01+num02));
		System.out.println(num01 + "-"+ num02 + "="+(num01-num02));
		System.out.println(num01 + "*"+ num02 + "="+(num01*num02));
		System.out.println(num01 + "/"+ num02 + "="+(num01/num02));
		System.out.println(num01 + "%"+ num02 + "="+(num01%num02));
		/*
		ex) 사칙연산자 처리 연습예제
		1. 사과와 바나나의 가격을 설정해서 총 비용을 연산자, 피연산자를 통한 연산식을 만들어 결과를 출력하세요.
		2. 사과의 가격에 구매한 갯수를 처리하여 결과를 출력
		3. 바나나의 구매 갯수를 설정하고, 사과의 총비용과 바나나의 총 비용의 차이를 구하세요.
		4. 곰돌이 3마리가 빵 20개를 똑같이 먹고, 남은 나머지 갯수를 위 연산식에 의해 출력하세요.
		 */
		int appleprice = 1000;
		int bananaprice = 3000;
		int applebuy = 4;
		int bananabuy = 2;		
		System.out.println(appleprice + "+" + bananaprice + "=" + (appleprice+bananaprice));
		System.out.println(appleprice + "-" + bananaprice + "=" + (appleprice-bananaprice));
		System.out.println(appleprice + "*" + bananaprice + "=" + (appleprice*bananaprice));
		System.out.println(appleprice + "/" + bananaprice + "=" + (appleprice/bananaprice));
		System.out.println(appleprice + "%" + bananaprice + "=" + (appleprice%bananaprice));
		
		System.out.println(applebuy*appleprice);
		
		int appletot = appleprice*applebuy;
		int bananatot = bananaprice*bananabuy;
		System.out.println(appletot-bananatot);
		
		int bear = 3;
		int bread = 20;
		System.out.println(bread + "%" + bear + "=" + (bread%bear));

	}

}
