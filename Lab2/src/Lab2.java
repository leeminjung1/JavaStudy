/*
	JavaProgramming1
	class 1
	32172988 이민정
	
	Lab2
	2021.03.19
 */


public class Lab2 {
	
	
	/*
	 * 1. 이슬점을 계산해주는 메소드 정의
	 * 온도(t)와 습도(rh)를 파라미터로 받아 이슬점(DewPointTemperature)을 계산하여 리턴해주는 메소드
	 */
	
	public static double calculateDewPointTemperature(double t, double rh) {
		double result;

		result = ( 243.12 * (Math.log(rh/100) + (17.62 * t) / (243.12 + t)))
					/(17.62 - (Math.log(rh/100) + (17.62 * t) / (243.12 + t)));	// Dew Point를 계산하는 식 작성
		
		return Math.round(result);												// 결과를 소수점 첫째 자리에서 반올림하도록 Math class의 round함수를 사용
		
	}
	
	
	/* 2. 체감온도를 계산해주는 메소드 정의
	 * 온도(t)와 풍속(v)를 파라미터로 받아 체감온도(WindChillTemperatrue)을 계산하여 리턴해주는 메소드
	 */
	
	public static double calculateWindChillTemperature(double t, double v) {
		double result;

		result = 35.74 + 0.6215*t - 35.75*Math.pow(v, 0.16) + 0.4275*t*Math.pow(v, 0.16);	// 체감온도를 계산하는 식 작성
																							// Math.pow(밑,지수) 함수를 사용하여 지수표현
		return Math.round(result);															// 결과를 소수점 첫째 자리에서 반올림하도록 Math class의 round함수를 사용
		
	}
	
	
	/* 3. 이슬점 테이블을 출력해주는 메소드 정의
	 * 온도(t)배열과 습도(rh)배열을 파라미터로 받아 두 배열의 가능한 조합을 모두 계산하여 표와 같은 형태로 출력해주는 메소드
	 * 글씨 크기, 인코딩방법 등에 따라 의도와 다르게 나타날수있음..
	 */
	
	public static void printDewPointTemperature(int[] t, int[] rh) {
				
		System.out.print("Relative Humidity|");
        for (int i=0; i<rh.length; i++)
            System.out.print(rh[i] + "\t");													// 첫번째 열에 주어진 상대습도 데이터 출력
        System.out.println("\n    Air Temp ℃\t |-------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i=0; i<t.length; i++) {														// 모든 t배열 탐색			
			System.out.print("\t" + t[i] + "\t |");											// 각 행 첫번째에 주어진 온도 데이터 출력
			for(int j=0; j<rh.length; j++, System.out.print("\t")) {						// 모든 rh배열 탐색
				if(calculateDewPointTemperature(t[i],rh[j])>=0) {							// 이슬점 table에서 음수는 나오지 않기 때문에 양수일때만
					System.out.print((int)calculateDewPointTemperature(t[i],rh[j]));		// calculateDewPointTemperature메소드를 사용하여 그 결과를 정수로 변환하여 출력
				}
				else System.out.print("    ");												// 음수일때는 공백 출력
			}
			System.out.println();
		}
		
	}
	
	/* 4. 체감온도 테이블을 출력해주는 메소드 정의
	 * 온도(t)배열과 풍속(v)배열을 파라미터로 받아 두 배열의 가능한 조합을 모두 계산하여 표와 같은 형태로 출력해주는 메소드
	 */
	
