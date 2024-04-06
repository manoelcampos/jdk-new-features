/**
 * A sample class that doesn't belong to any package,
 * that uses {@link Jdk22Class1}, and enables you to compile
 * all required classes and run this {@link #main(String[])} method
 * just typing at the terminal: {@snippet lang=bash : java Jdk22Class2.java}
 *
 * @author Manoel Campos
 * @see <a href="https://openjdk.org/jeps/458">https://openjdk.org/jeps/458</a>
 */
public class Jdk22Class2 {
    private final Jdk22Class1 class1 = new Jdk22Class1("class1");

    public static void main(String[] args) {
        new Jdk22Class2();
    }

    public Jdk22Class2() {
        System.out.println("Name: " + class1.getName());
    }
}
