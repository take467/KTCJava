package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

/**
 * 1. 引数ではなく、キーボードからじゃんけんの手を指定する。 
 * 2. "q"　(quit) が入力されるまでじゃんけんを繰り返す
 * 3. 最大１０回勝負
 * @author fujisawa
 * 
 */
public class Janken07 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };

		String work = "";
		for( int i = 0 ; i < 10 ; i++ ) {
			// キーボードから入力を受け取る
			System.out.println("じゃんけんゲーム：あと " + ( 10 - i) + "回出来ます。(途中で終了は q を入力)");
			System.out.print(( i + 1 ) + " 回目　0:グー　１：チョキ　２：パー\nあなたの手は？:");
			Scanner scan = new Scanner(System.in);
			work = scan.next(); // 　文字として取り込む
			if (work.equals("q")) {
				break;
			}
			int you = Integer.parseInt(work);
			System.out.print("あなた：" + label[you] + "　です。");

			// PCのじゃんけんの手を、乱数から決める
			int pc = (int) (Math.random() * 3);
			System.out.print(" PC：" + label[pc] + "　です。");

			// SWITCHをつかう
			int lose = -1;
			switch (you) {
			case 0: /* グー */
				lose = 1;
				break; // チョキ
			case 1: /* チョキ */
				lose = 2;
				break; // パー
			case 2: /* パー */
				lose = 0;
				break; // グー
			}
			if (you == pc) {
				System.out.println("あいこ\n");
			} else if (pc == lose) {
				System.out.println("あなたの勝ち!\n");
			} else {
				System.out.println("あなたの負け\n");
			}
		}
		System.out.println("終了");
	}
}
