package org.tzesar.rest.annotations;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author Augusto Amarilla
 * @version 6.5
 * @since 4/17/18
 */
@Provider
public class DateParameterConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType, final Annotation[] annotations) {
        if (Date.class.equals(rawType)) {
            final DateParameterConverter dateParameterConverter =
                    new DateParameterConverter();

            for (Annotation annotation : annotations) {
                if (DateTimeFormat.class.equals(
                        annotation.annotationType())) {
                    dateParameterConverter.
                            setCustomDateTimeFormat((DateTimeFormat) annotation);
                } else if (DateFormat.class.equals(
                        annotation.annotationType())) {
                    dateParameterConverter.
                            setCustomDateFormat((DateFormat) annotation);
                }
            }
            return (ParamConverter<T>) dateParameterConverter;
        }
        return null;
    }
}