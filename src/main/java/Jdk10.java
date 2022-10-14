import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

public class Jdk10 {
    public static void main(String[] args) throws IOException {
        localVariableTypeInference();
    }

    /**
     * Mostra com usar a nova palavra reservada "var"
     * para declarar variáveis locais, onde o compilador
     * descobre automaticamente o tipo de uma variável
     * de acordo com o valor atribuído a ela.
     *
     * @see <a href="https://openjdk.org/jeps/286">JEP 286</a>
     * @see <a href="https://openjdk.org/projects/amber/guides/lvti-style-guide ">Style Guide</a>
     */
    @SuppressWarnings("unused")
    private static void localVariableTypeInference() throws IOException {
        var currentDate = LocalDate.now();
        var url = new URL("https://bio.link/manoelcampos");
        var scanner = new Scanner(System.in);
        System.out.print("Whats your name: ");
        var name = scanner.nextLine();
        System.out.printf("Hello %s%n", name);
    }
}
