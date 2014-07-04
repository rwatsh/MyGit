package patterns.structural;

/**
 * Adapter design pattern can be implemented in two ways. One using the
 * inheritance method and second using the composition method.
 * 
 * @author Watsh
 * 
 */
class CylindricalSocket {
	public String supply(String cylinStem1, String cylinStem2) {
		String output = "Power power power...";
		return output;
	}
}

/**
 * Adapter using inheritance.
 * 
 * @author Watsh
 * 
 */
class RectangularAdapter extends CylindricalSocket {
	public String adapt(String rectaStem1, String rectaStem2) {
		// some conversion logic
		String cylinStem1 = rectaStem1;
		String cylinStem2 = rectaStem2;
		return supply(cylinStem1, cylinStem2);
	}
}

/**
 * Adapter using composition.
 * 
 * @author Watsh
 * 
 */
class RectangularAdapter2 {
	private CylindricalSocket socket;

	public String adapt(String rectaStem1, String rectaStem2) {
		// some conversion logic
		socket = new CylindricalSocket();
		String cylinStem1 = rectaStem1;
		String cylinStem2 = rectaStem2;
		return socket.supply(cylinStem1, cylinStem2);
	}
}

public class AdapterExample {
	private static String rectaStem1 = "test";
	private static String rectaStem2 = "test";

	public static void main(String[] args) {
		RectangularAdapter adapter = new RectangularAdapter();
		String power = adapter.adapt(rectaStem1, rectaStem2);
		System.out.println(power);
	}
}
