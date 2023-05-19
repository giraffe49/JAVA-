package game;
import java.util.Scanner;

import game.Mainclass;

public class Ox {

	static Mainclass mc = new Mainclass();

	static int win = 0; // 是否勝利 1 ->勝利

	public void display() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String game[] = new String[9];
		int X, Y; // 玩家輸入座標
		int count; // 已放置格數
		int first; // 誰先出手 0 -> 電腦先出
		win = 0;

		System.out.println("---------------------------------------------------------");
		System.out.println("歡迎來到人機對戰的井字遊戲");
		System.out.println("以下為此遊戲的規則:");
		System.out.println("★ 玩家為o，電腦為x");
		System.out.println("★ 當遊戲有任何一方的符號連為一條線(包含直線、橫線、斜線)即為遊戲勝利者");
		System.out.println("");

		all: while (true) {
			// 設定電腦先出
			first = 0;

			// 初始化棋盤
			count = 0;
			for (int i = 0; i < 9; i++) {
				game[i] = " ";
			}

			// 下棋迴圈
			play: while (count < 9) {

				// 電腦下棋
				if (first == 0) {
					System.out.println("<電腦出手囉~>");
					// 放置電腦的棋
					while (true) {
						int computerGame = (int) (Math.random() * 9);
						if (game[computerGame] == " ") {
							game[computerGame] = "x";
							count++;
							break;
						}
					}
					// 呼叫印出目前棋盤
					map(game);

					// 呼叫判斷電腦是否勝利
					finish(game);

					if (win == 1) {
						break all;
					}

					if (count == 9) {
						System.out.println("此局為平局喔~~你們都很強呢!!");
						System.out.println("那就再玩一次,分出勝負吧!");
						break play; // 離開下棋迴圈,重新開始遊戲
					}
					first = 1;
				}
				if (first == 1) {
					System.out.println("<輪到你出手囉~>");
					// 玩家下棋迴圈
					while (true) {
						// X位置
						while (true) {
							System.out.println("請輸入想要放置的X座標:");
							X = sc.nextInt();
							if (X <= 3 && X >= 1) {
								break;
							} else {
								System.out.println("請輸入正確的數值");
							}
						}
						// Y位置
						while (true) {
							System.out.println("請輸入想要放置的Y座標:");
							Y = sc.nextInt();
							if (Y <= 3 && Y >= 1) {
								break;
							} else {
								System.out.println("請輸入正確的數值");
							}
						}
						// 放置玩家的棋
						if (game[(Y - 1) * 3 + X - 1] == " ") {
							game[(Y - 1) * 3 + X - 1] = "o";
							count++;
							break; // 離開玩家下棋迴圈
						} else {
							System.out.println("這個位置有東西囉!請重新輸入~");
						}
					}

					// 呼叫印出目前棋盤
					map(game);

					// 呼叫判斷玩家是否勝利
					finish(game);

					if (win == 1) {
						break all; // 結束遊戲
					}

					if (count == 9) {
						System.out.println("此局為平局喔~~你們都很強呢!!");
						System.out.println("<那就再玩一次,分出勝負吧!>");
						break play; // 離開下棋迴圈,重新開始遊戲
					}
					first = 0;
				}
			}
		}
	}

	// 印出棋盤方法
	public static void map(String game[]) {
		System.out.println("Y座標");
		System.out.println(" ↓");
		System.out.println("   ┌───┬───┬───┐");
		System.out.println(" 1 │ " + game[0] + " │ " + game[1] + " │" + game[2] + "  │");
		System.out.println("   ├───┼───┼───┤");
		System.out.println(" 2 │ " + game[3] + " │ " + game[4] + " │" + game[5] + "  │");
		System.out.println("   ├───┼───┼───┤");
		System.out.println(" 3 │ " + game[6] + " │ " + game[7] + " │" + game[8] + "  │");
		System.out.println("   └───┴───┴───┘");
		System.out.println("     1   2   3    ← X座標");
		System.out.println("");

	}

	// 判斷勝利方法
	public static void finish(String game[]) {
		// 斜線
		if (game[0] == game[4] && game[0] == game[8] && game[0] == "o") {
			win = 1;
			System.out.println("恭喜玩家勝利~你真是井字遊戲高手!!!");
			System.out.println("---------------------------------------------------------");
			// 呼叫MainClass的smallgm(c)方法,給值c,使MainClass判斷小遊戲的輸贏,c=1 -> 勝利
			mc.smallgm(1);
		}
		if (game[0] == game[4] && game[0] == game[8] && game[0] == "x") {
			win = 1;
			System.out.println("恭喜電腦勝利~玩家加油呦~");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(0);
		}
		if (game[2] == game[4] && game[2] == game[6] && game[2] == "o") {
			win = 1;
			System.out.println("恭喜玩家勝利~你真是井字遊戲高手!!!");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(1);
		}
		if (game[2] == game[4] && game[2] == game[6] && game[2] == "x") {
			win = 1;
			System.out.println("恭喜電腦勝利~玩家加油呦~");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(0);
		}
		// 橫線
		for (int i = 0; i < 9; i += 3) {
			if (win == 1)
				break;
			if (game[i] == game[i + 1] && game[i] == game[i + 2] && game[i] == "o") {
				win = 1;
				System.out.println("恭喜玩家勝利~你真是井字遊戲高手!!!");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(1);
				break;
			}
			if (game[i] == game[i + 1] && game[i] == game[i + 2] && game[i] == "x") {
				win = 1;
				System.out.println("恭喜電腦勝利~玩家加油呦~");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(0);
				break;
			}
		}
		// 直線
		for (int i = 0; i < 3; i++) {
			if (win == 1)
				break;
			if (game[i] == game[i + 3] && game[i] == game[i + 6] && game[i] == "o") {
				win = 1;
				System.out.println("恭喜玩家勝利~你真是井字遊戲高手!!!");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(1);
				break;
			}
			if (game[i] == game[i + 3] && game[i] == game[i + 6] && game[i] == "x") {
				win = 1;
				System.out.println("恭喜電腦勝利~玩家加油呦~");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(0);
			}
		}
	}
}
