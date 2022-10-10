package javaexp.z02_util;

import java.util.Scanner;

public class A03_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// # Random 데이터란?
		// 1. 임의의 데이터를 말하는 것으로 프로그램이나 빅데이터 처리시 많이 활용된다.
		// 2. 자바에서는 기본적으로 Math.random()을 통해 0.0~1.0 사이에 실수로 임의의 데이터가 지원되고 있다.
		// 3. 0.0 <= Math.random()<1.0
		// 4. 0.0*10 <= (int)(Math.random()*10)<10.0
		// 5. 0.0 <= (int)(Math.random()*10)< 10
		// 6. 1 <= (int)(Math.random()*10+1)< 11
		//#공식 (int)(Math,random()*경우의 수 + 시작수)<11
		System.out.println(Math.random());
		System.out.println(Math.random()*10);
		System.out.println((int)(Math.random()*10));
		System.out.println((int)(Math.random()*10+1));
		// 주사위를 뽑아내려고 한다.
		// 주사위의 수 : 6, 시작수 1
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		System.out.println("주사위1:"+dice1);
		System.out.println("주사위2:"+dice2);
		
		// 동전 앞면/뒷면
		// 경우의 수 2 ==>0,1
		int game01 = (int)(Math.random()*2);
		if(game01==0) {
			System.out.println("동전 앞면");
		}else {
			System.out.println("동전 뒷면");
		}
		//ex1) 국어점수(0~100)을 임의로 처리하여 출력하게 하세요.
				//경우의 수:101, 시작0
		int kor = (int)(Math.random()*101+0);
		System.out.println("국어점수:"+kor);
		
		//ex2) 가위/바위/보 게임을 하여 투명이 게임한 결과를 출력하세요.
		int game02 = (int)(Math.random()*3);
		int game03 = (int)(Math.random()*3);
		if(game02==game03) {
			System.out.println("무승부");
		}else if((game02==1 && game03==3)||(game02==2 && game03==1)||(game02==3 && game03==2)) {
			System.out.println("game02 승");
		}else {
			System.out.println(("game03승"));
		}
		
		//선생님 답
		int m01 = (int)(Math.random()*3);
		int m02 = (int)(Math.random()*3);
		System.out.println("첫번째 사람 결과:");
		if(m01==0) System.out.println("가위");
		if(m01==1) System.out.println("바위");
		if(m01==2) System.out.println("보");
		System.out.println("두번쨰 사람 결과:");
		if(m02==0) System.out.println("가위");
		if(m02==1) System.out.println("바위");
		if(m02==2) System.out.println("보");
		//ex3) 홀짝 게임을 하여 홀/짝을 출력하세요.
		// 컴퓨터가 쥔 홀/짝, 내가제시한 홀/짝 맞추면 승, 그외 패.
		int gameIdx = (int)(Math.random()*2);
		String result = "짝";
		if(gameIdx==1) result = "홀";
		Scanner s = new Scanner(System.in);
		System.out.print("홀/짝을 선택하세요 : ");
		String inputch = s.nextLine();
		System.out.println("#결과#");
		System.out.println("컴퓨터가 쥔 내용 :"+result);
		System.out.println("내가 제시한 내용 :"+inputch);
		if(result.equals(inputch)) {
			System.out.println("게암 승!!");
		}else {
			System.out.println("게암 패!!");
		}
		// System.out.println("결과:"+result);
		// Random r = new Random()
		// 외부 패키지를 통해서 임의의 값에 대한 처리
	}

}
