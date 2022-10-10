package javaexp.a03_calcu;

public class A05_Calcu_equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 비교연산자
		1. 두개의 피연산자의 값을 비교하여 동일한지(==), 같지 않은지(!=), 큰지(>), 작은지(<)를 boolean 값은 true/false값으로 
		결과를 처리하는 연산자를 말한다.
		2. 종류
			==, !=, >, <, >=, <=
		3. 활용
			boolean에 할당하거나, 조건식if(비교연산자), while(비교연산자)를 통하여 활용한다.
		 */
		int num01 = 1;
		int num02 = 20;
		System.out.println("#비교 연산 결과#");
		System.out.println(num01+"=="+num02+"="+(num01==num02)); // num01 과 num02가 같은지
		System.out.println(num01+"!="+num02+"="+(num01!=num02)); // num01 과 num02가 같지않은지
		System.out.println(num01+">"+num02+"="+(num01>num02)); // num01 이 num02 보다 큰지
		System.out.println(num01+"<"+num02+"="+(num01<num02)); // num01 이 num02 보다 작은지
		System.out.println(num01+">="+num02+"="+(num01>=num02)); // num01 이 num02 보다 크거나 같은지
		System.out.println(num01+"<="+num02+"="+(num01<=num02)); // num01 이 num02 보다 작거나 같은지
		
		boolean isEqual = num01 == num02;
		System.out.println("같은지 여부 :"+isEqual);
		if(isEqual) {
			System.out.println("동일합니다(조건식1)");
		}else {
				System.out.println("동일합니다(조건식2)");
		}
		while(num01==num02) {
			num02++;
			System.out.println(num01+":"+num02);
		}
		// ex1) 획득 점수를 변수로 선언하고, 합격기준 점수도 변수를 선언하여, 합격 여부를 boolean값으로 아래 형식으로 출력하세요.
		//	   획득 점수 : 222, 합격 기준 점수 :@@, 합격 여부 : true/false
		
		int score = 95;
		int ok = 90;
		System.out.println(score+"<="+ok+"="+(score>=ok));
		System.out.println("합격여부 : "+(score>=ok));
		//답
		int point = 80;
		int passPoint = 70;
		boolean isPass = point>=passPoint;
		System.out.println("획득 점수 : "+point+",");
		System.out.println("합격 기준 점수 : "+passPoint+",");
		System.out.println("획득 점수 : "+isPass+"\n");
		
		// ex2) 4지 선다에서 check한 번호 선언, 정답번호 선언 정답여부를 출력
		int check = 4;
		int answer = 1;
		System.out.println("정답여부 "+(check==answer));
		
		//답
		int ckNum = 2;
		int corNum = 3;
		boolean isCorrect = ckNum==corNum;
		System.out.println("체크한 번호 : "+ckNum+",");
		System.out.println("정답 번호 : "+corNum+",");
		System.out.println("정답 여부 : "+isCorrect+"\n");
	}

}
