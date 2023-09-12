package exercise_0912;

class Animal{
	String name;
	
	public Animal(String name) {
		this.name = name;
	}
	public void sleep() {
		System.out.println(name + " is sleeping");
	}
	public void eat() {
		System.out.println(name + " is eating");
	}
}

class Dog extends Animal{
	public Dog(String name) {
		super(name);
	}
	public void bark() {
		System.out.println(name + " is barking");
	}
}

class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}
	public void play() {
		System.out.println(name + " is playing");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog = new Dog("Luke");
		Cat cat = new Cat("Goyang");
		
		dog.sleep();
		dog.eat();
		dog.bark();
		
		cat.sleep();
		cat.eat();
		cat.play();

	}

}
