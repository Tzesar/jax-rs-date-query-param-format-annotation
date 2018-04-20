package org.tzesar.rest.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Augusto Amarilla
 * @version 6.5
 * @since 4/17/18
 */
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
public @interface DateFormat {

    String DEFAULT_DATE = "yyyy-MM-dd";

    String value() default DEFAULT_DATE;
}