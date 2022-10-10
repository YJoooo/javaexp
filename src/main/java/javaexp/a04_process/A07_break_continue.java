package javaexp.a04_process;

public class A07_break_continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 반복문에서 조건과 함께하는 break와 continue문
		1. 반복문 안에서 특정 조건일 때, break를 처리하면 반복문의 범위와 상관없이 중단이 된다. 
			(for문, while문, do while문 다 활용된다.)
		
		 */
		for(int cnt=1;cnt<100;cnt++) {
			if(cnt==20) break;
			System.out.println(cnt);
		}
		/*
		2. 반복문 안에서 특정 조건일 때, continue를 쓰면 해당 반복 step을 pass by(넘어가고) 처리되고, 그 다음 반복을 수행하게된다.
		 */
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt==5) continue;
			System.out.println(cnt+"단");
		}
		// ex1) 구구단의 단수를 전역변수로 선언하여 해당 단수의 1~9까지 곱한 값을 처리하되
		//		X7 일때, 프로세스가 중단되게 처리하세요.
		int dan=3;
		for(int cnt=1;cnt<=9;cnt++) {
			if(cnt==7) break;
			System.out.println(dan+"*"+cnt+"="+(dan*cnt));	
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
		
		int internet=32000;
		System.out.println("월\t"+"요금\t"+"누적요금\t");
		for (int cnt=1;cnt<=12;cnt++) {
			if(cnt==5) continue;
			System.out.println(cnt+"월\t"+internet+"\t"+(internet*cnt));
		}
		//선생님 답
		int tot = 0;
		int pay = 32000;
		System.out.println("월\t요금\t누적요금\t");
		for(int mon=1;mon<=12;mon++) {
			if(mon==5) continue;
			tot+=pay;
			System.out.print(mon+"\t");
			System.out.print(pay+"\t");
			System.out.print(tot+"\n");
			
		}
		
		
		
	}

}
