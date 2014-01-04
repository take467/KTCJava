package ComputerDrill01.g2.h25.Janken;

import java.util.Scanner;

/**
 * 1. 引数ではなく、キーボードからじゃんけんの手を指定する。 
 * 2. "q"　(quit) が入力されるまでじゃんけんを繰り返す
 * 3. 最大１０回勝負
 * 4. 勝率を表示
 * 5. 勝敗の履歴を表示（ 1: 勝ち 0:負け 2: あいこ)
 * 6. エラー処理の追加
 * 7. お互いの手を記憶して履歴に表示
 * @author fujisawa
 * 
 */
public class Janken10 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };
		int[] gameLog = new int[10];
		int[] youLog = new int[10];
		int[] pcLog  = new int[10];
 		for( int i = 0 ; i < 10 ; i++ ){
			gameLog[i] = -1;
		}

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
			if( ! ( work.equals("0") || work.equals("1") || work.equals("2") ) ){
				System.out.println("\nエラー：0,1,2のいずれかの数値を入力して下さい\n");
				i--;
				continue;
			}
			int you = Integer.parseInt(work);
			youLog[i]= you;
			System.out.print("あなた：" + label[you] + "　です。");

			// PCのじゃんけんの手を、乱数から決める
			int pc = (int) (Math.random() * 3);
			pcLog[i] = pc;
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
				gameLog[i] = 2;
			} else if (pc == lose) {
				System.out.println("あなたの勝ち!\n");
				gameLog[i] = 1;
			} else {
				System.out.println("あなたの負け\n");
				gameLog[i] = 0;
			}
		}
		int winCount = 0;
		int loseCount = 0;
		int gameCount = 0;
		for( int i = 0 ; i < gameLog.length ; i++ ){
			if( gameLog[i] == -1 ){
				break;
			}
			String msg = "あいこ";
			switch( gameLog[i] ){
				case 1: 
					msg = "勝ち"; 
					winCount++;
					break;
				case 0: 
					msg = "負け"; 
					loseCount++;
					break;
			}
			gameCount++;
			System.out.print(gameCount + "回目；");
			
			int you = youLog[i];
			int pc  = pcLog[i];
			System.out.print("あなた：" + label[you] + " , PC:" + label[pc] + " => ");
			System.out.println(msg);
		}
		double winRate = (double) winCount / gameCount * 100.0;  
		System.out.println(winCount + "勝," + loseCount + "敗、" + ( gameCount - winCount - loseCount ) + "引き分け　勝率：" +  + winRate + "%");
		System.out.println("終了");
	}
}
