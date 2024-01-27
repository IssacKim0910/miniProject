package main;

import java.util.Scanner;

import controller.Controller;
import model.CharacterDAO;
import model.CharacterDTO;
import model.DTO;
import model.Random1;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"                ` `   ```````                        ` `                               ```                          ```  `                                  \r\n"
						+ "                  ````````##                         ``##`                           ``##`                          `###``                                  \r\n"
						+ " `  ``            ###   ``##    ` ##############    ` `##`      ```  ``###`` ```     ``##`   ` `########`#########   ###`         `####################` `  \r\n"
						+ "` ###     ``##`   ###   ``##`     ##`        ```    ` `##`      ` `#####``####`      ``##`   ``````###``````###````  ### `       ``                 ### `   \r\n"
						+ "  ##`     ` ##`   ###   ``##     `##`               ` `##`   `` ``###`` `   `### ` ` ``##`      ` `##``    `##`      ###```                         ###     \r\n"
						+ "  ##` `   ` ##``  ###   ``##     `##`               ` `#######```###`         ##``   ``##`       `####   ```##`      ########                       ##`     \r\n"
						+ "  ##` `   ` ##``  ###   ``##     `##`               ` `##`   `  `##`          ###    ``##`       `####`   `####`     ###``  `                       ##`     \r\n"
						+ "  ############``  ##########     `##``` ``  ``````#######`       ### ``    `  ##`    ``##`     `###``###``### ##` `  ###                        ` ``##      \r\n"
						+ "  ##` `   ` ##``  ###`````##      #################`` `##`      ``###````` ``###     ``##`    `###``` `#####   ###`  ###      `                    ###      \r\n"
						+ "  ##` `   ` ##``  ###  ` `##    `      `` `  `   ` ` ` `        `  `########## `     ``##`    ``` ` ` ` `#    `  ``  ###     `##############################\r\n"
						+ "  ##` `   ` ##``  ###   ``##          ####################          `  ``````        ``##`          ` ``  ```````` `  `  `     `            ##``            \r\n"
						+ "  ##` `   ` ##``  ###   ``##         ``                ###          `   ` `          ``##`           ``###############   `                  ##``           `\r\n"
						+ "  ############    ###   ``##        ``                 ###     ````````  ` ``    ```` `##`          `###`    ``` ` `####`                   ##`             \r\n"
						+ "                  ###   ``##         `####################   ` `#################### ``##`          ###              `###`                  ##`             \r\n"
						+ "                  ###   ``##         `###`             `       `            `  ``    ``##`          ###`            ``##`                   ##`             \r\n"
						+ "                  ###`  ``##         `###````````````````` `                         ``##`           `####` ` `  `#####``                   ##`             \r\n"
						+ "                         `##        ` ####################                          ` `##`             ``########### `                     `##`             ");
		CharacterDTO cDTO = new CharacterDTO(null, 0, 0, 0);
		CharacterDAO cDAO = new CharacterDAO();
		Controller controller = new Controller();
		Random1 r = new Random1();
		DTO dto = null;

		while (true) {
			System.out.print("[1]회원가입  [2]로그인  [3]랭킹  [4]게임종료 >> ");
			int menu = sc.nextInt();
			if (menu == 1) { // 회원가입
				System.out.println("회원 등록");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");
				String nick = sc.next();
				dto = new DTO(id, pw, nick);
				int cnt = controller.join(dto);

			} else if (menu == 2) { // 로그인
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				DTO info = controller.login(id, pw);
				int num = 0;
				if (info == null) {
					System.out.println("로그인 실패");
				} else if (info != null) {
					String name = info.getNick();
					for (int i = 0; i < name.length(); i++) {
						System.out.print(name.charAt(i));
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					System.out.println("님 환영합니다.");

					int life = r.random4(0);
					String ya = "하루최대 배달 가능횟수 : " + life + "회";
					for (int i = 0; i < ya.length(); i++) {
						System.out.print(ya.charAt(i));
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println();

					while (life > 0) { // 게임진행
						System.out.print("경로선택 >> [1]떡잎마을 [2]떡잎 유치원 [3]캐릭터정보 [4]로비로 돌아가기>> ");
						num = sc.nextInt();

						if (num == 1) { // 떡잎마을
							life--;
							System.out.println("떡잎마을 배달시작");
							System.out.println(r.random3(0));
							System.out.println("남은 배달횟수 : " + life);

						} else if (num == 2) { // 떡잎유치원
							life--;
							System.out.println("떡잎 유치원 배달시작");
							System.out.println(r.random2(0));
							System.out.println("남은 배달횟수 : " + life);

						} else if (num == 3) { // 캐릭터정보
							System.out.println("레벨 : ");
							System.out.println("HP : ");
							System.out.println("초코비 : ");
							
							//임시로 작성한건데 DB랑 연결하는법을 찾는중..
							DTO Info = cDAO.login(id, pw);
							cDAO.eat(cDTO);
							System.out.print(Info.getNick()+"님");
							System.out.println(cDTO.getHp());
							
						} else if (num == 4) { // 뒤로가기
							String end = "로비로 돌아가는중...";
							for (int i = 0; i < end.length(); i++) {
								System.out.print(end.charAt(i));

								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println();
							break;

						}

						else {
							System.out.println("잘못 입력하셨습니다.");
						}
					}
				}
				if (num != 4) {
					String end = "남은 배달 횟수를 모두 소진하여 종료합니다.";
					for (int i = 0; i < end.length(); i++) {
						System.out.print(end.charAt(i));
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println();
				}
			} else if (menu == 3) { // 랭킹
				for (int i = 0; i < 10; i++) {
					System.out.println((i + 1) + "위 : " + "\t 레벨 : ");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} else if (menu == 4) { // 게임종료
				System.out.println(
						"\r\n" + "\r\n" + "                                ,~:!****!:~,.                         \r\n"
								+ "                             .!#@@@@@@@@@@@@@=,                       \r\n"
								+ "                           ,=@@@=;:;!*=$@@@@@@@=~                     \r\n"
								+ "                          :@@@@@@;      .,;@@@@@@=,                   \r\n"
								+ "                         !#@@@@@@@*      ;#@@@@@@@@;                  \r\n"
								+ "                        *@@@@*:#@@@-    =@@@@@@@@@@@*                 \r\n"
								+ "                       :@@@@!  -@@@@   .@@@@#;,$@@@@@=                \r\n"
								+ "                       !@@@:    -@@@   .#@@=,  .=@@@@@*               \r\n"
								+ "                      :.!=~,~~~-~;*,    .;:,~~~~:#@@!;@;              \r\n"
								+ "          ,;          ;   :-     !        ;~     =*:  !@,             \r\n"
								+ "          -.-  -      ~  :,       :      ;.       ;,  :@=             \r\n"
								+ "       .. ,,~.:~     ., ,-    ..  .-    -- ..      :  ,@@~            \r\n"
								+ "       ~-*,: !;-     .. $   -$@@@: =    ! =@@$~    ,:  @@=            \r\n"
								+ "       ~~ -, ; ,     .. ! .*@@@@@@=-    ;#@@@@@!    !  =@#.           \r\n"
								+ "        ~-   , -    .-.   *@@@#$#@@:   ,@@@##@@@-   .  ;@@:           \r\n"
								+ "      ~;:~    .,   :,    -@@@#. .@@@   *@@!..#@@$      -@@$           \r\n"
								+ "      -~~,    .-  ~      !@@@-   $@@.  @@@   ;@@@.     .@#~-:         \r\n"
								+ "         *.     ;!       *@@@-  ,@@@  .@@@  .#@@@.     .#.  .:        \r\n"
								+ "        ;.-;=,  :.       ;@@@@$$@@@=   @@@#$#@@@#      ,-    ,-       \r\n"
								+ "        ;!- ,, ,-         $@@@@@@@@,   ;@@@@@@@@~      :      ~       \r\n"
								+ "             ; ~           #@@@@@@-     *@@@@@@;              -.      \r\n"
								+ "             ~ ~            ,~~~~.       .,~~-.               .~      \r\n"
								+ "             --,                                               !      \r\n"
								+ "              $                                                *      \r\n"
								+ "              ~.                                              .~      \r\n"
								+ "              ,,                                      ,,.     -       \r\n"
								+ "               -                                   ,*!..-!~,,;,       \r\n"
								+ "               ~                                ~:;!.,:~::.,,         \r\n"
								+ "               ,~                             .!~ .......,,           \r\n"
								+ "                --                         -;~-..........,,           \r\n"
								+ "                .!-                    .,~;~..............~           \r\n"
								+ "                ~.,#.        .      .!$~,.................;           \r\n"
								+ "                !...~:!~     - .!!::-......................-          \r\n"
								+ "                .:,....-!*!*!*!~...........................~          \r\n"
								+ "                  ~~....,..................................~,         \r\n"
								+ "                   .:-.:....................................!         \r\n"
								+ "                     ,::.........................-..........-.        \r\n"
								+ "                      .;.........................~,.......,:*.        \r\n"
								+ "                      :,.........................-,....-~:*.          \r\n"
								+ "                      *..........................-,.,;*-  ;           \r\n"
								+ "                      :..........................,;:-!    ;           \r\n"
								+ "                     .-..............................~.   !           \r\n"
								+ "                     ,,..............................,-   *           \r\n"
								+ "                     -,..............................,:  .;           \r\n"
								+ "                     ;...............................-~, -,           \r\n"
								+ "                     ;...............................:.; :            \r\n"
								+ "                     ;..........................,,..,:~, ~            \r\n"
								+ "                     ;......~;!-....,!;;,....,:;;;!;!,   -.           \r\n"
								+ "                     -;::::,.  ,;;:-.   -;:;:-      .=   :            \r\n"
								+ "                     -.                   ..         ~~,~:            \r\n"
								+ "                     ~                                :.              \r\n"
								+ "                     :                                :               \r\n" + "");

				break;
			} else {
				System.out.println("잘못 입력 하셨습니다.");
			}

		}

	}

}
