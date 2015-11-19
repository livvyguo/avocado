package org.lvy.avocado.web.provider;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

public class BeanPropertyNamingStrategy extends PropertyNamingStrategyBase {

    /**
     * 
     */
    private static final long serialVersionUID = -2508432050905241273L;

    @Override
    public String translate(String propertyName) {
        return propertyName;
    }

}
