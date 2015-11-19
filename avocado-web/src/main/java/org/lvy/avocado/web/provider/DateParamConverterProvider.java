package org.lvy.avocado.web.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

    private final SimpleDateFormat formatter;

    public DateParamConverterProvider(String dateFormat) {
        this.formatter = new SimpleDateFormat(dateFormat);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

        if (!Date.class.equals(rawType)) {
            return null;
        }

        return (ParamConverter<T>) new ParamConverter<Date>() {

            @Override
            public Date fromString(String value) {
                try {
                    return formatter.parse(value);
                } catch (Exception ex) {
                    throw new WebApplicationException("Bad formatted date", 400);
                }
            }

            @Override
            public String toString(Date date) {
                return formatter.format(date);
            }
        };
    }
}
