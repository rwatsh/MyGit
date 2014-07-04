package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}

class Originator {

	// this String is just for example
	// in real world application this
	// will be a java class - the object
	// for which the state to be stored
	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento createMemento() {
		return new Memento(state);
	}

	public void setMemento(Memento memento) {
		state = memento.getState();
	}
}

class Caretaker {
	private List<Memento> statesList = new ArrayList<Memento>();

	public void addMemento(Memento m) {
		statesList.add(m);
	}

	public Memento getMemento(int index) {
		return statesList.get(index);
	}
}

public class MementoExample {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("Lion");
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(memento);

		originator.setState("Tiger");
		originator.setState("Horse");
		memento = originator.createMemento();
		caretaker.addMemento(memento);
		originator.setState("Elephant");
		System.out
				.println("Originator Current State: " + originator.getState());
		System.out.println("Originator restoring to previous state...");
		memento = caretaker.getMemento(1);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getState());
		System.out.println("Again restoring to previous state...");
		memento = caretaker.getMemento(0);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getState());
	}
}
