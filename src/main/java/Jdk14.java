import java.time.DayOfWeek;

public class Jdk14 {
    public static void main(String[] args) {
        //oldSwitch();
        switchExpressionSingleLine();
        switchExpressionExaustiveWithEnum();
        //switchExpressionMultiLine()
    }

    /**
     * Exemplo de uso do novo recurso de Switch Expression onde cada instrução case tem apenas uma linha de código.
     * Permite atribuir o resultado de uma Switch Expression para uma variável,
     * no lugar de repetir a atribuição de um valor à variável em cada um dos case's.
     * Diferente do Switch convencional, tal variável pode ser final,
     * trazendo garantias de que variáveis não serão alteradas indevidamente
     * em locais posteriores do código.
     */
    private static void switchExpressionSingleLine() {
        final int month = (int)(Math.random()*12 + 1);
        final int days = switch (month) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };

        System.out.printf("Month: %d Days: %d%n", month, days);
    }

    /**
     * Exemplo de uso de Switch Expression exaustiva com Enum:
     * verifica se todos os valores possíves para a Enum foram incluídos.
     */
    private static void switchExpressionExaustiveWithEnum() {
        final var weekDay = DayOfWeek.of((int)(Math.random()*7 + 1));
        final var categoryName = switch (weekDay) {
            case SATURDAY, SUNDAY -> "Weekend";
            default -> "Weekday";
        };

        System.out.printf("%s is %s%n", weekDay, categoryName);
    }

    /**
     * Exemplo de uso do novo recurso de Switch Expression onde instruções case podem ter múltiplas linhas.
     */
    private static void switchExpressionMultiLine() {
        final int month = (int)(Math.random()*12 + 1);
        final int days = switch (month) {
            case 2 -> {
                System.out.println("We are not considering that for leap years February has 29 days.");
                yield 28;
            }
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };

        System.out.printf("Month: %d Days: %d%n", month, days);
    }

    /**
    private static void switchExpressionNonExaustive() {
        // Código deste método NÃO COMPILA, pois com Switch Expression, o compilador verifica
        // se todas as possibilidades foram cobertas nos comandos case.
        // Neste examplo, os meses com 31 dias não foram incluídos no switch
        // nem uma cláusula default para retornar 31 como valor padrão foi incluída.
        // Assim, variável days não teria um valor caso o mês fosse de 31 dias.
        final int month = (int)(Math.random()*12 + 1);
        final int days = switch (month) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
        };

        System.out.printf("Month: %d Days: %d%n", month, days);
    }
    */

    private static void oldSswitch() {
        final int month = (int)(Math.random()*12 + 1);
        int days;
        switch (month) {
            case 2: days = 28; break;
            case 4, 6, 9, 11: days = 30; break;
            default: days = 31; break;
        }

        System.out.printf("Month: %d Days: %d%n", month, days);
    }
}
