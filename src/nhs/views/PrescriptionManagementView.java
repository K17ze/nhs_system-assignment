package nhs.views;

import nhs.controllers.PrescriptionManagementController;
import nhs.models.MedicationPrescription;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View component for managing medication prescriptions.
 * Provides interface for viewing, creating, and managing prescriptions.
 */
public class PrescriptionManagementView extends JPanel {
    private PrescriptionManagementController controller;
    private DefaultTableModel tableModel;
    private JTable prescriptionTable;

    public PrescriptionManagementView(PrescriptionManagementController controller) {
        this.controller = controller;
        initializeComponents();
        layoutComponents();
        refreshPrescriptionTable();
    }

    private void initializeComponents() {
        String[] columnNames = {"Prescription ID", "Patient ID", "Clinician ID", 
                                "Medication", "Dosage", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        prescriptionTable = new JTable(tableModel);
        prescriptionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(prescriptionTable);
        scrollPane.setPreferredSize(new Dimension(0, 400));
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JButton addButton = new JButton("Issue Prescription");
        JButton refreshButton = new JButton("Refresh List");
        JButton collectButton = new JButton("Mark as Collected");

        addButton.addActionListener(new CreatePrescriptionAction());
        refreshButton.addActionListener(e -> refreshPrescriptionTable());
        collectButton.addActionListener(new MarkCollectedAction());

        controlPanel.add(addButton);
        controlPanel.add(refreshButton);
        controlPanel.add(collectButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void refreshPrescriptionTable() {
        tableModel.setRowCount(0);
        for (MedicationPrescription prescription : controller.getAllPrescriptions()) {
            Object[] rowData = {
                prescription.getPrescriptionId(),
                prescription.getPatientId(),
                prescription.getClinicianId(),
                prescription.getMedicationName(),
                prescription.getDosageAmount(),
                prescription.getCollectionStatus()
            };
            tableModel.addRow(rowData);
        }
    }

    private class CreatePrescriptionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MedicationPrescription newPrescription = new MedicationPrescription(
                "PRES-" + System.currentTimeMillis(),
                "P001",
                "CLIN001",
                "Paracetamol",
                "500mg",
                false
            );
            controller.createPrescription(newPrescription);
            refreshPrescriptionTable();
            JOptionPane.showMessageDialog(PrescriptionManagementView.this,
                "Prescription issued and saved to file", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class MarkCollectedAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = prescriptionTable.getSelectedRow();
            if (selectedRow >= 0) {
                String prescriptionId = (String) tableModel.getValueAt(selectedRow, 0);
                controller.markPrescriptionAsCollected(prescriptionId);
                refreshPrescriptionTable();
                JOptionPane.showMessageDialog(PrescriptionManagementView.this,
                    "Prescription marked as collected", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(PrescriptionManagementView.this,
                    "Please select a prescription", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
