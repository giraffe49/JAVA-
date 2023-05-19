package game;

import java.util.Scanner;

public class Connect4 {

	static Mainclass mc = new Mainclass();
	
	// 印出棋盤
	public static void drawMap(String[][] qi) {
		System.out.println("-----------------------------");
		for (int i = qi.length - 1; i >= 0; i--) {
			for (int j = 0; j < qi[0].length; j++)
				System.out.print(qi[i][j]);
			System.out.println("|");
			System.out.println("-----------------------------");
		}
		for (int i = 0; i < qi[0].length; i++) {
			System.out.print("* " + (i + 1) + " ");
		}
		System.out.println("");
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		String[][] qi = new String[6][7];
		String line = "|   ";
		String user = "| Y "; //玩家黃棋符號
		String userwin = "| 𝓨 "; //玩家勝利符號
		String pc = "| R "; //電腦紅棋符號
		String pcwin = "| 𝓡 "; //電腦勝利符號
		int row = 0, column = 0;
		int count = 1; //count=1 -> 電腦出棋

		// 初始化棋盤
		for (int i = 0; i < qi.length; i++) {
			for (int j = 0; j < qi[0].length; j++) {
				qi[i][j] = line;
			}
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("這是一個人機對戰的四子棋遊戲\n玩家是黃棋Y，電腦是紅棋R\n");

		// 下棋迴圈
		play: while (true) {
			// 玩家下棋(count=0)
			while (count == 0) {
				while (true) {
					System.out.println("玩家請在1~7行出棋:");
					column = sc.nextInt() - 1;
					if (column >= 0 && column <= 6) {
						for (row = 0; row < qi.length; row++) {
							if (qi[row][column] == line) {
								qi[row][column] = user;
								count = 1;
								break;
							}
						}
						if (row == qi.length) {
							System.out.print("此行已經下滿了" + "請重新下棋! \n");
						} else if (!(row == qi.length)) {
							break;
						} else {
							System.out.print("輸入錯誤" + "請重新下棋! : ");
						}
					}
				}
				// 列出棋盤
				drawMap(qi);
				System.out.println("");

				// 判斷輸贏
				// 判斷直的連線
				if (row >= 3) {
					if (qi[row - 1][column] == user && qi[row - 2][column] == user && qi[row - 3][column] == user) {
						System.out.println("《玩家勝利》");
						qi[row][column] = userwin;
						qi[row - 1][column] = userwin;
						qi[row - 2][column] = userwin;
						qi[row - 3][column] = userwin;
						drawMap(qi);
						mc.smallgm(1);
						System.out.println("-------------------------------------------");
						break play; // 離開下棋迴圈
					}
				}
				// 判斷衡的連線
				for (int i = 0; i < qi.length; i++) {
					for (int j = 0; j < qi[0].length - 4; j++) {
						if (qi[i][j] == user && qi[i][j + 1] == user && qi[i][j + 2] == user && qi[i][j + 3] == user) {
							System.out.println("《玩家勝利》");
							qi[i][j] = userwin;
							qi[i][j + 1] = userwin;
							qi[i][j + 2] = userwin;
							qi[i][j + 3] = userwin;
							drawMap(qi);
							mc.smallgm(1);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}
				// 判斷斜的連線
				// 左下右上
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 3; j++) {
						if (qi[i][j] == user && qi[i + 1][j + 1] == user && qi[i + 2][j + 2] == user
								&& qi[i + 3][j + 3] == user) {
							System.out.println("《玩家勝利》");
							qi[i][j] = userwin;
							qi[i + 1][j + 1] = userwin;
							qi[i + 2][j + 2] = userwin;
							qi[i + 3][j + 3] = userwin;
							drawMap(qi);
							mc.smallgm(1);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}
				// 左上右下
				for (int i = 3; i <= 5; i++) {
					for (int j = 0; j <= 3; j++) {
						if (qi[i][j] == user && qi[i - 1][j + 1] == user && qi[i - 2][j + 2] == user
								&& qi[i - 3][j + 3] == user) {
							System.out.println("《玩家勝利》");
							qi[i][j] = userwin;
							qi[i - 1][j + 1] = userwin;
							qi[i - 2][j + 2] = userwin;
							qi[i - 3][j + 3] = userwin;
							drawMap(qi);
							mc.smallgm(1);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}

			}

			// 電腦下棋(count=1)
			while (count == 1) {
				System.out.println("電腦出棋:");
				while (true) {
					column = (int) (Math.random() * 7);
					for (row = 0; row < qi.length; row++) {
						if (qi[row][column] == line) {
							qi[row][column] = pc;
							count = 0;
							break;
						}
					}
					break;
				}
				// 列出棋盤
				drawMap(qi);
				System.out.println("");

				// 判斷輸贏
				// 判斷直的連線
				if (row >= 3) {
					if (qi[row - 1][column] == pc && qi[row - 2][column] == pc && qi[row - 3][column] == pc) {
						System.out.println("《電腦勝利》");
						qi[row][column] = pcwin;
						qi[row - 1][column] = pcwin;
						qi[row - 2][column] = pcwin;
						qi[row - 3][column] = pcwin;
						drawMap(qi);
						mc.smallgm(0);
						System.out.println("-------------------------------------------");
						break play; // 離開下棋迴圈
					}
				}
				// 判斷衡的連線
				for (int i = 0; i < qi.length; i++) {
					for (int j = 0; j < qi[0].length - 4; j++) {
						if (qi[i][j] == pc && qi[i][j + 1] == pc && qi[i][j + 2] == pc && qi[i][j + 3] == pc) {
							System.out.println("《電腦勝利》");
							qi[i][j] = pcwin;
							qi[i][j + 1] = pcwin;
							qi[i][j + 2] = pcwin;
							qi[i][j + 3] = pcwin;
							drawMap(qi);
							mc.smallgm(0);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}
				// 判斷斜的連線
				// 左下右上
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 3; j++) {
						if (qi[i][j] == pc && qi[i + 1][j + 1] == pc && qi[i + 2][j + 2] == pc
								&& qi[i + 3][j + 3] == pc) {
							System.out.println("《電腦勝利》");
							qi[i][j] = pcwin;
							qi[i + 1][j + 1] = pcwin;
							qi[i + 2][j + 2] = pcwin;
							qi[i + 3][j + 3] = pcwin;
							drawMap(qi);
							mc.smallgm(0);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}
				// 左上右下
				for (int i = 3; i <= 5; i++) {
					for (int j = 0; j <= 3; j++) {
						if (qi[i][j] == pc && qi[i - 1][j + 1] == pc && qi[i - 2][j + 2] == pc
								&& qi[i - 3][j + 3] == pc) {
							System.out.println("《電腦勝利》");
							qi[i][j] = pcwin;
							qi[i - 1][j + 1] = pcwin;
							qi[i - 2][j + 2] = pcwin;
							qi[i - 3][j + 3] = pcwin;
							drawMap(qi);
							mc.smallgm(0);
							System.out.println("-------------------------------------------");
							break play; // 離開下棋迴圈
						}
					}
				}
			}
		}
	}
}
