package ch07;

import java.util.Arrays;
import java.util.Random;

// 클래스를 --> 단일 책임 원칙을 설정하는것이 좋다.
public class LottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;

	// 기능 : 6개의 랜덤 번호를 생성하는 메서드가 필요하다.
	public int[] creteNumber() {

		int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();

		//outer for -> 0 -> inner for -> 동작안함
		//outer for -> 1 -> inner for -> 한번동작함
		//outer for -> 2 -> inner for -> 두번동작함
		
		for (int i = 0; i < lottoWinNum.length; i++) { 
			lottoWinNum[i] = random.nextInt(45) + 1; // 1~45 까지값이담긴다
			for (int j = 0; j < i ; j++) {
				
				if(lottoWinNum[j] == lottoWinNum[i]) {
					// 값이 중복된 상태이다.
					i--;
				}
				
			}
		}
		
		// 중복 제거 완료
		
		Arrays.sort(lottoWinNum); // 오름차순으로 자동 정렬
		return lottoWinNum;
	}

	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();

		int[] resultArray = randomNumber.creteNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
}
