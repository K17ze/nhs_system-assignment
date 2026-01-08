package nhs.models;

/**
 * Represents a General Practitioner (GP) doctor.
 * Specialized type of healthcare provider for primary care.
 */
public class GeneralPractitioner extends HealthcareProvider {
    private String gpRegistrationNumber;

    public GeneralPractitioner(String userId, String fullName, String emailAddress,
                              String providerId, String medicalSpecialty,
                              String gpRegistrationNumber) {
        super(userId, fullName, emailAddress, providerId, medicalSpecialty);
        this.gpRegistrationNumber = gpRegistrationNumber;
    }

    public String getGpRegistrationNumber() {
        return gpRegistrationNumber;
    }
}
