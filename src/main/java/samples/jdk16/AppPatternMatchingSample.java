package samples.jdk16;

public class AppPatternMatchingSample {
    public static void main(String[] args) {
        final var p0 = new Point();
        printObjectUsingInstanceOfPatternMatching(p0);

        final var p1 = new Point(10, 20);
        printObjectUsingInstanceOfPatternMatching(p1);
        System.out.println();

        final var r1 = new Rectangle(p0, p1);
        printObjectUsingInstanceOfPatternMatching(r1);

        final var p2 = new Point(50);
        final var r2 = new Rectangle(p0, p2);
        printObjectUsingInstanceOfPatternMatching(r2);
    }

    /**
     * Shows how to use instanceof pattern matching to avoid
     * having to perform typecast to access elements
     * from specific for a given type.
     *
     * <p>See that the instanceof here is followed by a variable declaration.
     * The instruction checks if obj is an instance
     * of the specified type.
     * In that case, a variable p is declared with that type
     * and can be accessed inside the if statement.
     *</p>
     *
     * <p>Without this new feature, we need to manually cast the object
     * to the expected type, as shown in {@link #printObjectInTradditionalWay(Object)}.</p>
     *
     * @param obj the object to print
     */
    private static void printObjectUsingInstanceOfPatternMatching(Object obj) {
        if(obj instanceof Point p){  // see there is a variable declaration here
            final var location = p.isOrigin() ? "in the origin" : "somewhere";
            System.out.println("Point " + location);
            return;
        }

        if(obj instanceof Rectangle r){  // see there is a variable declaration here
            final var shape = r.isSquare() ? "square" : "regular";
            System.out.printf("%s Rectangle %.2f x %.2f%n", shape, r.width(), r.height());
            return;
        }

        System.out.printf("Invalid object type: %s%n", obj.getClass().getSimpleName());
    }

    /**
     * This version of the previous method doesn't use the new instanceof pattern matching feature.
     * This way, we have to manually cast an object to the desired type if we want to access
     * members (fields/methods) specific to that type.
     * @param obj the object to print
     */
    private static void printObjectInTradditionalWay(Object obj) {
        if(obj instanceof Point){
            final Point p = (Point)obj; //we need to cast manually
            final var location = p.isOrigin() ? "in the origin" : "somewhere";
            System.out.println("Point " + location);
            return;
        }

        if(obj instanceof Rectangle){
            final Rectangle r = (Rectangle)obj; //we need to cast manually
            final var shape = r.isSquare() ? "square" : "regular";
            System.out.printf("%s Rectangle %.2f x %.2f%n", shape, r.width(), r.height());
            return;
        }

        System.out.printf("Invalid object type: %s%n", obj.getClass().getSimpleName());
    }
}
