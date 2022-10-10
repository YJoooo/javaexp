package javaexp.a05_reference;

public class A04_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 배열 타입
		1. 같은 타입의 데이터를 연속된 공간에 저장하는 자료 구조
		2. 각 데이터 저장 위치는 인덱스 부여해 접근한다.
		 */
		int[] arry = {1000,2000,3000,4000};
		System.out.println(arry[0]);
		System.out.println(arry[1]);
		System.out.println(arry[2]);
		System.out.println(arry[3]);
		/*
		# 배열의 장점
		1. 중복된 변수 선언을 줄이기 위해 사용합니다.
			int num01;
			int num02;
			int num03;
			int num04;
			==>
			int[] numArry;
		2. 반복문을 통해서 효과적으로 활용할 수 있다.
			for(인덱스의 초기값;인덱스의 범위;증감연산자)
		 */
		// 배열명.length : 배열의 길이
		// 배열의 index의 최고값 : 배열의 길이 -1 (0부터 시작하기떄문에)
		// 배열의 범위를 설정할 때, index값이 길이보다 작기때문
		// 비교연산자를 < 
		// cf) 주의 <= (X)
		System.out.println("반복문을 통한 배열의 처리");
		for(int idx=0;idx < arry.length;idx++) {
			System.out.println("index 번호:"+idx+"\t");
			System.out.println(arry[idx]+"\n");
		}
		/*
		# 배열의 선언.
		1. 배열을 사용하기 위해서 우선 배열 변수 선언.
			데이터유형[] 배열변수;
			데이터유형 배열변수[];
		2. 배열은 초기화를 통해 선언을 완료한다.
			배열변수 = null;
			배열의 초기화 선언으로 사용할 수 없다.
			ex) int num01;
				num01 = 0; 사용할 수 있듯이
				
		3. 배열의 heap영역에 메모리를 할당하여야 사용할 수 있다.
			1) new 데이터유형[배열의 크기]; 초기값(0)으로 모든 배열의 구성요소를 할당.
			2) {데이터1, 데이터2, 데이터3} : 선언과 직접적인 데이터 할당 한번에
			3) new 데이터 유형[]{데이터1, 데이터2, 데이터3}; : 선언/할당 분리할 때
			4) 각 배열의 index값을 할당.
		 */
		int []arry01; // 배열의 선언1
		int arry02[]; // 배열의 선언2
		arry01=null; // 배열의 stack영역 초기화 : heap영역에 할당되지 않음, 사용불가능
		float [] arry03 = null;
		System.out.println(arry01);
		System.out.println(arry03);
//		System.out.println(arry02); stack영역 초기화 되지 않아 호출조차 불가능
		// heap영역에 할당하지 않은 상황에서 index로 사용하면 에러 발생
//		System.out.println(arry01[0]); 에러발생.
		// heap 메모리 할당 - 데이터 초기화
		// 객체는 stack/heap영역 같이 사용하고, new 키워드를 통해서 heap영역에 객체를 생성한다.
		int [] arry04 = new int[5]; // int형으로 초기값이 0인 데이터가 할당된 5개가 포함된 배열 선언.
		arry04[2] = 50;
		System.out.println(arry04[0]);
		System.out.println(arry04[1]);
		System.out.println(arry04[2]);
		System.out.println(arry04[3]);
		System.out.println(arry04[4]);
		int [] arry05 = {10,20,40,30,50};
		//배열객체를 생성, 초기 데이터 할당
		System.out.println(arry05[0]);
		System.out.println(arry05[1]);
		System.out.println(arry05[2]);
		System.out.println(arry05[3]);
		System.out.println(arry05[4]);
		int [] arry06;
		arry06 = new int[] {10,40,20};
		//선언후, 초기데이터 할당시에는 반드시 new 데이터유형[]{} 선언하여야 한다.
		System.out.println(arry06[0]);
		System.out.println(arry06[1]);
		System.out.println(arry06[2]);
		char [] arry07 = {'A','C','E'};
		double[] arry08 = {30.5,4.2,50.7};
		String[] arry09 = {"사과","바나나","딸기"};
		for(int idx=0;idx<arry07.length;idx++) {
			System.out.println(arry07[idx]+":"+arry08[idx]+":"+arry09[idx]);
		}
		// ex1) 정수형으로 5개 초기값 0으로 배열을 선언하고 2번째와 4번쨰 데이터를 할당하고 전체 데이터를 출력하세요.
		int[] arry1=new int [5];
		arry1 = new int[] {0,5,0,7,0};
		System.out.println(arry1[0]);
		System.out.println(arry1[1]);
		System.out.println(arry1[2]);
		System.out.println(arry1[3]);
		System.out.println(arry1[4]);
		//선생님 답
		int[] intArry = new int[5];
		intArry[1] = 30;
		intArry[3] = 40;
		for(int idx=0;idx<intArry.length;idx++) {
			System.out.println(idx+1+"번쨰 데이터 : "+intArry[idx]);
		}
		// ex2) 몸무게(실수) 배열 3개를 선언과 동시에 할당하고 출력하세요.
		double[] arry2 = {55.5,74.2,48.8};
		System.out.println(arry2[0]);
		System.out.println(arry2[1]);
		System.out.println(arry2[2]);
		// 선생님 답
		double[]weightArry = {70.2,55.41,80.5};
		for(int idx=0;idx<weightArry.length;idx++) {
			System.out.println(idx+1+"번째 몸무게:"+weightArry[idx]);
		}
	
	
	
	
	}
	

}
