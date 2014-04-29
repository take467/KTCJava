package se.g5.h25.seiseki.V4;

public class Seiseki01 {
	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student();

		s1.setData("田中太郎", 99, 30, 77);
		s2.setData("鈴木二郎", 81, 60, 59);
		s1.display();
		s2.display();

	}
}

class Student {
	private String name;
	private int kokugoPoint;
	private int sansuPoint;
	private int englishPoint;

	public void setData(String n, int k, int s, int e) {
		name = n;
		kokugoPoint = k;
		sansuPoint = s;
		englishPoint = e;
	}

	public void display() {
		System.out.println("氏名：" + name);
		String kokugoResult = judgment(kokugoPoint);
		String sansuResult = judgment(sansuPoint);

		System.out.println("\t国語：" + kokugoPoint + " " + kokugoResult);
		System.out.println("\t算数：" + sansuPoint + " " + sansuResult);

		String englishResult = judgment(englishPoint);
		System.out.println("\t英語：" + englishPoint + " " + englishResult);
	}
	public String judgment(int seiseki) {
		if (seiseki >= 60) {
			return "合格";
		} else {
			return "不合格";
		}
	}
}
