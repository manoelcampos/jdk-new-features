package samples.jdk16;

/**
 * Using records, you can even define overloaded constructors
 * as you do for classes.
 * You can even any other method you want.
 *
 * @param x
 * @param y
 */
public record PointRecord(double x, double y) {
    /**
     * Creates a point with default coordinates 0.
     */
    public PointRecord(){
        this(0, 0);
    }

    /**
     * Creates a point with a specific value for x and 0 for y.
     * @param x
     */
    public PointRecord(double x){
        this(x, 0);
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
    public PointRecord(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.printf("# Creating point %.2f, %.2f%n", x, y);
    }

    /**
     * Computes the distance between this point and other point.
     * @param other
     * @return
     */
    public double distance(PointRecord other){
        return square(other.x - x) + square(other.y - y);
    }

    private static double square(final double val){ return val * val; }
}
