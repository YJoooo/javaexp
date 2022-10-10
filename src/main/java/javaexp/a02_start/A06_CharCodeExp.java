package javaexp.a02_start;

public class A06_CharCodeExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ex) int와 char형으로 (int), (char) 형식으로 형변환하여 code값과 코드 값에 해당하는
		문자를 확인할 수 있다.
		1) a, A, z, Z의 코드값을 확인하여 출력하세요.
		2) 코드값 69, 80의 문자를 확인하여 출력하세요.
		
		 */
		char ch01 = 'a';
		char ch02 = 'A';
		char ch03 = 'z';
		char ch04 = 'Z';
		System.out.println(ch01 + "의 unicode값:" + (int)ch01);
		System.out.println(ch02 + "의 unicode값:" + (int)ch02);
		System.out.println(ch03 + "의 unicode값:" + (int)ch03);
		System.out.println(ch04 + "의 unicode값:" + (int)ch04);
		
		int num1 = 69;
		int num2 = 80;
		System.out.println(num1 + "코드값의 문자:" + (char)num1);
		System.out.println(num2 + "코드값의 문자:" + (char)num2);
		
		/*
		# 정수형 데이터의 기본 데이터 유형
		ex1) 300이 할당할 수 있는 최소 데이터 유형을 확인하여 출력하세요.
		ex2) 15억, 20억의 정수형 기본 데이터유형을 선언하고, 이를 합산하여 할당할 데이터 유형을 
		선언하여 출력하세요.
		 */
//		byte num01 = 300;
		short num01 = 300;
		System.out.println("num01:" + num01);
		// 연산이 들어가는 순간 데이터 유형은 int형 이상이 필요로 한다.
		byte num08 = 25;
		byte num09 = 7;
//		byte num10 = num08+num09; 에러발생
//		System.out.println(num09);
		int num02 = 1500000000;
		int num03 = 2000000000;
		//데이터 유형의 범위에 맞는 데이터를 (long) 형변환을 하고, 적절한 데이터에 합당하여야 처리 할수있다.
		//long num04 = num02+num03; 데이터가 제대로 나오지 않음.
		long num04 = (long)num02+(long)num03;// 명시적 타입변환
		System.out.println("num02:" + num02);
		System.out.println("num03:" + num03);
		System.out.println("num04:" + num04);
		
		/*
		Math.random()함께 임시비밀번호 발급
		 */
		for(int code=65;code<=90;code++) {
			System.out.println(code+":"+(char)code);
		}
		System.out.println("# 임의의 비밀번호(알파벳대문자) #");
		for(int cnt=1;cnt<=8;cnt++){
			int ranCode = (int)(Math.random()*26+65);
			System.out.println(ranCode+":"+(char)ranCode);
		}

	}

}
