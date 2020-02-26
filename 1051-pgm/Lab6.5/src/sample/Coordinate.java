package sample;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = (int) (((double) x / UseGUI3.maxX) * UseGUI3.h);
        this.y = (int) (((double) y / UseGUI3.maxY) * UseGUI3.w);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
