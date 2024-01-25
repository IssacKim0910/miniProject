package gitTest01;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("팀장 첫번째 커밋!");

		System.out.println("팀원1 두번째 커밋!");
		
		System.out.println("팀원2 세번째 커밋!");
		
		for(int i = 0; i < 25; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}

}
