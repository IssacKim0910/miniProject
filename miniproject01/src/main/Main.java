package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println();
		
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
		
		
	
		while(true) {
			System.out.print("[1]회원등록  [2]로그인  [3]랭킹  [4]종료 >> ");
			int menu = sc.nextInt();
			if(menu == 1) {
				System.out.println("회원 등록");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");
				String nic = sc.next();
				
				
				
			} else if (menu == 2) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				String nic = sc.next();
				String name = nic + "님 환영합니다.";
				for(int i =0; i < name.length(); i++) {
					
				System.out.print(name.charAt(i));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				}
				System.out.println();
				
//				while (true) {
//					System.out.print("경로선택 >> 1.떡잎마을 2.떡잎 유치원");
//					int num = sc.nextInt();
//					break;
//				}
				
			} else if (menu == 3) {
				
			} else if (menu == 4) {
				System.out.println(
						"\r\n"
						+ "\r\n"
						+ "                                ,~:!****!:~,.                         \r\n"
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
						+ "                     :                                :               \r\n"
						+ "");
						 
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다.");
			}
			
			
		}
		
		
		
	}

}
