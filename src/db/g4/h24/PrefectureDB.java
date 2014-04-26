package db.g4.h24;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class PrefectureDB {
	
	static Connection conn = null;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		dbPreProcess();  // 接続，初期化などデータベースを利用するための前準備
		
		
		//dbMain(); // prefectures テーブルの内容を表示する
		preparedStatemetDemo("石川県");
		
		dbPostProcess();  // データベースを切り離す
		
	}

	private static void dbPostProcess() throws SQLException {

		conn.close();
	}
	
	private static void preparedStatemetDemo(String name) throws SQLException{
		String sql = "SELECT * FROM prefectures WHERE name = ? ";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String  col1 = rs.getString("id");
			String  col2 = rs.getString("name");
			String  col3 = rs.getString("kana");
			
			System.out.printf("%s | %4s | %s \n",col1,col2,col3);
		}
		rs.close();
		pstmt.close();
	}

	private static void dbMain() throws SQLException {

		Statement stmt = (Statement) conn.createStatement();

		String sql = "SELECT * FROM prefectures ";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String  id   = rs.getString("id");
			String  name = rs.getString("name");
			String  kana = rs.getString("kana");
			
			System.out.printf("%s | %4s | %s \n",id,name,kana);
		}
	}

	
	private static void dbPreProcess() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost/pinfo?user=root";
		conn = (Connection) DriverManager.getConnection(url);
	}

}
