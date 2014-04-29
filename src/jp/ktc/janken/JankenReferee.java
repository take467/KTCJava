package jp.ktc.janken;

public class JankenReferee {
	/**
	 * ルール　
	 * 
	 * hand1 対　hand2　で hand1が勝つのは、
	 * グー   　　チョキ
	 * チョキ    パー
	 * パー　　　　グー
	 */
	public JankenPlayer judge(JankenPlayer player1, JankenPlayer player2) {
		
		String hand1 = player1.getHand();
		String hand2 = player2.getHand();
		
		JankenPlayer winner = null;
		if( hand1.equals(hand2)){
			// 同じなのでアイコ
			return null;
		}else{
			winner = player2; // PCが勝つと仮定する
			
			// 人が勝つパターンなら winner を入れ替える
			if(hand1.equals("グー") &&  hand2.equals("チョキ")){
				winner =  player1;
			}else if( hand1.equals("チョキ") && hand2.equals("パー")) {
				winner =  player1;
			}else if( hand1.equals("パー") &&  hand2.equals("グー")){
				winner =  player1;
			}
		}
		return winner ;
	}
}
