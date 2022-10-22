/**
 * Creates a record, which is like a class for data storage only,
 * automatically including getters with the same name of the attributes,
 * a {@link #toString()} and {@link #hashCode()} method.
 *
 * <p>
 * The parameters in the record declaration
 * are automatically declared as:
 * <ul>
 *     <li>the record attributes;</li>
 *     <li>parameters for a default constructor.</li>
 * </ul>
 * </p>
 *
 * @param name
 * @param continent
 */
record Country(String name, String continent){
}

public class Jdk16 {
    public static void main(String[] args) {
        var country = new Country("Portugal", "Europe");
        //Prints using the default toString() method.
        System.out.println(country);

        //Prints by calling each getter method provided automatically.
        System.out.printf("%s is in %s%n", country.name(), country.continent());
    }
}
