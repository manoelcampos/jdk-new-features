public class Jdk15 {
    public static void main(String[] args) {
        //stringConcatenation();
        noStringConcatenationWithTextBlock();
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
     * Show how you can create more formatted
     * Strings
     */
    private static void formattedTextBlock() {
        final String city = "Palmas";
        final String state = "Tocantins";
        final String region = "North";
        final String capital = "Yes";
        final double areaKm2 =  2.219;

        final String cityData =
                """
                City: %s
                State: %s
                Region: %s
                Capital: %s
                Area: %.2f KM²
                """.formatted(city, state, region, capital);
        System.out.println(cityData);
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
