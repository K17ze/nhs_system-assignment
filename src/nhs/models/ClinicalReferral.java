package nhs.models;

/**
 * Represents a clinical referral from one clinician to another.
 * Contains referral details including urgency and clinical summary.
 */
public class ClinicalReferral {
    private String referralId;
    private String patientId;
    private String referringClinicianId;
    private String receivingSpecialistId;
    private String urgencyLevel;
    private String clinicalSummary;
    private String referralStatus;

    public ClinicalReferral(String referralId, String patientId,
                           String referringClinicianId, String receivingSpecialistId,
                           String urgencyLevel, String clinicalSummary) {
        this.referralId = referralId;
        this.patientId = patientId;
        this.referringClinicianId = referringClinicianId;
        this.receivingSpecialistId = receivingSpecialistId;
        this.urgencyLevel = urgencyLevel;
        this.clinicalSummary = clinicalSummary;
        this.referralStatus = "Pending";
    }

    public String getReferralId() {
        return referralId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getReferringClinicianId() {
        return referringClinicianId;
    }

    public String getReceivingSpecialistId() {
        return receivingSpecialistId;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public String getClinicalSummary() {
        return clinicalSummary;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public void updateStatus(String newStatus) {
        this.referralStatus = newStatus;
    }

    public void markAsCompleted() {
        this.referralStatus = "Completed";
    }
}
