package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;

public class Building {
        private int width;
        private int height;
        private Color color;
        private Coordinate origin;
        private Coordinate coord2;
        private Coordinate coord3;
        private Coordinate coord4;

        public Building(Coordinate origin, int width, int height, Color color) {
            this(
                    origin,
                    new Coordinate(origin.x() + width, origin.y()),
                    new Coordinate(origin.x() + width, origin.y() - height),
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
                int width,
                int height
        ) {
            this.origin = origin;
            this.coord2 = coord2;
            this.coord3 = coord3;
            this.coord4 = coord4;
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public Group makeBuilding() {
            Polygon polygon = new Polygon(
                    origin.x(), origin.y(),
                    coord2.x(), coord2.y(),
                    coord3.x(), coord3.y(),
                    coord4.x(), coord4.y()
            );
            polygon.setFill(color);
            return new Group(polygon);
        }

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

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
}
