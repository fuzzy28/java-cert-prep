package designpatterns;

public class SimpleFactory {

	public static void main(String[] args) {
		System.out.println(AnimalFactory.getAnimal("Dog").name);
		System.out.println(AnimalFactory.getAnimal("Unknown").name);
	}

}

abstract class Animal {
	protected String name = "Default animal";
}

class Dog extends Animal {

	public Dog() {
		this.name = "Dog";
	}
}

class Cat extends Animal {
	public Cat() {
		this.name = "Dog";
	}
}

class Fish extends Animal {
	public Fish() {
		this.name = "Dog";
	}
}

class Tiger extends Animal {
	public Tiger() {
		this.name = "Dog";
	}
}

class AnimalFactory {
	public static Animal getAnimal(String type) {
		switch (type) {
		case "Dog":
			return new Dog();
		case "Cat":
			return new Cat();
		case "Fish":
			return new Fish();
		case "Tiger":
			return new Tiger();
		default:
			return new Animal() {

			};
		}
	}
}