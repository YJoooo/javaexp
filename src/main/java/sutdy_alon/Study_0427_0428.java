package sutdy_alon;

public class Study_0427_0428 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ex) 사칙연산자 처리 연습예제
//		1. 사과와 바나나의 가격을 설정해서 총 비용을 연산자, 피연산자를 통한 연산식을 만들어 결과를 출력하세요.
		int appleprice = 1500;
		int bananaprice = 4500;
		System.out.println(appleprice+"+"+bananaprice+"="+(appleprice+bananaprice));
//		2. 사과의 가격에 구매한 갯수를 처리하여 결과를 출력
		int appleCnt = 5;
		System.out.println("구매한 사과 갯수:"+appleCnt);
//		3. 바나나의 구매 갯수를 설정하고, 사과의 총비용과 바나나의 총 비용의 차이를 구하세요.
		int bananaCnt = 2;
		int appletot = appleCnt*appleprice;
		int bananatot = bananaCnt*bananaprice;
		System.out.println("사과의 총비용 :"+appletot);
		System.out.println("바나나의 총비용 :"+bananatot);
		System.out.println("사과와 바나나의 비용 차이:"+(appletot-bananatot));
//		4. 곰돌이 3마리가 빵 20개를 똑같이 먹고, 남은 나머지 갯수를 위 연산식에 의해 출력하세요.
		int bear = 3;
		int bread = 20;
		int remain = bread%bear;
		System.out.println("남은 빵의 갯수:"+remain);
		
//		ex) 방어율계산(9이닝(회)동안 피실점율) - 1이닝동안 실점 5
//		방어율 = (투수의 자책점 x 9)/이닝
//	
//		1. 투수의 자책점 4점, 경기회수(이닝) 5, 방어율이 얼만지를 프로그램상으로 출력하세요.
//			선언할 변수 - 자책점, 이닝, 방어율
		int loss = 4;
		int inning = 5;
		double defense = (loss*9)/(double)inning;
		System.out.println("방어율:"+defense);
		
//		ex) 변수 cnt01~cnt05에 데이터 5를 한번에 선언과 할당을 하고, 누적증감연산자에 의해서
//		cnt01~cnt05, 2,3,4,5,6,증가 처리 하여 출력하세요.
		int cnt01; int cnt02; int cnt03; int cnt04; int cnt05;
		cnt01=cnt02=cnt03=cnt04=cnt05 = 5;
		System.out.println("2증가"+(cnt01+=2));
		System.out.println("3증가"+(cnt02+=3));
		System.out.println("4증가"+(cnt03+=4));
		System.out.println("5증가"+(cnt04+=5));
		System.out.println("6증가"+(cnt05+=6));
		
//		ex) 구매하는 김밥의 갯수를 선언하고, 1씩 증가하여
//				김밥의 단가(2500)
//				김밥 1개 구매 2500 (산술연산자 활용)
//				김밥 2개 구매 5000
//				김밥 3개 구매 10000
//				김밥 4개 구매 12500
//				김밥 5개 구매 15000
		int kimbap = 0;
		int kimbapPrice = 2500;
		System.out.println("김밥 "+(++kimbap)+"개 "+"구매 "+(kimbap*kimbapPrice));
		System.out.println("김밥 "+(++kimbap)+"개 "+"구매 "+(kimbap*kimbapPrice));
		System.out.println("김밥 "+(++kimbap)+"개 "+"구매 "+(kimbap*kimbapPrice));
		System.out.println("김밥 "+(++kimbap)+"개 "+"구매 "+(kimbap*kimbapPrice));
		System.out.println("김밥 "+(++kimbap)+"개 "+"구매 "+(kimbap*kimbapPrice));
		// for 활용해서 풀이
		for(int cnt = 1;cnt<=5;cnt++) {
			int kimbapTot = kimbapPrice*cnt;
			System.out.println("김밥 "+cnt+"개 "+"구매 "+kimbapTot);
		}
		
//		ex1) 획득 점수를 변수로 선언하고, 합격기준 점수도 변수를 선언하여, 합격 여부를 boolean값으로 아래 형식으로 출력하세요.
//			획득 점수 : 222, 합격 기준 점수 :@@, 합격 여부 : true/false
		int score = 222;
		int passPoint = 200;
		boolean pass = score>=passPoint;
		System.out.print("획득 점수 : "+passPoint+", ");
		System.out.print("합격 기준 점수 : "+score+", ");
		System.out.print("합격 여부 : "+pass);
		System.out.println();
//		ex2) 4지 선다에서 check한 번호 선언, 정답번호 선언 정답여부를 출력
		int check = 4;
		int answer = 1;
		boolean answerCheck = check==answer;
		System.out.println("정답여부 : "+answerCheck);
		
//		ex1) 구매한 물건(사과, 바나나, 딸기)이 모두가 2000원 이상이면 vip고객여부를 true
		int apple = 1200;
		int banana = 4500;
		int berry = 15000;
		boolean result = apple>=2000 && banana>=2000 && berry>=2000;
		System.out.println("vip 고객 여부 : "+result);
//		ex2) 위 구매 물건에서 갯수를 각각 처리하여 총비용이 5000원 이상인 것이 있으면 할인대상 고객여부 true
		int appleCnt01 = 1;
		int bananaCnt01 = 1;
		int berryCnt01 = 2;
		int appleTot01 = apple*appleCnt01;
		int bananaTot01 = banana*bananaCnt01;
		int berryTot01 = berry*berryCnt01;
		boolean totResult = appleTot01>=5000||bananaTot01>=5000||berryTot01>=5000;
		System.out.println("할인대상 고객 여부 : "+totResult);
		
//		ex1) 쇼핑몰에서 구매한 물건의 가격과 갯수를 변수로 설정하여, 총비용이 30000원 이상이면 할인대상고객 그렇지 않으면 일반고객으로
//				표시하세요.
		int coffeePrice = 4200;
		int coffeCnt = 5;
		int totPrice = coffeePrice*coffeCnt;
		String result02 = (totPrice>=30000)?"할인대상고객":"일반고객";
		System.out.println("고객분류:"+result02);
		
//		ex2) 위 문제에서 나이를 check 하여 나이가 20미만이면 20%할인하여 금액을 산정하고, 그렇지 않으면 전체금액을 처리할때, 최종 금액을
//				출력하세요.
		int age = 15;
		double result03 = (age<20)?totPrice*0.8:totPrice;
		System.out.println("최종금액 : "+result03);
	}

}
