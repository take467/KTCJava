package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

/**
 * 1. 引数ではなく、キーボードからじゃんけんの手を指定する。 
 * 2. "q"　(quit) が入力されるまでじゃんけんを繰り返す
 * 3. 最大１０回勝負
 * 4. 勝率を表示
 * @author fujisawa
 * 
 */
public class Janken08 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };

		int winCount = 0;
		int loseCount = 0;
		String work = "";
		for( int i = 0 ; i < 10 ; i++ ) {
			// キーボードから入力を受け取る
			System.out.println("\n\nじゃんけんゲーム：あと " + ( 10 - i) + "回出来ます。(途中で終了は q を入力)");
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
				System.out.println("あいこ");
			} else if (pc == lose) {
				System.out.println("あなたの勝ち!");
				winCount++;
				
			} else {
				System.out.println("あなたの負け");
				loseCount++;
			}
			//double winRate = (double) winCount / ( i + 1) * 100.0;  
			//System.out.println("勝率:" + winRate + "%");
			System.out.println(winCount + "勝　" + loseCount + "敗");
		}
		//System.out.print("\n終了\n" + winCount + "勝　" + loseCount + "敗で");
		System.out.println("終了");
		if( winCount > loseCount ){
			System.out.println("あなたの勝ち!");
		}else if( winCount < loseCount ){
			System.out.println("あなたの負け");
		}else{
			System.out.println("引き分け");
		}
	}
}
