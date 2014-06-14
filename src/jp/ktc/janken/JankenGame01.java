package jp.ktc.janken;


public class JankenGame01 {

	public static void main(String[] args) {

		// プレイヤー（人）
		JankenPlayer human = new HumanJankenPlayer("あなた");
		// プレイヤー（PC）
		JankenPlayer pc		= new AIJankenPlayer("PC");	
		// 審判
		JankenReferee	referee = new  JankenReferee();

		// 勝負開始！
		human.decideHand();
		pc.decideHand();
		
		// どっちが勝ったのかを判定し、勝った方のインスタンスがwinnerにセットさせる
		JankenPlayer winner = referee.judge(human,pc);
		
		// 勝敗を表示する
		if( winner == null ){
			System.out.print("アイコ" );
		}else{
			System.out.print(winner.name + "の勝ち　"); 
		}
		System.out.println("[" + human.name + ":" + human.getHand() + " " + pc.name + ":" + pc.getHand() + "]");
	}
}
