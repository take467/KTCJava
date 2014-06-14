package se.g5.h26.No3
;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Student {
	private String name;
	private int score;
	
	// コンストラクターは複数定義できる
	// 1. スコアをString型で受け取るコンストラクタ
	Student(String name, String score){
		this(name, Integer.parseInt(score));
	}
	// 2. スコアをint型で受け取るコンストラクタ
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	String getName(){
		return name;
	}
	
	int getScore(){
		return score;
	}
}
public class SeisekiCalc {

	public static void main(String[] args) throws Exception {
		boolean DEBUG = true;

		ArrayList students = new ArrayList();
		
		// ファイルからデータを読み込んで、リストに格納
		File csv = new File("data.csv"); // CSVデータファイル
		BufferedReader br = new BufferedReader(new FileReader(csv));

		// 最終行まで読み込む
		String line = "";
		while ((line = br.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}
			// 1行をデータの要素に分割
			StringTokenizer st = new StringTokenizer(line, ",");
			while (st.hasMoreTokens()) {
				
				//　コンストラクターでインスタンスの名前とスコアをセットする
				// 属性の可視性がprivateなので，これ以降に値をインスタンスの外部から変更することは出来ない。
				Student s = new Student(st.nextToken(),st.nextToken());
				students.add(s);
			}
		}
		br.close();

		// デバッグ表示
		if (DEBUG) {
			for (int i = 0; i < students.size(); i++) {
				Student s = (Student)students.get(i);
				System.out.printf("%s\t%s\n", s.getName(), s.getScore());
			}
		}

		// 平均を求める
		int total = 0;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			total += s.getScore();
		}
		double average = (double) total / students.size();
		System.out.printf("平均:%3.1f\n", average);
		
		// 平均以下の学生の名前と点数を表示する
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			if(  s.getScore() <= average){
				System.out.printf("平均:%3.1f %s\t%s\n", average,s.getName(), s.getScore());
			}
		}
	}
}
