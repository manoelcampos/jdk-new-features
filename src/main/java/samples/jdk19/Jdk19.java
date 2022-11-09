package samples.jdk19;

import samples.jdk16.Point;
import samples.jdk16.Rectangle;

public class Jdk19 {
    public static void main(String[] args) {
        final var p1 = new Point(10, 20);
        printObjInfoUsingRecordPattern(p1);

        System.out.println();
        final var p2 = new Point(80, 100);
        printObjInfoUsingRecordPattern(new Rectangle(p1, p2));
    }

    /**
     * Shows how to use the Record Pattern Matching,
     * which is a kind of destructuring pattern
     * we find in JavaScript and other languages.
     * Objects given as parameter don't need to belong to a hierarchy.
     *
     * <p>It's used when we need to access specific members for different
     * classes of object.</p>
     *
     * @param obj object to print data
     * @see <a href="https://openjdk.org/jeps/405">JEP 405</a>
     */
    private static void printObjInfoUsingRecordPattern(final Object obj) {
        /* After the instanceof we are extracting the attributes x and y
        *  out of the obj if it is a Point instance.
        *  This way, we can use x and y instead of p.x() and p.y().
        */
        if (obj instanceof Point(int x, int y)) {
            System.out.printf("Sum of coordinates for given point: %d%n", x+y);
            return;
        }

        /* After the instanceof we are extracting the attributes p1 and p2
         *  out of the obj if it is a Rectangle instance.
         * This way, we can use p1 and p1 instead of r.p1() and r.p2().
         */
        if (obj instanceof Rectangle(Point p1, Point p2)) {
            System.out.printf("Rectangle points: %s, %s%n", p1, p2);
            return;
        }

        System.out.println("Unknown object: " + obj.getClass().getSimpleName());
    }
}
