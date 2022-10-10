package sutdy_alon;

import java.util.Scanner;

public class Study_Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ex) 과일의 갯수를 2개씩 증가시켜서 출력하게 변수를 선언하고 출력하고, 
		//		4일떄, 처리할 조건 블럭 설정
		//		10일때, 처리할 바로 옆에 프로세스를 처리
		//		14일때, 바로 밑에 처리할 조건 프로세스를 처리하세요.
		for(int cnt=0;cnt<=14;cnt+=2) {
			if(cnt==4) {
				System.out.println("과일의 갯수 : "+cnt);
			}else if(cnt==10) {
				System.out.println("과일의 갯수 : "+cnt);
			}else if(cnt ==14) {
				System.out.println("과일의 갯수 : "+cnt);
			}else {
				System.out.println("끝");
			}
		}// 원하는 방향과는 다르지만 시도할만 했다
		// ex) age를 임의로 숫자로 할당하고, 10~20까지일 때는 청소년 요금제입니다.
		//		그 외는 청소년 요금제가 아닙니다. 출력하게 하세요.
		int age = 25;
		if(age>=10 && age<=20) {
			System.out.println("청소년 요금제입니다");
		}else {
			System.out.println("청소년 요금제가 아닙니다.");
		}
		// 구매비용을 기준으로 MVP, VIP, 보통고객
		int buyCost = 250000;
		if(buyCost>=500000) {
			System.out.println("MVP고객");
		}else if(buyCost>=25000) {
			System.out.println("VIP고객");
		}else {
			System.out.println("일반고객");
		}
		// ex) 타율 : 안타수/타석 입력 받아서
		//		0.350 이상은 최고타자
		//		0.3~0.35미만 우수타자
		//		0.25~03 일반타자
		//		0.25미만 2군 준비 타자
		int anta = 5;
		double seat = 12.0;
		double hit = anta/seat;
		if(hit>=0.350) {
			System.out.println("최고타자");
		}else if(hit>=0.3) {
			System.out.println("우수타자");
		}else if(hit>=0.25) {
			System.out.println("일반타자");
		}else {
			System.out.println("2군 준비 타자");
		}
		// 삼각형 만들기 이게 아니었따...!!
		for(int cnt=1;cnt<=5;cnt++) {
			if(cnt==1) {
				System.out.println("*");
			}else if(cnt==2) {
				System.out.println("**");
			}else if(cnt==3) {
				System.out.println("***");
			}else if(cnt==4) {
				System.out.println("****");
			}else {
				System.out.println("*****");
			}
		}
		//ex) 주사위 번호를 변수로 선언해서 1,3은 빙고라고 출력,
		//2,4번은 행운의 번호 출력, 5,6번은 gogo!라고 출력, 그외에는 주사위번호가 아닙니다. 라고 출력 처리하세요.
		int diceNum = 1;
		switch(diceNum) {
		case 1: case 3:
			System.out.println("빙고");
		case 2: case 4:
			System.out.println("행운의 번호");
		case 5: case 6:
			System.out.println("gogo!");
			break;
		default:
		System.out.println("주사위 번호가 아닙니다.");
		}
		// ex1) 1~10 출력 내용 중에 짝수만 출력하기
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt%2==0) {
				System.out.println(cnt);
			}
		}
		// ex2) 1~100 출력하되, 5단위로 줄바꿈 처리하기
		for(int cnt=1;cnt<=100;cnt++) {
			if(cnt%5==0) {
				System.out.print(cnt+"\n");
			}else {
				System.out.print(cnt+", ");
			}
		}
		// ex4) 1~20까지 합산을 하되, 마지막에는 =을 표기하기
		//		1+2+3.....+20 = @@@
		int tot = 0;
		for(int cnt = 1;cnt<=20;cnt++) {
			tot+=cnt;
			System.out.print(cnt+"+");
			if(cnt==20) System.out.print(cnt+"="+tot);
		}	
		System.out.println();
		//김밥 한개당 2500원으로 첫번째 날짜는 1개를 판매, 두번째 날짜는 2개를 판매... 10일동안 판매된 김밥을 출력하고
		// 판매액을 프로그램적으로 구하세요.
		int kimbob = 2500;
		int sell = 0;
		for(int cnt = 1;cnt<=10;cnt++) {
			sell+=cnt;
		}
		System.out.println("10일동안 판매된 김밥의 갯수:"+sell);
		System.out.println("10일동안 판매된 김밥의 판매액:"+(sell*kimbob));
		// ex3) 짜장면의 가격이 5000일 때, 1~10 그릇까지 가격을 출력하세요. 
		// @@그릇 @@원
		int jja = 5000;
		for(int cnt=1;cnt<=10;cnt++) {
			System.out.println(cnt+"그릇 "+(cnt*jja)+"원");
		}
				
		// ex) 1~100까지 숫자 중에 10~20까지만 출력을 제외하고 출력 처리하세요.
		for(int cnt=1;cnt<=100;cnt++) {
			if(!(cnt>=10 && cnt<=20)) {
				System.out.println(cnt);
			}
		}
		// 100~90까지 합산을 아래의 형식으로 하고 최종적으로 결과를 처리하세요.
		// 100 + 99 + .... 90 = @@(합산결과)
		int tot01 = 0;
		for(int cnt=100;cnt>=90;cnt--) {
			tot01+=cnt;
			if(cnt==90) {
				System.out.print(cnt+"="+tot01);
			}else {
				System.out.print(cnt+"+");
			}
		}
		System.out.println();
		// ex3) 1~10까지 해당 수가 홀인지 짝인지 표시 하세요.
		//		1(홀),2(짝),3(홀),4(짝)...10(짝)
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt%2==1) {
				System.out.print(cnt+"(홀),");	
			}else if (cnt==10){
				System.out.println(cnt+"(짝)");
			}else {
				System.out.print(cnt+"(짝),");
			}
		}
		// ex1) 구구단의 단수를 전역변수로 선언하여 해당 단수의 1~9까지 곱한 값을 처리하되
		//		X7 일때, 프로세스가 중단되게 처리하세요.
		int dan = 5;
		for(int cnt=1;cnt<=9;cnt++) {
			if(cnt==7) {
				break;
			}
			System.out.println(dan+"X"+cnt+"="+(dan*cnt));
		}
		// ex2) 매월 인터넷 요금이 32000 정도 나온다. 1~12월까지 요금 내용을 출력하되 5월은 출장을 가서 정지를 시켰다.
		// 		아래의 형식으로 출력하세요.
		//		월	요금		누적요금
		//		1월	32000	32000
		//		2월	32000	64000
		//		3월	32000	96000
		//		4월	32000	..
		//		6월	32000	..
		//		..	
		//		12월	32000	...
		int price = 32000;
		int tot02 = 0;
		System.out.println("월\t"+"요금\t"+"누적요금\t");
		for(int cnt=1;cnt<=12;cnt++) {
			if(cnt==5)continue;
			tot02+=price;
			System.out.println(cnt+"월\t"+price+"\t"+tot02);
		}
		// ex) while문을 활용하여 100부터 70까지 2씩 감소시켜 출력하세요.
		int num = 100;
		while(num>=70) {
			System.out.print(num+",");
			num-=2;
		}
		System.out.println();
		//ex1) 구매할 물건의 가격을 입력받고, 종료시 -1을 입력받아 가격을 출력하게 하세요.
		/*Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("구매할 물건의 가격을 입력하고 종료시 -1을 입력하세요");
			int price01 = scn.nextInt();
			if(price01 == -1) {
				System.out.println("입력을 종료하였습니다.");
				break;
			}
			System.out.println(price01);
		}
		*/
		//ex2) 등록할 회원명을 입력받아 아래의 형식으로 출력 종료시 Q
				//		회원번호	회원명
				//		1		홍길동
				//		2		김길동
				//		3		신길동
		/*
		Scanner member = new Scanner(System.in);
		int num02 = 0;
		while(true) {
			System.out.println("회원명을 입력하세요");
			String alpa = member.nextLine();
			num02++;
			if(alpa.equals("Q")) {
				System.out.println("회원등록이 완료되었습니다.");
				break;
			}
			System.out.println("회원번호\t회원명");
			System.out.println(num02+"\t"+alpa);
		}
		*/
		
		Scanner member = new Scanner(System.in);
		int mnum = 0;
		while(true) {
			System.out.println("회원명을 입력하세요. 종료시 Q를 입력하세요.");
			String mname = member.nextLine();
			mnum++;
			if(mname.equals("Q")) {
				System.out.println("회원 등록이 완료되었습니다.");
				break;
			}
			System.out.println("회원번호\t회원명");
			System.out.println(mnum+"\t"+mname);
		}
	}

}
