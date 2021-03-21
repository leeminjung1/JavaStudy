import java.util.Scanner;

/* 1. ����� �Է��� �޴� UserInput class */

public class UserInput {

	static Scanner scan = new Scanner(System.in);									// Scanner ��ü ����
	
	public static double getDouble() {return Double.parseDouble(scan.nextLine());}	// Scanner�� ���� Ű�� �а� �Ͽ� double�� ��ȯ�Ͽ� ��ȯ���ִ� �޼ҵ� 
	
	public static int getInteger() {return Integer.parseInt(scan.nextLine());}		// Scanner�� ���� Ű�� �а� �Ͽ� int������ ��ȯ�Ͽ� ��ȯ���ִ� �޼ҵ� 
	
	public static int getIntegerBetween(int min, int max) {							// �� ������ �Ķ���ͷ� �޾� �� ���� ������ ���� �Է¹޵��� ���ִ� �޼ҵ�

		int result;		
		do {
			System.out.println(min + "�� "+ max +" ������ ������ �Է��ϼ���. ");			
			result = getInteger();													// ������ ������ getInteger()�޼ҵ带 ����Ͽ� ���� �Է¹���
			if(result>=min && result<=max) break;									// �Է¹��� ���� ���ǵ� �� ���� ������ ���̶�� ����
		} while(true);
		
		return result;																// �Է¹��� ���� ��ȯ�Ͽ���
	}
	
	public static boolean getExitKey() {											// q-key�� ������ true�� ��ȯ�ϰ�, enter-key�� ������ false�� ��ȯ���ִ� �޼ҵ�
		System.out.println("<<Press q-key to Exit or enter-key to Continue>>");
		String s = scan.nextLine();													
		if (s.contentEquals("q")) return true;										// contentEquals �Լ��� ����Ͽ� �Լ� ���ο� ������ "q"�� ������ true�� ����
		else return false;
	}

}
