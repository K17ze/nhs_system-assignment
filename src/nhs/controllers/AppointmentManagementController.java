package nhs.controllers;

import nhs.models.MedicalAppointment;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing appointment-related operations.
 * Handles business logic for appointment creation, updates, and retrieval.
 */
public class AppointmentManagementController {
    private List<MedicalAppointment> appointmentList;

    public AppointmentManagementController() {
        appointmentList = new ArrayList<>();
    }

    /**
     * Creates a new appointment in the system.
     * 
     * @param appointment the appointment to create
     */
    public void createAppointment(MedicalAppointment appointment) {
        appointmentList.add(appointment);
    }

    /**
     * Retrieves all appointments.
     * 
     * @return list of all appointments
     */
    public List<MedicalAppointment> getAllAppointments() {
        return new ArrayList<>(appointmentList);
    }

    /**
     * Finds appointments for a specific patient.
     * 
     * @param patientId the patient identifier
     * @return list of appointments for the patient
     */
    public List<MedicalAppointment> getAppointmentsForPatient(String patientId) {
        List<MedicalAppointment> patientAppointments = new ArrayList<>();
        for (MedicalAppointment appointment : appointmentList) {
            if (appointment.getPatientId().equals(patientId)) {
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }

    /**
     * Updates the status of an appointment.
     * 
     * @param appointmentId the appointment identifier
     * @param newStatus the new status
     */
    public void updateAppointmentStatus(String appointmentId, String newStatus) {
        for (MedicalAppointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointment.updateStatus(newStatus);
                break;
            }
        }
    }

    /**
     * Cancels an appointment.
     * 
     * @param appointmentId the appointment identifier
     */
    public void cancelAppointment(String appointmentId) {
        for (MedicalAppointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointment.cancelAppointment();
                break;
            }
        }
    }
}
