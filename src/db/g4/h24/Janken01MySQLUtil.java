package db.g4.h24;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * 10.   ただし、これだと、更新障害が発生するのでPlayLogテーブルでplayIdを管理する
 * 
 * 
 * @author fujisawa
 * 
 */
public class Janken01MySQLUtil {
	private Connection conn = null;
	
	private int playID = -1;

	public void DbInit(String url ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = (Connection) DriverManager.getConnection(url);
		
		// PlayIdを求める
		//  トランザクション処理を入れる
		conn.setAutoCommit(false);
		Statement stmt = (Statement) conn.createStatement();
		String sql = "INSERT INTO PlayLog () values ()";
		stmt.executeUpdate(sql);
		
		sql = "SELECT max(playId) as max FROM PlayLog ";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			playID = rs.getInt("max");
		}
		rs.close();
		stmt.close();
		
		conn.commit();
	}

	public void DbFinish() throws SQLException {
		conn.commit(); // 入れ忘れてLogデータがロールバックされていた　bug 
		conn.close();
	}

	public void gameLog(int count, int you, int pc,int result) throws SQLException {
		String sql = "INSERT INTO jankenLog04 (playId,no,you, pc,result) values (?,?,?, ?,?)";
		PreparedStatement pstmt = (PreparedStatement) conn
				.prepareStatement(sql);

		pstmt.setInt(1, playID);
		pstmt.setInt(2, count);
		pstmt.setInt(3, you);
		pstmt.setInt(4, pc);
		pstmt.setInt(5, result);
		int num = pstmt.executeUpdate(); // num は今のところ未使用
	}

	public void showLog() throws SQLException {
		String sql = "SELECT * FROM jankenLog04_v WHERE playId = ? ORDER BY no";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, playID);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			int you = rs.getInt("you");
			int pc = rs.getInt("pc");
			String youLabel = rs.getString("YouLabel");
			String pcLabel = rs.getString("PCLabel");
			String resultLabel = rs.getString("ResultLabel");
			int result = rs.getInt("result");
			System.out
					.print(no + "回目　あなた：" + youLabel + " , PC:" + pcLabel);

			System.out.println(" ==> " + resultLabel);
		}
		rs.close();
		pstmt.close();

	}
	public void showNumOfHands() throws SQLException{

		String sql = "SELECT COUNT( * ) as count ,you, YouLabel  FROM jankenLog04_v WHERE playID = ? GROUP BY you Order by you";

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
	public void showStatistics() throws SQLException{
		String sql = "SELECT COUNT( * ) as count ,result  FROM jankenLog04 WHERE playId = ? GROUP BY result";
		
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
}
