package nhs.views;

import nhs.controllers.*;

import javax.swing.*;

/**
 * Main application window for the NHS Healthcare Management System.
 * Provides a tabbed interface for accessing different system modules.
 */
public class ApplicationWindow extends JFrame {
    private PatientManagementController patientController;
    private AppointmentManagementController appointmentController;
    private PrescriptionManagementController prescriptionController;
    private ReferralManagementController referralController;

    public ApplicationWindow(PatientManagementController patientController,
                            AppointmentManagementController appointmentController,
                            PrescriptionManagementController prescriptionController,
                            ReferralManagementController referralController) {
        this.patientController = patientController;
        this.appointmentController = appointmentController;
        this.prescriptionController = prescriptionController;
        this.referralController = referralController;
        
        initializeWindow();
        setupUserInterface();
    }

    private void initializeWindow() {
        setTitle("NHS Healthcare Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupUserInterface() {
        JTabbedPane mainTabs = new JTabbedPane();
        
        mainTabs.addTab("Patient Records", new PatientManagementView(patientController));
        mainTabs.addTab("Appointments", new AppointmentManagementView(appointmentController));
        mainTabs.addTab("Prescriptions", new PrescriptionManagementView(prescriptionController));
        mainTabs.addTab("Referrals", new ReferralManagementView(referralController));

        add(mainTabs);
    }
}
