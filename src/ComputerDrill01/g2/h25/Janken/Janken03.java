package ComputerDrill01.g2.h25.Janken;

public class Janken03 {
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
		
		// TODO: 問題３　勝敗の判定を入れる

	}
}
