package jp.ktc.janken;

public class HumanJankenPlayer extends JankenPlayer {

	public HumanJankenPlayer(String string) {
		super(string);
	}
	@Override
	public void decideHand() {
		hand = null;
		while(hand == null ){
			System.out.print("0:グー 1:チョキ 2:パー\nあなたの手は?:"); 
			java.util.Scanner scan = new java.util.Scanner(System.in);
			int no = -1;
			try {
				no = scan.nextInt(); // int 型の値として取り込む
			}catch(Exception e){}
			if( no == 0 || no == 1 || no == 2 ){
				hand = hands[no];
			}
		}
	}
}
