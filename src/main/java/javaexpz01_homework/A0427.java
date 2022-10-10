package javaexpz01_homework;

public class A0427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		[1단계:개념] 1. 증감연산식의 앞에 ++, 뒤에 ++의 차이점을 예제를 통하여 기술하세요.
		int age = 2;
		System.out.println(age++); //뒤에 ++는 출력후 증가
		System.out.println(age++);
		System.out.println(age++);
		System.out.println(age++);
		System.out.println(age+++"\n");
		System.out.println(age);
		System.out.println(++age); // 앞에 ++는 증가 후 출력
		System.out.println(++age);
		System.out.println(++age);
		System.out.println(++age);

//		[1단계:코드] 2. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
//		      1~3, 1~5까지의 총비용을 출력하세요.
		int jjajang = 5000;
		int jjam = 6000;
		int jjajangCnt = 0;
		int jjamCnt = 0;
		System.out.println((++jjajangCnt)+"그릇"+(jjajang*jjajangCnt));
		System.out.println((++jjajangCnt)+"그릇"+(jjajang*jjajangCnt));
		System.out.println((++jjajangCnt)+"그릇"+(jjajang*jjajangCnt));
		System.out.println((++jjamCnt)+"그릇"+(jjam*jjamCnt));
		System.out.println((++jjamCnt)+"그릇"+(jjam*jjamCnt));
		System.out.println((++jjamCnt)+"그릇"+(jjam*jjamCnt));
		System.out.println((++jjamCnt)+"그릇"+(jjam*jjamCnt));
		System.out.println((++jjamCnt)+"그릇"+(jjam*jjamCnt));
		
		//답
		int jjajang1 = 5000;
		int buyCnt = 0;
		System.out.println(++buyCnt+"개의 짜장면 가격:"+jjajang1*buyCnt);
		System.out.println(++buyCnt+"개의 짜장면 가격:"+jjajang1*buyCnt);
		System.out.println(++buyCnt+"개의 짜장면 가격:"+jjajang1*buyCnt);
		int jjambong = 6000;
		buyCnt = 0;
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		System.out.println(++buyCnt+"개의 짬뽕의 가격:"+jjambong*buyCnt);
		
//		[1단계:개념] 3. 비교연산식의 종류를 기술하고, 기본예제를 만들어 해당 내용에 대한 개념을 설명하세요.
		//비교연산자 종류 : 동일한지(==), 같지 않은지(!=), 큰지(>), 작은지(<)
		int num01 = 25;
		int num02 = 5;
		System.out.println((num01==num02)); // num01 과 num02가 같은지
		System.out.println((num01!=num02)); // num01 과 num02가 같지않은지
		System.out.println((num01>num02)); // num01 이 num02 보다 큰지
		System.out.println((num01<num02)); // num01 이 num02 보다 작은지
		System.out.println((num01>=num02)); // num01 이 num02 보다 크거나 같은지
		System.out.println((num01<=num02)); // num01 이 num02 보다 작거나 같은지
		
		
//		[1단계:코드] 4. 아래와 같이 비교 연산식을 이용하여 boolean(true/false) 처리하세요
//		      1) 점수를 지정하여 A학점(90이상 경우) 여부를 출력하세요
		int score01 = 50;
		boolean alpa = score01>=90;
		System.out.println("A학점 여부 : "+alpa);
//		      2) 설문지(1~4지선택)에서 3번항목을 선택하지 않은 경우를 출력
		int choose = 1;
		boolean answer = choose==3;
		System.out.println("3번 선택여부 : "+answer);
		
		//답
		int chNum = 2;
		System.out.println("선택항 번호:"+chNum);
		System.out.println("3번항목을 선택하지 않았는지 여부:"+(chNum!=3));
		
//		      3) 점수를 지정하여 60점 미만인 경우 과락이면, 과락여부를 출력
		boolean result = score01<60;
		System.out.println("과락여부 : "+result);
		
//		[1단계:개념] 5. 비교연산식와 논리연산식의 차이점을 기술하세요.
		// 비교연산자는 두개의 피연산자를 비교하는것이고,
		// 논리연산자는 비교연산자나 boolean의 값을 비교하는것이다.
		
