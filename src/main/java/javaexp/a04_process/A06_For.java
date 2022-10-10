package javaexp.a04_process;

public class A06_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 반복문에 조건문 사용
		1. 여러가지 조건 사용형식
			1) 비교연산(==,!=,>=,<=,>,<), 논리식(!,&&,||), equals()
			2) 연산자 +, -, *, /, %
			 	ex) 짝수인 경우 if(cnt%2==0)
			 		n	1	2	3	4	5	6	7	8	9	
			 		n%3 1	2	0	1	2	0	1	2	0
		2. 조건문 사용시 처리하는 중단 형식
			1) break;
			2) continue;
		 */
		// 반복문과 연산식의 사용
		// ex) 1~100까지 숫자 중에 10~20까지만 출력을 제외하고 출력 처리하세요.
		for(int cnt=1;cnt<=100;cnt++) { // cnt<10 || cnt>20
			if(!(cnt>=10 && cnt<=20)) {
				System.out.print(cnt+",");
			}
		}
		System.out.println();
		// ex) 1~20의 숫자 중에 짝수만 출력하세요. 합산은 1~20까지 처리하세요.
		int tot = 0;
		for(int cnt=1;cnt<=20;cnt++) {
			tot+=cnt;
			if(cnt%2==0) {
				System.out.print(cnt+" ");
			}
		}
		System.out.println("\n1~20까지 합:"+tot);
		// 100~90까지 합산을 아래의 형식으로 하고 최종적으로 결과를 처리하세요.
		// 100 + 99 + .... 90 = @@(합산결과)
		tot = 0;
		for(int cnt=100;cnt>=90;cnt--) {
			System.out.print(cnt);
			if(cnt!=90) {
				System.out.print(" + ");
			}else {
				System.out.print(" = ");
			}
			tot+=cnt;
		}
		System.out.println(tot);
		
		// ex1) 100에서 90까지 아래의 형식으로 처리하여 뺀 최종 결과값을 출력하세요.
		//		100 - 99 - 98 .... 90 = @@@
		int miner=100;
		System.out.print(miner+" - ");
		for(int cnt=100;cnt>=90;cnt--) {
			miner-=cnt;
			System.out.print(cnt);
			if(cnt!=90) {
				System.out.print(" - ");
			}else {
				System.out.print(" = ");
			}
		}
		System.out.println(miner);
		// ex2) 1~100까지 출력하되 조건문을 이용하여 5단위로 줄바꿈 출력 하세요.
		//		1	2	3	4	5	
		//		6	7	8	9	10	
		//		...
		//		96	97	98	99	100
		for(int cnt=1;cnt<=100;cnt++) {
			if(!(cnt%5==1)) {
				System.out.print(cnt+"\t");
			}else {
				System.out.print("\n"+cnt+"\t");
			}
		}
		System.out.println();
		// ex3) 1~10까지 해당 수가 홀인지 짝인지 표시 하세요.
		//		1(홀),2(짝),3(홀),4(짝)...10(짝)
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt%2==0) {
				System.out.print(cnt+"(짝)");
			}else {
				System.out.print(cnt+"(홀)");
			}
		}
		System.out.println();
		//선생님 답
		
		for(int cnt=1;cnt<=10;cnt++) {
			System.out.print(cnt);
			char c='홀'; //지역변수로 처리했기에 초기화 처리가 된다.
			if(cnt%2==0) c='짝'; //짝수일 떄만, c변수를 '짝'으로 변경 처리.
			System.out.print("("+c+")");		
		}
		
		
		
		
		
		
		
		
	}	
}
