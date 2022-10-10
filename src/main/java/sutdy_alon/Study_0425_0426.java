package sutdy_alon;

public class Study_0425_0426 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		4/25(월)
//		ex1) 사과의 가격을 변수로 선언하고, 출력하세요.
		int apple = 1300;
		System.out.println(apple+"원");
//		ex2) 바나나의 구매갯수를 아래와 같이 출력하세요.
//		     바나나의 갯수는 @@개입니다.
		int banana = 1;
		System.out.println("바나나의 갯수는 "+banana+"개 입니다.");
//		ex3) 아래와 같은 내용의 변수를 할당하고, 그 결과를 출력하세요.
//			1) 사과의 갯수 변수 선언 및 25 데이터 할당
//			2) 바나나의 가격 변수 선언 후, 해당 변수에 데이터 할당.
//			3) 위 두 과일의 정보 출력 @@의 갯수 @@, @@의 가격 @@원 형식으로 출력하세요.
		int appleCnt;
		appleCnt = 25;
		int bananaPrice;
		bananaPrice = 4500;
		System.out.println("사과의 갯수:"+appleCnt+"개 "+"바나나의 가격:"+bananaPrice+"원");
		
//		ex4) 현재 나이는 변수로 선언하여, 초기화가 되지 않았을때,
//			10년 후 나이를 처리해보고, 초기화한 후 10면 후 나이를 처리하고 출력하세요.
//		int age;
//		age+=10;
//		age = 25;
//		System.out.println(age);
		int age01 = 27;
		age01+=10;
		System.out.println(age01);
		
//		ex5) int와 char형으로 (int), (char) 형식으로 형변환하여 code값과 코드 값에 해당하는
//		문자를 확인할 수 있다.
//		1) a, A, z, Z의 코드값을 확인하여 출력하세요.
		char alp = 'a';
		char alp01 = 'A';
		char alp02 = 'z';
		char alp03 = 'Z';
		System.out.println(alp+"의 코드값 :"+(int)alp);
		System.out.println(alp01+"의 코드값 :"+(int)alp01);
		System.out.println(alp02+"의 코드값 :"+(int)alp02);
		System.out.println(alp03+"의 코드값 :"+(int)alp03);
//		2) 코드값 69, 80의 문자를 확인하여 출력하세요.
		int num = 69;
		int num01 = 80;
		System.out.println(num+"의 문자 : "+(char)num);
		System.out.println(num01+"의 문자 : "+(char)num01);
		
//		ex6) 300이 할당할 수 있는 최소 데이터 유형을 확인하여 출력하세요.
//		byte num300 = 300; 범위 초과
		short num301 = 300;
		System.out.println(num301);
//		ex7) 15억, 20억의 정수형 기본 데이터유형을 선언하고, 이를 합산하여 할당할 데이터 유형을 선언하여 출력하세요.
		int num15 = 1500000000;
		int num20 = 2000000000;
		long tot = num15+(long)num20; // 명시적 타입변환
		System.out.println(tot);
		
//		ex7) byte형으로 구매한 사과의 갯수와 바나나의 갯수를 합산하여 특정한 데이터 유형에 할당하세요.
		byte apple02 = 2;
		byte banana02 = 4;
//		byte sum = apple02+banana02; 오류 -> int부터 연산자 가능
		int sum01 = apple02+banana02; // 묵시적 형변환(byte==>int)
		int sum02 = (byte)apple02+banana02;
		System.out.println(sum01);
		System.out.println((byte)sum01);
		System.out.println(sum02); // 3가지 모두 결과는 6
//		ex8) 소고기 600g을 7등분을 하되 소숫점 이하의 결과까지 출력 처리하세요.
		int beef = 600;
		double shar = beef/7.0;
		double shar01 = (double)beef/7; // 명시적 형변환
		System.out.println(shar);
		System.out.println(shar01);

	}

}
