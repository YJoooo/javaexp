package javaexp.a03_calcu;

public class A07_Calcu_Triple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 삼항연산자
		1. 세 개의 피연산자를 필요로 하는 연산자
		2. 앞의 조건식 결과에 따라 클론 앞 뒤의 피연산자 선택 ==> 조건연산기
		3. 형식
			(비교연산자, 논리연산자) ? true일때 : false일때
			
			cf) 다중의 조건을 처리할 때, 위의 false일때에 다시 3항연산식을 사용한다.
			if else if else if....
			조건1?결과1:(조건2?결과2:그외결과)
		 */
		
		int point = 80;
		String result = (point>=70)?"합격":"불합격";
		System.out.println("점수:"+point);
		System.out.println("결과:"+result);
		// ex1) 쇼핑몰에서 구매한 물건의 가격과 갯수를 변수로 설정하여, 총비용이 30000원 이상이면 할인대상고객 그렇지 않으면 일반고객으로
		//		표시하세요.
		int price = 8000;
		int cnt = 6;
		int totPrice = price*cnt; // 총비용
		String chkCustom = (totPrice>=30000)?"할인대상고객":"일반고객";
		System.out.println("총비용 :"+totPrice);
		System.out.println("고객분류 :"+chkCustom);
		
		//ex2) 위 문제에서 나이를 check 하여 나이가 20미만이면 20%할인하여 금액을 산정하고, 그렇지 않으면 전체금액을 처리할때, 최종 금액을
		//		출력하세요.
		//		hint) double discount (할인율은 20% ==> 0.2(실수)) 최종금액 = 기본금액 - (기본금액+*할인율)
		int age = 18;
		double disPer = (age<20)? (totPrice*0.8):totPrice;
		System.out.println("최종 금액 : "+disPer);
		//힌트기반 답변
		double disPer1 = (age<20)? totPrice-(totPrice*0.2):totPrice;
		System.out.println("최종 금액 : "+disPer1);
		
		//선생님 답
		int age1 = 18;
		double discount = age1<20?0.2:0.0; // 할인율이 0%, 20% 경우를 구분
		int resultPay = totPrice-(int)(totPrice*discount);
		System.out.println("할인율:"+(int)(discount*100)+"%");
		System.out.println("최종금액:"+resultPay);

	}

}
