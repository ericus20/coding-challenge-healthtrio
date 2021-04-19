package com.healthtrio.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationPropertiesTest {

    @Autowired
    ApplicationProperties properties;

    @Test
    void propertiesShouldNotBeNull() {
        Assertions.assertNotNull(properties);
    }

    @Test
    void propertyEndpointShouldBeSetCorrectly() {
        Assertions.assertNotNull(properties.getEndpoint());
    }

    @Test
    void propertyPeriodShouldBeSetCorrectly() {
        Assertions.assertNotNull(properties.getPeriod());
    }

    @Test
    void propertySortShouldBeSetCorrectly() {
        Assertions.assertNotNull(properties.getSort());
    }

    @Test
    void propertySortDirShouldBeSetCorrectly() {
        Assertions.assertNotNull(properties.getSortDir());
    }

    @Test
    void propertySourceShouldBeSetCorrectly() {
        Assertions.assertNotNull(properties.getSource());
    }
}