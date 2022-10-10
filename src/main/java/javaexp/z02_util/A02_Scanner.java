package javaexp.z02_util;

import java.util.Scanner;

public class A02_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ex) Scanner 생성하고, 구매할 과일명을 입력하세요.
		 구매할 과일 갯수를 입력하세요.
		 과일명 @@, 갯수@@개 출력.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("구매할 과일명");
		String fruite = sc.nextLine();
		System.out.println("구매할 갯수");
//		String cnt = sc.nextLine();
		int cnt = sc.nextInt();// 연산이 필요한 경우 숫자형으로 입력 받아야한다.
		//sc.nextFloat(); 실수형 데이터 입력..
		System.out.println("과일명"+fruite+",갯수"+cnt+"개");
		System.out.println("가격이 3000인 경우:"+cnt*3000);

	}

}
