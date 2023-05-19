package game;
import java.util.Scanner;

import game.Mainclass;

public class Mora {
	
	static Mainclass mc = new Mainclass();
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		int user,computer;
	    String start[] = {"剪刀","石頭","布"};
		System.out.println("現在是猜拳的環節");
		System.out.println("請輸入想出的拳吧!");
		while(true) {
			System.out.println("1. 剪刀\n2. 石頭\n3. 布");
			user=sc.nextInt();
			if(user<1||user>3) {
				System.out.println("輸入錯誤，請輸入1~3之間的整數");
				continue;
			}
			computer=(int)(Math.random()*3)+1;
			System.out.println("電腦出的是:"+start[computer-1]);
			if(user==computer) {
				System.out.println("居然平手了!再進行一次吧!");
				continue;
			}
			if(user==1 && computer==3) {
				System.out.println("玩家贏了~");
				mc.smallgm(1);
				break;
			}
			if(user==3 && computer==1) {
				System.out.println("電腦贏了~鬼來囉!");
				mc.smallgm(0);
				break;
			}
			if(user==1 && computer==2) {
				System.out.println("電腦贏了~鬼來囉!");
				mc.smallgm(0);
				break;
			}
			if(user==2 && computer==1) {
				System.out.println("玩家贏了~");
				mc.smallgm(1);
				break;
			}
			if(user==2 && computer==3) {
				System.out.println("電腦贏了~鬼來囉!");
				mc.smallgm(0);
				break;
			}
			if(user==3 && computer==2) {
				System.out.println("玩家贏了~");
				mc.smallgm(1);
				break;
			}
		}
	}
	
}
