package se.g5.h25.seiseki;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SeisekiV3 {
	static String students_data[] = new String[]{
		"田中太郎,99,30,77",
		"鈴木二郎,81,60,59"
	};
	public static void main(String[] args) {

		StudentV2.setBorderPoint(55);

		ArrayList students = new ArrayList();
		for( int i = 0 ; i < students_data.length ; i++ ){
			StudentV2 s = new StudentV2();
			String line = students_data[i];
			StringTokenizer st = new StringTokenizer(line, ",");
			String n = st.nextToken();
			int    kokugo = Integer.parseInt(st.nextToken());
			int    sansu  = Integer.parseInt(st.nextToken());
			int    eng    = Integer.parseInt(st.nextToken());
			s.setData(n, kokugo, sansu, eng);
			students.add(s);
		}

		for( int i = 0 ;  i < students.size() ; i++ ){
			Student s = (Student) students.get(i);
			s.display();
		}
	}

}

class StudentV2 {
	private String name;
	private int kokugoPoint;
	private int sansuPoint;
	private int englishPoint;

	static private int borderPoint = 60;

	public static void setBorderPoint(int v){
		borderPoint = v;
	}
	public void setData(String n,int k,int s ,int e){
		name = n;
		kokugoPoint = k;
		sansuPoint  = s;
		englishPoint = e;
	}
	public String judgment(int seiseki){
		if( seiseki >= borderPoint ){
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

		String englishResult = judgment(englishPoint);
		System.out.println("\t英語：" + englishPoint + " " + englishResult);
	}
}