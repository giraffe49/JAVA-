package game;

import java.util.Scanner;

public class Cat {

	String game[][];
	static int h = 8, w = 8;
	static int c;

	Mainclass mc = new Mainclass();

	// 畫出棋盤
	public static void drawMap(String[][] game) {
		System.out.println("Y");
		System.out.println("↓");
		for (int i = game.length - 1; i >= 0; i--) {
			System.out.print(i + 1);
			System.out.print(" ");
			for (int j = 0; j < game[0].length; j++) {
				System.out.print(game[i][j]);
			}
			System.out.println("");
		}
		System.out.print("  ");
		for (int j = 1; j <= w; j++) {
			System.out.print(j + " ");
		}
		System.out.print(" -> X");
		System.out.println("");
	}

	public void display() {
		int pch, pcw;
		int plh, plw;
		int count = 0;
		int full = 1;
		String line = "□ ";
		String play = "■ ";
		String cat = "😺";
		Scanner sc = new Scanner(System.in);

		System.out.println("這是圍圍神經貓");

		String game[][] = new String[h][w];

		// 棋盤初始化
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[0].length; j++) {
				game[i][j] = line;
			}
		}

		// 隨機神經貓
		while (true) {
			pch = (int) (Math.random() * h);
			pcw = (int) (Math.random() * w);
			if (pch >= 2 && pch <= (h - 3) && pcw >= 2 && pcw <= (w - 3)) {
				game[pch][pcw] = cat;
				break;
			}
		}
		// 印出棋盤
		drawMap(game);

		playgame: while (true) {
			// 玩家放棋
			while (true) {
				System.out.println("請輸入要擺放的位置");
				while (true) {
					System.out.println("x:");
					plw = sc.nextInt();
					if (plw >= 0 && plw <= 8) {
						break;
					} else {
						System.out.println("輸入錯誤,請重新輸入!");
					}
				}
				while (true) {
					System.out.println("y:");
					plh = sc.nextInt();
					if (plh >= 1 && plh <= 8) {
						break;
					} else {
						System.out.println("輸入錯誤,請重新輸入!");
					}
				}
				if (game[plh - 1][plw - 1] == line) {
					game[plh - 1][plw - 1] = play;
					count++;
					full++;
					break;
				}else {
					System.out.println("這個位置滿了,請重新輸入");
				}

			}
			// 判斷輸贏
			if (full == h * w) {
				if (!(pch >= 1 && pch <= (h - 2) && pcw >= 1 && pcw <= (w - 2))) {
					// 印出棋盤
					drawMap(game);

					System.out.println("貓逃走了!鬼來囉!");
					mc.smallgm(0);
					break playgame;
				} else {
					// 印出棋盤
					drawMap(game);

					System.out.println("抓到神經貓啦!");
					mc.smallgm(1);
					break playgame;
				}
			} else if (pch >= 1 && pch <= (h - 2) && pcw >= 1 && pcw <= (w - 2)) {
				if (game[pch - 1][pcw - 1] == play && game[pch][pcw - 1] == play && game[pch + 1][pcw - 1] == play
						&& game[pch + 1][pcw] == play && game[pch + 1][pcw + 1] == play && game[pch][pcw + 1] == play
						&& game[pch - 1][pcw + 1] == play && game[pch - 1][pcw] == play) {
					// 印出棋盤
					drawMap(game);

					System.out.println("恭喜抓到神經貓啦!");
					mc.smallgm(1);
					break playgame;
				}
			}

			// 初始神經貓
			game[pch][pcw] = line;
			// 神經貓走走
			System.out.println("");
			int a = 0;
			while (a == 0) {
				int pc = (int) (Math.random() * 8) + 1;
				switch (pc) {
				case 1:
					if (game[pch + 1][pcw - 1] == line) {
						pch = pch + 1;
						pcw = pcw - 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 2:
					if (game[pch + 1][pcw] == line) {
						pch = pch + 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 3:
					if (game[pch + 1][pcw + 1] == line) {
						pch = pch + 1;
						pcw = pcw + 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 4:
					if (game[pch][pcw - 1] == line) {
						pcw = pcw - 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 5:
					if (game[pch][pcw + 1] == line) {
						pcw = pcw + 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 6:
					if (game[pch - 1][pcw - 1] == line) {
						pch = pch - 1;
						pcw = pcw - 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 7:
					if (game[pch - 1][pcw] == line) {
						pch = pch - 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				case 8:
					if (game[pch - 1][pcw + 1] == line) {
						pch = pch - 1;
						pcw = pcw + 1;
						game[pch][pcw] = cat;
						a = 1;
						break;
					}
				}

			}
			// 印出棋盤
			drawMap(game);

			// 判斷輸贏
			if (!(pch >= 1 && pch <= (h - 2) && pcw >= 1 && pcw <= (w - 2))) {
				System.out.println("貓逃走了!鬼來囉!");
				mc.smallgm(0);
				break playgame;
			}

			if (full == h * w) {
				if (!(pch >= 1 && pch <= (h - 2) && pcw >= 1 && pcw <= (w - 2))) {
					// 印出棋盤
					drawMap(game);

					System.out.println("貓逃走了!鬼來囉!");
					mc.smallgm(0);
					break playgame;
				} else {
					// 印出棋盤
					drawMap(game);

					System.out.println("抓到神經貓啦!");
					mc.smallgm(1);
					break playgame;
				}
			} else if (pch >= 1 && pch <= (h - 2) && pcw >= 1 && pcw <= (w - 2)) {
				if (game[pch - 1][pcw - 1] == play && game[pch][pcw - 1] == play && game[pch + 1][pcw - 1] == play
						&& game[pch + 1][pcw] == play && game[pch + 1][pcw + 1] == play && game[pch][pcw + 1] == play
						&& game[pch - 1][pcw + 1] == play && game[pch - 1][pcw] == play) {
					// 印出棋盤
					drawMap(game);

					System.out.println("恭喜抓到神經貓啦!");
					mc.smallgm(1);
					break playgame;
				}
			}

		}
	}
}
