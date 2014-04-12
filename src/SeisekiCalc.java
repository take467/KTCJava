import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SeisekiCalc {

	public static void main(String[] args) throws Exception {
		boolean DEBUG = true;

		ArrayList names = new ArrayList();
		ArrayList scores = new ArrayList();

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
				// 1行の各要素をタブ区切りで表示
				names.add(st.nextToken());
				scores.add(new Integer(st.nextToken()));
			}
		}
		br.close();

		// デバッグ表示
		if (DEBUG) {
			for (int i = 0; i < names.size(); i++) {
				String name = (String) names.get(i);
				Integer I = (Integer) scores.get(i);
				int score = I.intValue();

				System.out.printf("%s\t%s\n", name, score);
			}
		}

		// 平均を求める
		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			String dummyu = (String) names.get(i);
			Integer I = (Integer) scores.get(i);
			total += I.intValue();
		}
		double average = (double) total / names.size();
		System.out.printf("平均:%3.1f\n", average);
		
		// 平均以下の学生の名前と点数を表示する
		for (int i = 0; i < names.size(); i++) {
			String name = (String) names.get(i);
			Integer I = (Integer) scores.get(i);
			int score = I.intValue();
			if( score <= average){
				System.out.printf("平均:%3.1f %s\t%s\n", average,name, score);
			}
		}
	}
}
