package sample;

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate(double x, double y) {
        this.x = (int) (((double) x / UseGUI3.MAX_X) * UseGUI3.MAX_X);
        this.y = (int) (((double) y / UseGUI3.MAX_Y) * UseGUI3.MAX_Y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }
}
