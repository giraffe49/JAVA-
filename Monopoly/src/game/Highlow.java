package game;
import java.util.Scanner;

import game.Mainclass;

public class Highlow {

	static Mainclass mc = new Mainclass();

	public void display() {
		Scanner sc = new Scanner(System.in);
		int x, computer, number, first = 1;
		System.out.println("���U�ӬO��j�p�����`");
		System.out.println("�|�H����j�Τ�p");
		while (first == 1) {
			while (true) {
				System.out.println("�п�J�@�Ӥ���1~10���Ʀr:");
				x = sc.nextInt();
				if (x >= 1 && x <= 10) {
					break;
				} else {
					System.out.println("��J���~,�Э��s��J");
				}
			}
			computer = (int) (Math.random() * 10) + 1;
			System.out.println("�q���X���O:" + computer);
			number = (int) (Math.random() * 2);
			if (number == 1) {
				if (x > computer) {
					System.out.println("�o���O��j�A���ߪ��a���");
					mc.smallgm(1);
				} else if (x < computer) {
					System.out.println("�o���O��j�A���߹q�����");
					System.out.println("");
					mc.smallgm(0);
				}
			}
			first = 0;
			if (number == 0) {
				if (x > computer) {
					System.out.println("�o���O��p�A���߹q�����");
					System.out.println("");
					mc.smallgm(0);
				} else if (x < computer) {
					System.out.println("�o���O��p�A���ߪ��a���");
					mc.smallgm(1);
				}
			}
			first = 0;
			if (x == computer) {
				System.out.println("����A�A���@��!");
				first = 1;
			}
		}
	}
}
