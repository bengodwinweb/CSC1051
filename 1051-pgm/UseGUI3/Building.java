package UseGUI3;

// Class that creates rectangular representations of a "building"
// given an origin Coordinate, width, height, and color. Parent of ThreeDimensionalBuilding

/*
*               BUILDING
*
*                width
*         C4  ___________  C3
*            |           |
*            |           |
*            |           |
*            |           |  height
*            |           |
*            |           |
*            |           |
*            |           |
*     Origin  ------------  C2
*
* */

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;

public class Building {
        private final double width;
        private final double height;
        private Color color;
        // saves the corners as Coordinates so they can be referenced
        // by new buildings or when creating outlines
        private Coordinate origin; // bottom left corner
        private Coordinate coord2; // bottom right corner
        private Coordinate coord3; // top right corner
        private Coordinate coord4; // top left corner

        public Building(Coordinate origin, double width, double height, Color color) {
            this(
                    origin, // set bottom left
                    // keep y from origin, move x over width to get bottom right
                    new Coordinate(origin.x() + width, origin.y()),
                    // keep x from bottom right, move y up height to get top right
                    new Coordinate(origin.x() + width, origin.y() - height),
                    // keep y from top right, move x over -width to get top left
                    new Coordinate(origin.x(), origin.y() - height),
                    color,
                    width,
                    height
            );
        }

        private Building(
                Coordinate origin,
                Coordinate coord2,
                Coordinate coord3,
                Coordinate coord4,
                Color color,
                double width,
                double height
        ) {
            this.origin = origin;
            this.coord2 = coord2;
            this.coord3 = coord3;
            this.coord4 = coord4;
            this.color = color;
            this.width = width;
            this.height = height;
        }

        // Returns a group containing the "Building" shape
        /* Has to return a group so it has the same return type
            as overridden method in children classes that create
            more than one shape */
        public Group makeBuilding() {
            // Creates a polygon using the four points
            Polygon polygon = new Polygon(
                    origin.x(), origin.y(),
                    coord2.x(), coord2.y(),
                    coord3.x(), coord3.y(),
                    coord4.x(), coord4.y()
            );
            polygon.setFill(color); // set building fill color
            return new Group(polygon);
        }

        // Getters for corner Coordinates
        protected Coordinate getOrigin() {
            return origin;
        }

        protected Coordinate getC2() {
            return coord2;
        }

        protected Coordinate getC3() {
            return coord3;
        }

        protected Coordinate getC4() {
            return coord4;
        }

        public Color getColor() {
            return color;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
}
