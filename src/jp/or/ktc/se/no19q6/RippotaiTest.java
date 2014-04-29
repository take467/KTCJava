package jp.or.ktc.se.no19q6;

import junit.framework.TestCase;

public class RippotaiTest extends TestCase {


	public void testGetHyoMenseki() {
		Rippotai r = new Rippotai();
		r.setHen(2);
		assertEquals(24,r.getHyoMenseki());
		//fail("Not yet implemented");
	}
	public void testSetHenFalse() {
		// 課題：一辺の長さにマイナスを入れたら falseを返すように改造し、テストをパスさせる
		Rippotai r = new Rippotai();
		// プラスの値だったらtrueを返す。
		assertFalse(r.setHen(-1));
	}
	public void testSetHenTrue() {
		// 課題：一辺の長さにプラスの値を入れたら trueを返すように改造し、テストをパスさせる
		Rippotai r = new Rippotai();
		// プラスの値だったらtrueを返す。
		assertTrue(r.setHen(1));
	}
}
