package samples.jdk16;

/**
 * Shows how to use Records.
 * @see <a href="https://openjdk.org/jeps/395">JEP 395</a>
 */
public class AppRecordSample {
    public static void main(String[] args) {
        createCountryRecord();
        createPointRecord();
    }

    /**
     * Show how to use the basic {@link Country}
     * which provides just one constructor.
     */
    private static void createCountryRecord() {
        var country = new Country("Portugal", "Europe");
        //Prints using the default toString() method.
        System.out.println(country);

        //Prints by calling each getter method provided automatically.
        System.out.printf("%s is in %s%n", country.name(), country.continent());
    }

    /**
     * Show how to use the more complex {@link Point}
     * which provides multiple constructors.
     */
    private static void createPointRecord() {
        System.out.println();
        System.out.println(new Point());
        final var p1 = new Point(10);
        final var p2 = new Point(20, 30);
        final var p3 = new Point(20, 40);
        System.out.println(p1);
        System.out.println(p2);
        System.out.printf("p1 to p2 distance: %d%n", p1.distance(p2));
        System.out.printf("p2 to p3 distance: %d%n", p2.distance(p3));

        final int coordinatesSum = p3.x() + p3.y();
        System.out.printf("p3: x + y = %d%n", coordinatesSum);

        //DOES NOT COMPILE: record attributes are private
        //p1.x = 3;

        //DOES NOT COMPILE: records are immutable and therefore don't have setters
        //p1.setX(3);

        /*DOES NOT COMPILE: remember record getters have the same name of the attribute.
        There is no "get" prefix. It's p1.x() instead of p1.getX(). */
        //p1.getX(3);
    }
}
