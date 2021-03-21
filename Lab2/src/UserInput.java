import java.util.Scanner;

/* 1. 사용자 입력을 받는 UserInput class */

public class UserInput {

	static Scanner scan = new Scanner(System.in);									// Scanner 객체 생성
	
	public static double getDouble() {return Double.parseDouble(scan.nextLine());}	// Scanner를 통해 키를 읽게 하여 double로 변환하여 반환해주는 메소드 
	
	public static int getInteger() {return Integer.parseInt(scan.nextLine());}		// Scanner를 통해 키를 읽게 하여 int형으로 변환하여 반환해주는 메소드 
	
	public static int getIntegerBetween(int min, int max) {							// 두 정수를 파라미터로 받아 두 정수 사이의 값만 입력받도록 해주는 메소드

		int result;		
		do {
			System.out.println(min + "과 "+ max +" 사이의 정수를 입력하세요. ");			
			result = getInteger();													// 위에서 정의한 getInteger()메소드를 사용하여 값을 입력받음
			if(result>=min && result<=max) break;									// 입력받은 값이 정의된 두 정수 사이의 값이라면 멈춤
		} while(true);
		
		return result;																// 입력받은 값을 반환하여줌
	}
	
	public static boolean getExitKey() {											// q-key를 누르면 true를 반환하고, enter-key를 누르면 false를 반환해주는 메소드
		System.out.println("<<Press q-key to Exit or enter-key to Continue>>");
		String s = scan.nextLine();													
		if (s.contentEquals("q")) return true;										// contentEquals 함수를 사용하여 함수 내부에 대입한 "q"와 같으면 true를 리턴
		else return false;
	}

}
