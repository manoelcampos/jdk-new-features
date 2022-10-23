package samples.jdk19;

import samples.jdk16.Point;
import samples.jdk16.Rectangle;

public class Jdk19 {
    public static void main(String[] args) {
        final var p1 = new Point(10, 20);
        printObjectInfo(p1);

        System.out.println();
        final var p2 = new Point(80, 100);
        printObjectInfo(new Rectangle(p1, p2));
    }

    /**
     * Shows how to use the Record Pattern Matching,
     * which is a kind of destructuring pattern
     * we find in JavaScript and other languages.
     * @param obj
     */
    private static void printObjectInfo(Object obj) {
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

        System.out.println("Unknow object: " + obj.getClass().getSimpleName());
    }
}
