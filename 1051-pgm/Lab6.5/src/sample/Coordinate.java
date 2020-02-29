package sample;

// Class that holds an x and y Coordinate to make it easier to reuse
// points for drawing javafx Shapes

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // formats the Coordinate into a human readable String in the form of
    // "(x, y)" for printing or debugging
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // getter for x coordinate
    public double x() {
        return x;
    }

    // getter for y coordinate
    public double y() {
        return y;
    }
}
