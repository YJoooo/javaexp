package javaexp.thirdProject;


public class Login {
	String userEmail;
	String userPassword;
	Member m;
	
	public Login(String userEmail, String userPassword,Member m) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.m = m;
	}
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public boolean loginCk(){
		if(m.getUserEmail().equals(userEmail)&&
				m.getUserPassword().equals(userPassword)) {
			return true;
		}else {
			return false;
		}
	}
	

}
