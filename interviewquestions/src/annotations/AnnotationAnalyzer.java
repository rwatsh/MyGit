package annotations;

import java.lang.reflect.Method;

public class AnnotationAnalyzer {

	/**
	 * The main method of this class analyzes the annotations and calls the
	 * corresponding methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotatedMethodsClass clz = new AnnotatedMethodsClass();
		Method[] methods = clz.getClass().getMethods();

		for (Method m : methods) {
			CanRun annos = m.getAnnotation(CanRun.class);
			if (annos != null) {
				try {
					m.invoke(clz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
