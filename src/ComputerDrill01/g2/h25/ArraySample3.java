package ComputerDrill01.g2.h25;

public class ArraySample3 {
	public static void main(String[] args){
		int[] data = new int[]{ 11,10,6,3,8,9};
	
		data[3]         = data[3] * 10;
		int index       = data.length - 1;
		data[index ]    = data[ index ] *  10;
		
		
		for( int i =   0   ; i   <   data.length ; i++ ){
			System.out.println(data[  i  ]);
		}
	}
}