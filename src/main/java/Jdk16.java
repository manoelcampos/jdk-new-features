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
record Person(String name, String city, String state){
}

public class Jdk16 {
    public static void main(String[] args) {
        createRecord();
    }

    private static void createRecord() {
        var person = new Person("Manoel", "Palmas", "TO");
        //Prints using the default toString() method.
        System.out.println(person);

        //Prints by calling each getter method provided automatically.
        System.out.printf("My name is %s and I live in %s-%s%n", person.name(), person.city(), person.state());
    }
}
