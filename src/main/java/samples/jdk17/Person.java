package samples.jdk17;

import java.util.Objects;

/**
 * A selead class used to implement different kinds of people.
 * The interface just allows a list of permited classes
 * to implement it. This way, we can always now what are
 * all the classes that implement this interface.
 *
 * @see NaturalPerson
 * @see LegalPerson
 * @see <a href="https://openjdk.org/jeps/409>JEP 409</a>
 */
public sealed abstract class Person permits NaturalPerson, LegalPerson {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = Objects.requireNonNull(address);
        return this;
    }

    @Override
    public String toString() {
        return "Name: %s Address: %s".formatted(name, address);
    }
}
