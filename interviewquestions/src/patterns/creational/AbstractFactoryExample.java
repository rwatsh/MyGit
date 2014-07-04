package patterns.creational;

interface Animal {
	public void breathe();
}

interface AnimalFactory {
	public Animal createAnimal();
}

class SeaFactory implements AnimalFactory {

	public Animal createAnimal() {
		return new Shark();
	}

}

class LandFactory implements AnimalFactory {
	public Animal createAnimal() {
		return new Elephant();
	}
}

class Shark implements Animal {
	public void breathe() {
		System.out.println("I breathe in water! He he!");
	}
}

class Elephant implements Animal {
	public void breathe() {
		System.out.println("I breathe with my lungs. Its easy!");
	}
}

/**
 * Given an animal factory, creates an animal.
 * 
 * @author Watsh
 * 
 */
class Wonderland {
	public Wonderland(AnimalFactory factory) {
		Animal animal = factory.createAnimal();
		animal.breathe();
	}
}

/**
 * Test abstract factory pattern.
 * 
 * @author Watsh
 *
 */
public class AbstractFactoryExample {

	public static void main(String[] args) {
		new Wonderland(createAnimalFactory("water"));
	}

	public static AnimalFactory createAnimalFactory(String type) {
		if ("water".equals(type))
			return new SeaFactory();
		else
			return new LandFactory();
	}
}
