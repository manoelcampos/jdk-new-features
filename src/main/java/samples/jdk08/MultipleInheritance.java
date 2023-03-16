package samples.jdk08;

import java.util.regex.Pattern;

/**
 * Changes the chars into a String to anoter representation.
 */
interface StringEncoder {
    String convert(String text);
}

/**
 * Replaces some letters by numbers.
 * <a href="https://en.wikipedia.org/wiki/Leet">Leet</a>
 */
interface LeetCode extends StringEncoder {
    // Partial list of leet codes.
    String[][] leetCodes = {
            {"A", "4"},
            {"B", "8"},
            {"C", "(", "{"},
            {"D", "|)"},
            {"E", "3"},
            {"F", "ph"},
            {"G", "6"},
            {"H", "#"},
            {"I", "1"},
            {"J", "j"},
            {"K", "|<"},
            {"O", "0"}};

    @Override
    default String convert(String text) {
        for (final String[] row : leetCodes) {
            text = text.replaceAll(row[0], row[1]);
        }

        return text;
    }
}

/**
 * Capitalizes every first letter into a word.
 */
class Camelcaser implements StringEncoder {
    @Override
    public String convert(String text) {
        final var matcher = Pattern.compile("(^[a-z])|\\s([a-z])").matcher(text);
        return matcher.replaceAll(r -> r.group(0).toUpperCase());
    }
}

/**
 * Converts the String to uppercase
 */
interface Uppercaser extends StringEncoder {
    @Override
    default String convert(String text) {
        return text.toUpperCase();
    }
}

/**
 * Converts a String into uppercase then to Leet code,
 * using the interfaces {@link Uppercaser} and {@link LeetCode}.
 * Since those interfaces have a default implementation for the convert method,
 * this UpperLeet class could not use both of them,
 * causing the <a href="https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem">Diamond of Death issue</a>.
 * If you just remove the convert method below
 * you'll see the method doesn't compile.
 *
 * <p>
 * Overriding the method, you can decide which implementation to use.
 * In this example, I decided to use both.
 * </p>
 *
 * <p><b>NOTICE:</b> THIS IS JUST AN EXAMPLE ON HOW TO USE MULTIPLE
 * INHERITANCE WITH DEFAULT METHODS ON JDK 8+.
 * KEEP IN MIND THE SOLUTION PROVIDED HERE IS JUST FOR DEMONSTRATION
 * PURPOSES. USING FUNCTIONAL PROGRAMMING AND FUNCTION COMPOSITION
 * TO IMPLEMENT THE FEATURES IN THIS CLASS WILL BE MUCH EASIER.</p>
 */
class UpperLeet implements Uppercaser, LeetCode {
    @Override
    public String convert(final String text) {
        final String upperCase = Uppercaser.super.convert(text);
        return LeetCode.super.convert(upperCase);
    }
}

/**
 * Shows how to use multiple inheritance in JDK 8 with
 * default methods in interfaces.
 * Thoses methods have a default implementation
 * that are inherited by implementing classes.
 * The {@link UpperLeet} class applies multiple
 * inheritance by implementing the {@link Uppercaser}
 * and {@link LeetCode} interfaces.
 */
public class MultipleInheritance {
    public static void main(String[] args) {
        final var str = "a string with all letters lower case, just to try";
        System.out.printf("Original   String: %s%n", str);
        System.out.printf("Camelcase  String: %s%n", new Camelcaser().convert(str));
        System.out.printf("Upper Leet String: %s%n", new UpperLeet().convert(str));
    }
}
