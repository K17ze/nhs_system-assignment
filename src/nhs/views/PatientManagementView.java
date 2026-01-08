package nhs.views;

import nhs.controllers.PatientManagementController;
import nhs.models.PatientRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View component for managing patient records.
 * Provides interface for viewing, adding, and managing patients.
 */
public class PatientManagementView extends JPanel {
    private PatientManagementController controller;
    private DefaultTableModel tableModel;
    private JTable patientTable;

    public PatientManagementView(PatientManagementController controller) {
        this.controller = controller;
        initializeComponents();
        layoutComponents();
        refreshPatientTable();
    }

    private void initializeComponents() {
        String[] columnNames = {"Patient ID", "Name", "NHS Number", "Date of Birth", "GP Surgery"};
        tableModel = new DefaultTableModel(columnNames, 0);
        patientTable = new JTable(tableModel);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Table in center
        JScrollPane scrollPane = new JScrollPane(patientTable);
        scrollPane.setPreferredSize(new Dimension(0, 400));
        add(scrollPane, BorderLayout.CENTER);

        // Control panel at bottom
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JButton addButton = new JButton("Add New Patient");
        JButton refreshButton = new JButton("Refresh List");
        JButton deleteButton = new JButton("Delete Selected");

        addButton.addActionListener(new AddPatientAction());
        refreshButton.addActionListener(e -> refreshPatientTable());
        deleteButton.addActionListener(new DeletePatientAction());

        controlPanel.add(addButton);
        controlPanel.add(refreshButton);
        controlPanel.add(deleteButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void refreshPatientTable() {
        tableModel.setRowCount(0);
        for (PatientRecord patient : controller.getAllPatientRecords()) {
            Object[] rowData = {
                patient.getIdentifier(),
                patient.getFullName(),
                patient.getNhsNumber(),
                patient.getBirthDate(),
                patient.getRegisteredGpSurgery()
            };
            tableModel.addRow(rowData);
        }
    }

    private class AddPatientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PatientRecord newPatient = new PatientRecord(
                "P" + System.currentTimeMillis(),
                "New Patient",
                "patient@nhs.uk",
                "NHS" + (int)(Math.random() * 100000),
                "1990-01-01",
                "07123456789",
                "City GP Surgery"
            );
            controller.addPatientRecord(newPatient);
            refreshPatientTable();
            JOptionPane.showMessageDialog(PatientManagementView.this,
                "New patient added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class DeletePatientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = patientTable.getSelectedRow();
            if (selectedRow >= 0) {
                String patientId = (String) tableModel.getValueAt(selectedRow, 0);
                controller.removePatientRecord(patientId);
                refreshPatientTable();
                JOptionPane.showMessageDialog(PatientManagementView.this,
                    "Patient deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(PatientManagementView.this,
                    "Please select a patient to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
