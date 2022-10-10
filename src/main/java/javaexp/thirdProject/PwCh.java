package javaexp.thirdProject;

public class PwCh {
	
	public boolean pattern2(String userPassword) {
		  int o = 0;
		  int d = 0;
		  int p = 0;
		  int n = 0;  
		  int limit = 3;
		  
		  for(int i=0; i<userPassword.length(); i++) {
		   char tempVal = userPassword.charAt(i);
		   if(i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 :0) > limit -3) {
		    return false;
		   }
		   d = p;
		   o = tempVal;
		  }
		  return true;
		 }
}
