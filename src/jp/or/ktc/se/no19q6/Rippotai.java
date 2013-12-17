package jp.or.ktc.se.no19q6;
/**
 * 立方体を表わすクラス。面積の計算や表示はこのクラスが受け持つ
 * @author fujisawa
 *
 */
public class Rippotai {
	int hen = 0;
	/**
	 * <p>一辺の長さをメンバ変数に格納する。セッターメソッドを介して値をセットすることでカプセル化を実現している</p>
	 * <p>
	 * <b>処理概要</b><br>
	 * <ul>
	 * 	<li>一辺の長さを格納するメンバー変数に値をセットする
	 * </ul>
	 * </p>
	 * @param val 一辺の長さ
	 */
	void setHen(int val){
		this.hen = val;
	}
	/**
	 * <p>立方体の表面積を求める。</p>
	 * <p>
	 * 	<b>処理概要</b><br>
	 *  <ul>
	 *  	<li>一辺の長さｘ一辺の長さｘ６を計算し、返り値として返す
	 *  </ul>
	 * </p>
	 * @return 立方体の表面積
	 */
	int getHyoMenseki(){
		return  this.hen * this.hen * 6;
	}
	/**
	 * <p>立方体の表面積を求めて標準出力に計算結果を表示する。</p>
	 * <p>
	 * <b>処理概要</b>
	 * <ul>
	 *  <li>表面積を求める
	 * 	<li>表面積を表示する文字列を生成する
	 * 	<li>生成した文字列を標準出力に表示する
	 * </ul>
	 * </p>
	 */
	void display(){
		StringBuffer sb = new StringBuffer();
		sb.append("一辺の長さ");
		sb.append( hen );
		sb.append("センチメートルの立方体の面積は");
		sb.append(getHyoMenseki());
		sb.append("平方センチメートル");
		
		System.out.println(sb.toString());
	}
	
	/**
	 *  単体デバッグ用
	 */
	public static void main(String[] args){
		Rippotai r = new Rippotai();
		// No.1
		r.setHen(9);
		System.out.println(r.hen);
		//No.2
		//r.setHen(1.5);
		// No.3
		r = new Rippotai();
		System.out.println(r.getHyoMenseki());
		// No.4
		r.setHen(-1);
		System.out.println(r.getHyoMenseki());
		// No.5
		r.setHen(0);
		System.out.println(r.getHyoMenseki());
		// No.6
		r.setHen(1);
		System.out.println(r.getHyoMenseki());
		// No.7
		r.setHen(9);
		System.out.println(r.getHyoMenseki());
		// No.8,9,10
		r.setHen(9);
		r.display();
	}
}