import java.util.ArrayList;


public class AnimalSound {

	public static void main(String[] args) {
		
		doAllAnimals0();
		
		// doAllAnimals1();
		
		//doAllAnimals2();
		
	}
	public static void doAllAnimals0(){

		Dog dog   = new Dog();
		dog.sound();
		
		Sloth sloth = new Sloth();
		sloth.sound();
		
		Pig pig   = new Pig();
		pig.sound();
		
		
		Cat cat   = new Cat();
		cat.sound();
	}
	public static void doAllAnimals1(){
		Animal  animal;
		animal  = new Dog();
		animal.sound();
		
		animal  = new Sloth();
		animal.sound();
		
		animal  = new Pig();
		animal.sound();
		
		
		animal  = new Cat();
		animal.sound();
	}
	public static void doAllAnimals2(){
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
class Sloth extends Animal {
	public void sound(){
		System.exit(1);
	}
}