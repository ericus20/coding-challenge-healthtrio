package com.healthtrio.ui.api.v1;

import com.healthtrio.annotation.Loggable;
import com.healthtrio.backend.domain.HospitalEHR;
import com.healthtrio.backend.service.HospitalEHRService;
import com.healthtrio.constant.ControllerConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class handles all rest calls for hospitalEHR.
 *
 * @author Eric Opoku
 */
@Slf4j
@RestController
@RequestMapping(ControllerConstants.API_ROOT_URL)
public class HospitalEHRResource {

    private final HospitalEHRService hospitalEHRService;

    public HospitalEHRResource(HospitalEHRService hospitalEHRService) {
        this.hospitalEHRService = hospitalEHRService;
    }

    /**
     * Retrieves the hospitals by state and in descending order,
     * the percentage of hospitals that support basic EHR notes in the year 2014.
     *
     * @return the hospitals by state
     */
    @Loggable
    @GetMapping
    public ResponseEntity<List<HospitalEHR>> getHospitalEHR() {
        List<HospitalEHR> hospitalEHRByState = hospitalEHRService.getHospitalEHRByStateInDesc();
        LOG.info("Count of response retrieved is {}", hospitalEHRByState.size());
        return ResponseEntity.ok(hospitalEHRByState);
    }
}
