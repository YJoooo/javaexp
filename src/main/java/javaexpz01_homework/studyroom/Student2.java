package javaexpz01_homework.studyroom;

public class Student2 {
	void studentInfo() {
		Student1 s01 = new Student1();
//		System.out.println(s01.rank); // 같은 클래스 내에서만 접근 가능으로 오류
		System.out.println(s01.ban); // 같은 패키지 내에서만 접근가능 => Friend1,Friend2 에서는 접근 불가능
		System.out.println(s01.grade); // 모두 접근 가능
	}

}
