package db.g4.h24;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * MySQLに関するコードを分離
 * 
 * @author fujisawa
 * 
 */
public class Janken16MySQL {
	static String[] label = new String[] { "グー", "チョキ", "パー" };
	static String[] resultLabel = new String[] { "負け", "勝ち", "あいこ" };
	
	/**
	 * 1: あなたの勝ち、　0:あなたの負け　2: あいこ
	 * 
	 * @param you
	 * @param pc
	 * @return
	 */
	public static int getResult(int you, int pc) {
		int result = -1;
		// SWITCHをつかう
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
			break;
		}
		if (you == pc) {
			result = 2; // あいこ
		} else if (pc == lose) {
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}

	/**
	 * グー、チョキ、パーはint型の０，１，２で表す
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Janken01MySQLUtil db = new Janken01MySQLUtil();
		db.DbInit("jdbc:mysql://localhost/janken?user=root");

		String work = "";
		for (int i = 0; i < 10; i++) {
			// キーボードから入力を受け取る
			System.out.println("じゃんけんゲーム：あと " + (10 - i)
					+ "回出来ます。(途中で終了は q を入力)");
			System.out.print((i + 1) + " 回目　0:グー　１：チョキ　２：パー\nあなたの手は？:");
			Scanner scan = new Scanner(System.in);
			work = scan.next(); // 　文字として取り込む
			if (work.equals("q")) {
				break;
			}
			if (!(work.equals("0") || work.equals("1") || work.equals("2"))) {
				System.out.println("\nエラー：0,1,2のいずれかの数値を入力して下さい\n");
				i--;
				continue;
			}
			int you = Integer.parseInt(work);
			System.out.print("あなた：" + label[you] + "　です。");

			// PCのじゃんけんの手を、乱数から決める
			int pc = (int) (Math.random() * 3);
			System.out.print(" PC：" + label[pc] + "　です。");

			// SWITCHをつかう
			int result = getResult(you, pc);
			System.out.println(resultLabel[result]);

			db.gameLog(i + 1, you, pc,result);
		}
		db.showLog();
		db.showNumOfHands();
		db.showStatistics();
		System.out.println("終了");

		db.DbFinish();
	}
}
