package samples.jdk16;

import samples.shared.CountryClass;

/**
 * Creates a record, which is like a data class (used just to store data),
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
 * <p>
 * You can check the {@link CountryClass} class
 * that provides the same features as this extremelly
 * simple record, but with a lot of boilerplate code.
 * </p>
 *
 * @param name
 * @param continent
 */
public record Country(String name, String continent) {
}
