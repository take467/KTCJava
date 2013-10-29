package se.g5.h25.seiseki.V4;
public class HeadTeacherDriver {
	public static void main(String[] args){
		
		// エラーになる
		// HeadTeacher ht = new HeadTeacher();
		
		HeadTeacher ht1 = HeadTeacher.getInstance();
		HeadTeacher ht2 = HeadTeacher.getInstance();
		
		if( ht1.equals(ht2)){
			System.out.println("ht1 と ht2 は同じオブジェクトです。");
		}else{
			System.out.println("ht1 と ht2 は違うオブジェクトです。");
		}
	}
}
class HeadTeacher {
	private static HeadTeacher singleton;
	private HeadTeacher(){}
	public static HeadTeacher getInstance(){
		if( singleton == null ){
			singleton = new HeadTeacher();
		}
		return singleton;
	}
}