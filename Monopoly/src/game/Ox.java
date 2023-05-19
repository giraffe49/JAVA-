package game;
import java.util.Scanner;

import game.Mainclass;

public class Ox {

	static Mainclass mc = new Mainclass();

	static int win = 0; // �O�_�ӧQ 1 ->�ӧQ

	public void display() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String game[] = new String[9];
		int X, Y; // ���a��J�y��
		int count; // �w��m���
		int first; // �֥��X�� 0 -> �q�����X
		win = 0;

		System.out.println("---------------------------------------------------------");
		System.out.println("�w��Ө�H����Ԫ����r�C��");
		System.out.println("�H�U�����C�����W�h:");
		System.out.println("�� ���a��o�A�q����x");
		System.out.println("�� ��C��������@�誺�Ÿ��s���@���u(�]�t���u�B��u�B�׽u)�Y���C���ӧQ��");
		System.out.println("");

		all: while (true) {
			// �]�w�q�����X
			first = 0;

			// ��l�ƴѽL
			count = 0;
			for (int i = 0; i < 9; i++) {
				game[i] = " ";
			}

			// �U�Ѱj��
			play: while (count < 9) {

				// �q���U��
				if (first == 0) {
					System.out.println("<�q���X���o~>");
					// ��m�q������
					while (true) {
						int computerGame = (int) (Math.random() * 9);
						if (game[computerGame] == " ") {
							game[computerGame] = "x";
							count++;
							break;
						}
					}
					// �I�s�L�X�ثe�ѽL
					map(game);

					// �I�s�P�_�q���O�_�ӧQ
					finish(game);

					if (win == 1) {
						break all;
					}

					if (count == 9) {
						System.out.println("������������~~�A�̳��ܱj�O!!");
						System.out.println("���N�A���@��,���X�ӭt�a!");
						break play; // ���}�U�Ѱj��,���s�}�l�C��
					}
					first = 1;
				}
				if (first == 1) {
					System.out.println("<����A�X���o~>");
					// ���a�U�Ѱj��
					while (true) {
						// X��m
						while (true) {
							System.out.println("�п�J�Q�n��m��X�y��:");
							X = sc.nextInt();
							if (X <= 3 && X >= 1) {
								break;
							} else {
								System.out.println("�п�J���T���ƭ�");
							}
						}
						// Y��m
						while (true) {
							System.out.println("�п�J�Q�n��m��Y�y��:");
							Y = sc.nextInt();
							if (Y <= 3 && Y >= 1) {
								break;
							} else {
								System.out.println("�п�J���T���ƭ�");
							}
						}
						// ��m���a����
						if (game[(Y - 1) * 3 + X - 1] == " ") {
							game[(Y - 1) * 3 + X - 1] = "o";
							count++;
							break; // ���}���a�U�Ѱj��
						} else {
							System.out.println("�o�Ӧ�m���F���o!�Э��s��J~");
						}
					}

					// �I�s�L�X�ثe�ѽL
					map(game);

					// �I�s�P�_���a�O�_�ӧQ
					finish(game);

					if (win == 1) {
						break all; // �����C��
					}

					if (count == 9) {
						System.out.println("������������~~�A�̳��ܱj�O!!");
						System.out.println("<���N�A���@��,���X�ӭt�a!>");
						break play; // ���}�U�Ѱj��,���s�}�l�C��
					}
					first = 0;
				}
			}
		}
	}

	// �L�X�ѽL��k
	public static void map(String game[]) {
		System.out.println("Y�y��");
		System.out.println(" ��");
		System.out.println("   �z�w�w�w�s�w�w�w�s�w�w�w�{");
		System.out.println(" 1 �x " + game[0] + " �x " + game[1] + " �x" + game[2] + "  �x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println(" 2 �x " + game[3] + " �x " + game[4] + " �x" + game[5] + "  �x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println(" 3 �x " + game[6] + " �x " + game[7] + " �x" + game[8] + "  �x");
		System.out.println("   �|�w�w�w�r�w�w�w�r�w�w�w�}");
		System.out.println("     1   2   3    �� X�y��");
		System.out.println("");

	}

	// �P�_�ӧQ��k
	public static void finish(String game[]) {
		// �׽u
		if (game[0] == game[4] && game[0] == game[8] && game[0] == "o") {
			win = 1;
			System.out.println("���ߪ��a�ӧQ~�A�u�O���r�C������!!!");
			System.out.println("---------------------------------------------------------");
			// �I�sMainClass��smallgm(c)��k,����c,��MainClass�P�_�p�C������Ĺ,c=1 -> �ӧQ
			mc.smallgm(1);
		}
		if (game[0] == game[4] && game[0] == game[8] && game[0] == "x") {
			win = 1;
			System.out.println("���߹q���ӧQ~���a�[�o��~");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(0);
		}
		if (game[2] == game[4] && game[2] == game[6] && game[2] == "o") {
			win = 1;
			System.out.println("���ߪ��a�ӧQ~�A�u�O���r�C������!!!");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(1);
		}
		if (game[2] == game[4] && game[2] == game[6] && game[2] == "x") {
			win = 1;
			System.out.println("���߹q���ӧQ~���a�[�o��~");
			System.out.println("---------------------------------------------------------");
			mc.smallgm(0);
		}
		// ��u
		for (int i = 0; i < 9; i += 3) {
			if (win == 1)
				break;
			if (game[i] == game[i + 1] && game[i] == game[i + 2] && game[i] == "o") {
				win = 1;
				System.out.println("���ߪ��a�ӧQ~�A�u�O���r�C������!!!");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(1);
				break;
			}
			if (game[i] == game[i + 1] && game[i] == game[i + 2] && game[i] == "x") {
				win = 1;
				System.out.println("���߹q���ӧQ~���a�[�o��~");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(0);
				break;
			}
		}
		// ���u
		for (int i = 0; i < 3; i++) {
			if (win == 1)
				break;
			if (game[i] == game[i + 3] && game[i] == game[i + 6] && game[i] == "o") {
				win = 1;
				System.out.println("���ߪ��a�ӧQ~�A�u�O���r�C������!!!");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(1);
				break;
			}
			if (game[i] == game[i + 3] && game[i] == game[i + 6] && game[i] == "x") {
				win = 1;
				System.out.println("���߹q���ӧQ~���a�[�o��~");
				System.out.println("---------------------------------------------------------");
				mc.smallgm(0);
			}
		}
	}
}
