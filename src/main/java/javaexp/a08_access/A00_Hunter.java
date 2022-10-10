package javaexp.a08_access;

//import javaexp.a08_access.a01_friendship.Deer;
import javaexp.a08_access.a01_friendship.WoodCutter;
// public 이라도 외부 패키지에 있는 클래스는 import 또는 패키명.클래스명으로 사용 하능하다.

public class A00_Hunter {
		void callWoodCutterInfo() {
			// WoodCutter wc : public class WoodCutter
			// wc = new WoodCutter() : public class WoodCutter(){}
			// wc.hiddenDeer : default 접근제어자로 상단에 선언된 패키지가 같기 때문에 접근이 가능하다.
			// A00_ Hunter 는 package javaexp.a08_access; 때문에 default
			// 접근제어자가 붙은 hiddenDeer 필드는 접근을 할 수 없다.
			WoodCutter wc =null;
			wc= new WoodCutter();
//			System.out.println(wc.hiddenDeer);
		}
		void callDeerInfo() {
			// 사슴의 클래스에 대한 접근도 default가 접근 불가능
			//Deer d = new Deer();
			//System.out.println(d.whereWhen);
		}

	}



