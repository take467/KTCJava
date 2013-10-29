package se.g5.h25.seiseki;

public class SeisekiV2 {

	public static void main(String[] args) {

		Student3.setBorderPoint(55);

		Student3 s1 = new Student3();
		Student3 s2 = new Student3();
		
		s1.setData("田中太郎", 99, 30,77);		
		s2.setData("鈴木二郎", 81, 60,59);
		s1.display();
		s2.display();
	
	}

}

class Student{
	private String name;
	private int kokugoPoint;
	private int sansuPoint;
	
	public void setData(String n,int k, int s){
		name = n;
		kokugoPoint = k;
		sansuPoint  = s;
	}
	protected String judgment(int seiseki){
		if( seiseki >= 60 ){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void display(){
		System.out.println("氏名：" + name);
		String kokugoResult = judgment(kokugoPoint);
		String sansuResult  = judgment(sansuPoint);
		
		System.out.println("\t国語：" + kokugoPoint + " " + kokugoResult);
		System.out.println("\t算数：" + sansuPoint + " " + sansuResult);
	}
}

class Student2 extends Student{
	private int englishPoint;
	public void setData(String n,int k,int s ,int e){
		super.setData(n, k, s);
		englishPoint = e;
	}
	public void display(){
		super.display();
		String englishResult = judgment(englishPoint);
		System.out.println("\t英語：" + englishPoint + " " + englishResult);
	}
}

class Student3 extends Student2 {
	static private int borderPoint = 60;

	public static void setBorderPoint(int v){
		borderPoint = v;
	}

	public String judgment(int seiseki){
		if( seiseki >= borderPoint ){
			return "合格";
		}else{
			return "不合格";
		}
	}
}