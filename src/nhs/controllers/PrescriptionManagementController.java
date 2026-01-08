package nhs.controllers;

import nhs.models.MedicationPrescription;
import nhs.utils.CSVFileWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing prescription-related operations.
 * Handles prescription creation, updates, and persistence.
 */
public class PrescriptionManagementController {
    private List<MedicationPrescription> prescriptionList;

    public PrescriptionManagementController() {
        prescriptionList = new ArrayList<>();
    }

    /**
     * Creates a new prescription and persists it to file.
     * 
     * @param prescription the prescription to create
     */
    public void createPrescription(MedicationPrescription prescription) {
        prescriptionList.add(prescription);
        CSVFileWriter.writePrescriptionToFile(prescription);
    }

    /**
     * Retrieves all prescriptions.
     * 
     * @return list of all prescriptions
     */
    public List<MedicationPrescription> getAllPrescriptions() {
        return new ArrayList<>(prescriptionList);
    }

    /**
     * Finds prescriptions for a specific patient.
     * 
     * @param patientId the patient identifier
     * @return list of prescriptions for the patient
     */
    public List<MedicationPrescription> getPrescriptionsForPatient(String patientId) {
        List<MedicationPrescription> patientPrescriptions = new ArrayList<>();
        for (MedicationPrescription prescription : prescriptionList) {
            if (prescription.getPatientId().equals(patientId)) {
                patientPrescriptions.add(prescription);
            }
        }
        return patientPrescriptions;
    }

    /**
     * Marks a prescription as collected.
     * 
     * @param prescriptionId the prescription identifier
     */
    public void markPrescriptionAsCollected(String prescriptionId) {
        for (MedicationPrescription prescription : prescriptionList) {
            if (prescription.getPrescriptionId().equals(prescriptionId)) {
                prescription.markAsCollected();
                break;
            }
        }
    }
}
