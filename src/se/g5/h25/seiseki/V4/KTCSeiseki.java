package se.g5.h25.seiseki.V4;

public class KTCSeiseki {
	public static void main(String[] args) {

		// 金沢高専の赤点は５０点未満
		KTCStudent.setBorderPoint(50);

		KTCStudent s1 = new KTCStudent();
		KTCStudent s2 = new KTCStudent();

		s1.setData("田中太郎", 99, 30, 77);
		s2.setData("鈴木二郎", 81, 60, 59);
		s1.display();
		s2.display();

	}
}

class KTCStudent extends Student {
	static private int borderPoint = 60;

	public static void setBorderPoint(int v) {
		borderPoint = v;
	}

	public String judgment(int seiseki) {
		if (seiseki >= borderPoint) {
			return "合格";
		} else {
			return "不合格";
		}
	}
}