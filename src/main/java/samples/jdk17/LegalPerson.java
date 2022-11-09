package samples.jdk17;

import java.time.LocalDate;

/**
 * A legal person that represents a business or organization.
 * It's a final class extending the selead class {@link Person}.
 * In Portuguese, it's called "Pessoa Jurídica".
 *
 * @see <a href="https://openjdk.org/jeps/409>JEP 409</a>
 */
public final class LegalPerson extends Person {
    private LocalDate foundationDate;
    private String website;

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public LegalPerson setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public LegalPerson setWebsite(String website) {
        this.website = website;
        return this;
    }

    @Override
    public String toString() {
        final String personData = super.toString();
        return "%s Foundation date: %s Website: %s".formatted(personData, foundationDate, website);
    }
}
