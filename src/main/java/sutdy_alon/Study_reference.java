package sutdy_alon;

import java.util.Scanner;

public class Study_reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ex1) Product 를 prod01과 prod02 객체를 생성하고 주소값을 비교
		Product prod01 = new Product();
		Product prod02 = new Product();
		System.out.println(prod01);
		System.out.println(prod02);
		System.out.println(prod01==prod02);
		System.out.println(prod01.equals(prod02));
		
		//ex2) prod03을 선언하고 prod01에서 할당하고, prod01과 prod03를 비교
		Product prod03 = new Product();
		prod03=prod01;
		System.out.println(prod03==prod01);
		System.out.println(prod03);
		// ex1) 정수형으로 5개 초기값 0으로 배열을 선언하고 2번째와 4번쨰 데이터를 할당하고 전체 데이터를 출력하세요.
		int[] arry = new int[5];
		arry[1] = 1;
		arry[3] = 2;
		for(int inx=0;inx<arry.length;inx++) {
			System.out.println(arry[inx]);
		}
		// ex2) 몸무게(실수) 배열 3개를 선언과 동시에 할당하고 출력하세요.
		double[]weight = {48.2,52.6,55.0};
		for(int inx=0;inx<weight.length;inx++) {
			System.out.println(weight[inx]);
		}
		// ex) 2차원 배열로 번호별로 국어/영어/수학점수를 할당했을때.
		//		3명의 국어/영어/수학 출력하세요.
		// 3명의 학생의 국어/영어/수학점수
		int [][] score = {
				{80,90,75},
				{70,45,68},
				{50,69,100}
		};
		for(int idx = 0;idx<score.length;idx++) {
			System.out.println((idx+1)+"번째 학생 점수");
			for(int jdx = 0; jdx<score[idx].length;jdx++) {
				System.out.println(score[idx][jdx]);
			}
		}
//		ex) Scanner 생성하고, 구매할 과일명을 입력하세요.
//		 구매할 과일 갯수를 입력하세요.
//		 과일명 @@, 갯수@@개 출력.
		/*
		Scanner fruite = new Scanner(System.in);
		System.out.println("구매할 과일명을 입력하세요");
		String fname = fruite.nextLine();
		System.out.println("구매할 과일 갯수를 입력하세요.");
		int cnt = fruite.nextInt();
		System.out.println("과일명 "+fname+", 갯수"+cnt+"개");
		*/
		//ex1) 국어점수(0~100)을 임의로 처리하여 출력하게 하세요.
		//경우의 수:101, 시작0
		/*
		int kor = (int)(Math.random()*101+0);
		System.out.println(kor);
		//ex2) 가위/바위/보 게임을 하여 두명이 게임한 결과를 출력하세요.
		int game = (int)(Math.random()*3+1);
		int game1 = (int)(Math.random()*3+1);
		
		if(game==1) System.out.println("가위");
		if(game==2) System.out.println("바위");
		if(game==3) System.out.println("보");
		if(game1==1) System.out.println("가위");
		if(game1==2) System.out.println("바위");
		if(game1==3) System.out.println("보");
		//ex3) 홀짝 게임을 하여 홀/짝을 출력하세요.
				// 컴퓨터가 쥔 홀/짝, 내가제시한 홀/짝 맞추면 승, 그외 패.
		int game01 = (int)(Math.random()*2+1);
		int game02 = (int)(Math.random()*2+1);
		if(game01==1)System.out.println("홀");
		if(game01!=1)System.out.println("짝");
		if(game02==1)System.out.println("홀");
		if(game02!=1)System.out.println("짝");
		if(game01==game02) System.out.println("승");
		if(game01!=game02) System.out.println("패");
		
		int game03 = (int)(Math.random()*2);
		String result;
		if(game03==0) {
			result = "홀";
		}else {
			result = "짝";
		}
		Scanner g = new Scanner(System.in);
		System.out.println("홀짝을 입력하세요");
		String hss = g.nextLine();
		if(result.equals(hss)) {
			System.out.println("승");
		}else {
			System.out.println("패");
		}
		*/
		// java A.05_ArgsExp 학생명 국어 영어 수학
		// 위와 같이 학생명과 국어 영어 수학 점수를 입력 받아, 해당 정보를 출력하세요.
		// 학생명 : @@
		// 국어 : @@
		// 영어 : @@
		// 수학 : @@
		// 총점 : @@
		// 평균 : @@ (소숫점이하 표기)
		String name1 = args[0];
		int kor1 = Integer.parseInt(args[1]);
		double eng1 = Double.valueOf(args[2]);
		int math1 = Integer.parseInt(args[3]);
		double tot = kor1+eng1+math1;
		double evg = (kor1+eng1+math1)/3.0;
		System.out.println("학생명 : "+name1);
		System.out.println("국어 : "+kor1);
		System.out.println("영어 : "+eng1);
		System.out.println("수학 : "+math1);
		System.out.println("총점 : "+tot);
		System.out.println("평균 : "+evg);
	}

}
class Product{
	int num;
}
