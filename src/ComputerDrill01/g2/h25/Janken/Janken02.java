package ComputerDrill01.g2.h25.Janken;

public class Janken02 {
	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * こちらの手はコマンドラインから　０、１，２のいずれかの値を入力する
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String[] label = new String[]{"グー","チョキ","パー"};
		// TODO: 問題２　コマンドラインからの引数が入力されなかったら入力を促すメッセージを
		//              表示する
		int you = Integer.parseInt(args[0]);
		System.out.println( you + "　は　" + label[you] + "　です。");
	}
}