	public static void printWindChillTemperature(int[] t, int[] v) {
		
		System.out.print("   Air Temp ℉ \t|");
        for (int i=0; i<t.length; i++)												// 첫번째 열에 주어진 온도 데이터 출력
            System.out.print(t[i] + "\t");
        System.out.println("\n   Wind (mph) \t|---------------------------------------------------------------------------------------------------------------------------------------------");
				
		for(int i=0; i<v.length; i++) {												// 모든 v배열 탐색
			System.out.print("\t" + v[i] + "\t|");									// 각 행 첫번째에 주어진 풍속데이터 출력
			for(int j=0; j<t.length; j++, System.out.print("\t")) {					// 모든 t배열 탐색
				System.out.print((int)calculateWindChillTemperature(t[j], v[i]));	// calculateWindChillTemperature메소드를 사용하여 그 결과를 정수로 변환하여 출력
			}
			System.out.println();
		}
	
	}
	
	
	
	
	public static void main(String[] args) {
		
		/*
		 * 5. main 메소드에서 데이터를 넣고, 배열을 출력하는 부분
		 */
		
		// 5-1. 이슬점 계산에 필요한 온도(t) 데이터 생성
		int[] t1 = new int[17];											// int형 배열 t1 선언후 크기 17의 배열 생성
		
		for(int i=0; i<t1.length-1; i++) {								// 주어진 이슬점 table의 온도조건을 일일이 대입하지 않고 규칙을 찾아 대입 
			t1[i] = (int) Math.round((110 - (double)i*5 - 32)*5/9);		// Fahrenheit 온도로는 110부터 5씩작아지는 규칙을 이용하여 Celsius로 바꿈
																		// 마지막 값은 Celsius 온도로 0도 이기 때문에 따로 대입하지 않음	
		}
		// 5-1. 이슬점 계산에 필요한 온도 데이터 배열을 출력
		System.out.println("This is Temperature(℃) Array to calcuate Dew Point Temperature");
		for(int i : t1) {
			System.out.print(i + " ");		// foreach문을 사용하여 배열 t1의 값 출력
		}
		System.out.println();
		
		
		
		// 5-2. 이슬점 계산에 필요한 상대습도(rh) 데이터 생성
		int[] rh = new int[19];				// int형 배열 rh 선언후 크기 19의 배열 생성
		for(int i=0; i<rh.length; i++) {	// 주어진 이슬점 table에 맞게 100%에서 5씩 작아지는 규칙찾아 대입
			rh[i] = 100 - i*5;
		}
		// 5-2. 이슬점 계산에 필요한 상대습도 데이터 배열을 출력
		System.out.println();
		System.out.println("This is Relative Humidity(%) Array to calcuate Dew Point Temperature");
		for(int i=0; i<rh.length; i++) {
			System.out.print(rh[i] +" ");	// for문을 사용하여 배열 rh의 값 출력
		}
		System.out.println();
		
		
		
		// 5-3. 체감온도 계산에 필요한 풍속(v) 데이터 생성
		int[] v = new int[12];			// int형 배열 v 선언후 크기 12의 배열 생성
		for(int i=0; i<v.length; i++) {
			v[i] = 5*(i+1);				// 주어진 체감온도 table에 맞게 5mph에서 5씩 커지는 규칙찾아 대입
		}
		// 5-3. 체감온도 계산에 필요한 풍속 데이터 배열을 출력
		System.out.println();
		System.out.println("This is Wind Speed(mph) Array to calcuate Wind Chill Temperature");
		int j = 0;
		while(j<v.length) {					// while문을 이용하여 배열 v의 값 출력
			System.out.print(v[j] +" ");
			j++;
		}
		System.out.println();
		
		
		
		// 5-4. 체감온도 계산에 필요한 온도(t) 데이터 생성
		int[] t2 = new int[18];				// int형 배열 t2 선언후 크기 18의 배열 생성
		for(int i=0; i<t2.length; i++) {
			t2[i] = 40 - i*5;				// 주어진 체감온도 table에 맞게 40에서 5씩 작아지는 규칙찾아 대입
		}
		// 5-4. 체감온도 계산에 필요한 온도 데이터 배열을 출력
		System.out.println();
		System.out.println("This is Temperature(℉) Array to calcuate Wind Chill Temperature");
		int k = 0;
		do {								// do-while문을 이용하여 배열 t2 출력
			System.out.print(t2[k] +" ");	
			k++;
		} while(k<t2.length);
		System.out.println();
		System.out.println();
		
		
		
		/*
		 * My code
		 * 
		 * Switch문을 사용하여 숫자를 입력받아 원하는 배열을 보여주도록 작성
		 * 
		 */
		System.out.println("이슬점 계산에 사용되는 데이터셋을 보려면 1, 체감온도 계산에 사용되는 데이터셋을 보려면 2, 보지않으려면 0을 입력하세요");
		
		int num = UserInput.getIntegerBetween(0,2);	// UserInput class의 getIntegerBetween 메소드를 사용하여 값을 0과 2사이의 정수만 받도록 설정
		
		switch (num) {
		case 0:
			break;
		case 1:
			System.out.print("t : ");
			for(int i : t1) {
				System.out.print(i + " ");		// foreach문을 사용하여 배열 t1 출력
			}
			System.out.println();
			System.out.print("rh : ");
			for(int i : rh) {
				System.out.print(i + " ");		// foreach문을 사용하여 배열 rh 출력
			}
			System.out.println();
			break;
		case 2:
			System.out.print("t : ");
			for(int i : t2) {
				System.out.print(i + " ");		// foreach문을 사용하여 배열 t2 출력
			}
			System.out.println();
			System.out.print("v : ");
			for(int i : v) {
				System.out.print(i + " ");		// foreach문을 사용하여 배열 v 출력
			}
			System.out.println();
			break;
		}
		
		
		
		
		/*
		 *  6. do-while문을 이용하여 사용자가 enter-key누르면 계속, q-key 누르면 종료하도록 구현
		 *  	사용자로부터 1 또는 2를 선택하여 이슬점 또는 체감온도 계산
		 */
	
		do {
			if(UserInput.getExitKey()) System.exit(0);	// UserInput class의 getExitKey 메소드를 실행하여 true이면 프로그램 종료
									
			if(UserInput.getIntegerBetween(1,2) == 1)	// UserInput class의 getIntegerBetween 메소드를 실행하여 arguments로 1과 2를 넣어주고 1이면
				printDewPointTemperature(t1,rh);		// printDewPointTemperature메소드 실행. arguments로 t1배열과 rh배열을 줌
			else										// UserInput class의 getIntegerBetween 메소드를 실행하여 arguments로 1과 2를 넣어주고 1이 아니면(2이면)
				printWindChillTemperature(t2,v);		// printWindChillTemperature메소드 실행. arguments로 t2배열과 v배열을 줌
						
		} while(true);									// 무한 반복
		
		
	}

}
