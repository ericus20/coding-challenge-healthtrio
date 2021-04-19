package com.healthtrio.backend.service.impl;

import com.healthtrio.backend.domain.HospitalEHR;
import com.healthtrio.backend.service.HospitalEHRService;
import com.healthtrio.config.ApplicationProperties;
import com.healthtrio.constant.RequestParamConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * This is the implementation for the HospitalEHRService.
 *
 * @author Eric Opoku
 */
@Service
public class HospitalEHRServiceImpl implements HospitalEHRService {

    private final RestTemplate restTemplate;
    private final ApplicationProperties properties;

    public HospitalEHRServiceImpl(RestTemplate restTemplate, ApplicationProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    /**
     * Connects to the appropriate endpoint and get, by state and in descending order,
     * the percentage of hospitals that support basic EHR notes in the year 2014.
     *
     * @return list of hospitalEHR
     */
    @Override
    public List<HospitalEHR> getHospitalEHRByStateInDesc() {
        HttpHeaders headers = getHttpHeaders();
        UriComponentsBuilder builder = getUriComponentsBuilder();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<List<HospitalEHR>> response = getListHttpEntity(builder, entity);
        return response.getBody();
    }

    /**
     * Execute the rest call and return the response.
     *
     * @param builder the builder
     * @param entity  the entity
     * @return list of hospitalEHR
     */
    private HttpEntity<List<HospitalEHR>> getListHttpEntity(UriComponentsBuilder builder, HttpEntity<?> entity) {
        ParameterizedTypeReference<List<HospitalEHR>> responseType = new ParameterizedTypeReference<>() {};
        return restTemplate.exchange(
                builder.build().toUriString(),
                HttpMethod.GET,
                entity,
                responseType
        );
    }

    /**
     * Build the uri with the appropriate query parameters.
     *
     * @return the uriComponentsBuilder
     */
    private UriComponentsBuilder getUriComponentsBuilder() {
        return UriComponentsBuilder.fromHttpUrl(properties.getEndpoint())
                .queryParam(RequestParamConstants.SOURCE, properties.getSource())
                .queryParam(RequestParamConstants.PERIOD, properties.getPeriod())
                .queryParam(RequestParamConstants.SORT, properties.getSort())
                .queryParam(RequestParamConstants.SORT_DIR, properties.getSortDir());
    }

    /**
     * Retrieve the prepared httpHeaders.
     *
     * @return httpHeaders
     */
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
