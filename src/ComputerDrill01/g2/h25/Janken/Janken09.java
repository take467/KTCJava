package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

/**
 * 1. 引数ではなく、キーボードからじゃんけんの手を指定する。 
 * 2. "q"　(quit) が入力されるまでじゃんけんを繰り返す
 * 3. 最大１０回勝負
 * 4. 勝率を表示
 * 5. 勝敗の履歴を表示（ 1: 勝ち 0:負け 2: あいこ)
 * @author fujisawa
 * 
 */
public class Janken09 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };
		int[] winLog = new int[10];
		for( int i = 0 ; i < 10 ; i++ ){
			winLog[i] = -1;
		}

		String work = "";
		for( int i = 0 ; i < 10 ; i++ ) {
			// キーボードから入力を受け取る
			System.out.println("\nじゃんけんゲーム：あと " + ( 10 - i) + "回出来ます。(途中で終了は q を入力)");
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
				winLog[i] = 2;
			} else if (pc == lose) {
				System.out.println("あなたの勝ち!\n");
				winLog[i] = 1;
			} else {
				System.out.println("あなたの負け\n");
				winLog[i] = 0;
			}
		}
		int winCount = 0;
		int loseCount = 0;
		int gameCount = 0;
		for( int i = 0 ; i < winLog.length ; i++ ){
			if( winLog[i] == -1 ){
				break;
			}
			String msg = "あいこ";
			switch( winLog[i] ){
				case 1: 
					msg = "あなたの勝ち"; 
					winCount++;
					break;
				case 0: 
					msg = "あなたの負け"; 
					loseCount++;
					break;
			}
			gameCount++;
			//System.out.print(gameCount + "回目；");

			//System.out.println(msg);
		}
		System.out.println("終了");
		System.out.println(winCount + "勝," + loseCount + "敗、" + ( gameCount - winCount - loseCount ) + "引き分け");
		if( winCount > loseCount ){
			System.out.println("あなたの勝ち!");
		}else if( winCount < loseCount ){
			System.out.println("あなたの負け");
		}else{
			System.out.println("引き分け");
		}

	}
}
