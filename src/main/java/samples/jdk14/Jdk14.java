package samples.jdk14;

import java.time.DayOfWeek;

public class Jdk14 {
    public static void main(String[] args) {
        //oldSwitch();
        switchExpressionSingleLine();
        switchExpressionExaustiveWithEnum();
        //switchExpressionMultiLine()
    }

    /**
     * Shows utilization example of the new Switch Expression feature,
     * where each case instruction has only one line of code.
     * Switch Expressions enable the switch to yield ("return") a value
     * which can be assigned to a variable.
     * Different from the tradditional switch, such a variable can be
     * final because we have just a single variable assignement.
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
     * Show how Switch Expression can be exahustive when using
     * together with enums. Checks if all possible values for an enum
     * were covered by the switch.
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
     * Shows how to use a Switch Expression with multiple intructions for
     * some cases.
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
        //This code DOES NOT COMPILE, since using Switch Expression,
        //the compiler che ks if all options were covered by the case instructions.
        //In this example, months with 31 days weren't included in the switch,
        //neither a default clause.
        //This way, the days variable wouldn't have a value for months 1, 3, 5, 7, 8, 10 and 12.
        // Código deste método NÃO COMPILA, pois com Switch Expression, o compilador verifica
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
