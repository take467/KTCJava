package megascus;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	Math math = new Math();
	@Test
	public void testCase_失敗() {
		fail("失敗");
	}

	@Test
	public void testCase_１から１０までの合計は５５(){
		assertEquals(55,math.sum(1,2,3,4,5,6,7,8,9,10));
	}
	
	@Test
	public void testCase_１から１０までの合計は５４(){
		assertEquals(54,math.sum(1,2,3,4,5,6,7,8,9,10));
	}
}
