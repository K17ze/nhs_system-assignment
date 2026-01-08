package nhs;

import nhs.controllers.*;
import nhs.models.*;
import nhs.utils.CSVFileReader;
import nhs.utils.DataFileManager;
import nhs.views.ApplicationWindow;

import javax.swing.*;
import java.util.List;

/**
 * Main entry point for the NHS Healthcare Management System.
 * Initializes the application, loads data from CSV files, and launches the GUI.
 * 
 * This application demonstrates:
 * - MVC (Model-View-Controller) architectural pattern
 * - Singleton design pattern for referral management
 * - Three-tier architecture separation
 */
public class NHSApplication {

    public static void main(String[] args) {
        // Initialize controllers
        PatientManagementController patientController = new PatientManagementController();
        AppointmentManagementController appointmentController = new AppointmentManagementController();
        PrescriptionManagementController prescriptionController = new PrescriptionManagementController();
        ReferralManagementController referralController = new ReferralManagementController();

        // Load patient data
        loadPatientData(patientController);

        // Load appointment data
        loadAppointmentData(appointmentController);

        // Load prescription data
        loadPrescriptionData(prescriptionController);

        // Load referral data
        loadReferralData(referralController);

        // Launch GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ApplicationWindow mainWindow = new ApplicationWindow(
                patientController,
                appointmentController,
                prescriptionController,
                referralController
            );
            mainWindow.setVisible(true);
        });
    }

    private static void loadPatientData(PatientManagementController controller) {
        List<String[]> patientRows = CSVFileReader.readDataFromCSV(DataFileManager.PATIENTS_FILE);
        for (String[] row : patientRows) {
            if (row.length >= 14) {
                PatientRecord patient = new PatientRecord(
                    row[0],                              // patient_id
                    row[1] + " " + row[2],               // name (first + last)
                    row[7],                              // email
                    row[4],                              // nhs_number
                    row[3],                              // date_of_birth
                    row[6],                              // phone_number
                    row[13]                              // gp_surgery_id
                );
                controller.addPatientRecord(patient);
            }
        }
    }

    private static void loadAppointmentData(AppointmentManagementController controller) {
        List<String[]> appointmentRows = CSVFileReader.readDataFromCSV(DataFileManager.APPOINTMENTS_FILE);
        for (String[] row : appointmentRows) {
            if (row.length >= 10) {
                MedicalAppointment appointment = new MedicalAppointment(
                    row[0],     // appointment_id
                    row[1],     // patient_id
                    row[2],     // clinician_id
                    row[4],     // appointment_date
                    row[5],     // appointment_time
                    row[8],     // status
                    row[9]      // reason_for_visit
                );
                controller.createAppointment(appointment);
            }
        }
    }

    private static void loadPrescriptionData(PrescriptionManagementController controller) {
        List<String[]> prescriptionRows = CSVFileReader.readDataFromCSV(DataFileManager.PRESCRIPTIONS_FILE);
        for (String[] row : prescriptionRows) {
            if (row.length >= 13) {
                MedicationPrescription prescription = new MedicationPrescription(
                    row[0],                 // prescription_id
                    row[1],                 // patient_id
                    row[2],                 // clinician_id
                    row[5],                 // medication_name
                    row[6],                 // dosage
                    "Collected".equalsIgnoreCase(row[12]) // status
                );
                controller.createPrescription(prescription);
            }
        }
    }

    private static void loadReferralData(ReferralManagementController controller) {
        List<String[]> referralRows = CSVFileReader.readDataFromCSV(DataFileManager.REFERRALS_FILE);
        for (String[] row : referralRows) {
            if (row.length >= 7) {
                String referralId = controller.generateReferralId();
                ClinicalReferral referral = new ClinicalReferral(
                    referralId,        // generated referral ID
                    "",                // patientId (optional)
                    row[0],            // from clinician
                    row[0],            // to specialist
                    row[4],            // urgency_level
                    row[6]             // clinical_summary
                );
                controller.createReferral(referral);
            }
        }
    }
}
