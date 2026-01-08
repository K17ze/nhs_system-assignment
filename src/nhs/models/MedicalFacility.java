package nhs.models;

/**
 * Represents a healthcare facility such as a GP surgery or hospital.
 * Contains facility details including capacity and contact information.
 */
public class MedicalFacility {
    private String facilityId;
    private String facilityName;
    private String facilityType;
    private String contactInformation;
    private int patientCapacity;

    public MedicalFacility(String facilityId, String facilityName, String facilityType,
                          String contactInformation, int patientCapacity) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.contactInformation = contactInformation;
        this.patientCapacity = patientCapacity;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public int getPatientCapacity() {
        return patientCapacity;
    }

    public void updateCapacity(int newCapacity) {
        this.patientCapacity = newCapacity;
    }
}
