package ComputerDrill01.g2.h25.Janken;

public class Janken04 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[]{"グー","チョキ","パー"};
		
		
		if( args.length == 0 ){
			System.out.println("0,1,2のいずれかの数値を入力して下さい");
			System.exit(0);
		}
		int you = Integer.parseInt(args[0]);
		System.out.print( "あなた：" + label[you] + "　です。");
		
		// PCのじゃんけんの手を、乱数から決める
		int pc = (int) (Math.random() * 3);
		System.out.print( " PC：" + label[pc] + "　です。");
		
		// TODO: 問題集P１３のやりかたで勝敗を判定する
		if( you == pc ){
			System.out.println("あいこ");
		}else if( you == 0 /* グー */ && pc == 1 /* チョキ */  ||
		    you == 1 /* チョキ　*/ && pc == 2 /* パー */  ||
		    you == 2 /* パー */   &&  pc == 0 /* グー */ ){
			System.out.println("あなたの勝ち!");
		}else{
			System.out.println("あなたの負け");
		}
	}
}
