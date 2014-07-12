import java.util.*;
import java.text.*;

class Test {
  public static void main(String[] args) {
    Date date1 = new Date(); 

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHmmSS");
    String s = sdf1.format(date1) + ".txt";
    System.out.println(s); 
  }
}