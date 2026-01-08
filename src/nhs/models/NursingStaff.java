package nhs.models;

/**
 * Represents nursing staff members.
 * Specialized type of healthcare provider for nursing care.
 */
public class NursingStaff extends HealthcareProvider {
    private String nursingRegistrationNumber;
    private String nursingGrade;

    public NursingStaff(String userId, String fullName, String emailAddress,
                        String providerId, String medicalSpecialty,
                        String nursingRegistrationNumber, String nursingGrade) {
        super(userId, fullName, emailAddress, providerId, medicalSpecialty);
        this.nursingRegistrationNumber = nursingRegistrationNumber;
        this.nursingGrade = nursingGrade;
    }

    public String getNursingRegistrationNumber() {
        return nursingRegistrationNumber;
    }

    public String getNursingGrade() {
        return nursingGrade;
    }
}
