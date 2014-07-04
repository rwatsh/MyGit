package patterns.creational;

class Bike implements Cloneable {
	private int gears;
	private String bikeType;
	private String model;

	public Bike() {
		bikeType = "Standard";
		model = "Leopard";
		gears = 4;
	}

	public Bike clone() {
		return new Bike();
	}

	public void makeAdvanced() {
		bikeType = "Advanced";
		model = "Jaguar";
		gears = 6;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Bike [gears=" + gears + ", bikeType=" + bikeType + ", model="
				+ model + "]";
	}

}

public class PrototypeExample {
	/**
	 * Takes a basic bike object and makes an advanced bike object.
	 * 
	 * @param basicBike
	 * @return
	 */
	public static Bike makeJaguar(Bike basicBike) {
		basicBike.makeAdvanced();
		return basicBike;
	}

	public static void main(String[] args) {
		Bike bike = new Bike();
		Bike basicBike = bike.clone();
		System.out.println(basicBike);
		Bike advancedBike = makeJaguar(basicBike);
		System.out.println("Prototype Design Pattern: " + advancedBike);
	}
}
