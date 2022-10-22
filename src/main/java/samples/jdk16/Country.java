package samples.jdk16;

/**
 * This is what a regular data class (which just stores data)
 * looks like in traditional Java code.
 * We have attributes, getters and possibly a {@link #toString()} method.
 * If we don't want to change object attribute values,
 * we don't include setters.
 *
 * <p>After JDK 16, such a class can be replaced by a Record,
 * such as {@link CountryRecord}, which removes all boilerplate code,
 * providing the same features.</p>
 */
public final class Country {
    private final String name;
    private final String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "Country[name= %s, continent=%s]".formatted(name, continent);
    }
}