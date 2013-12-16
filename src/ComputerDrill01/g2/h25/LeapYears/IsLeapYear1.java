package ComputerDrill01.g2.h25.LeapYears;

public class IsLeapYear1 {
    public static void main( String[] args ) {
        int year = 2012;
        if( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
            System.out.println( year + "年はうるう年です" );
        } else {
            System.out.println( year + "年は平年です" );
        }
    }
}