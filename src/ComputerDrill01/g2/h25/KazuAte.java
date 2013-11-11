package ComputerDrill01.g2.h25;

public class KazuAte {
	public static void main(String[] args) {
		if( args.length == 0 ){
			System.out.println("引数に正解を予想した数を指定して下さい．");
		}else {
			int seikai = -100;
			String hikisu = args[0];
			int kaitou = Integer.parseInt(hikisu);
			
			int offset = seikai - kaitou;
			
			if( offset > 0 ){
				if( offset < 10 ){
					System.out.println("残念！正解はもうちょっと大きい数です．");
				}else{
					System.out.println("残念！正解はずっと大きい数です．");
				}
			}else if( offset < 0  ){
				if( offset > -10 ){
					System.out.println("残念！正解はもうちょっと小さい数です.");
				}else{
					System.out.println("残念！正解はずっと小さい数です.");
				}
			}else{
				System.out.println("正解！答えは " + hikisu + " でした.");
			}
		}
	}
}
