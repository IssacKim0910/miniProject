package gitTest01;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("팀장 첫번째 커밋!");

		System.out.println("팀원1 두번째 커밋!");
		
		System.out.println("팀원2 세번째 커밋!");
		
//		for(int i = 0; i < 25; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}System.out.println();
//		}
		
//		for(int j = 10; j >=0; j --) {
//			System.out.println();
//			for(int k = 0; k < j; k++) {
//				System.out.print("");
//			}
//			for(int i = 10; i >=j; i--) {
//				System.out.print("*");
//			}
			
//		}
//		
//		Random ran = new Random();
//		int num = ran.nextInt(30)+1;
//		
//		for(int i = 1; i <= num; i++) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i = num; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}

}
