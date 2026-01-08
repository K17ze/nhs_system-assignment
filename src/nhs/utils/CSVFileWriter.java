package nhs.utils;

import nhs.models.ClinicalReferral;
import nhs.models.MedicationPrescription;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Utility class for writing data to CSV files.
 * Handles appending new records to existing CSV files.
 */
public class CSVFileWriter {

    /**
     * Appends a prescription record to the prescriptions CSV file.
     * 
     * @param prescription the prescription to write
     */
    public static void writePrescriptionToFile(MedicationPrescription prescription) {
        String currentDate = LocalDate.now().toString();

        try (FileWriter fileWriter = new FileWriter(DataFileManager.PRESCRIPTIONS_FILE, true)) {
            StringBuilder csvLine = new StringBuilder();
            csvLine.append(prescription.getPrescriptionId()).append(",");
            csvLine.append(prescription.getPatientId()).append(",");
            csvLine.append(prescription.getClinicianId()).append(",");
            csvLine.append(","); // appointment_id
            csvLine.append(currentDate).append(","); // prescription_date
            csvLine.append(prescription.getMedicationName()).append(",");
            csvLine.append(prescription.getDosageAmount()).append(",");
            csvLine.append(","); // frequency
            csvLine.append(","); // duration_days
            csvLine.append(","); // quantity
            csvLine.append(","); // instructions
            csvLine.append(","); // pharmacy_name
            csvLine.append(prescription.getCollectionStatus()).append(","); // status
            csvLine.append(currentDate).append(","); // issue_date
            csvLine.append(""); // collection_date
            csvLine.append("\n");

            fileWriter.append(csvLine.toString());
            fileWriter.flush();

        } catch (IOException writeException) {
            System.err.println("Error writing prescription to file");
            writeException.printStackTrace();
        }
    }

    /**
     * Appends a referral record to the referrals CSV file.
     * 
     * @param referral the referral to write
     */
    public static void writeReferralToFile(ClinicalReferral referral) {
        String currentDate = LocalDate.now().toString();

        try (FileWriter fileWriter = new FileWriter(DataFileManager.REFERRALS_FILE, true)) {
            StringBuilder csvLine = new StringBuilder();
            csvLine.append(referral.getReceivingSpecialistId()).append(",");
            csvLine.append("S001,"); // referring_facility_id
            csvLine.append("H001,"); // referred_to_facility_id
            csvLine.append(currentDate).append(","); // referral_date
            csvLine.append(referral.getUrgencyLevel()).append(",");
            csvLine.append("System generated referral,"); // referral_reason
            csvLine.append(referral.getClinicalSummary()).append(",");
            csvLine.append(","); // requested_investigations
            csvLine.append(referral.getReferralStatus()).append(",");
            csvLine.append(","); // appointment_id
            csvLine.append(","); // notes
            csvLine.append(currentDate).append(","); // created_date
            csvLine.append(currentDate); // last_updated
            csvLine.append("\n");

            fileWriter.append(csvLine.toString());
            fileWriter.flush();

        } catch (IOException writeException) {
            System.err.println("Error writing referral to file");
            writeException.printStackTrace();
        }
    }
}
