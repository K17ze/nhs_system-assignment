package nhs.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton service for managing clinical referrals.
 * Ensures a single instance manages all referral operations,
 * maintaining consistency across the referral processing system.
 * 
 * This implementation uses the Singleton pattern to prevent
 * multiple instances that could lead to data inconsistencies.
 */
public class ReferralService {
    private static ReferralService singleInstance;
    private List<ClinicalReferral> referralList;
    private int referralCounter;

    /**
     * Private constructor prevents external instantiation.
     */
    private ReferralService() {
        referralList = new ArrayList<>();
        referralCounter = 1;
    }

    /**
     * Returns the single instance of ReferralService.
     * Uses double-checked locking for thread safety.
     * 
     * @return the singleton instance
     */
    public static ReferralService getServiceInstance() {
        if (singleInstance == null) {
            synchronized (ReferralService.class) {
                if (singleInstance == null) {
                    singleInstance = new ReferralService();
                }
            }
        }
        return singleInstance;
    }

    /**
     * Adds a new referral to the system.
     * 
     * @param referral the referral to add
     */
    public void registerReferral(ClinicalReferral referral) {
        referralList.add(referral);
    }

    /**
     * Retrieves all referrals in the system.
     * 
     * @return list of all referrals
     */
    public List<ClinicalReferral> retrieveAllReferrals() {
        return new ArrayList<>(referralList);
    }

    /**
     * Finds a referral by its ID.
     * 
     * @param referralId the referral ID to search for
     * @return the referral if found, null otherwise
     */
    public ClinicalReferral findReferralById(String referralId) {
        for (ClinicalReferral referral : referralList) {
            if (referral.getReferralId().equals(referralId)) {
                return referral;
            }
        }
        return null;
    }

    /**
     * Generates a unique referral ID.
     * 
     * @return a new referral ID
     */
    public String generateReferralId() {
        return "REF-" + String.format("%04d", referralCounter++);
    }

    /**
     * Gets the total number of referrals.
     * 
     * @return count of referrals
     */
    public int getReferralCount() {
        return referralList.size();
    }
}
