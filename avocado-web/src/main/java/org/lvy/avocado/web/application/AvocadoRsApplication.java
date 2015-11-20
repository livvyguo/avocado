package org.lvy.avocado.web.application;

import org.lvy.avocado.common.consts.GlobalConstants;
import org.lvy.avocado.web.provider.AvocadoObjectMapperProvider;
import org.lvy.avocado.web.provider.DateParamConverterProvider;

import org.glassfish.jersey.server.ResourceConfig;

public class AvocadoRsApplication extends ResourceConfig {

    /**
     * 
     */
    public AvocadoRsApplication() {
        packages("org.lvy.avocado.server.resources");
        register(AvocadoObjectMapperProvider.class);
        register(new DateParamConverterProvider(GlobalConstants.DEFAULT_DATE_TIME_PATTERN));
    }
}
