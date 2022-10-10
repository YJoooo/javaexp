package javaexp.a02_start;

public class A07_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 데이터의 형변환
		1. 데이터 타입을 다른 타입으로 변환하는 것을 말한다.
			byte ==> int, int ==> double
		2. 종류
			자동(묵시적)타입변환 : promotion
			강제(명시적)타입변환 : casting
		3. 자동(묵시적)타입변환
			작은 데이터유형에서 큰 데이터 유형으로 변환할 때는 추가 코드 없이 자동으로 할당이 된다.
		 */
		byte num01 = 25;
		int num02 = 25+num01;
		int num03 = 30;
		double num04 = num03;
		System.out.println("# 묵시적 형변환 결과#");
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		// 앞에 문자 앞에 영향을 받아서 묵시적으로 숫자가 문자열로 변경되는 
		/*
		4. 명시적 형변환(casting)
			1) ()을 활용하여 특정한 데이터유형으로 변경이 명시적으로 필요할 때, 사용한다.
			2) 유형
				큰데이터형 ==> 작은데이터형
					int num01 = (int)25.27;
				작은데이터형 ==> 큰데이터형
					int num02 = 10;
					int num03 = 3;
					double result = num02/num03; 3.0
					double result = num02/(double)num03; 3.33333
				cf) 자바에서는 정수와 정수형의 나눗셈음 정수형으로만 나온다.
				실수형까지 처리하려면 연산하는 피연산자가 하나는 실수이어야한다.
				
		 */
		double dbNum = 25.27;
		int num05 = (int)dbNum;
		System.out.println("casting한 결과:"+num05);
		int num06 = 10;
		int num07 = 3;
		// 정수형/정수형 ==> 정수형 : 소숫점 이하의 값이 나오지 않는다.
		// 정수형/실수형 ==> 실수형 : 소숫점 이하의 값이 처리가 된다.
		double result = num06/num07;
		System.out.println("연산결과값:"+result);
		double result2 = num06/(double)num07;
		System.out.println("연산결과값:"+result2);
		
		/*
		ex1) byte형으로 구매한 사과의 갯수와 바나나의 갯수를 합산하여 특정한 데이터 유형에 할당하세요.
		ex2) 소고기 600g을 7등분을 하되 소숫점 이하의 결과까지 출력 처리하세요.
		
		 */
		byte apple = 1;
		byte banana = 2;
		//+(연산자)가 들어가면 결과값이 int 유형이 필요로한다.
		int tot1 = apple +banana;
		// 합산 결과를 해당 유형에 맞게 casting하여 int ==> byte로 처리되게 한다.
		byte tot2 = (byte)(apple+banana);
		System.out.println("결과값1"+tot1);
		System.out.println("결과값2"+tot2);
		
		int beef = 600;
		int div = 7;
		double result3 = beef/(double)div;
		System.out.println("결과값3"+result3+"g");
		

	}

}
