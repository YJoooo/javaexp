package javaexpz01_homework.studyroom;

import javaexpz01_homework.playroom.Friend1;

public class Student1 {
	private int rank = 1;
	int ban = 6;
	public int grade = 2;
		
	void callFriendInfo() {
		Friend1 f01 = new Friend1();
//		System.out.println(f01.num); // private 자기클래스 내에서만 접근가능
//		System.out.println(f01.age); // default 같은 패키지 내에서만 접근가능
		System.out.println(f01.name); // public 모두 접근가능

	}


}
