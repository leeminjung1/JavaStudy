/*
	JavaProgramming1
	class 1
	32172988 �̹���
	
	Lab2
	2021.03.19
 */


public class Lab2 {
	
	
	/*
	 * 1. �̽����� ������ִ� �޼ҵ� ����
	 * �µ�(t)�� ����(rh)�� �Ķ���ͷ� �޾� �̽���(DewPointTemperature)�� ����Ͽ� �������ִ� �޼ҵ�
	 */
	
	public static double calculateDewPointTemperature(double t, double rh) {
		double result;

		result = ( 243.12 * (Math.log(rh/100) + (17.62 * t) / (243.12 + t)))
					/(17.62 - (Math.log(rh/100) + (17.62 * t) / (243.12 + t)));	// Dew Point�� ����ϴ� �� �ۼ�
		
		return Math.round(result);												// ����� �Ҽ��� ù° �ڸ����� �ݿø��ϵ��� Math class�� round�Լ��� ���
		
	}
	
	
	/* 2. ü���µ��� ������ִ� �޼ҵ� ����
	 * �µ�(t)�� ǳ��(v)�� �Ķ���ͷ� �޾� ü���µ�(WindChillTemperatrue)�� ����Ͽ� �������ִ� �޼ҵ�
	 */
	
	public static double calculateWindChillTemperature(double t, double v) {
		double result;

		result = 35.74 + 0.6215*t - 35.75*Math.pow(v, 0.16) + 0.4275*t*Math.pow(v, 0.16);	// ü���µ��� ����ϴ� �� �ۼ�
																							// Math.pow(��,����) �Լ��� ����Ͽ� ����ǥ��
		return Math.round(result);															// ����� �Ҽ��� ù° �ڸ����� �ݿø��ϵ��� Math class�� round�Լ��� ���
		
	}
	
	
	/* 3. �̽��� ���̺��� ������ִ� �޼ҵ� ����
	 * �µ�(t)�迭�� ����(rh)�迭�� �Ķ���ͷ� �޾� �� �迭�� ������ ������ ��� ����Ͽ� ǥ�� ���� ���·� ������ִ� �޼ҵ�
	 * �۾� ũ��, ���ڵ���� � ���� �ǵ��� �ٸ��� ��Ÿ��������..
	 */
	
	public static void printDewPointTemperature(int[] t, int[] rh) {
				
		System.out.print("Relative Humidity|");
        for (int i=0; i<rh.length; i++)
            System.out.print(rh[i] + "\t");													// ù��° ���� �־��� ������ ������ ���
        System.out.println("\n    Air Temp ��\t |-------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i=0; i<t.length; i++) {														// ��� t�迭 Ž��			
			System.out.print("\t" + t[i] + "\t |");											// �� �� ù��°�� �־��� �µ� ������ ���
			for(int j=0; j<rh.length; j++, System.out.print("\t")) {						// ��� rh�迭 Ž��
				if(calculateDewPointTemperature(t[i],rh[j])>=0) {							// �̽��� table���� ������ ������ �ʱ� ������ ����϶���
					System.out.print((int)calculateDewPointTemperature(t[i],rh[j]));		// calculateDewPointTemperature�޼ҵ带 ����Ͽ� �� ����� ������ ��ȯ�Ͽ� ���
				}
				else System.out.print("    ");												// �����϶��� ���� ���
			}
			System.out.println();
		}
		
	}
	
	/* 4. ü���µ� ���̺��� ������ִ� �޼ҵ� ����
	 * �µ�(t)�迭�� ǳ��(v)�迭�� �Ķ���ͷ� �޾� �� �迭�� ������ ������ ��� ����Ͽ� ǥ�� ���� ���·� ������ִ� �޼ҵ�
	 */
	
