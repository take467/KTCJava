package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class RippotaiTest {

	@Test
	public void testSetHen() {
		Rippotai r = new Rippotai();
		//assertFalse(r.setHen(-1));
	}

	@Test
	// 一辺の長さが２の場合の立方体の面積が正しく求まれば成功
	public void testGetHyoMenseki() {
		Rippotai r = new Rippotai();
		r.setHen(2);
		// assertEquals(24,r.getHyoMenseki());
	}

}
