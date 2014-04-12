import java.util.ArrayList;


public class AnimalSounds {

	public static void main(String[] args) {
		
		ArrayList animals = new ArrayList();
		animals.add(new Dog());
		animals.add(new Pig());
		animals.add(new Cat());
		
		// Dog,Pig,Catの各インスタンスのsound()メソッドを呼び出す
		for(int i = 0 ; i < animals.size() ; i++ ){
				
				// ここに適切なコードを書いて、プログラムを完成させる
			
		}
	}
}
// クラスにする意味がないので、インタフェースにするか、抽象クラスにする
class Animal{
	public void sound(){
		System.out.println("Who am I?");
	}
}

class Dog extends Animal{
	public void sound(){
		System.out.println("Dog Bow wow.");
	}
}

class Pig extends Animal{
	public void sound(){
		System.out.println("Pig oink oink.");
	}
}

class Cat extends Animal{
	public void sound(){
		System.out.println("Cat mew mew.");
	}
}
