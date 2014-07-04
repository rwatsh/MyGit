package patterns.behavioral;

/**
 * State interface.
 */
interface MobileAlertState {
	public void alert(AlertStateContext ctx);
}

class Vibration implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		System.out.println("vibration...");
	}
}

class Silent implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		System.out.println("silent...");
	}

}

/**
 * This class maintains the current state and is the core of the state design
 * pattern. A client should access / run the whole setup through this class.
 */
class AlertStateContext {
	private MobileAlertState currentState;

	public AlertStateContext() {
		currentState = new Vibration();
	}

	public void setState(MobileAlertState state) {
		currentState = state;
	}

	public void alert() {
		currentState.alert(this);
	}
}

public class StateExample {
	public static void main(String[] args) {
		AlertStateContext stateContext = new AlertStateContext();
		stateContext.alert();
		stateContext.alert();
		stateContext.setState(new Silent());
		stateContext.alert();
		stateContext.alert();
		stateContext.alert();
	}
}
