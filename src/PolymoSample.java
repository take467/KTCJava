public class PolymoSample {

	public static void main(String[] args) {

		// IS-A 関係をしっかり理解すること！
		Student good = new GoodStudent();
		Student bad  = new BadStudent();
		
		good.doAtHome();
		bad.doAtHome();
	}
}

class Student{
	public void doAtHome(){
		System.out.println("Who am I?");
	}
}

class GoodStudent extends Student{
	public void doAtHome(){
		System.out.println("good student is always studing ..");
	}
}

class BadStudent extends Student{
	public void doAtHome(){
		System.out.println("bad student hardly  studies ");
	}
}