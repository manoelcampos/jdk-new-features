package samples.jdk17;

import java.time.LocalDate;

public class Jdk17 {
    public static void main(String[] args) {
        createPeople();
    }

    /**
     * Creates the {@link NaturalPerson} and {@link LegalPerson}
     * which extend the selead class {@link Person}.
     *
     * <p>
     * The chainned calls to setter methods are not a JDK feature,
     * just a OOP practice to make it easier to call
     * methods in sequence.
     * </p>
     */
    private static void createPeople() {
        final var naturalPerson = new NaturalPerson();
        naturalPerson
                .setGender('M')
                .setBirthDate(LocalDate.now())
                .setName("Manoel Campos")
                .setAddress("Street 1");
        System.out.println(naturalPerson);

        final var legalPerson = new LegalPerson();
        legalPerson
                .setWebsite("https://mycompany.com")
                .setFoundationDate(LocalDate.of(2000, 10, 19))
                .setName("My Company")
                .setAddress("5th Avenue");
        System.out.println(legalPerson);
    }
}
