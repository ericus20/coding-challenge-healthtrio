package com.healthtrio.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Holds data access and documentation for the non-federal acute care hospital EHR adoption and use open data.
 *
 * @author Eric Opoku
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class HospitalEHR implements Serializable {

    private static final long serialVersionUID = -6657194804188908035L;

    /**
     * The region name for the data. This includes all 50 states and the District of Columbia.
     */
    private String region;

    /**
     * Time period for the data. Year in which data was collected through survey.
     */
    private String period;

    /**
     * Percent of All Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_hospitals_basic_ehr_notes")
    private String pctHospitalsBasicEhrNotes;

    /**
     * Percent of Rural Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_rural_hospitals_basic_ehr_notes")
    private String pctRuralHospitalsBasicEhrNotes;

    /**
     * Percent of Small Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_small_hospitals_basic_ehr_notes")
    private String pctSmallHospitalsBasicEhrNotes;
}
