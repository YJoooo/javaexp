package javaexpz01_homework.playroom;

import javaexpz01_homework.playroom.Friend1;

public class Friend2 {
	void callFriendInfo() {
		Friend1 f01 = new Friend1();
//		System.out.println(f01.num); // private 자기클래스 내에서만 접근가능
		System.out.println(f01.age);
		System.out.println(f01.name);

	}

}


