package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {
    public static Logger getLogger() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // stackTrace[0]: lay log cua Thread.currentThread().getStackTrace();
        // stackTrace[1]: lay log cua ham log
        String className = stackTrace[2].getClassName();
        return LoggerFactory.getLogger(className);
    }


}
