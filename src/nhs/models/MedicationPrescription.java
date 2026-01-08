package nhs.models;

/**
 * Represents a medication prescription issued to a patient.
 * Contains medication details and collection status.
 */
public class MedicationPrescription {
    private String prescriptionId;
    private String patientId;
    private String clinicianId;
    private String medicationName;
    private String dosageAmount;
    private boolean isCollected;

    public MedicationPrescription(String prescriptionId, String patientId,
                                 String clinicianId, String medicationName,
                                 String dosageAmount, boolean isCollected) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.medicationName = medicationName;
        this.dosageAmount = dosageAmount;
        this.isCollected = isCollected;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getDosageAmount() {
        return dosageAmount;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void markAsCollected() {
        this.isCollected = true;
    }

    public String getCollectionStatus() {
        return isCollected ? "Collected" : "Issued";
    }
}
