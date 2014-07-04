package patterns.structural;

/** "Implementor" */
interface Workshop {
	abstract public void work();
}

/** "ConcreteImplementor" 1/2 */
class Produce implements Workshop {

	@Override
	public void work() {
		System.out.print("Produced");
	}

}

/** "ConcreteImplementor" 2/2 */
class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.println(" Assembled.");
	}

}

/**
 * abstraction in bridge pattern
 * 
 */
abstract class Vehicle {
	protected Workshop workShop1;
	protected Workshop workShop2;

	protected Vehicle(Workshop workShop1, Workshop workShop2) {
		this.workShop1 = workShop1;
		this.workShop2 = workShop2;
	}

	abstract public void manufacture();
}

/** "Refined Abstraction" */
class Car extends Vehicle {

	public Car(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Car ");
		workShop1.work();
		workShop2.work();

	}
}

/** "Refined Abstraction" */
class Bike extends Vehicle {

	public Bike(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Bike ");
		workShop1.work();
		workShop2.work();
	}

}
/** "Client" */
public class BridgeExample {
	public static void main(String[] args) {

		Vehicle vehicle1 = new Car(new Produce(), new Assemble());
		vehicle1.manufacture();
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();

	}
}
