package javaexp.a03_calcu;

public class A06_Calcu_Logical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 논리연산자
		1. 비교연산자나 boolean(true/false)값이 나오면 그것에 의해서 and(논리합),or(논리곱)에 의해 결과를 혼합해서 처리할때
		필요한 연산자를 말한다.
		2. 형식
			비교 연산자1 && 비교연산자2
				두개의 비교연산식이 모두 다 true일 때, true로 처리 되는것을 말한다.
				ex) 국어점수와 영어점수가 모두 80점 이상일 때, 합격인 경우를 처리할 때 활용된다.
				kor>=80 && eng>=80
			비교연산자1 || 비교연산자2
				두개의 비교연산식 중 하나만 true일 때, true이고, 모두 다 false일 때는 false일 경우에 필요한 논리 연산자이다.
				ex) 국어, 영어, 수학 점수가 하나라도 80점 이상이면 합격인 경우를 처리할 때, 활용된다.
				kor>=80 || eng>=80 || math>=80
				cf) &, &&
					|, ||
					한개와 두개의 차이는 두개가 있으면 논리식이 합당치 않으면 두번째 비교연산식에 처리를 방지해준다.
					비교연산식1 && 비교연산식2 의 경우, 비교연산식1이 false이면 비교연산식 2로 프로세스를 처리하는 것을 방지한다. 
					비교연산식1 || 비교연산식2 의 경우, 비교연산식 1이 true이면 비교연산식 2로 프로세스를 처리하는 것을 방지한다.
		 */
		int kor =80;
		int eng =70;
		int math =90;
		System.out.println("모두가 80이상일 때 합격:");
		System.out.println(kor>=80 && eng>=80 && math>=80);
		System.out.println("하나라도 80이상이면 합격:");
		System.out.println(kor>=80 || eng>=80 || math>=80);
		
		// ex1) 구매한 물건(사과, 바나나, 딸기)이 모두가 2000원 이상이면 vip고객여부를 true
		int apple = 1200;
		int banana = 4500;
		int berry = 10000;
		boolean isVip = apple>=2000 && banana>=2000 && berry>=2000;
		System.out.println("구매한 물건 모두가 2000원 이상이면 vip 고객:");
		System.out.println(apple>=2000 && banana>=2000 && berry>=2000);
		System.out.println("VIP고객 여부 : "+isVip);
		
		// ex2) 위 구매 물건에서 갯수를 각각 처리하여 총비용이 5000원 이상인 것이 있으면 할인대상 고객여부 true
		int appleCnt = 2;
		int bananaCnt = 1;
		int berryCnt = 1;
		int appletot = apple*appleCnt;
		int bananatot = banana*bananaCnt;
		int berrytot = berry*berryCnt;
		boolean isDis = appletot>=5000 || bananatot>=5000 ||berrytot>=5000;
		System.out.println("구매한 물건 각각의 비용에 5000원 이상인 것이 있으면 할인대상:");
		System.out.println(appletot>=5000 || bananatot>=5000 ||berrytot>=5000);
		System.out.println("할인대상 고객여부 : "+isDis);
		/*
			논리 부정 연산자 : !
				논리결과값이 true ==> false, false ==> true로 처리하는 논리 연산자이다.
				
		 */
		System.out.println("할인대상 고객이 아닌지 여부:"+!isDis);
		
		

	}

}
