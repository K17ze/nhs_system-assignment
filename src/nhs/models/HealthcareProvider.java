package nhs.models;

/**
 * Base class for healthcare providers (doctors, nurses, specialists).
 * Represents clinical staff members in the NHS system.
 */
public class HealthcareProvider extends Person {
    private String providerId;
    private String medicalSpecialty;

    public HealthcareProvider(String userId, String fullName, String emailAddress,
                             String providerId, String medicalSpecialty) {
        super(userId, fullName, emailAddress);
        this.providerId = providerId;
        this.medicalSpecialty = medicalSpecialty;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }
}
