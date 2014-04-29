package se.g5.h25.seiseki.V4;

import java.util.ArrayList;

public class Seiseki00 {
	public static void init(ArrayList nameList,ArrayList sansuList,ArrayList kokugoList){ // initialize (初期化）
		nameList.add("田中太郎");
		sansuList.add(new Integer(99));
		kokugoList.add(new Integer(30));
		
		nameList.add("鈴木二郎");
		sansuList.add(81);
		kokugoList.add(60);
	}
	public static void main(String[] args) {

		ArrayList nameList = new ArrayList();
		ArrayList sansuList = new ArrayList();
		ArrayList kokugoList = new ArrayList();
		
		init(nameList,sansuList,kokugoList);
		
		for(int i = 0 ; i < nameList.size(); i++ ){
			String name = (String)nameList.get(i);
			Integer I = (Integer)kokugoList.get(i);
			int kokugoPoint = I.intValue();
			I = (Integer)sansuList.get(i);
			int sansuPoint = I.intValue();;
			
			System.out.println("氏名：" + name);
			String kokugoResult = judgment(kokugoPoint);
			String sansuResult = judgment(sansuPoint);

			System.out.println("\t国語：" + kokugoPoint + " " + kokugoResult);
			System.out.println("\t算数：" + sansuPoint + " " + sansuResult);
		}
	}
	public static String judgment(int seiseki) {
		if (seiseki >= 60) {
			return "合格";
		} else {
			return "不合格";
		}
	}
}
