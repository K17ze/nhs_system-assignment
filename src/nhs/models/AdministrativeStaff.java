package nhs.models;

/**
 * Represents non-clinical administrative staff members.
 * Includes receptionists, administrators, and support personnel.
 */
public class AdministrativeStaff extends Person {
    private String staffRole;
    private String departmentName;

    public AdministrativeStaff(String userId, String fullName, String emailAddress,
                              String staffRole, String departmentName) {
        super(userId, fullName, emailAddress);
        this.staffRole = staffRole;
        this.departmentName = departmentName;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void updateRole(String newRole) {
        this.staffRole = newRole;
    }

    public void updateDepartment(String newDepartment) {
        this.departmentName = newDepartment;
    }
}
