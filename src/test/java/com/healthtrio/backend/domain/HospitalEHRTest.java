package com.healthtrio.backend.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HospitalEHRTest {


    @Test
    void convertJsonToModel() throws JsonProcessingException {
        String jsonString = "{\n" +
                "\"region\": \"Wyoming\",\n" +
                "\"region_code\": \"WY\",\n" +
                "\"period\": \"2014\",\n" +
                "\"pct_hospitals_basic_ehr_notes\": \"0.68\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        HospitalEHR hospitalEHR = objectMapper.readValue(jsonString, HospitalEHR.class);
        Assertions.assertEquals("Wyoming", hospitalEHR.getRegion());
        Assertions.assertEquals(0.68, hospitalEHR.getPctHospitalsBasicEhrNotes());
    }

    @Test
    void equalsContract() {
        EqualsVerifier
                .forClass(HospitalEHR.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}