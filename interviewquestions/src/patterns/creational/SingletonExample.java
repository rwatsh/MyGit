package patterns.creational;

/**
 * Singleton instance created when class is loaded.
 * 
 * @author Watsh
 * 
 */
class EagerSingleton {
	private static EagerSingleton INSTANCE = new EagerSingleton();

	private EagerSingleton() {
	}

	public static EagerSingleton getSingleInstance() {
		return INSTANCE;
	}
}

/**
 * This is also lazy initialization. Only works for Java SE 5.0 or later.
 * 
 */
class DoubleCheckedLockingSingleton {
	private static DoubleCheckedLockingSingleton INSTANCE = null;

	private DoubleCheckedLockingSingleton() {
	}

	public static DoubleCheckedLockingSingleton getSingleInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}
}

/**
 * Initialization on-demand holder. The nested class is referenced no earlier
 * (and therefore loaded no earlier by the class loader) than the moment that
 * getInstance() is called. Thus, this solution is thread-safe without requiring
 * special language constructs (i.e. volatile or synchronized).
 */
class Singleton {
	// Private constructor prevents instantiation from other classes
	private Singleton() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}

/**
 * Best approach - does not have the drawback of serializable objects. Any enum
 * value is instantiated only once in a Java program. Since Java enum values are
 * globally accessible, so is the singleton, initialized lazily by the
 * classloader.
 * 
 * @author Watsh
 * 
 */
enum LazySingleton {
	INSTANCE;
	public void execute(String arg) {
		System.out.println(arg);
	}
}

public class SingletonExample {

	public static void main(String[] args) {
		LazySingleton in = LazySingleton.INSTANCE;
		in.execute("test");
	}
}
