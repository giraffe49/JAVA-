package game;

import java.util.Scanner;

public class Mainclass {

	static int disum = 0; // 玩家點數累計
	static int gssum = 19; // 鬼點數累計 鬼尚未出現設為19
	static int a = 0; // 玩家是否繼續擲骰 ,a -> 0 繼續擲骰
	static int b = 0; // 是否繼續判斷遊戲內容 ,b -> 0 持續判斷
	static int k = 0; // 玩家是否有因小遊戲失敗而倒退一格,如果有則需重新印出棋盤 ,k -> 0 否
	static String pp = "☺"; // 玩家符號
	static String gs = "☻"; // 鬼符號
	static String ca = "😺";
	static boolean gss = false; // 鬼是否已經出現
	static boolean win; // 小遊戲輸贏與否

	static Scanner sc = new Scanner(System.in);
	static Cat catgo = new Cat(); // 建立catgo物件 貓圍棋
	static Ox ox = new Ox(); // 建立ox物件 井字
	static Mora mora = new Mora(); // 建立mora物件 猜拳
	static Highlow hilo = new Highlow(); // 建立hilo物件 比大小
	static Connect4 confr = new Connect4(); // 建立confr物件 四子棋

	// 初始棋盤
	public static void createMap(String[][] game) {
		for (int i = game.length - 1; i >= 0; i--) {
			for (int j = 0; j <= game[0].length - 1; j++) {
				if (j == 1 && i != 0) {
					game[i][j] = "◆";
				} else if (j == 5 && i != 0) {
					game[i][j] = "◆";
				} else if (j == 3 && i != 3) {
					game[i][j] = "◆";
				} else {
					game[i][j] = "❏";
				}
			}
		}
		if (disum == 0) {
			game[3][0] = pp; // 起點
		} else {
			game[3][0] = "❏";
		}
		game[3][6] = "✪"; // 終點符號
	}

