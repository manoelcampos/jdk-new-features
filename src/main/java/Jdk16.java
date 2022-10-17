/**
 * Cria um record (registro), que é uma classe apenas para armazenamento de dados,
 * contendo automaticamente métodos getters com o mesmo nome dos atributos,
 * além de {@link #toString()} e {@link #hashCode()}.
 * Os parâmetros passados na declaração do record são declarados
 * automaticamente:
 * <ul>
 *     <li>como atributos dele;</li>
 *     <li>e em um construtor com todos estes parâmetros (não existindo construtor padrão sem parâmetros).</li>
 * </ul>
 *
 * @param name
 * @param city
 * @param state
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
