package game;
import java.util.Scanner;

import game.Mainclass;

public class Highlow {

	static Mainclass mc = new Mainclass();

	public void display() {
		Scanner sc = new Scanner(System.in);
		int x, computer, number, first = 1;
		System.out.println("接下來是比大小的環節");
		System.out.println("會隨機比大或比小");
		while (first == 1) {
			while (true) {
				System.out.println("請輸入一個介於1~10的數字:");
				x = sc.nextInt();
				if (x >= 1 && x <= 10) {
					break;
				} else {
					System.out.println("輸入錯誤,請重新輸入");
				}
			}
			computer = (int) (Math.random() * 10) + 1;
			System.out.println("電腦出的是:" + computer);
			number = (int) (Math.random() * 2);
			if (number == 1) {
				if (x > computer) {
					System.out.println("這局是比大，恭喜玩家獲勝");
					mc.smallgm(1);
				} else if (x < computer) {
					System.out.println("這局是比大，恭喜電腦獲勝");
					System.out.println("");
					mc.smallgm(0);
				}
			}
			first = 0;
			if (number == 0) {
				if (x > computer) {
					System.out.println("這局是比小，恭喜電腦獲勝");
					System.out.println("");
					mc.smallgm(0);
				} else if (x < computer) {
					System.out.println("這局是比小，恭喜玩家獲勝");
					mc.smallgm(1);
				}
			}
			first = 0;
			if (x == computer) {
				System.out.println("平手，再玩一次!");
				first = 1;
			}
		}
	}
}
