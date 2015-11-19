package org.lvy.avocado.web.provider;

import org.lvy.avocado.common.consts.GlobalConstants;
import org.lvy.avocado.common.util.LogUtils;


import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class AvocadoObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private static final Logger logger = LogUtils.getLogger();

    private final ObjectMapper defaultObjectMapper;
    private final ObjectMapper combinedObjectMapper;

    /**
     * 构造函数初始化ObjectMapper。
     */
    public AvocadoObjectMapperProvider() {
        logger.debug("init objectMapper");
        defaultObjectMapper = createDefaultMapper();
        combinedObjectMapper = createCombinedObjectMapper();
    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createCombinedObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
        
        SimpleDateFormat fmt = new SimpleDateFormat(GlobalConstants.DEFAULT_DATE_TIME_PATTERN);
        mapper.setDateFormat(fmt);
        return mapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.enable(SerializationFeature.INDENT_OUTPUT);
        result.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SimpleDateFormat fmt = new SimpleDateFormat(GlobalConstants.DEFAULT_DATE_TIME_PATTERN);
        result.setDateFormat(fmt);
        result.setPropertyNamingStrategy(new BeanPropertyNamingStrategy());
        return result;
    }

    private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {
        final AnnotationIntrospector jaxbIntrospector = 
                new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
        return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
    }

    public ObjectMapper getCombinedObjectMapper() {
        return combinedObjectMapper;
    }
    
    

}
