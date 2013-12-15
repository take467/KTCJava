package ComputerDrill01.g2.h25;

public class LeapYear {
	public static void main(String[] args) {

		for( int year = 1995 ; year <= 2015; year++){
			boolean isLeapYear = isLeapYear(year);
			boolean isLeapYear2 = isLeapYear2(year);
			if( isLeapYear != isLeapYear2 ){
				System.out.println("bug! :" + year);
			}else{
				System.out.println("OK!  :" + year);
			}
			if(isLeapYear){
				System.out.println(year+":Leap Year");
			}else{
				System.out.println(year);
			}
		}
	}
	public static boolean isLeapYear(int year){
		boolean isLeapYear=false;
		
		if( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}
		return isLeapYear;
	}
	public static boolean isLeapYear2(int year){
		boolean result = false;
		if (year%4 == 0) {     
			result = true; //４で割り切れる
			if (year%100 == 0) {    	//１００で割り切れる
				result = false;
				if (year%400 == 0) { 	//４００で割り切れる
					result = true;
				}
			}
		}
		return result;
	}
}
