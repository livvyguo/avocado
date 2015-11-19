package org.lvy.avocado.web.config;

import org.lvy.avocado.common.consts.GlobalConstants;
import org.lvy.avocado.web.provider.AvocadoObjectMapperProvider;
import org.lvy.avocado.web.provider.DateParamConverterProvider;

import org.glassfish.jersey.server.ResourceConfig;

public class AvocadoReApplication extends ResourceConfig {

    /**
     * 
     */
    public AvocadoReApplication() {
        packages("org.lvy.avocado.server.resources");
        register(AvocadoObjectMapperProvider.class);
        register(new DateParamConverterProvider(GlobalConstants.DEFAULT_DATE_TIME_PATTERN));
    }
}
