package com.healthtrio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration properties are initialized in this configuration class.
 *
 * @author Eric Opoku
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api.parameter")
public class ApplicationProperties {

    private String endpoint;
    private String period;
    private String sort;
    private String sortDir;
    private String source;

}
