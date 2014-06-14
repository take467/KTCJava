package se.g5.h26;

public class Seiseki {
	public static void main(String[] args) {

		KTCStudent s1 = new KTCStudent();
		KTCStudent s2 = new KTCStudent();

		s1.borderPoint = 50;
		s2.borderPoint = 70;
		// KTCStudent.borderPoint = 70;
		
		s1.setData("田中太郎", 60);
		s2.setData("鈴木二郎", 60);
		
		s1.display();
		s2.display();

	}
}

class KTCStudent {
	public static  int borderPoint;
	
	private String name;
	private int point;

	public void setData(String n, int p) {
		name = n;
		point = p;
	}
	public void display() {
		System.out.println("氏名：" + name);
		System.out.print(point + " ");
		if( point  >= borderPoint ){
			System.out.println("合格");
		}else{
			System.out.println("不合格");
		}
	}
}