package se.g5.h25;

import java.util.Random;

public class StrategySample {

	public static void main(String[] args) {
		Player player1 = new Player("青木",new WinningStrategy());
		Player player2 = new Player("井上",new ProbStrategy());
		
		for(int i = 0 ; i < 10000 ; i++ ){
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			
			if( nextHand1.isStrongerThan(nextHand2)){
				System.out.println("勝者:" + player1);
				player1.win();
				player2.lose();
			}else if( nextHand2.isStrongerThan(nextHand1)){
				System.out.println("勝者:" + player2);
				player2.win();
				player1.lose();
			}else{
				System.out.println("引き分け....");
				player1.even();
				player2.even();
			}
		}
		System.out.println("総合結果");
		System.out.println("" + player1);
		System.out.println("" + player2);
	}

}
interface Strategy {
	public abstract Hand nextHand();
	public abstract void study(boolean win);
}


class Hand {
	public static final int HANDVALUE_GUU = 0; // グー
	public static final int HANDVALUE_CHO = 1;
	public static final int HANDVALUE_PAA = 2;
	private    int handvalue;
	private Hand( int handvalue){
		this.handvalue = handvalue;
	}
	public static final Hand[] hand = { new Hand(HANDVALUE_GUU),new Hand(HANDVALUE_CHO),new Hand(HANDVALUE_PAA)};
	private static final String[] name = {
		"グー",
		"チョキ",
		"パー"
	};
	public static Hand getHand(int handvalue){
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h){
		return fight(h) == 1;
	}
	public boolean isWeakerThan(Hand h){
		return fight(h) == -1;
	}
	private int fight(Hand h){  // 引き分けは０，自分が勝ちなら１，負けなら−１を返す．
		if( this  == h ){
			return 0;
		}else if( (this.handvalue + 1 ) % 3 == h.handvalue ){
			return 1;
		}else{
			return -1;
		}
	}
	public String toString(){
		return name[handvalue];
	}
}

class WinningStrategy implements Strategy{
	private Random random;
	private boolean won = false;
	private Hand preHand ;
	public WinningStrategy(){
        Random rnd = new Random();

        int ran = rnd.nextInt(3);
		random = new Random(ran);
	}
	public Hand nextHand() {
		if( ! won ){
			preHand = Hand.getHand(random.nextInt(3));
		}
		return preHand;
	}
	public void study(boolean win) {
		won = win;
	}
}
class ProbStrategy implements Strategy {

	private Random random;
	private int prevHandValue =  0;
	private int currentHandValue = 0;
	private int[][] history = {
		{1,1,1},
		{1,1,1},
		{1,1,1}
	};
	public ProbStrategy(){
        Random rnd = new Random();

        int ran = rnd.nextInt(10);
		random = new Random(ran);
	}
	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = 0;
		if ( bet < history[currentHandValue][0]){
			handvalue = 0;
		}else if(bet < history[currentHandValue][0] + history[currentHandValue][1] ){
			handvalue = 1;
		}else{
			handvalue = 2;
		}
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}
	private int getSum(int hv){
		int sum = 0;
		for( int i = 0 ; i < 3 ; i++ ){
			sum += history[hv][i];
		}
		return sum;
	}
	
	public void study(boolean win) {
		// TODO Auto-generated method stub
		if( win ){
			history[prevHandValue][currentHandValue]++;
		}else{
			history[prevHandValue][(currentHandValue + 1) % 3 ]++;
			history[prevHandValue][(currentHandValue + 2) % 3 ]++;		
		}
	}
	
}
class Player{
	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	
	public Player(String name,Strategy strategy){
		this.name = name;
		this.strategy = strategy;
	}
	public Hand nextHand(){
		return strategy.nextHand();
	}
	public void win(){
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	public void lose(){
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	public void even(){
		gamecount++;
	}
	public String toString(){
			return "[" + name +":" + gamecount + "ゲーム, " + wincount + "勝, " + losecount + "負, " + "]";
	}
}
