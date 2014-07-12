package megascus;

public class Math {

	/**
	 * 合計値を返します
	 */
	public int sum(int ... args){
		int ret = 0;
		for( int i : args){
			ret += i;
		}
		return ret;
	}
}