//		[1단계:개념] 6. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
		// 단항연산자 : int people = 1; -> =이나, ++ 같은 하나의 항으로 이루어진 연산자
		// 이항연산자 : int party = 5*2 -> 2개의 항으로 연산하는 연산자
		// 삼항산자 : (people>=2) ? "성공" : "실패" -> 3개의 피연산자로 연산
		
//		[2단계:코드] 7. 삼항연산자를 이용하여 놀이공원에 입장료가 50000원 일 때, 나이가 6미만이거나 65세 이상일 때는 무료,
//		               10~20일 때는 청소년 요금으로 20%할인이 된다. 나이에 따라 무료여부와, 청소년요금제 여부를
//		          처리하고, 총비용을 출력하세요
		int fee = 50000;
		int age01 = 15;
		String agefee = (age01<6 || age01>=65) ? "무료":"정상요금";
		System.out.println(agefee);
		double disTeen = (age01<=20 && age01>=10) ? 0.2:0;
		int resultPay = fee-(int)(fee*disTeen);
		System.out.println("할인율:"+(int)(disTeen*100)+"%");
		System.out.println("총비용:"+resultPay);
		
		//답
		int pay = 50000;
		int age02 = 3;
		System.out.println("나이는 "+age02);
		String ckFree = (age<6 || age>=65)?"무료":"유료";
		String ckAdult = (age>=10 && age<=20)?"청소년오금제":"기타요금제";
		System.out.println("무료여부: "+ckFree);
		System.out.println("요금제:"+ckAdult);
		double disRatio = (age<6 || age>=65)?1.0:((age>=10 && age<=20)?0.2:0);
		//조건1?true:false
		//조건1?조건1일경우처리?조건2:조건이인경우처리:그외경우
		System.out.println("할인율:"+(int)(disRatio*100)+"%");
		int lastTot = pay-(int)(pay*disRatio);
		System.out.println("최종 금액:"+lastTot);
		
//		[1단계:개념] 8. main()에서 데이터의 기본 흐름 방향을 기술하고, 조건문이 처리되는 형식에 따른
//		      플로우를 설명하세요.
		// main()메소드의 시작인 중괄호({})는 위에서 아래로, 왼쪽에서 오른쪽으로 실행을 한다.
		// if (비교연산자,논리연산식) 이 true면, {}안의 결과를 도출
		
//		[1단계:코드] 9. 조건문활용하여 1~10까지 출력하되 3/6/9게임과 같이, 
//		      해당 번호에서는 짝이라고 문자열을 출력하게 하세요.
		int game = 0;
		System.out.println(++game);
		System.out.println(++game);
		if(game==3) {
			System.out.println("짝");
		}
		System.out.println(++game);
		System.out.println(++game);
		System.out.println(++game);
		if(game==6) {
			System.out.println("짝");
		}
		System.out.println(++game);
		System.out.println(++game);
		System.out.println(++game);
		if(game==9) {
			System.out.println("짝");
		}
		System.out.println(++game);
		System.out.println(++game);
		
		//답
		int cnt = 0;
		System.out.println("#3,6,9 게임#");
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		System.out.println(++cnt%3==0?"짝":cnt);
		
		
//		[1단계:코드] 10. if else문을 이용하여 점수에 따른 등급 A~F를 출력 처리하세요.
		int score = 30;
		if(score>=90) {
			System.out.println("A등급 입니다.");
		}else if(score>=80) {
			System.out.println("B등급 입니다.");
		}else if(score>=70) {
			System.out.println("C등급 입니다.");
		}else if(score>=60) {
			System.out.println("D등급 입니다.");
		}else {
			System.out.println("F등급 입니다.");
		}
		
		
		
//		[1단계:코드] 11. switch case문을 활용하여 월별 날짜수를 출력하고 월이 아닌 범위는 월이 아니라고 출력하세요.
		int month = 6;
		System.out.println((month+"월은 "));
		switch(month) {
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				System.out.println("31일 까지 입니다.");
				break;
			case 2 :
				System.out.println("28일 까지 입니다.");
				break;
			case 4 :	
			case 6 :	
			case 9 :
			case 11 :
				System.out.println("30일 까지 입니다.");
				break;
			default	:
				System.out.println("월이 아닙니다.");
		}
		
		
		
		
		
		
		
		

	}

}
