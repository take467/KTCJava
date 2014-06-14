package se.g5.h26;

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