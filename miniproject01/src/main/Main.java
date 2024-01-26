package main;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import controller.Controller;
import java.sql.SQLException;
import model.DTO;
import model.DAO;

import model.Random;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

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

		Controller controller = new Controller();

		DTO dto = null;

		while (true) {
			System.out.print("[1]회원등록  [2]로그인  [3]랭킹  [4]종료 >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("회원 등록");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");
				String nick = sc.next();
				dto = new DTO(id, pw, nick);
				int cnt = controller.join(dto);

			} else if (menu == 2) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				String nick = sc.next();
				String name = nick + "님 환영합니다.";
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println();
				DTO info = controller.login(id, pw);
				if (info != null) {
					System.out.println(info.getNick() + "님 환영합니다.");		//로그인 성공시 닉네임 출력
				} else {
					System.out.println("존재하지 않는 ID입니다");				//실패시
				}
				System.out.println();

				while (true) {
					System.out.print("경로선택 >> [1]떡잎마을 [2]떡잎 유치원 >> ");
					int num = sc.nextInt();
					if (num == 1) {
						System.out.println("배달시작");

					} else if (num == 2) {

					} else {
						System.out.println("잘못입력 하셨습니다.");
					}

				}

			} else if (menu == 3) {

			} else if (menu == 4) {
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
