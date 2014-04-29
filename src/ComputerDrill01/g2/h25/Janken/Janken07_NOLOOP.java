package ComputerDrill01.g2.h25.Janken;

public class Janken07_NOLOOP {
	public static void main(String[] args) {
		String[] label = new String[] { "グー", "チョキ", "パー" };

		String work = "";
		START: {
			System.out.print("0:グー　１：チョキ　２：パー\nあなたの手は？:");
			java.util.Scanner scan = new java.util.Scanner(System.in);
			work = scan.next();
			if (work.equals("q")) {
				System.exit(0);
			}

			int you, pc;

			you = Integer.parseInt(work);
			System.out.print("あなた：" + label[you] + "　です。");

			// PCのじゃんけんの手を、乱数から決める
			pc = (int) (Math.random() * 3);
			System.out.print(" PC：" + label[pc] + "　です。");

			int lose = -1;

			switch (you) {
			case 0: /* グー */
				lose = 1;
				break; // チョキ
			case 1: /* チョキ */
				lose = 2;
				break; // パー
			case 2: /* パー */
				lose = 0;
				break; // グー
			}

			if (you == pc) {
				System.out.println("あいこ\n");
			} else if (pc == lose) {
				System.out.println("あなたの勝ち!\n");
			} else {
				System.out.println("あなたの負け\n");
			}
			
			break START;
		}
		System.out.println("終了");
	}
}
