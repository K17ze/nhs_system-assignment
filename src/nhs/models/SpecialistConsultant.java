package nhs.models;

/**
 * Represents a specialist consultant doctor.
 * Specialized type of healthcare provider for secondary care.
 */
public class SpecialistConsultant extends HealthcareProvider {
    private String consultantRegistrationNumber;
    private String subSpecialty;

    public SpecialistConsultant(String userId, String fullName, String emailAddress,
                               String providerId, String medicalSpecialty,
                               String consultantRegistrationNumber, String subSpecialty) {
        super(userId, fullName, emailAddress, providerId, medicalSpecialty);
        this.consultantRegistrationNumber = consultantRegistrationNumber;
        this.subSpecialty = subSpecialty;
    }

    public String getConsultantRegistrationNumber() {
        return consultantRegistrationNumber;
    }

    public String getSubSpecialty() {
        return subSpecialty;
    }
}
