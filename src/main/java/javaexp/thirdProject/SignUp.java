package javaexp.thirdProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("# 회원가입 #");
		String userEmail;
		while(true) {
			System.out.println("이메일");
			userEmail = sc.next();
			// 정규 표현식 활용하여 유효성 검사 
			//(알파벳 또는 문자@알파벳 또는 문자.알파벳 또는 문자(.알파또는 문자 한번 더 반복가능))
			boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", userEmail);
			System.out.println(email_check);
			if(email_check){
				break;
			}else {
				System.out.println("이메일 형식이 올바르지 않습니다.");
			}
		}
		
		String userPassword;
		PwCh PWcheak = new PwCh();
	
		// 비밀번호 형식 검사
		while(true) {
			System.out.println("비밀번호");
			userPassword = sc.next();
			// 문자,숫자,특수문자 조합으로 12자이상 32자 이하
			String regExp_pattern1 = 
				"^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{12,32}$";
			Pattern pattern_pattern1 = Pattern.compile(regExp_pattern1);
			Matcher matcher_pattern1 = pattern_pattern1.matcher(userPassword);
			if(matcher_pattern1.find()) {
				// 연속된 숫자 3자 불가능
				if(PWcheak.pattern2(userPassword)) {
					System.out.println("비밀번호 확인");
					String userPasswordCheck = sc.next();
					if(userPasswordCheck.equals(userPassword)) {
						System.out.println("회원가입 완료!");
							break;
					}else {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}
				}
			}
		}
			
	    // 이메일, 비밀번호 저장
	    Member member = new Member(userEmail, userPassword);
	    
	    System.out.println(member.getUserEmail());
	    System.out.println(member.getUserPassword());
	    
	    
	    //로그인
	    String email;
	    String password;
	    while(true) {
	    	System.out.println("이메일");
	    	email = sc.next();
	    	System.out.println("비밀번호");
	    	password = sc.next();
	    	Login lo = new Login(email,password,member);
	    	if(lo.loginCk()) {
	    		System.out.println("로그인 성공");
	    		break;
	    	}else {
	    		System.out.println("이메일 또는 비밀번호를 확인하세요.");
	    	
	    	}
	    }
	    
	    
	    
	      
	    // 비밀번호 찾기
		String femail;
		while(true) {
			System.out.println("이메일");
			femail = sc.next();
			// 정규 표현식 활용하여 유효성 검사 
			//(알파벳 또는 문자@알파벳 또는 문자.알파벳 또는 문자(.알파또는 문자 한번 더 반복가능))
			boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", femail);
			System.out.println(email_check);
			if(email_check){
				System.out.println(femail+"\n 위 주소로 비밀번호 설정 메일이 전송되었습니다.\n 메일을 확인해주세요.");
				break;
			}else {
				System.out.println("이메일 형식이 올바르지 않습니다.");
			}
		}
	
		// 비밀번호 변경
		String changePW;
		while(true) {
			System.out.println("변경할 비밀번호로 정확히 입력해주세요");
			changePW = sc.next();
			// 문자,숫자,특수문자 조합으로 12자이상 32자 이하
			String regExp_pattern1 = 
				"^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{12,32}$";
			Pattern pattern_pattern1 = Pattern.compile(regExp_pattern1);
			Matcher matcher_pattern1 = pattern_pattern1.matcher(changePW);
			if(matcher_pattern1.find()) {
				// 연속된 숫자 3자 불가능
				if(PWcheak.pattern2(changePW)) {
					System.out.println("비밀번호 확인");
					String changePWCheck = sc.next();
					if(changePWCheck.equals(changePW)) {
						System.out.println("비밀번호 변경 완료");
						changePW = userPassword;
							break;
					}else {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}
				}
			}
		}
	}
}