	public static void printWindChillTemperature(int[] t, int[] v) {
		
		System.out.print("   Air Temp �� \t|");
        for (int i=0; i<t.length; i++)												// ù��° ���� �־��� �µ� ������ ���
            System.out.print(t[i] + "\t");
        System.out.println("\n   Wind (mph) \t|---------------------------------------------------------------------------------------------------------------------------------------------");
				
		for(int i=0; i<v.length; i++) {												// ��� v�迭 Ž��
			System.out.print("\t" + v[i] + "\t|");									// �� �� ù��°�� �־��� ǳ�ӵ����� ���
			for(int j=0; j<t.length; j++, System.out.print("\t")) {					// ��� t�迭 Ž��
				System.out.print((int)calculateWindChillTemperature(t[j], v[i]));	// calculateWindChillTemperature�޼ҵ带 ����Ͽ� �� ����� ������ ��ȯ�Ͽ� ���
			}
			System.out.println();
		}
	
	}
	
	
	
	
	public static void main(String[] args) {
		
		/*
		 * 5. main �޼ҵ忡�� �����͸� �ְ�, �迭�� ����ϴ� �κ�
		 */
		
		// 5-1. �̽��� ��꿡 �ʿ��� �µ�(t) ������ ����
		int[] t1 = new int[17];											// int�� �迭 t1 ������ ũ�� 17�� �迭 ����
		
		for(int i=0; i<t1.length-1; i++) {								// �־��� �̽��� table�� �µ������� ������ �������� �ʰ� ��Ģ�� ã�� ���� 
			t1[i] = (int) Math.round((110 - (double)i*5 - 32)*5/9);		// Fahrenheit �µ��δ� 110���� 5���۾����� ��Ģ�� �̿��Ͽ� Celsius�� �ٲ�
																		// ������ ���� Celsius �µ��� 0�� �̱� ������ ���� �������� ����	
		}
		// 5-1. �̽��� ��꿡 �ʿ��� �µ� ������ �迭�� ���
		System.out.println("This is Temperature(��) Array to calcuate Dew Point Temperature");
		for(int i : t1) {
			System.out.print(i + " ");		// foreach���� ����Ͽ� �迭 t1�� �� ���
		}
		System.out.println();
		
		
		
		// 5-2. �̽��� ��꿡 �ʿ��� ������(rh) ������ ����
		int[] rh = new int[19];				// int�� �迭 rh ������ ũ�� 19�� �迭 ����
		for(int i=0; i<rh.length; i++) {	// �־��� �̽��� table�� �°� 100%���� 5�� �۾����� ��Ģã�� ����
			rh[i] = 100 - i*5;
		}
		// 5-2. �̽��� ��꿡 �ʿ��� ������ ������ �迭�� ���
		System.out.println();
		System.out.println("This is Relative Humidity(%) Array to calcuate Dew Point Temperature");
		for(int i=0; i<rh.length; i++) {
			System.out.print(rh[i] +" ");	// for���� ����Ͽ� �迭 rh�� �� ���
		}
		System.out.println();
		
		
		
		// 5-3. ü���µ� ��꿡 �ʿ��� ǳ��(v) ������ ����
		int[] v = new int[12];			// int�� �迭 v ������ ũ�� 12�� �迭 ����
		for(int i=0; i<v.length; i++) {
			v[i] = 5*(i+1);				// �־��� ü���µ� table�� �°� 5mph���� 5�� Ŀ���� ��Ģã�� ����
		}
		// 5-3. ü���µ� ��꿡 �ʿ��� ǳ�� ������ �迭�� ���
		System.out.println();
		System.out.println("This is Wind Speed(mph) Array to calcuate Wind Chill Temperature");
		int j = 0;
		while(j<v.length) {					// while���� �̿��Ͽ� �迭 v�� �� ���
			System.out.print(v[j] +" ");
			j++;
		}
		System.out.println();
		
		
		
		// 5-4. ü���µ� ��꿡 �ʿ��� �µ�(t) ������ ����
		int[] t2 = new int[18];				// int�� �迭 t2 ������ ũ�� 18�� �迭 ����
		for(int i=0; i<t2.length; i++) {
			t2[i] = 40 - i*5;				// �־��� ü���µ� table�� �°� 40���� 5�� �۾����� ��Ģã�� ����
		}
		// 5-4. ü���µ� ��꿡 �ʿ��� �µ� ������ �迭�� ���
		System.out.println();
		System.out.println("This is Temperature(��) Array to calcuate Wind Chill Temperature");
		int k = 0;
		do {								// do-while���� �̿��Ͽ� �迭 t2 ���
			System.out.print(t2[k] +" ");	
			k++;
		} while(k<t2.length);
		System.out.println();
		System.out.println();
		
		
		
		/*
		 * My code
		 * 
		 * Switch���� ����Ͽ� ���ڸ� �Է¹޾� ���ϴ� �迭�� �����ֵ��� �ۼ�
		 * 
		 */
		System.out.println("�̽��� ��꿡 ���Ǵ� �����ͼ��� ������ 1, ü���µ� ��꿡 ���Ǵ� �����ͼ��� ������ 2, ������������ 0�� �Է��ϼ���");
		
		int num = UserInput.getIntegerBetween(0,2);	// UserInput class�� getIntegerBetween �޼ҵ带 ����Ͽ� ���� 0�� 2������ ������ �޵��� ����
		
		switch (num) {
		case 0:
			break;
		case 1:
			System.out.print("t : ");
			for(int i : t1) {
				System.out.print(i + " ");		// foreach���� ����Ͽ� �迭 t1 ���
			}
			System.out.println();
			System.out.print("rh : ");
			for(int i : rh) {
				System.out.print(i + " ");		// foreach���� ����Ͽ� �迭 rh ���
			}
			System.out.println();
			break;
		case 2:
			System.out.print("t : ");
			for(int i : t2) {
				System.out.print(i + " ");		// foreach���� ����Ͽ� �迭 t2 ���
			}
			System.out.println();
			System.out.print("v : ");
			for(int i : v) {
				System.out.print(i + " ");		// foreach���� ����Ͽ� �迭 v ���
			}
			System.out.println();
			break;
		}
		
		
		
		
		/*
		 *  6. do-while���� �̿��Ͽ� ����ڰ� enter-key������ ���, q-key ������ �����ϵ��� ����
		 *  	����ڷκ��� 1 �Ǵ� 2�� �����Ͽ� �̽��� �Ǵ� ü���µ� ���
		 */
	
		do {
			if(UserInput.getExitKey()) System.exit(0);	// UserInput class�� getExitKey �޼ҵ带 �����Ͽ� true�̸� ���α׷� ����
									
			if(UserInput.getIntegerBetween(1,2) == 1)	// UserInput class�� getIntegerBetween �޼ҵ带 �����Ͽ� arguments�� 1�� 2�� �־��ְ� 1�̸�
				printDewPointTemperature(t1,rh);		// printDewPointTemperature�޼ҵ� ����. arguments�� t1�迭�� rh�迭�� ��
			else										// UserInput class�� getIntegerBetween �޼ҵ带 �����Ͽ� arguments�� 1�� 2�� �־��ְ� 1�� �ƴϸ�(2�̸�)
				printWindChillTemperature(t2,v);		// printWindChillTemperature�޼ҵ� ����. arguments�� t2�迭�� v�迭�� ��
						
		} while(true);									// ���� �ݺ�
		
		
	}

}
