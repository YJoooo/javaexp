package javaexpz01_homework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project_homwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 작성 일자
		SimpleDateFormat df = new SimpleDateFormat("yyyy. MM. dd");
		Date now = new Date();
		System.out.println(df.format(now));
		// 리뷰 작성 받기
		Scanner review = new Scanner(System.in);
		System.out.println("기업명");
		String company = review.nextLine();
		System.out.println(company);
		System.out.println("기업한줄평");
		String evaluation = review.nextLine();
		System.out.println("기업의 장점");
		String merit = review.nextLine();
		System.out.println("기업의 단점");
		String demerit = review.nextLine();
		System.out.println("경영진에게 바라는점");
		String wish = review.nextLine();
		System.out.println("못다한 이야기");
		String s = review.nextLine();
		// 최소 입력 글자수, 필수 입력사항 
		if (evaluation.length()>=20) {
			if(merit.length()>=30) {
				if(demerit.length()>=30) {
					if(wish.length()>=20) {
						System.out.println("다음으로 넘어가기");
					}else if(wish.length()>0){
						System.out.println("경영진에게 바라는점 20자 이상으로 입력해주세요");
					}else {
						System.out.println("필수 입력정보입니다.");
					}
				}else if(demerit.length()>0){
					System.out.println("기업의 단점 30자 이상으로 입력해주세요");
				}else {
					System.out.println("필수 입력정보입니다.");
				}
			}else if(merit.length()>0){
				System.out.println("기업의 장점 30자 이상으로 입력해주세요");
			}else {
				System.out.println("필수 입력정보입니다.");
			}
		}else if(evaluation.length()>0){
			System.out.println("기업한줄평 20자 이상으로 입력해주세요");
		}else {
			System.out.println("필수 입력정보입니다.");
		}
		// 선택형 답변 구현
		String []arry = {"현 직장/전 직장",
						"전직장 - 2022년 퇴사",
						"전직장 2021년 퇴사",
						"전직장 2020년 퇴사",
						"전직장 2019년 퇴사",
						"전직장 2018년 퇴사",
						"전직장 2017년 퇴사",
						"전직장 2016년 퇴사",
						"전직장 2015년 퇴사",
						"전직장 2014년 퇴사",
						"전직장 2013년 퇴사",
						"전직장 2012년 퇴사",
						};
		for(int idx = 0; idx<=11; idx++) {
			System.out.println(arry[idx]);
		}
		System.out.println("해당되는것을 선택하세요");
		String situation = review.nextLine();
		System.out.println(arry[Integer.parseInt(situation)]);
		
		// 활동내역 리뷰 작성 목록
		System.out.println("기업명\t\t"+"고용상태\t\t"+"작성일\t\t"+"등록여부\t"+"수정/삭제");
		System.out.println
		(company+"\t"+arry[Integer.parseInt(situation)]+"\t"+df.format(now)+"\t등록 대기"+"\t수정/삭제");
	}

}
