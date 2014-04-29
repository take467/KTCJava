package se.g5.h25.Janken;
public class Janken {

	public int getComputerHand(){
		int pc = (int) (Math.random() * 3);
		return pc;
	}
	public int judgeNew(int you,int pc){
		if( you == pc ){
			return 2;
		}else if( you == 0 /* グー */ && pc == 1 /* チョキ */  ||
		    you == 1 /* チョキ　*/ && pc == 2 /* パー */  ||
		    you == 2 /* パー */   &&  pc == 0 /* グー */ ){
			return 1;
		}else{
			return 0;
		}
	}

	// 1: 勝ち 0:負け  2:あいこ
	public int judge(int you,int pc){
		// PCが負ける手を求める
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
		// 結果判定
		if (you == pc) {
			return 2;
		} else if (pc == lose) {
			return 1;
		} else {
			return 0;
		}
	}
	public int showResult(int winCount,int loseCount,int numOfPlay){
		if( winCount > numOfPlay - winCount ){
			System.out.println("あなたの勝ち!");
			return 1;
		}else if( winCount ==  loseCount ){
			System.out.println("引き分け");
			return 2;
		}else{
			System.out.println("あなたの負け");
			return 0;
		}
	}
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };

		Player p = new Player();
		Janken janken = new Janken();
		int winCount = 0;
		int loseCount = 0;
		String work = "";
		for( int i = 0 ; i < 10 ; i++ ) {
			// キーボードから入力を受け取る
			System.out.println("\n\nじゃんけんゲーム：あと " + ( 10 - i) + "回出来ます。(途中で終了は q を入力)");
			System.out.print(( i + 1 ) + " 回目　");
			String msg = "0:グー　１：チョキ　２：パー\nあなたの手は？:";
			work = p.selectHand(msg);
			if (work.equals("q")) {
				break;
			}
			int you = Integer.parseInt(work);
			System.out.print("あなた：" + label[you] + "　です。");

			// PCのじゃんけんの手を、乱数から決める
			int pc = janken.getComputerHand();
			System.out.print(" PC：" + label[pc] + "　です。");
		
			int result = janken.judge(you,pc);
			switch (result) {
			case 1: 
				System.out.println("あなたの勝ち!");
				winCount++;
				break; 
			case 0: 
				System.out.println("あなたの負け");
				break; 
			case 2: 
				System.out.println("あいこ");
				break; 
			}
		}
		System.out.print("\n終了\n" + winCount + "勝　" + loseCount + "敗で、");
		janken.showResult(winCount, loseCount, 10);
		//System.out.println("終了");

	}
}
