public class Jdk15 {
    public static void main(String[] args) {
        //stringConcatenation();
        noStringConcatenationWithTextBlock();
    }

    /**
     * Mostra como usar o recurso de Text Block.
     * Perceba que não temos que nos preocupar em concatenar Strings,
     * nem manualmente inserir uma quebra de linha (\n) onde queremos.
     * As quebras são inseridas automaticamente quando pressionado ENTER no
     * bloco de texto.
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
