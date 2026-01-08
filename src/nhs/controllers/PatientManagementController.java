package nhs.controllers;

import nhs.models.PatientRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing patient-related operations.
 * Acts as the intermediary between the view layer and model layer
 * following the MVC architectural pattern.
 */
public class PatientManagementController {
    private List<PatientRecord> patientRecords;

    public PatientManagementController() {
        patientRecords = new ArrayList<>();
    }

    /**
     * Adds a new patient record to the system.
     * 
     * @param patient the patient record to add
     */
    public void addPatientRecord(PatientRecord patient) {
        patientRecords.add(patient);
    }

    /**
     * Removes a patient record by identifier.
     * 
     * @param patientId the patient identifier
     */
    public void removePatientRecord(String patientId) {
        patientRecords.removeIf(patient -> patient.getIdentifier().equals(patientId));
    }

    /**
     * Retrieves all patient records.
     * 
     * @return list of all patients
     */
    public List<PatientRecord> getAllPatientRecords() {
        return new ArrayList<>(patientRecords);
    }

    /**
     * Finds a patient by NHS number.
     * 
     * @param nhsNumber the NHS number to search for
     * @return the patient record if found, null otherwise
     */
    public PatientRecord findPatientByNhsNumber(String nhsNumber) {
        for (PatientRecord patient : patientRecords) {
            if (patient.getNhsNumber().equals(nhsNumber)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Finds a patient by identifier.
     * 
     * @param patientId the patient identifier
     * @return the patient record if found, null otherwise
     */
    public PatientRecord findPatientById(String patientId) {
        for (PatientRecord patient : patientRecords) {
            if (patient.getIdentifier().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }
}
