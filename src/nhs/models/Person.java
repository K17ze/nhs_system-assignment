package nhs.models;

/**
 * Base class representing a person in the NHS system.
 * Provides common attributes for all system entities.
 */
public abstract class Person {
    protected String identifier;
    protected String fullName;
    protected String emailAddress;

    public Person(String identifier, String fullName, String emailAddress) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
