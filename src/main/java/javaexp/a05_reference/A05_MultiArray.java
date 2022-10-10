package javaexp.a05_reference;

public class A05_MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다차원 배열
		1. 2차원 배열 이상의 배열
		2. 자바는 1차원 배열을 이용하여 2차원 이상의 배열을 구현할 수 있다.
			int[][] 배열명 = new int[크기1][크기2];
		ex) 다차원 배열을 이해하기 위한 비유
			기차 : 1호차, 2호차 ... 5호차
				1호차 안에 좌석 1~80번
				1호차 안에 30번 좌석에 좌석/예약
			학년 반 번 : 3차원
				int[][][] students = new int[3][5][30];	
				students[0][0][20] = 80;
					students라는 배열에 최상위 항목의 1번째 데이터 안에
						차상위 항목 1번째 데이터 안에
						하위 항목에 21번째 데이터에 30번을 할당.
		 */
		int[][] multiArry = new int[3][2];
		// cf) 기차로 비유하면 3개의 호차가 있고, 각 호차 안에 좌석 2개가 있는 경우.
		System.out.println("상위 차원의 크기:"+multiArry.length);
		System.out.println("하위 차원의 크기:"+multiArry[0].length);
		
		// 배열명[바깥쪽상위데이터index][안쪽데이터index]
		
		multiArry[0][0]=25;
		multiArry[0][1]=55;
		multiArry[1][0]=35;
		multiArry[1][1]=45;
		multiArry[2][0]=65;
		multiArry[2][1]=75;
		for(int idx=0;idx<multiArry.length;idx++) {
			for(int jdx=0;jdx<multiArry[idx].length;jdx++) {
				System.out.println("multiArry["+idx+"]["+jdx+"]:"+multiArry[idx][jdx]);
			}
		}
		// ex) 2차원 배열로 번호별로 국어/영어/수학점수를 할당했을때.
		//		3명의 국어/영어/수학 출력하세요.
		// 3명의 학생의 국어/영어/수학점수
		// 선생님 답
		int[][]records1 = {
				{80,90,90}, //한명당 데이터 국어,영어,수학 점수 할당. (첫번째 학생의 점수)
				{70,80,90}, // 두번째 학생의 국어, 영어, 수학 점수
				{70,70,80}, // 세번째 학생의 국어, 영어, 수학 점수
		};
		System.out.println("1차원(밖에있는 데이터 크기):"+records1.length);
		System.out.println("2차원(안쪽에있는 데이터 크기):"+records1[0].length);
		System.out.println("첫번쨰의 첫번째데이터:"+records1[0][0]); // 첫번째 학생의 국어점수를 호출
		System.out.println("세번쨰의 두번째데이터:"+records1[2][1]); // [2]:세번째 학생의 [1]:영어점수를 호출
		for(int idx=0;idx<records1.length;idx++) { // 학생 단위로 반복문 loop
			System.out.println(idx+1+"번째의 학생의 성적");
			for(int jdx=0;jdx<records1[idx].length;jdx++){ // 과목 단위로 반복문 loop
				System.out.println("  "+(jdx+1)+"번쨰 과목 점수:"+records1[idx][jdx]);
			}
		}
		
		int[][]recores2 = new int[3][3];
		recores2[0][0] = 80;
		recores2[0][1] = 90;
		recores2[0][2] = 90;

		recores2[1][0] = 70;
		recores2[1][1] = 80;
		recores2[1][2] = 90;

		recores2[2][0] = 70;
		recores2[2][1] = 70;
		recores2[2][2] = 80;
	}

}