	// 畫出棋盤
	public static void drawMap(String[][] game) {
		System.out.println("");
		for (int i = game.length - 1; i >= 0; i--) {
			for (int j = 0; j <= game[0].length - 1; j++) {
				System.out.print(game[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 介紹遊戲
		System.out.print("歡迎來到「大逃脫」迷宮\n玩家☺要以甩骰子的方式從起點走至終點\n★注意！只有恰好停在終點上才算逃脫成功\n");
		System.out.print("某些格子會有一項小挑戰\n若是無法完成挑戰\n將會引出鬼☻來抓你！");
		System.out.print("\n★記住，別被鬼抓到,否則就逃脫失敗\n準備好了嗎？逃脫之門即將開啟\n祝福你能成功逃脫\n");

		// 呼叫初始棋盤
		String game[][] = new String[4][7];
		createMap(game);

		// 呼叫畫出棋盤
		drawMap(game);

		play: while (true) {
			pp = "☺";
			gs = "☻";
			b = 0;
			k = 0;
			
			// 玩家擲骰
			while (a == 0) {
				System.out.println("輸入1來擲骰子:");
				int go = sc.nextInt();
				if (go == 1) {
					int dice = (int) (Math.random() * 6) + 1;
					disum = disum + dice;
					System.out.println("您擲出了《" + dice + "》點");
					a = 1;
				} else {
					System.out.println("輸入無效,想擲骰子請輸入\"1\"!");
				}
			}

			// 呼叫初始棋盤
			createMap(game);

			// 判斷棋的位置
			move(game);
			gsmove(game);

			// 呼叫畫出目前棋盤
			drawMap(game);

			//進入小遊戲迴圈
			smgame:
			while (b == 0) {

				// 呼叫進入該位置的遊戲
				movegm(game);
				
				if((disum==1 || disum==11 || disum==15  || disum==18) && k==0) {
					break smgame;
				}
				
				// 重新判斷並畫出遊戲後位置
				createMap(game);
				move(game);
				gsmove(game);
				drawMap(game);
			}

			// 是否繼續下一輪遊戲
			if (disum == 18 || gssum>=disum && gssum!=19) {
				System.out.println("是否再次進行挑戰 1.是 2.否:");
				int keep = sc.nextInt();
				if (keep == 1) {
					disum = 0;
					gssum = 19;
					gss = false;
				} else {
					System.out.println("感謝遊玩,別忘了留下五星成績喔!");
					break play;
				}
			}

			a = 0;
			
		}
	}

	// 判斷小遊戲輸贏
		public static void smallgm(int c) {
			if (c == 0) {
				win = false;
			} else if (c == 1) {
				win = true;
			}
		}

		// 小遊戲輸贏後懲罰與繼續
		public static void smgm(boolean win) {
			if (win == false) {
				disum=disum-1;
				gsgo();
				System.out.println("玩家倒退一格");
				k = 1;
				b = 1;
			} else if (win == true) {
				a = 0;
				b = 1;
			}
		}

		// 鬼移動
		public static void gsgo() {
			if (gss == false) {
				gssum = 0;
				gss = true;
			} else if (gss == true) {
				int gsdice = (int) (Math.random() * 4) + 2;
				gssum = gssum + gsdice;
				System.out.println("鬼擲出了《" + gsdice + "》點");
				a = 1;
			}
		}
	
	// 判斷玩家位置
	public static void move(String[][] game) {
		while (true) {
			if (disum == 1) {
				game[2][0] = pp;
				break;
			} else if (disum == 2) {
				game[1][0] = pp;
				break;
			} else if (disum == 3) {
				game[0][0] = pp;
				break;
			} else if (disum == 4) {
				game[0][1] = pp;
				break;
			} else if (disum == 5) {
				game[0][2] = pp;
				break;
			} else if (disum == 6) {
				game[1][2] = "😺";
				break;
			} else if (disum == 7) {
				game[2][2] = pp;
				break;
			} else if (disum == 8) {
				game[3][2] = pp;
				break;
			} else if (disum == 9) {
				game[3][3] = pp;
				break;
			} else if (disum == 10) {
				game[3][4] = pp;
				break;
			} else if (disum == 11) {
				game[2][4] = pp;
				break;
			} else if (disum == 12) {
				game[1][4] = pp;
				break;
			} else if (disum == 13) {
				game[0][4] = pp;
				break;
			} else if (disum == 14) {
				game[0][5] = pp;
				break;
			} else if (disum == 15) {
				game[0][6] = pp;
				break;
			} else if (disum == 16) {
				game[1][6] = pp;
				break;
			} else if (disum == 17) {
				game[2][6] = pp;
				break;
			} else if (disum == 18) {
				game[3][6] = "♛";
				break;
			} else if (disum > 18) {
				System.out.println("《呀!走過頭了!回去重走!》");
				disum = 18 - (disum - 18);
			}
		}
	}

	// 判斷玩家位置遊戲
	public static void movegm(String[][] game) {
		while (true) {
			if (disum == 1) {
				System.out.println("\\\\沒有關卡~休息一下//");
				b = 1;
				break ;
			} else if (disum == 2) {
				ox.display();
				smgm(win);
				break;
			} else if (disum == 3) {
				mora.display();
				smgm(win);
				break;
			} else if (disum == 4) {
				System.out.println("\\\\守衛不在家!前進兩格~//");
				disum = disum + 2;
				break;
			} else if (disum == 5) {
				System.out.println("!!!被守衛發現了");
				gsgo();
				b = 1;
				break;
			} else if (disum == 6) {
				catgo.display();
				smgm(win);
				break;
			} else if (disum == 7) {
				System.out.println("!!!踩到陷阱了");
				System.out.println("後退一格!");
				disum = disum - 1;
				break;
			} else if (disum == 8) {
				System.out.println("找到捷徑!前進一格!");
				disum = disum + 1;
				break;
			} else if (disum == 9) {
				confr.display();
				smgm(win);
				break;
			} else if (disum == 10) {
				System.out.println("!!!被守衛發現了");
				gsgo();
				b = 1;
				break;
			} else if (disum == 11) {
				System.out.println("\\\\沒有關卡~休息一下//");
				b = 1;
				break;
			} else if (disum == 12) {
				hilo.display();
				smgm(win);
				break;
			} else if (disum == 13) {
				mora.display();
				smgm(win);
				break;
			} else if (disum == 14) {
				ox.display();
				smgm(win);
				break;
			} else if (disum == 15) {
				System.out.println("加油快到了!");
				b = 1;
				break;
			} else if (disum == 16) {
				hilo.display();
				smgm(win);
				break;
			} else if (disum == 17) {
				System.out.println("守衛不在家!前進三格!");
				disum = disum + 3;
				break;
			} else if (disum == 18) {
				System.out.println("你贏了!!!");
				b = 1;
				break;
			}
		}
	}

	// 鬼移動格子
	public static void gsmove(String[][] game) {
			if (gssum == disum) {
				System.out.println("《抓到了!抓到你了!》");
				b = 1;
			} else if (gssum > disum && gssum != 19) {
				System.out.println("《抓到了!抓到你了!》");
				createMap(game);	//使玩家消失在地圖上
				b = 1;
			} 
				if (gssum == 0) {
					game[3][0] = gs;
				} else if (gssum == 1) {
					game[2][0] = gs;
				} else if (gssum == 2) {
					game[1][0] = gs;
				} else if (gssum == 3) {
					game[0][0] = gs;
				} else if (gssum == 4) {
					game[0][1] = gs;
				} else if (gssum == 5) {
					game[0][2] = gs;
				} else if (gssum == 6) {
					game[1][2] = gs;
				} else if (gssum == 7) {
					game[2][2] = gs;
				} else if (gssum == 8) {
					game[3][2] = gs;
				} else if (gssum == 9) {
					game[3][3] = gs;
				} else if (gssum == 10) {
					game[3][4] = gs;
				} else if (gssum == 11) {
					game[2][4] = gs;
				} else if (gssum == 12) {
					game[1][4] = gs;
				} else if (gssum == 13) {
					game[0][4] = gs;
				} else if (gssum == 14) {
					game[0][5] = gs;
				} else if (gssum == 15) {
					game[0][6] = gs;
				} else if (gssum == 16) {
					game[1][6] = gs;
				} else if (gssum == 17) {
					game[2][6] = gs;
				} else if (gssum == 18) {
					game[3][6] = gs;
				} 
			
	}

}

