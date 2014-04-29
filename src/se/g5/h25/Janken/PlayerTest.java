package se.g5.h25.Janken;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	public void testSelectHand1() {
		Player p = new Player();
		assertEquals("0",p.selectHand("Input Hand:"));
	}
	public void testSelectHand2() {
		Player p = new Player();
		assertEquals("q",p.selectHand("Input Hand:"));
	}
}
