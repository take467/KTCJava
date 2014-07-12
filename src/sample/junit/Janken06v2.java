package sample.junit;

import java.util.Scanner;
public class Janken06v2 {

		/**
		 * グー、チョキ、パーはint型の０，１，２で表す
		 *
		 * @param args
		 */
		public static void main(String[] args) {
			Janken06v2 j = new Janken06v2();
			
			
			// キーボードから入力を受け取る
			int you = j.getHumanHand();
			
			// PCのじゃんけんの手を、乱数から決める
			int pc  = j.getComputerHand();
			
			String result = j.judge(you,pc);
			
			
			
			String[] label = new String[]{"グー","チョキ","パー"};
						
			System.out.print( "あなた：" + label[you] + "　です。");
			System.out.print( " PC：" + label[pc] + "　です。");
			System.out.print(result);
			System.out.println("終了\n");
		}

		public String judge(int you, int pc) {
			String result ;
			int lose = -1;
			switch( you ){
			case 0 : /* グー */
				lose = 1 ; break; // チョキ
			case 1 : /* チョキ */
				lose = 2 ; break; // パー
			case 2 : /* パー */
				lose = 0 ; break; // グー
			}
			if( you == pc ){
				result ="あいこ";
			}else if( pc == lose ){
				result = "あなたの勝ち!";
			}else{
				result = "あなたの負け";
			}
			return result;
		}

		public int getComputerHand() {
			int pc = (int) (Math.random() * 3);
			return pc;
		}

		public int getHumanHand() {
			System.out.print("0:グー　１：チョキ　２：パー\nあなたの手は？:");
			Scanner scan = new Scanner(System.in);
			int you = scan.nextInt(); // 　文字として取り込む
			return you;
		}
	}