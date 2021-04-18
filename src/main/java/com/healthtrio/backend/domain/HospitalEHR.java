package com.healthtrio.backend.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Holds data access and documentation for the non-federal acute care hospital EHR adoption and use open data.
 *
 * @author Eric Opoku
 */
@Data
@Builder
public class HospitalEHR {

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
    private double pctHospitalsBasicEhrNotes;

    /**
     * Percent of Rural Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    private double pctRuralHospitalsBasicEhrNotes;

    /**
     * Percent of Small Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    private double pctSmallHospitalsBasicEhrNotes;

    /**
     * Percent of Critical Access Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    private double pctCriticalAccessHospitalsBasicEhrNotes;
}
