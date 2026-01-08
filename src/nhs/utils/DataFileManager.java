package nhs.utils;

/**
 * Centralized management of data file paths.
 * Maintains all CSV file locations in one place for easy maintenance.
 */
public class DataFileManager {
    private static final String DATA_FOLDER = "src/nhs/data/";

    public static final String PATIENTS_FILE = DATA_FOLDER + "patients.csv";
    public static final String CLINICIANS_FILE = DATA_FOLDER + "clinicians.csv";
    public static final String FACILITIES_FILE = DATA_FOLDER + "facilities.csv";
    public static final String APPOINTMENTS_FILE = DATA_FOLDER + "appointments.csv";
    public static final String PRESCRIPTIONS_FILE = DATA_FOLDER + "prescriptions.csv";
    public static final String REFERRALS_FILE = DATA_FOLDER + "referrals.csv";
    public static final String STAFF_FILE = DATA_FOLDER + "staff.csv";
}
