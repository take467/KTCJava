package ComputerDrill01.g2.h25;

public class KazuAte {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("異常終了：引数を指定して下さい。");
		} else {
			int seikai = 74;
			int count = 1;
			for (int i = 0; i < args.length; i++, count++) {
				String hikisu = args[i];
				int kaitou = Integer.parseInt(hikisu);
				int offset = 0;
				if (seikai > kaitou) {
					System.out.print("残念！もっと大きい数で、");
					offset = seikai - kaitou;
				} else if (seikai < kaitou) {
					System.out.print("残念！もっと小さい数で、");
					offset = kaitou - seikai; // 今度は解答から正解を引く
				}

				if (seikai == kaitou) {
					System.out.println("正解！答えは " + hikisu + " でした.");
					System.out.println(count + "回目で正解しました！");
					break;
				} else {
					if (offset <= 10) {
						System.out.println("差分は１０以下です。");
					} else if (offset > 10 && offset < 50) {
						System.out.println("差分は１１以上、４９以下です。");
					} else {
						System.out.println("差分は５０以上です。");
					}
				}
			}
		}
	}
}
