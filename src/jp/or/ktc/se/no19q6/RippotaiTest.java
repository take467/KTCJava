package jp.or.ktc.se.no19q6;

import junit.framework.TestCase;

public class RippotaiTest extends TestCase {
	Rippotai r = new Rippotai();

	public void testGetHyoMenseki() {
		r.setHen(2);
		assertEquals(24,r.getHyoMenseki());
		//fail("Not yet implemented");
	}
	public void testGetHyoMenseki02() {
		// 課題：一辺の長さにマイナスを入れたら falseを返すように改造し、テストをパスさせる
		// プラスの値だったらtrueを返す。
		assertFalse(r.setHen(-1));
	}
}
