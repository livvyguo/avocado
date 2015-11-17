package org.lvy.avocado.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
public final class LogUtils {

    public final static Logger getLogger() {
        Throwable throwable = new Throwable();
        StackTraceElement traceElement = throwable.getStackTrace()[1];
        String className = traceElement.getClassName();
        return LoggerFactory.getLogger(className);
    }
}
