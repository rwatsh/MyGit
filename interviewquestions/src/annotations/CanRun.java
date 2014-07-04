package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations are defined via the @interface annotation before the class name.
 * Via @Retention you define if the annotation should be retained at runtime or
 * not. The @Target annotation lets you define where this annotation can be
 * used, e.g. the class, fields, methods, etc.
 * 
 * @author Watsh
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CanRun {

}
