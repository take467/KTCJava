package se.g5.h25.Janken;

import junit.framework.TestCase;

public class JankenTest extends TestCase {
	Janken j = new Janken();
	
	// コンピュータが０〜２の間で値を返すかテスト
	public void testGetComputerHand() {

		for(int i = 0 ; i < 100 ; i++ ){
			int v = j.getComputerHand();
			boolean result = (  v >= 0 && v <= 2  );
			assertTrue(result);
		}
	}

	// 勝ち判定のテスト
	public void testJudgeWin1() {
		assertEquals(1,j.judge(0,1 ));
	}
	public void testJudgeWin2() {
		assertEquals(1,j.judge(1,2 ));
	}
	public void testJudgeWin3() {
		assertEquals(1,j.judge(2,0 ));
	}
	// 引き分け判定のテスト
	public void testJudgeDraw() {
		assertEquals(2,j.judge(2,2 ));
	}
	// 最終の対戦結果のテスト・勝ちのケース
	public void testShowResult() {
		assertEquals(1,j.showResult(6, 3, 10));
	}

}
