package nhs.models;

/**
 * Represents a patient record in the NHS system.
 * Contains demographic and contact information.
 */
public class PatientRecord extends Person {
    private String nhsNumber;
    private String birthDate;
    private String phoneNumber;
    private String registeredGpSurgery;

    public PatientRecord(String patientId, String fullName, String emailAddress,
                        String nhsNumber, String birthDate, String phoneNumber,
                        String registeredGpSurgery) {
        super(patientId, fullName, emailAddress);
        this.nhsNumber = nhsNumber;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.registeredGpSurgery = registeredGpSurgery;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegisteredGpSurgery() {
        return registeredGpSurgery;
    }

    public void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void updateGpSurgery(String newGpSurgery) {
        this.registeredGpSurgery = newGpSurgery;
    }
}
