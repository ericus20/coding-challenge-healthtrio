package com.healthtrio.ui.controller;


import com.healthtrio.annotation.Loggable;
import com.healthtrio.backend.domain.HospitalEHR;
import com.healthtrio.backend.service.HospitalEHRService;
import com.healthtrio.config.ApplicationProperties;
import com.healthtrio.constant.ControllerConstants;
import com.healthtrio.constant.RequestParamConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * The root controller for handling all root mappings.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Controller
public class IndexController {

    private final ApplicationProperties properties;
    private final HospitalEHRService hospitalEHRService;

    public IndexController(ApplicationProperties properties, HospitalEHRService hospitalEHRService) {
        this.properties = properties;
        this.hospitalEHRService = hospitalEHRService;
    }

    /**
     * The method is the root mapping.
     *
     * @param model the model
     * @return the index page.
     */
    @Loggable
    @GetMapping(path = ControllerConstants.INDEX_URL_MAPPING)
    public String root(Model model) {
        List<HospitalEHR> hospitalEHRByState = hospitalEHRService.getHospitalEHRByStateInDesc();
        LOG.info("Count of response retrieved is {}", hospitalEHRByState.size());
        model.addAttribute("hospitalEHRByState", hospitalEHRByState);
        model.addAttribute(RequestParamConstants.PERIOD, properties.getPeriod());
        return ControllerConstants.INDEX_VIEW_NAME;
    }
}
