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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}

