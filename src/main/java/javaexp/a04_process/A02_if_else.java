package javaexp.a04_process;

public class A02_if_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 분기 조건문 처리
		1. 기본 형식
			if(조건식){
				조건식이 true일 떄,
			}else{
				조건식이 false일 때.
			}
		2. 여러가지 분기 조건
		
			if(조건1){
			
			}else if(조건2){ // else 앞선 조건1을 제외하고를 포함
			
			}else if(조건3){
			
			}else if(조건4){
			
			}else{ // 나열된 조건식 이외 일 때,
			
			}
			ex)
			if(point>=99){
				A학점 처리
			}else if(point<90 && point>=80){
					문제점은 point<90 &&는 else를 통해서 상위에 선언된 조건을 제외하고 라는 것을 포함하고 있기에 필요없다.
			
			}else if(point>=70){
			
			}..
			..
			}else{ //위에 기술한 조건 이외일 때, 처리할 내용
			
			}
			
			
			if(point>=90){
			
			}
			if(point<90 && point>=80){
			
			}
		
		 */
		/*
		# java에서 문자열의 비교 처리
		1. 문자열1==문자열2 로 비교하면 예외가 발생한다.
		2. 문자열1.equals(문자열2)
		 */
		String name01 = "홍길동";
		String name02 = "홍길동";
		String name03 = "신길동";
		System.out.println("문자열 비교:"+name01.equals(name02));
		System.out.println("문자열 비교:"+name01.equals(name03));
		
		String inputId = "himan";
		String inputPwd = "9999";
		if(inputId.equals("himan") && inputPwd.equals("9999")) {
			System.out.println(inputId+"님 로그인 성공입니다!!!");
		}else {
			System.out.println("로그인 실패입니다!!");	
		}
		// ex) age를 임의로 숫자로 할당하고, 10~20까지일 때는 청소년 요금제입니다.
		//		그 외는 청소년 요금제가 아닙니다. 출력하게 하세요.
		int age = 27;
		if(age>=10 && age<=20) {
			System.out.println("청소년 요금제입니다.");
		}else { //age<10 || age>20
			System.out.println("청소년 요금제가 아닙니다.");
		}
		// 구매비용을 기준으로 MVP, VIP, 보통고객
		int buyPrice = 5200;
		int buyCnt = 15;
		int tot = buyPrice*buyCnt;
		System.out.println("구매비용이"+tot+"원 이므로,");
		if(tot>=100000) {
			System.out.println("MVP 고객입니다.");
		}else if(tot>=50000){
			System.out.println("VIP 고객입니다.");
		}else {
			System.out.println("보통 고객입니다.");
		}
		// ex) 타율 : 안타수/타석 입력 받아서
		//		0.350 이상은 최고타자
		//		0.3~0.35미만 우수타자
		//		0.25~03 일반타자
		//		0.25미만 2군 준비 타자
		
		int antaNum = 4;
		int hitset = 10;
		double hitRatio = antaNum/(double)hitset;
		System.out.println("타율:"+hitRatio);
		if(hitRatio>=0.350) {
			System.out.println("최고타자");
		}else if(hitRatio>=0.3) {
			System.out.println("우수타자");	
		}else if(hitRatio>=0.25) {
			System.out.println("일반타자");	
		}else {
			System.out.println("2군 준비 타자");
		}
		
		// # 중첩 조건문 : 조건문 안에 조건문이 계층적으로 처리될 때 활용된다.
		boolean isMale = true;
		int caAge = 18;
		if(isMale) {
			if(caAge>=20) {
				System.out.println("신사!!");
			}else {
				System.out.println("소년!!");
			}
		}else {
			if(caAge>=20) {
				System.out.println("숙녀!!");
			}else {
				System.out.println("소녀!!");
			}
		}
		
		
		
		
		
		
		
		

	}

}
