package nhs.views;

import nhs.controllers.ReferralManagementController;
import nhs.models.ClinicalReferral;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View component for managing clinical referrals.
 * Uses the ReferralService singleton through the controller.
 * Provides interface for viewing and creating referrals.
 */
public class ReferralManagementView extends JPanel {
    private ReferralManagementController controller;
    private DefaultTableModel tableModel;
    private JTable referralTable;

    public ReferralManagementView(ReferralManagementController controller) {
        this.controller = controller;
        initializeComponents();
        layoutComponents();
        refreshReferralTable();
    }

    private void initializeComponents() {
        String[] columnNames = {"Referral ID", "Patient ID", "From Clinician", 
                                "To Specialist", "Urgency", "Status", "Summary"};
        tableModel = new DefaultTableModel(columnNames, 0);
        referralTable = new JTable(tableModel);
        referralTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(referralTable);
        scrollPane.setPreferredSize(new Dimension(0, 400));
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JButton addButton = new JButton("Create Referral");
        JButton refreshButton = new JButton("Refresh List");
        JButton completeButton = new JButton("Mark Complete");

        addButton.addActionListener(new CreateReferralAction());
        refreshButton.addActionListener(e -> refreshReferralTable());
        completeButton.addActionListener(new CompleteReferralAction());

        controlPanel.add(addButton);
        controlPanel.add(refreshButton);
        controlPanel.add(completeButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void refreshReferralTable() {
        tableModel.setRowCount(0);
        for (ClinicalReferral referral : controller.getAllReferrals()) {
            Object[] rowData = {
                referral.getReferralId(),
                referral.getPatientId(),
                referral.getReferringClinicianId(),
                referral.getReceivingSpecialistId(),
                referral.getUrgencyLevel(),
                referral.getReferralStatus(),
                referral.getClinicalSummary().length() > 30 ? 
                    referral.getClinicalSummary().substring(0, 30) + "..." : 
                    referral.getClinicalSummary()
            };
            tableModel.addRow(rowData);
        }
    }

    private class CreateReferralAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String referralId = controller.generateReferralId();
            ClinicalReferral newReferral = new ClinicalReferral(
                referralId,
                "P001",
                "GP001",
                "SPEC001",
                "High",
                "Patient requires specialist consultation for ongoing condition"
            );
            controller.createReferral(newReferral);
            refreshReferralTable();
            JOptionPane.showMessageDialog(ReferralManagementView.this,
                "Referral created and saved to file", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class CompleteReferralAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = referralTable.getSelectedRow();
            if (selectedRow >= 0) {
                String referralId = (String) tableModel.getValueAt(selectedRow, 0);
                controller.updateReferralStatus(referralId, "Completed");
                refreshReferralTable();
                JOptionPane.showMessageDialog(ReferralManagementView.this,
                    "Referral marked as completed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ReferralManagementView.this,
                    "Please select a referral", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
