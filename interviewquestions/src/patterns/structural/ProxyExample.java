package patterns.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Animal {

	public void getSound();

}

class Lion implements Animal {

	public void getSound() {
		System.out.println("Roar");
	}

}

/**
 * InvocationHandler is the interface implemented by the invocation handler of a
 * proxy instance. Each proxy instance has an associated invocation handler.
 * When a method is invoked on a proxy instance, the method invocation is
 * encoded and dispatched to the invoke method of its invocation handler.
 */
class AnimalInvocationHandler implements InvocationHandler {
	public AnimalInvocationHandler(Object realSubject) {
		this.realSubject = realSubject;
	}

	public Object invoke(Object proxy, Method m, Object[] args) {
		Object result = null;
		try {
			/*
			 * Execute the getSound() method of realSubject.
			 */
			result = m.invoke(realSubject, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	private Object realSubject = null;
}

/**
 * Proxy provides static methods for creating dynamic proxy classes and
 * instances, and it is also the superclass of all dynamic proxy classes created
 * by those methods.
 * 
 * @author Watsh
 * 
 */
public class ProxyExample {
	public static void main(String[] args) {
		Animal realSubject = new Lion();
		ClassLoader classLoader = realSubject.getClass().getClassLoader();
		/*
		 * interfaces below will be patterns.structural.Animal
		 */
		Class<?>[] interfaces = realSubject.getClass().getInterfaces();
		AnimalInvocationHandler invocationHandler = new AnimalInvocationHandler(
				realSubject);
		/*
		 * Creates a dynamic proxy for Lion's realSubject instance for the
		 * interface methods that Lion implements.
		 */
		Animal proxy = (Animal) Proxy.newProxyInstance(classLoader, interfaces,
				invocationHandler);
		/*
		 * Calling an interface method on proxy instance will call invoke() of
		 * realSubject instance's invocation Handler.
		 */
		proxy.getSound();
	}
}
