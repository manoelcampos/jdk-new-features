/**
 * A sample class that doesn't belong to any package,
 * that uses {@link Jdk22SuperClass}, and enables you to compile
 * all required classes and run this {@link #main(String[])} method
 * just typing at the terminal: {@snippet lang=bash : java Jdk22Class2.java}
 *
 * @author Manoel Campos
 * @see <a href="https://openjdk.org/jeps/458">https://openjdk.org/jeps/458</a>
 */
public class Jdk22SubClass extends Jdk22SuperClass{
    public static void main(String[] args) {
        var obj = new Jdk22SubClass("Manoel");
        System.out.println("Name: " + obj.getName());
    }

    public Jdk22SubClass(String name) {
        super(name);
    }
}
