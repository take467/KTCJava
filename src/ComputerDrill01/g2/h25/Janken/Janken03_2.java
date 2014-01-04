package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

public class Janken03_2 {
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
		String work =  scan.next(); //　文字として取り込む
		int you = Integer.parseInt(work);
		System.out.print( "あなた：" + label[you] + "　です。");
		
		// PCのじゃんけんの手を、乱数から決める
		int pc = (int) (Math.random() * 3);
		System.out.print( " PC：" + label[pc] + "　です。");

	}
}
