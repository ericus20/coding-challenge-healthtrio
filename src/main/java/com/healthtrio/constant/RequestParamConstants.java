package com.healthtrio.constant;

/**
 * Constants used in the CacheConstants of the application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class RequestParamConstants {

    public static final String SOURCE = "source";
    public static final String PERIOD = "period";
    public static final String SORT = "sort";
    public static final String SORT_DIR = "sort_dir";
    public static final String USER_HISTORIES = "user_histories";

    private RequestParamConstants() {
        throw new AssertionError("Non Instantiable");
    }
}
