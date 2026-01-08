package nhs.views;

import nhs.controllers.AppointmentManagementController;
import nhs.models.MedicalAppointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View component for managing medical appointments.
 * Provides interface for viewing and managing appointments.
 */
public class AppointmentManagementView extends JPanel {
    private AppointmentManagementController controller;
    private DefaultTableModel tableModel;
    private JTable appointmentTable;

    public AppointmentManagementView(AppointmentManagementController controller) {
        this.controller = controller;
        initializeComponents();
        layoutComponents();
        refreshAppointmentTable();
    }

    private void initializeComponents() {
        String[] columnNames = {"Appointment ID", "Patient ID", "Clinician ID", 
                                "Date", "Time", "Status", "Reason"};
        tableModel = new DefaultTableModel(columnNames, 0);
        appointmentTable = new JTable(tableModel);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        scrollPane.setPreferredSize(new Dimension(0, 400));
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JButton addButton = new JButton("Create Appointment");
        JButton refreshButton = new JButton("Refresh List");
        JButton cancelButton = new JButton("Cancel Selected");

        addButton.addActionListener(new CreateAppointmentAction());
        refreshButton.addActionListener(e -> refreshAppointmentTable());
        cancelButton.addActionListener(new CancelAppointmentAction());

        controlPanel.add(addButton);
        controlPanel.add(refreshButton);
        controlPanel.add(cancelButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void refreshAppointmentTable() {
        tableModel.setRowCount(0);
        for (MedicalAppointment appointment : controller.getAllAppointments()) {
            Object[] rowData = {
                appointment.getAppointmentId(),
                appointment.getPatientId(),
                appointment.getClinicianId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getAppointmentStatus(),
                appointment.getVisitReason()
            };
            tableModel.addRow(rowData);
        }
    }

    private class CreateAppointmentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MedicalAppointment newAppointment = new MedicalAppointment(
                "APT-" + System.currentTimeMillis(),
                "P001",
                "CLIN001",
                java.time.LocalDate.now().toString(),
                "10:00",
                "Scheduled",
                "Routine checkup"
            );
            controller.createAppointment(newAppointment);
            refreshAppointmentTable();
            JOptionPane.showMessageDialog(AppointmentManagementView.this,
                "New appointment created", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class CancelAppointmentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow >= 0) {
                String appointmentId = (String) tableModel.getValueAt(selectedRow, 0);
                controller.cancelAppointment(appointmentId);
                refreshAppointmentTable();
                JOptionPane.showMessageDialog(AppointmentManagementView.this,
                    "Appointment cancelled", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(AppointmentManagementView.this,
                    "Please select an appointment to cancel", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
