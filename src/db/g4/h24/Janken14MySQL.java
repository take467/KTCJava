package db.g4.h24;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * 1. 引数ではなく、キーボードからじゃんけんの手を指定する。 
 * 2. "q"　(quit) が入力されるまでじゃんけんを繰り返す 
 * 3. 最大１０回勝負 
 * 
 * 5. 勝敗の履歴をデータベースに保存（ 1: 勝ち 0:負け 2: あいこ) 
 * 6. エラー処理の追加 
 * 7. お互いの手の履歴を表示
 * 8.  勝率をSQLで計算して表示
 * 9. 過去の対戦成績をずっと保存する -　jankenLog03 
 *   ただし、これだと、更新障害が発生するので正規化しないと行けない！！あ、正規化ではないか。。PlayLogテーブルでplayIdを管理するだけか。
 
  * 
  create view  jankenLog03_v as select j.playId,j.no ,j.you,u.label as YouLabel,j.pc,p.label as PCLabel,j.result,r.label  as ResultLabel from jankenLog03 j
  inner join label u  on u.val = j.you
  inner join label p  on p.val = j.pc
  inner join resultLabel r  on r.result = j.result
 * 
 * 
 * @author fujisawa
 * 
 */
public class Janken14MySQL {
	static Connection conn = null;
	static String[] label = new String[] { "グー", "チョキ", "パー" };
	static String[] resultLabel = new String[] { "負け", "勝ち", "あいこ" };
	
	static  int playID = -1;

	public static void DbInit() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost/janken?user=root");
		
		// PlayIdを求める
		// ホントはトランザクション処理になる
		Statement stmt = (Statement) conn.createStatement();
		String sql = "SELECT max(playId) as max FROM jankenLog03";
		ResultSet rs = stmt.executeQuery(sql);
		int max = 0;
		while (rs.next()) {
			max = rs.getInt("max");
		}
		playID = max + 1;
		rs.close();
		stmt.close();
	}

	public static void DbFinish() throws SQLException {
		conn.close();
	}

	public static void gameLog(int count, int you, int pc) throws SQLException {
		String sql = "INSERT INTO jankenLog03 (playId,no,you, pc,result) values (?,?,?, ?,?)";
		PreparedStatement pstmt = (PreparedStatement) conn
				.prepareStatement(sql);

		pstmt.setInt(1, playID);
		pstmt.setInt(2, count);
		pstmt.setInt(3, you);
		pstmt.setInt(4, pc);
		int result =  getResult(you, pc);
		pstmt.setInt(5, result);
		int num = pstmt.executeUpdate(); // num は今のところ未使用
	}

	public static void showLog() throws SQLException {
		String sql = "SELECT * FROM jankenLog03 WHERE playId = ? ORDER BY no";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, playID);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			int you = rs.getInt("you");
			int pc = rs.getInt("pc");
			int result = rs.getInt("result");
			System.out
					.print(no + "回目　あなた：" + label[you] + " , PC:" + label[pc]);

			System.out.println(" ==> " + resultLabel[result]);
		}
		rs.close();
		pstmt.close();

	}
	public static void showNumOfHands() throws SQLException{

		String sql = "SELECT COUNT( * ) as count ,you, YouLabel  FROM jankenLog03_v WHERE playID = ? GROUP BY you Order by you";

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, playID);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int count = rs.getInt("count");
			String youLabel = rs.getString("YouLabel");
			String del = "";
			System.out.print( del + youLabel + ":" + count + "回 ");
			del = ",";
		}
		System.out.println();
		rs.close();
		pstmt.close();
		
	}
	public static void showStatistics() throws SQLException{
		String sql = "SELECT COUNT( * ) as count ,result  FROM jankenLog03 WHERE playId = ? GROUP BY result";
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, playID);
		ResultSet rs = pstmt.executeQuery();
		
		
		int[] vals = new int[3];
		int gameCount = 0;
		while (rs.next()) {
			int count = rs.getInt("count");
			int result = rs.getInt("result");
			vals[result] = count;
			gameCount += count;
		}
		rs.close();
		pstmt.close();
		
		double winRate = (double) vals[1] /  gameCount * 100.0;
		System.out.println(vals[1] + "勝," + vals[0] + "敗、"
				+ vals[2] + "引き分け　勝率：" + +winRate
				+ "%");
	}

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
		// 初期化
		DbInit();

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

			gameLog(i + 1, you, pc);
		}
		showLog();
		showNumOfHands();
		showStatistics();
		System.out.println("終了");

		DbFinish();
	}
}
