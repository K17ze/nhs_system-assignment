package nhs.models;

/**
 * Represents a medical appointment between a patient and clinician.
 * Tracks scheduling details and appointment status.
 */
public class MedicalAppointment {
    private String appointmentId;
    private String patientId;
    private String clinicianId;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;
    private String visitReason;

    public MedicalAppointment(String appointmentId, String patientId,
                             String clinicianId, String appointmentDate,
                             String appointmentTime, String appointmentStatus,
                             String visitReason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
        this.visitReason = visitReason;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void updateStatus(String newStatus) {
        this.appointmentStatus = newStatus;
    }

    public void cancelAppointment() {
        this.appointmentStatus = "Cancelled";
    }

    public void completeAppointment() {
        this.appointmentStatus = "Completed";
    }
}
