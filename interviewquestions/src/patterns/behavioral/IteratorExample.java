package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class Animal {
	private String animalName;
	private String animalType;

	public Animal(String animalName, String animalType) {
		this.animalName = animalName;
		this.animalType = animalType;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
}

interface Iterator {
	public Animal nextAnimal();

	public boolean isLastAnimal();

	public Animal currentAnimal();
}

class WildIterator implements Iterator {

	public List<Animal> animalList;
	private int position;

	public WildIterator(List<Animal> animalList) {
		this.animalList = animalList;
	}

	@Override
	public Animal nextAnimal() {
		Animal animal = null;
		for (; position < animalList.size(); position++) {
			if ("Wild".equals((animalList.get(position)).getAnimalType())) {
				animal = animalList.get(position);
				position++;
				break;
			}
		}
		return animal;
	}

	@Override
	public boolean isLastAnimal() {
		for (int i = position; i < animalList.size(); i++) {
			if ("Wild".equals((animalList.get(i)).getAnimalType())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Animal currentAnimal() {
		if (position < animalList.size()) {
			return animalList.get(position);
		}
		return null;
	}

}

class DomesticIterator implements Iterator {

	List<Animal> animalList;
	private int position;

	public DomesticIterator(List<Animal> animalList) {
		this.animalList = animalList;
	}

	@Override
	public Animal nextAnimal() {
		Animal animal = null;
		for (; position < animalList.size(); position++) {
			if ("Domestic".equals((animalList.get(position)).getAnimalType())) {
				animal = animalList.get(position);
				position++;
				break;
			}
		}
		return animal;
	}

	@Override
	public boolean isLastAnimal() {
		for (int i = position; i < animalList.size(); i++) {
			if ("Domestic".equals((animalList.get(i)).getAnimalType())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Animal currentAnimal() {
		if (position < animalList.size()) {
			return animalList.get(position);
		}
		return null;
	}

}

interface IZoo {

	public List<Animal> getAnimals();

	public void addAnimal(Animal animal);

	public void removeAnimal(Animal animal);

	public Iterator createIterator(String iteratorType);
}

class ZooImpl implements IZoo {

	List<Animal> animalList;

	public ZooImpl() {
		animalList = new ArrayList<Animal>();
	}

	@Override
	public List<Animal> getAnimals() {

		return animalList;
	}

	@Override
	public void addAnimal(Animal animal) {
		animalList.add(animal);

	}

	@Override
	public void removeAnimal(Animal animal) {
		animalList.remove(animal);

	}

	@Override
	public Iterator createIterator(String iteratorType) {
		if ("Wild".equals(iteratorType)) {
			return new WildIterator(animalList);
		} else {
			return new DomesticIterator(animalList);
		}
	}
}

public class IteratorExample {
	public static void main(String args[]) {
		ZooImpl zoo = new ZooImpl();
		zoo.addAnimal(new Animal("Tiger", "Wild"));
		zoo.addAnimal(new Animal("Lion", "Wild"));
		zoo.addAnimal(new Animal("Tom Cat", "Domestic"));
		zoo.addAnimal(new Animal("Raging Bull", "Wild"));
		zoo.addAnimal(new Animal("Scooby Doo", "Domestic"));

		Iterator wildIterator = zoo.createIterator("Wild");
		while (!wildIterator.isLastAnimal()) {
			System.out.println("Wild Animal: "
					+ wildIterator.nextAnimal().getAnimalName());
		}

		Iterator domesticIterator = zoo.createIterator("Domestic");
		while (!domesticIterator.isLastAnimal()) {
			System.out.println("Domestic Animal: "
					+ domesticIterator.nextAnimal().getAnimalName());
		}
	}
}
