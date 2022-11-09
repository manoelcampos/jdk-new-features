package samples.jdk18;

import samples.jdk17.LegalPerson;
import samples.jdk17.NaturalPerson;
import samples.jdk17.Person;

import java.time.LocalDate;

public class Jdk18 {
    private NaturalPerson naturalPerson;
    private LegalPerson legalPerson;

    public static void main(String[] args) {
        new Jdk18();
    }

    private Jdk18() {
        createPeople();
        patternMatchingForSwitches();

        /*
        //The called method uses if instead of the Switch Pattern Matching feature.
        System.out.println("Gets the date field from natural person: " + getPersonDateUsingIf(naturalPerson));
        System.out.println("Gets the date field from legal person: " + getPersonDateUsingIf(legalPerson));
        */
    }

    /**
     * Shows how the Pattern Matching for Switches feature is used by
     * the {@link #getPersonDateUsingSwitchPatternMatching(Person)} method.
     */
    private void patternMatchingForSwitches() {
        var msg1 = "Natural person date: " + getPersonDateUsingSwitchPatternMatching(naturalPerson);
        System.out.println(msg1);

        var msg2 = "Legal person date: " + getPersonDateUsingSwitchPatternMatching(legalPerson);
        System.out.println(msg2);
    }

    /**
     * Gets the birthdate if the person is a {@link NaturalPerson}
     * or the foundation date if the person is a {@link LegalPerson}.
     * It uses the new Pattern Matching for Switches feature
     * to avoid casting to access the specific methods
     * in each different object.
     *
     * @param person
     * @return
     * @see <a href="https://openjdk.org/jeps/420">JEP 420</a>
     */
    private LocalDate getPersonDateUsingSwitchPatternMatching(final Person person) {
        return switch(person) {
            case NaturalPerson human -> human.getBirthDate();
            case LegalPerson company -> company.getFoundationDate();
        };
    }

    /**
     * This is the old way to call a specific method in each
     * kind of person given as parameter.
     * @param person
     * @return
     */
    private LocalDate getPersonDateUsingIf(final Person person) {
        if (person instanceof NaturalPerson)
            return ((NaturalPerson)person).getBirthDate();
        else // if(person instanceof LegalPerson)
        {
            /* Since Person is a selead class,
            * we know for sure that if the person is not a natural person,
            * it is a legal person. There are only these two options. */
            return ((LegalPerson)person).getFoundationDate();
        }

        /*
        There is no need for such a kind of operation,
        even if we just have "else if" statement after the first "if",
        because Person is a sealed class.

        Try to uncomment the if after the else above, so you can see the
        code still compiles, even without this line below.
        */
        //throw new UnsupportedOperationException("The kind of person given is not supported.");
    }

    private void createPeople() {
        this.naturalPerson = new NaturalPerson();
        naturalPerson
                .setGender('M')
                .setBirthDate(LocalDate.now())
                .setName("Manoel Campos")
                .setAddress("Street 1");
        System.out.println(naturalPerson);

        this.legalPerson = new LegalPerson();
        legalPerson
                .setWebsite("https://mycompany.com")
                .setFoundationDate(LocalDate.of(1950, 3, 19))
                .setName("My Company")
                .setAddress("5th Avenue");
        System.out.println(legalPerson);
        System.out.println();
    }
}
