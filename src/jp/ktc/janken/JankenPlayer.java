package jp.ktc.janken;

public abstract class  JankenPlayer {
	final String[] hands = new String[]{"グー","チョキ","パー"};
	public String name;
	public JankenPlayer(String string) {
		name = string;
	}
	public abstract void decideHand();
	
	String hand;
	public String getHand(){
		return hand;
	}
}
