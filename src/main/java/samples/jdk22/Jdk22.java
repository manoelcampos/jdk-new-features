package samples.jdk22;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static java.lang.StringTemplate.Processor;

class SampleClass{
    private final String jdkVersion;

    SampleClass(final String jdkVersion) {
        this.jdkVersion = Objects.requireNonNull(jdkVersion);
    }

    public String getJdkVersion() {
        return jdkVersion;
    }
}

public class Jdk22 extends SampleClass {
    /**
     * Instance main method. A simplified version of the main method that can be used in a class,
     * which doesn't require to be static and don't need a String array if you aren't going
     * to take command line parameters.
     * Started as preview in JDK 11. Second preview in JDK 22.
     * @see <a href="https://openjdk.org/jeps/445"></a>
     * @see <a href="https://openjdk.org/jeps/463"></a>
     */
    void main() {
        new Jdk22();
    }

    /**
     * A constructor showing how to use statements before calling the super constructor.
     * @see <a href="https://openjdk.org/jeps/447">https://openjdk.org/jeps/447</a>
     */
    public Jdk22(){
        // Calling any statements before a super or this construtor was not allowed before.
        String jdkVersion = "JDK 22";
        unamedVar();
        stringTemplate();
        jsonStringTemplate();
        super(jdkVersion);
    }

    /**
     * Creates a {@link JSONObject} using the String Template feature
     * (from JDK 22) and Text Blocks (from JDK 15).
     * Then it writes the JSON object to a file.
     * It instantiates not just a String, but an actual
     * {@link JSONObject} from a String.
     *
     * @see <a href="https://openjdk.org/jeps/459">https://openjdk.org/jeps/459</a>
     * @see <a href="https://openjdk.org/jeps/378">https://openjdk.org/jeps/378 (JDK 15)</a>
     * @see <a href="https://docs.oracle.com/en/java/javase/22/docs/specs/string-templates-jls.html">Sample source</a>
     */
    private static void jsonStringTemplate() {
        // See the static import (just for shortcut)
        Processor<JSONObject, RuntimeException> JSON = st -> new JSONObject(st.interpolate());

        String name    = "Joan Smith";
        String phone   = "555-123-4567";
        String address = "1 Maple Drive, Anytown";

        // Uses a Text Block (multi-line string)
        final JSONObject doc = JSON.
            """
            {
                "name":    "\{name}",
                "phone":   "\{phone}",
                "address": "\{address}"
            }
            """;

        final var path = Paths.get("contact.json");
        try (var writer = doc.write(Files.newBufferedWriter(path))){
            System.out.println(STR."JSON object written to file: \{path}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Shows how to use string template with the new {@link StringTemplate#STR} processor,
     * so that you can interpolate variables directly into a string,
     * following the pattern: {@snippet : STR."My message here: \{variableX}"}
     *
     * You don't need to import the {@link StringTemplate} class to use it.
     * The processor is automatically available in the classpath as if it was directly inside java.lang package.
     *
     * @see <a href="https://openjdk.org/jeps/459">https://openjdk.org/jeps/459</a>
     */
    private static void stringTemplate(){
        final String name = "Manoel";
        final int age = 44;
        final String role = "Software Engineer";
        final String msg = STR."Hello, my name is \{name}, I'm \{age} years old and I'm a \{role}.";
        System.out.println(msg);
    }

    /**
     * Shows how to use underscore to represent an unused variable/parameter,
     * so that it is ignored and can't be used.
     * @see <a href="https://openjdk.java.net/jeps/456">https://openjdk.java.net/jeps/456</a>
     */
    private static void unamedVar(){
        //Heights initially in centimeters
        final var personHeightMap = new HashMap<>(
                Map.of("John", 180.0, "Mary", 160.0, "Peter", 175.0, "Lucy", 165.0, "Paul", 190.0, "Alice", 155.0,
                       "Mark", 170.0, "Sandra", 175.0, "David", 185.0, "Eva", 160.0));

        // Converts the heights to meters
        // The name key is not being used in the lambda expression, so it can be replaced by an underscore
        personHeightMap.replaceAll((_, height) -> height/100.0);
        personHeightMap.forEach((name, height) -> System.out.printf("Name: %s | Height %.2fm\n", name, height));
        System.out.println();
    }
}
