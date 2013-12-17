package ComputerDrill01.g2.h25.LeapYears;

public class IsLeapYear3{
	public static void main(String[] args) {
		int year = 2012;
		boolean result = false;
		if (year % 4 == 0) {
			result = true; 
			if (year % 100 == 0) { 
				result = false;
				if (year % 400 == 0) { 
					result = true;
				}
			}
		}
		if (result == true) {
			System.out.println(year + "年はうるう年です");
		} else {
			System.out.println(year + "年は平年です");
		}
	}
}