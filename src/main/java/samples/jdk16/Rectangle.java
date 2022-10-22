package samples.jdk16;

/**
 * A record that represents a rectangle based on two
 * {@link Point}s.
 *
 * @param p1 point in the top-left corner of the rectangle
 * @param p2 point in the lower-right corner of the rectangle
 */
public record Rectangle(Point p1, Point p2) {
    public boolean isSquare() {
        return (p2.x() - p1.x()) == (p2.y() - p1.y());
    }

    public double width(){ return p2.x() - p1.x(); }

    public double height(){ return p2.y() - p1.y(); }
}
