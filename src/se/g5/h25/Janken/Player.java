package se.g5.h25.Janken;

import java.util.Scanner;

public class Player {

	public String selectHand(String msg) {
		if( msg != null ){
			System.out.print(msg);
		}
		Scanner scan = new Scanner(System.in);
		return scan.next(); // 　文字として取り込む
	}

}
