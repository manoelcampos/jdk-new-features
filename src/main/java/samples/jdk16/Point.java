package samples.jdk16;

/**
 * Using records, you can even define overloaded constructors
 * as you do for classes.
 * You can even any other method you want.
 *
 * @param x
 * @param y
 */
public record Point(double x, double y) {
    /**
     * Creates a point with default coordinates 0.
     */
    public Point(){
        this(0, 0);
    }

    /**
     * Creates a point with the same value for x and y.
     * @param x
     */
    public Point(double x){
        this(x, x);
    }

    /**
     * When you create a record, the parameters
     * given in the record declaration are used to provide
     * a default constructor with all those values.
     * However, if you want to customize this constructor,
     * you can explicitly add it as this one,
     * to perform any operation you want.
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.printf("# Creating point %.2f, %.2f%n", x, y);
    }

    public boolean isOrigin(){ return x == 0 && y == 0; }

    /**
     * Computes the distance between this point and other point.
     * @param other
     * @return
     */
    public double distance(Point other){
        return square(other.x - x) + square(other.y - y);
    }

    private static double square(final double val){ return val * val; }
}
