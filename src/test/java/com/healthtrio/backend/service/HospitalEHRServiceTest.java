package com.healthtrio.backend.service;

import com.healthtrio.backend.domain.HospitalEHR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HospitalEHRServiceTest {

    @Autowired
    private HospitalEHRService hospitalEHRService;

    @Test
    void getHospitalEHRReport() {
        List<HospitalEHR> hospitalEHRByState = hospitalEHRService.getHospitalEHRByStateInDesc();
        Assertions.assertFalse(hospitalEHRByState.isEmpty());
    }

}