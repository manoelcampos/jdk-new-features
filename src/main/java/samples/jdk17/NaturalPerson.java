package samples.jdk17;

import java.time.LocalDate;

/**
 * A natural person that represents an individual, a human being.
 * In Portuguese, it's called "Pessoa Física".
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

