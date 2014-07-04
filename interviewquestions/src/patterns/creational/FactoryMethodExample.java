package patterns.creational;

interface Pet {
	public String speak();
}

class Dog implements Pet {
	public String speak() {
		return "Bark bark...";
	}
}

class Duck implements Pet {
	public String speak() {
		return "Quack quack...";
	}
}

class PetFactory {

	public Pet getPet(String petType) {
		Pet pet = null;

		// based on logic factory instantiates an object
		if ("bark".equals(petType))
			pet = new Dog();
		else if ("quack".equals(petType))
			pet = new Duck();
		return pet;
	}
}

public class FactoryMethodExample {

	public static void main(String[] args) {
		//creating the factory
		 PetFactory petFactory = new PetFactory();
		 
		 //factory instantiates an object
		 Pet pet = petFactory.getPet("bark");
		 
		 //you don't know which object factory created
		 System.out.println(pet.speak());
	}
}
