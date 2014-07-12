package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Janken06v2Test {

	@Test
	// グーであいこ
	public void testJudgeEven0() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あいこ",j.judge(0, 0));
	}

	@Test
	// チョキであいこ
	public void testJudgeEven1() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あいこ",j.judge(1, 1));
	}
	
	@Test
	// パーであいこ
	public void testJudgeEven2() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あいこ",j.judge(2, 2));
	}
	
	@Test
	// グーで勝ち
	public void testJudgeWin0() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの勝ち!",j.judge(0, 1));
	}

	@Test
	// チョキで勝ち
	public void testJudgeWin1() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの勝ち!",j.judge(1, 2));
	}
	
	@Test
	// パーで勝ち
	public void testJudgeWin2() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの勝ち!",j.judge(2, 0));
	}
	
	
	@Test
	// グーで負け
	public void testJudgeLose0() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの負け",j.judge(0, 2));
	}

	@Test
	// チョキで負け
	public void testJudgeLose1() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの負け",j.judge(1, 0));
	}
	
	@Test
	// パーで負け
	public void testJudgeLose2() {
		Janken06v2 j = new Janken06v2();
		assertEquals("あなたの負け",j.judge(2, 1));
	}
	
	
	
	
	@Test
	// 人がグー
	public void testGetHumanHand0() {
		Janken06v2 j = new Janken06v2();
		System.out.println("==グー==");
		assertEquals(0,j.getHumanHand());
	}
	
	@Test
	// 人がパー
	public void testGetHumanHand1() {
		Janken06v2 j = new Janken06v2();
		System.out.println("==チョキ==");
		assertEquals(1,j.getHumanHand());
	}
	@Test
	// 人がチョキ
	public void testGetHumanHand２() {
		Janken06v2 j = new Janken06v2();
		System.out.println("==パー==");
		assertEquals(2,j.getHumanHand());
	}
}
