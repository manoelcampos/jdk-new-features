package samples.jdk17;

import java.time.LocalDate;

/**
 * A legal person that represents a business or organization.
 * In Portuguese, it's called "Pessoa Jurídica".
 */
public final class LegalPerson extends Person {
    private LocalDate foundationDate;
    private String website;

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
