package samples.jdk17;

import java.time.LocalDate;

/**
 * A natural person that represents an individual, a human being.
 * It's a final class extending the selead class {@link Person}.
 * In Portuguese, it's called "Pessoa Física".
 *
 * @see <a href="https://openjdk.org/jeps/409>JEP 409</a>
 */
public final class NaturalPerson extends Person {
    private LocalDate birthDate;
    private char gender;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public NaturalPerson setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public char getGender() {
        return gender;
    }

    public NaturalPerson setGender(char gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        final String personData = super.toString();
        return "%s Birth date: %s Gender: %c".formatted(personData, birthDate, gender);
    }
}

