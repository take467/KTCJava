package se.g5.h25;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DerivationSample {

	public static void main(String[] args) throws ParseException {
		Human h = new Human("1995/10/09");
		p(h);
		
		// 誕生日を変更
		h.birthday = "2012/10/09";
		p(h);
	
		// 年齢を変更
		h.age = 100;
		p(h);
		
	}
	public static void p(Human h){
		System.out.printf("Birthday is %s  and age is %d\n",h.birthday,h.age);
	}

}
class Human {
	String birthday;
	int age = -1;
	/**
	 * @param yyyymmdd 生年月日
	 * @throws ParseException
	 */
	public Human(String yyyymmdd) throws ParseException{

		this.birthday = yyyymmdd;
		this.age = calcAgeFromBirthday(yyyymmdd);
	}

	/** 
	 * 生年月日から年齢を求める
	 * @param yyyymmdd　生年月日
	 * @return　年齢
	 * @throws ParseException
	 */
	int calcAgeFromBirthday(String yyyymmdd) throws ParseException{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar birthDay = Calendar.getInstance();

		birthDay.setTime(sdf.parse(yyyymmdd));

		
		int by = birthDay.get(Calendar.YEAR);
		int bm = birthDay.get(Calendar.MONTH) + 1;
		int bd = birthDay.get(Calendar.DATE);
		
		
		Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 int mon = cal.get(Calendar.MONTH)+1;
		 int day = cal.get(Calendar.DATE);
		 int age = (year - by) - ( bm > mon || (bm == mon && bd > day) ? 1:0);
		 return age;
	}
}
