package se.g5.h25.seiseki.V4;

public class SeisekiV4 {
	public static void main(String[] args) {

		// 金沢高専の赤点は５０点未満
		KTCStudent.setBorderPoint(50);

		KTCStudent s1 = new KTCStudent();
		KTCStudent s2 = new KTCStudent();
		
		s1.setData("田中太郎", 99, 30,77);		
		s2.setData("鈴木二郎", 81, 60,59);
		s1.display();
		s2.display();
	
	}
}

abstract class Student {
	private String name;
	private int kokugoPoint;
	private int sansuPoint;
	private int englishPoint;
	
	// 抽象メソッド
	abstract public String judgment(int seiseki);
	
	public void setData(String n,int k,int s ,int e){
		name = n;
		kokugoPoint = k;
		sansuPoint  = s;
		englishPoint = e;
	}

	public void display(){
		System.out.println("氏名：" + name);
		String kokugoResult = judgment(kokugoPoint);
		String sansuResult  = judgment(sansuPoint);

		System.out.println("\t国語：" + kokugoPoint + " " + kokugoResult);
		System.out.println("\t算数：" + sansuPoint + " " + sansuResult);

		String englishResult = judgment(englishPoint);
		System.out.println("\t英語：" + englishPoint + " " + englishResult);
	}
}
// TODO:　抽象クラスである Studentを継承した KTCStudentクラスを作成して
// プログラムを完成させる