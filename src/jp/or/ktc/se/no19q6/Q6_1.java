package jp.or.ktc.se.no19q6;
/**
 * 　<p>このプログラムの目的は、立方体の面積を求めて表示することである。コマンドラインから立方体の一片の長さを入力し、各立方体の表面積を表示する。</p>
 * 
 *   <p><b>実行結果例</b> <br>
 *   
 *   &gt; java jp.or.ktc.se.no19q6.Q6 10<br>
 *   <b>一辺の長さ10センチメートルの立方体の表面積は600平方センチメートル</b>
 *
 * 	</p>
 *  <p>
 *  &gt; java jp.or.ktc.se.no196.Q6 1 <br>
 *  <b>一辺の長さ1センチメートルの立方体の表面積は6平方センチメートル</b><br>
 *  </p>
 */
public class Q6_1 {

	/**
	 * <p>メインメソッド。コマンドラインの引数のチェックは行わない</p>
	 * <p>
	 * <b>処理概要</b><br>
	 * 	<ul>
	 * 		<li>Rippotai クラスのインスタンスを生成
	 * 		<li>インスタンスに引数で指定した一辺の長さをセット
	 * 		<li>表面積の計算結果を表示する
	 * 	</ul>
	 * </p>
	 * @param args 立方体の一片の長さを引数として受け取る
	 */
	public static void main(String[] args) {
		
		int hen = 0 ;
		Rippotai r =  new Rippotai();
			
		hen = Integer.parseInt(args[0]);
		r.setHen(hen);
		r.display();
	}

}
