package nhs.controllers;

import nhs.models.ClinicalReferral;
import nhs.models.ReferralService;
import nhs.utils.CSVFileWriter;

import java.util.List;

/**
 * Controller for managing referral-related operations.
 * Uses the ReferralService singleton to manage referrals.
 * This controller acts as the bridge between the view and the singleton service.
 */
public class ReferralManagementController {
    private ReferralService referralService;

    public ReferralManagementController() {
        // Obtain the singleton instance
        referralService = ReferralService.getServiceInstance();
    }

    /**
     * Creates a new referral and persists it to file.
     * 
     * @param referral the referral to create
     */
    public void createReferral(ClinicalReferral referral) {
        referralService.registerReferral(referral);
        CSVFileWriter.writeReferralToFile(referral);
    }

    /**
     * Retrieves all referrals from the singleton service.
     * 
     * @return list of all referrals
     */
    public List<ClinicalReferral> getAllReferrals() {
        return referralService.retrieveAllReferrals();
    }

    /**
     * Finds a referral by its ID.
     * 
     * @param referralId the referral identifier
     * @return the referral if found, null otherwise
     */
    public ClinicalReferral findReferralById(String referralId) {
        return referralService.findReferralById(referralId);
    }

    /**
     * Generates a new referral ID.
     * 
     * @return a unique referral ID
     */
    public String generateReferralId() {
        return referralService.generateReferralId();
    }

    /**
     * Updates the status of a referral.
     * 
     * @param referralId the referral identifier
     * @param newStatus the new status
     */
    public void updateReferralStatus(String referralId, String newStatus) {
        ClinicalReferral referral = referralService.findReferralById(referralId);
        if (referral != null) {
            referral.updateStatus(newStatus);
        }
    }
}
