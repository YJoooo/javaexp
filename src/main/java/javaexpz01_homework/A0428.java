package javaexpz01_homework;

import java.util.Scanner;

public class A0428 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	[1단계:개념]1. 반복문 for, while, do while의 차이점을 기술하세요.
		//for문 : 조건이 진실이면 증감식 수행
		//while문 : 조건이 거짓이면 한번도 수행안함
		//do{}while문 : 거짓이어도 최소 한번은 수행
		
//	[1단계:개념]2. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
		// 0부터 5씩 증가하여 50까지 출력
		for(int cnt=0;cnt<=50;cnt+=5) { //for(초기화;조건식;증감식){
		System.out.println(cnt); // 실행문}
		}
//	[1단계:개념]3. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
		for(int cnt=200;cnt>=100;cnt-=3) {
			System.out.println(cnt);
		}
//	[1단계:개념]4. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 
//				총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
//	            # 출력 형식
//	            1일차 2개 2개
//	            2일차 4개 6개
//	            3일차 6개 10개
		int bread = 0;
		int tot = 0;
		for(int cnt=1;cnt<=10;cnt++) {
			bread+=2;
			tot+=bread;	
			System.out.println(cnt+"일차 "+bread+"개 "+tot+"개");
		}
//	[1단계:코드]5. 3/6/9게임 2단계 1~20까지 해당 게임과 같이 출력처리하세요(모두 출력해주세요)
//	            1) 1단계 : 3의 배수에 짝이라 표기
		for(int cnt=1;cnt<=20;cnt++) {
			if(cnt%3==0) {
				System.out.println("짝");
			}else {
				System.out.println(cnt);
			}
		}
//	            2) 2단계 : 1 2 짝 4 ... 10 11 12 짝 14 15 16 짝...
		for(int cnt=1;cnt<=20;cnt++) {
			if(cnt%3==0) {
				System.out.print("짝 ");
			}else {
				System.out.print(cnt+" ");
			}
		}
		System.out.println();
		
		//선생님 답
		// 마지막에 3,6,9가 되려면 십단위가 빠지면 된다.
		// 변수%10 ==> 모든 0,1,...9
		// 위 결과값에 %3 ==> 뒷자리가 3,6,9가 처리된다.
		// 10단위가 되는 부분은 제어 해야한다. cnt%10!=0
		for(int cnt=1;cnt<=20;cnt++) {
			if(cnt%10!=0 && cnt%10%3==0) {
				System.out.println("짝 ");
			}
			System.out.println(cnt+" ");
		}
		
//	[1단계:코드]6. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
//	           초기데이터 100
//	           1회  25 
//	           2회  6.2..
//	           3회  1.54...
//	           4회  0.38..
		//선생님 답
			double num01 = 100;
			for(int cnt=1;cnt<=4;cnt++) {
				// num =num/4
				//num/4; // 누적 /연산처리
				System.out.println(cnt+"회\t"+(num01/=4));
			}
		
//	[1단계:개념]7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
		//3단을 출력하는데 x5는 생략
		int dan = 3;
		for(int cnt = 1;cnt<=9;cnt++) {
			if(cnt==5) continue;
			System.out.println(dan+"*"+cnt+"="+(cnt*dan));
		}
		//5단을 출력하는데 x6부터는 중단
		int dan5 = 5;
		for(int cnt = 1;cnt<=9;cnt++) {
			if(cnt==6) break;
			System.out.println(dan5+"*"+cnt+"="+(cnt*dan5));
		}	
//	[2단계:코드]8. [continue 활용]1~12월까지 마지막일수*10으로 월급여 산정하되, 31일만 있는 월만 산정해서 출력하고 
//				나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요<어려움>
//	                월  일수   월급여 누적연봉      
//	                1월 31일  310만 310만원
//	                3월 31일  310만 620만원
//	                5월 31일  310만 930만원
//	                ..
//	                12 31일  .. 
		System.out.println("월\t일수\t월급여\t누적연봉");
		int tot03=0;
		for(int cnt=1;cnt<=12;cnt++) {
			if(cnt==1||cnt==3||cnt==5||cnt==7||cnt==8||cnt==10||cnt==12) {
				tot03+=310;
				System.out.println(cnt+"월\t31일\t310만원\t"+tot03+"만원");
			}else {}
			
		}
		// 선생님 답
		int dateSal = 10;
		int date = 31;
		int yearSal = 0;
		// 30,28 : 2,4,6,9,11
		System.out.println("월\t일수\t월급여\t누적연봉");
		for(int mcnt=1;mcnt<=12;mcnt++) {
			//해당월은 배제 처리.
		if (mcnt==2|| mcnt==4|| mcnt==6|| mcnt==9|| mcnt==11)
			continue;
			System.out.print(mcnt+"월\t");
			System.out.print(date+"일\t");
			int msal = dateSal*date;
			System.out.print(msal+"만원\t");
			yearSal+=msal;
			System.out.print(yearSal+"만원\n");
		}
		
//	[1단계:개념]9. Scanner 객체 선언과 사용법을 기술하세요.
		//import를 상단에 해주어서 객체를 생성해서 사용할 수 있다.
		//Scanner sc = new Scanner(System.in);
		//String name = sc.nextLine(); ==> console 에서 문자열데이터 입력받을수 있음.
		
//	[1단계:확인]10. Scanner 객체를 통해서 국어, 영어, 수학 점수를 숫자로 입력받아 합산과 평균을 출력하세요.
		
		// 선생님 답
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수");
		int kor01 = sc.nextInt();
		System.out.println("영어 점수");
		int eng01 = sc.nextInt();
		System.out.println("수학 점수");
		int math01 = sc.nextInt();
		int tot05 = kor01+eng01+math01;
		double avg1 = tot05/3.0;//소숫점이하의 평균이 필요한 경우,
		int avg2=tot05/3;
		System.out.printf("국어 : %d\n",kor01); // %d : 정수형 데이터 표시
		System.out.printf("영어 : %d\n",eng01);
		System.out.printf("수학 : %d\n",math01);
		System.out.printf("총점 : %d\n",tot05);
		System.out.printf("평균 : %2f\n",avg1);// %.소숫점이하자리수f : 실수형데이터

	}

}
