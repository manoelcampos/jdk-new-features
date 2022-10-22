package samples.jdk15;

public class Jdk15 {
    public static void main(String[] args) {
        //stringConcatenation();
        noStringConcatenationWithTextBlock();
        formattedTextBlock();
    }

    /**
     * Shows how to use a Text Block.
     * See that we don't have to worry about String concatenation,
     * neither manually insert line breaks (\n).
     * Line breaks are inserted automatically when you press ENTER inside
     * the Text Block.
     */
    private static void noStringConcatenationWithTextBlock() {
        final String html =
                """
                <table>
                  <tr><th>Site</th><th>Domain</th></tr>
                  <tr><td>Instagram</td><td>https://instagram.com/manoelcampos</td></tr>
                  <tr><td>GitHub</td><td>https://github.com/manoelcampos</td></tr>
                  <tr><td>Twitter</td><td>https://twitter.com/manoelcampos</td></tr>
                  <tr><td>YouTube</td><td>https://youtube.com/manoelcamposfh</td></tr>
                </table>
                """;
        System.out.println(html);
    }

    /**
     * Show how you can create formatted
     * Strings that are easier to ready,
     * providing a more clean code.
     */
    private static void formattedTextBlock() {
        final String city = "Palmas", state = "Tocantins";
        final double areaKm2 =  2.219;

        final String cityStr =
                """
                City: %s
                State: %s
                Area: %.2f KM²
                """.formatted(city, state, areaKm2);
        System.out.println(cityStr);

        /*
        //The same code using the traditional String.format method.
        //The code is less readable and the dev needs to manually include line breaks.
        final String cityStr2 = String.format("City: %s\nState: %s\nArea: %.2f KM²", city, state, areaKm2);
        System.out.println(cityStr2);
        */
    }

    private static void stringConcatenation() {
        final String html =
                      "<table>\n" +
                      "  <tr><th>Site</th><th>Domain</th></tr>\n" +
                      "  <tr><td>Instagram</td><td>https://instagram.com/manoelcampos</td></tr>\n" +
                      "  <tr><td>GitHub</td><td>https://github.com/manoelcampos</td></tr>\n" +
                      "  <tr><td>Twitter</td><td>https://twitter.com/manoelcampos</td></tr>\n" +
                      "  <tr><td>YouTube</td><td>https://youtube.com/manoelcamposfh</td></tr>\n" +
                      "</table>\n";
        System.out.println(html);
    }
}
