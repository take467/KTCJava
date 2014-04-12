package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

public class Janken06 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[]{"グー","チョキ","パー"};
		
		// キーボードから入力を受け取る
		System.out.print("0:グー　１：チョキ　２：パー\nあなたの手は？:");
		Scanner scan = new Scanner(System.in);
		int you = scan.nextInt(); // 　文字として取り込む
		
		System.out.print( "あなた：" + label[you] + "　です。");
		
		// PCのじゃんけんの手を、乱数から決める
		int pc = (int) (Math.random() * 3);
		System.out.print( " PC：" + label[pc] + "　です。");
		
		// SWITCHをつかう
		int lose = -1;
		switch( you ){
		case 0 : /* グー */
			lose = 1 ; break; // チョキ
		case 1 : /* チョキ */
			lose = 2 ; break; // パー
		case 2 : /* パー */
			lose = 0 ; break; // グー
		}
		if( you == pc ){
			System.out.println("あいこ");
		}else if( pc == lose ){
			System.out.println("あなたの勝ち!");
		}else{
			System.out.println("あなたの負け");
		}
		
		System.out.println("終了\n");
	}
}
