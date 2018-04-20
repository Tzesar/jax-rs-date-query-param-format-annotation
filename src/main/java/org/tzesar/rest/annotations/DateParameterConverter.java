package org.tzesar.rest.annotations;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ParamConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Augusto Amarilla
 * @version 6.5
 * @since 4/17/18
 */
public class DateParameterConverter implements ParamConverter<Date> {

    private static final String DEFAULT_FORMAT = DateTimeFormat.DEFAULT_DATE_TIME;

    private DateTimeFormat customDateTimeFormat;
    private DateFormat customDateFormat;

    public void setCustomDateFormat(DateFormat customDateFormat) {
        this.customDateFormat = customDateFormat;
    }

    public void setCustomDateTimeFormat(DateTimeFormat
                                                customDateTimeFormat) {
        this.customDateTimeFormat = customDateTimeFormat;
    }

    @Override
    public Date fromString(String string) {
        if (string != null) {
            String format = DEFAULT_FORMAT;
            if (customDateFormat != null) {
                format = customDateFormat.value();
            } else if (customDateTimeFormat != null) {
                format = customDateTimeFormat.value();
            }

            final SimpleDateFormat simpleDateFormat = new
                    SimpleDateFormat(format);

            try {
                return simpleDateFormat.parse(string);
            } catch (ParseException ex) {
                throw new WebApplicationException(ex);
            }
        } else {
            return null;
        }
    }

    @Override
    public String toString(Date date) {
        return new SimpleDateFormat(DEFAULT_FORMAT).format(date);
    }
}