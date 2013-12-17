package jp.or.ktc.se.no19q6;
/**
 * 　<p>このプログラムの目的は、立方体の面積を求めて表示することである。コマンドラインから立方体の一片の長さを入力し、各立方体の表面積を表示する。
 * 　なお、コマンドラインからは複数の立方体の情報を入力できるものとする。</p>
 * 
 *   <p><b>実行結果例</b> <br>
 *   
 *   &gt; java jp.or.ktc.se.no19q6.Q6 10<br>
 *   <b>一辺の長さ10センチメートルの立方体の表面積は600平方センチメートル</b>
 *
 * 	</p>
 *  <p>
 *  &gt; java jp.or.ktc.se.no196.Q6 1 2 3<br>
 *  <b>一辺の長さ1センチメートルの立方体の表面積は6平方センチメートル</b><br>
 *  <b>一辺の長さ2センチメートルの立方体の表面積は24平方センチメートル</b><br>
 *  <b>一辺の長さ3センチメートルの立方体の表面積は54平方センチメートル</b>
 *  </p>
 */
public class Q6 {

	/**
	 * <p>メインメソッド。コマンドラインの引数のチェックは行わない</p>
	 * <p>
	 * <b>処理概要</b><br>
	 * 	<ul>
	 * 		<li>引数の数だけ Rippotaiクラスのオブジェクトを生成して配列に格納する
	 * 		<li>それぞれのRippotaiオブジェクトに引数の値(一辺の長さ）をセットする
	 * 		<li>全てのRippotaiオブジェクトの表面積の計算結果を表示する
	 * 	</ul>
	 * </p>
	 * @param args 立方体の一片の長さを引数として受け取る
	 */
	public static void main(String[] args) {
		Rippotai rippotaiArray[] = new Rippotai[args.length];
		
		int hen = 0 ;
		for( int i = 0 ; i < rippotaiArray.length ; i++ ){
			rippotaiArray[i] = new Rippotai();
			
			hen = Integer.parseInt(args[i]);
			rippotaiArray[i].setHen(hen);
			rippotaiArray[i].display();
		}
	}

}
