package com.healthtrio.constant;

/**
 * This class holds all constants used by the operations available to the ADMIN.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class ControllerConstants {

    /**
     * Admin Controller URI Mappings.
     */
    public static final String API_ROOT_URL = "/api/v1/hospitals";
    public static final String INDEX_URL_MAPPING = "/";

    /**
     * Controller View Names.
     */
    public static final String INDEX_VIEW_NAME = "index";

    private ControllerConstants() {
        throw new AssertionError("Non Instantiable");
    }
}
