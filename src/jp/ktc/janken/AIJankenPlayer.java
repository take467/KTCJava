package jp.ktc.janken;

public class AIJankenPlayer extends JankenPlayer {
	
	public AIJankenPlayer(String string) {
		super(string);
	}

	@Override
	public void decideHand() {
		int no = (int) (Math.random() * 3); 
		hand = hands[no];
	}
}
