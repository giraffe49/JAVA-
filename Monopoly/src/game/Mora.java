package game;
import java.util.Scanner;

import game.Mainclass;

public class Mora {
	
	static Mainclass mc = new Mainclass();
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		int user,computer;
	    String start[] = {"�ŤM","���Y","��"};
		System.out.println("�{�b�O�q�������`");
		System.out.println("�п�J�Q�X�����a!");
		while(true) {
			System.out.println("1. �ŤM\n2. ���Y\n3. ��");
			user=sc.nextInt();
			if(user<1||user>3) {
				System.out.println("��J���~�A�п�J1~3���������");
				continue;
			}
			computer=(int)(Math.random()*3)+1;
			System.out.println("�q���X���O:"+start[computer-1]);
			if(user==computer) {
				System.out.println("�~�M����F!�A�i��@���a!");
				continue;
			}
			if(user==1 && computer==3) {
				System.out.println("���aĹ�F~");
				mc.smallgm(1);
				break;
			}
			if(user==3 && computer==1) {
				System.out.println("�q��Ĺ�F~�����o!");
				mc.smallgm(0);
				break;
			}
			if(user==1 && computer==2) {
				System.out.println("�q��Ĺ�F~�����o!");
				mc.smallgm(0);
				break;
			}
			if(user==2 && computer==1) {
				System.out.println("���aĹ�F~");
				mc.smallgm(1);
				break;
			}
			if(user==2 && computer==3) {
				System.out.println("�q��Ĺ�F~�����o!");
				mc.smallgm(0);
				break;
			}
			if(user==3 && computer==2) {
				System.out.println("���aĹ�F~");
				mc.smallgm(1);
				break;
			}
		}
	}
	
}
