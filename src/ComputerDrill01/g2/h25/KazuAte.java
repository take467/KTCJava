package ComputerDrill01.g2.h25;

public class KazuAte {
	public static void main(String[] args) {
		if( args.length > 0 ){
			int seikai = -100;
			String hikisu = args[0];
			int kaitou = Integer.parseInt(hikisu);
			
			int offset = seikai - kaitou;
			
			if(true /* TODO: 書き換え */ ){
				System.out.println("残念！もっと大きい数です．");
			}
			if(true /* TODO: 書き換え*/ ){
				System.out.println("残念！もっと小さい数です.");
			}
			if( true /* TODO: 書き換え */ ){
				System.out.println("正解！答えは " + hikisu + " でした.");
			}
		}
	}

}
