package se.g5.h25;

public class InterfaceSample {
	public static void main(String[] args) {
		
		Student tone = new Student("利根", new BadStudentBehavior());
		
		// 出力「利根はシステム開発演習Iの授業中ずっと寝てました。」 
		tone.takeLesson("ソフトウェア工学");
		
		// 心を入れ替えるメソッド
		tone.changeBehavior(new GoodStudentBehavior());
		
		// 出力「利根はシステム開発演習Iの授業の内容をノートにまとめ ました。」
		tone.takeLesson("ソフトウェア工学");
	}
}

interface StudentBehavior {
	// 登校する
	void goToSchool();

	// 授業を受ける
	void takeLesson(String name);

	// 宿題をする
	void doHomeWork();
}

class GoodStudentBehavior implements StudentBehavior {
	public void goToSchool() {
		System.out.println("始業30分前に着きました。");
	}

	public void takeLesson(String name) {
		System.out.println(name + "の授業の内容をノートにまとめました。");
	}

	public void doHomeWork() {
		System.out.println(" 宿題を終わらせました。");
	}
}

class BadStudentBehavior implements StudentBehavior {
	public void goToSchool() {
		System.out.println("遅刻して2限目に着きました。");
	}

	public void takeLesson(String name) {
		System.out.println(name + "の授業中ずっと寝てました。");
	}

	public void doHomeWork() {
		System.out.println(" ネットゲームを始めました。");
	}
}

class Student {
	StudentBehavior behavior;
	private String name;

	Student(String name, StudentBehavior sb) {
		this.name = name;
		this.behavior = sb;
	}

	public void takeLesson(String name) {
		System.out.print(this.name + "は");
		behavior.takeLesson(name);
	}

	public void changeBehavior(StudentBehavior studentBehavior) {
		System.out.println("\n" + this.name + "は心を入れ替えました。");
		this.behavior = studentBehavior;
	}
}