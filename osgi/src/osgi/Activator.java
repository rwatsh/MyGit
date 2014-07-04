package osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	public static BundleContext bc = null;

	private HelloWorldThread thread = null;

	public void start(BundleContext bc) throws Exception {
		System.out.println("Bundle starting...");
		Activator.bc = bc;
		thread = new HelloWorldThread();
		thread.start();
	}

	public void stop(BundleContext bc) throws Exception {
		System.out.println("Bundle stopping...");
		Activator.bc = null;
		thread.stopThread();
		thread.join();

	}
}