// Ben Godwin
// Lab 6.5 - UseGUI3.java
// I assert that the program I am submitting is the result of my own efforts

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class UseGUI3 extends Application {
    public int h = 1000;
    public int w = 1000;
    int maxX = 1000;
    int maxY = 1000;
    public Color shadeColor = Color.rgb(48, 51, 68);
    public Color sunColor = Color.rgb(91, 110, 129);
    public Color topColor = Color.WHITE;

    public class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = (int) (((double) x / 1000) * h);
            this.y = (int) (((double) y / 1000) * w);
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }

    public class Building {
        private Coordinate coord1;
        private Coordinate coord2;
        private Coordinate coord3;
        private Coordinate coord4;
        private Color color;

        public Building(Coordinate origin, int width, int height, Color color) {
            this(
                    origin,
                    new Coordinate(origin.x() + width, origin.y()),
                    new Coordinate(origin.x() + width, origin.y() - height),
                    new Coordinate(origin.x(), origin.y() - height),
                    color
            );
        }

        private Building(Coordinate coord1, Coordinate coord2, Coordinate coord3, Coordinate coord4, Color color) {
            this.coord1 = coord1;
            this.coord2 = coord2;
            this.coord3 = coord3;
            this.coord4 = coord4;
            this.color = color;
        }

        public Group makeBuilding() {
            Polygon polygon = new Polygon(
                    coord1.x(), coord1.y(),
                    coord2.x(), coord2.y(),
                    coord3.x(), coord3.y(),
                    coord4.x(), coord4.y()
            );
            polygon.setFill(color);
            return new Group(polygon);
        }

        public Coordinate getCoord1() {
            return coord1;
        }

        public Coordinate getCoord2() {
            return coord2;
        }

        public Coordinate getCoord3() {
            return coord3;
        }

        public Coordinate getCoord4() {
            return coord4;
        }

        public Color getColor() {
            return color;
        }
    }

    public class ThreeDimensionalBuilding extends Building {
        public Coordinate coord5;
        public Coordinate coord6;
        public Coordinate coord7;
        public Color rightColor;
        public Color topColor;

        public ThreeDimensionalBuilding(Coordinate origin, int width, int height, int midpointOffset, int heightOffset, Color leftColor, Color rightColor, Color topColor) {
            super(origin, width, height, leftColor);
            coord5 = new Coordinate(origin.x() + (width / 2) + midpointOffset, origin.y());
            coord6 = new Coordinate(origin.x() + (width / 2) + midpointOffset, origin.y() - height + heightOffset);
            coord7 = new Coordinate(origin.x() + (width / 2) - midpointOffset, origin.y() - height - heightOffset);
            this.rightColor = rightColor;
            this.topColor = topColor;
        }

        @Override
        public Group makeBuilding() {
            Polygon leftSide = new Polygon(
                    super.getCoord1().x(), super.getCoord1().y(),
                    coord5.x(), coord5.y(),
                    coord6.x(), coord6.y(),
                    super.getCoord4().x(), super.getCoord4().y()
            );
            leftSide.setFill(super.getColor());

            Polygon rightSide = new Polygon(
                    coord5.x(), coord5.y(),
                    super.getCoord2().x(), super.getCoord2().y(),
                    super.getCoord3().x(), super.getCoord3().y(),
                    coord6.x(), coord6.y()
            );
            rightSide.setFill(rightColor);

            Polygon topSide = new Polygon(
                    super.getCoord4().x(), super.getCoord4().y(),
                    coord6.x(), coord6.y(),
                    super.getCoord3().x(), super.getCoord3().y(),
                    coord7.x(), coord7.y()
            );
            topSide.setFill(topColor);

            return new Group(leftSide, rightSide, topSide);
        }
    }

    public void start(Stage primaryStage) {
        //
        // -- SKY --
        //
        Color sky1 = Color.rgb(242, 226, 180);
        Color sky2 = Color.rgb(244, 201, 131);
        Color sky3 = Color.rgb(242, 175, 90);
        Color sky4 = Color.rgb(238, 140, 55);
        Color sky5 = Color.rgb(234, 106, 50);

        Stop[] skyStops = new Stop[] { new Stop(0, sky1), new Stop(.2, sky2), new Stop(.4, sky3), new Stop(.6, sky4), new Stop(.8, sky5)};
        LinearGradient skyGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, skyStops);

        //
        // -- SUN --
        //
        Color sun1 = Color.rgb(246, 230, 87);
        Color sun2 = Color.rgb(242, 236, 182);
        Color sun3 = Color.rgb(244, 208, 98);
        Color sun4 = Color.rgb(230, 180, 67);

        Coordinate sunCenter = new Coordinate(638, 510);
        Coordinate sunSize = new Coordinate(165, 150);

        Stop[] sunStops = new Stop[] { new Stop(0, Color.WHITE), new Stop(.33, sun2), new Stop(66, sun1), new Stop(1, sun3)};
        RadialGradient sunGradient = new RadialGradient(0, .1, sunCenter.x(), sunCenter.y(), sunSize.x(), false, CycleMethod.NO_CYCLE, sunStops);

        Ellipse sun = new Ellipse(sunCenter.x(), sunCenter.y(), sunSize.x(), sunSize.y());
        sun.setFill(sunGradient);
        sun.setStroke(sun4);
        sun.setStrokeWidth(2);

        //
        // -- BUILDINGS --
        //

        // Building 1 - 3D
        int b1_w = 50;
        int b1_h = h / 3;
        int b1_mid_offset = -3;
        int b1_height_offset = 6;
        Coordinate b1_origin = new Coordinate(0, maxY);

        Building building1 = new ThreeDimensionalBuilding(b1_origin, b1_w, b1_h, b1_mid_offset, b1_height_offset, shadeColor, sunColor, topColor);

        Line building1Shade = new Line(building1.getCoord3().x() - 1, building1.getCoord3().y() + 1, building1.getCoord3().x() - 1, building1.getCoord3().y() + 80);
        building1Shade.setStrokeWidth(2);
        building1Shade.setStroke(topColor);

        Group building1Group = building1.makeBuilding();
        building1Group.getChildren().add(building1Shade);

        // Building 2 - Flat Shade
        int b2_w = 18;
        int b2_h = (b1_h / 2) + 15;
        Coordinate b2_origin = new Coordinate(b1_origin.x() + b1_w, maxY);

        Building building2 = new Building(b2_origin, b2_w, b2_h, shadeColor);
        Group building2Group = building2.makeBuilding();


        // Building 3 - Flat Shade
        int b3_w = 66;
        int b3_h = b2_h + 40;
        Coordinate b3_origin = new Coordinate(b2_origin.x() + b2_w, maxY);

        Building building3 = new Building(b3_origin, b3_w, b3_h, shadeColor);
        Group building3Group = building3.makeBuilding();

        // Building 4 - Flat Shade
        int b4_w = 67;
        int b4_h = b2_h - 45;
        Coordinate b4_origin = new Coordinate(b3_origin.x() + b3_w, maxY);

        Building building4 = new Building(b4_origin, b4_w, b4_h, shadeColor);
        Group building4Group = building4.makeBuilding();


        // Building 5 - 3D
        int b5_w = 66;
        int b5_h = b1_h - 10;
        int b5_mid_offset = -4;
        int b5_height_offset = 2;
        Coordinate b5_origin = new Coordinate(b4_origin.x() + b4_w, maxY);

        Building building5 = new ThreeDimensionalBuilding(b5_origin, b5_w, b5_h, b5_mid_offset, b5_height_offset, shadeColor, sunColor, topColor);
        Group building5Group = building5.makeBuilding();

        // Building 6 - Flat Shade
        int b6_w = 79;
        int b6_h = b3_h + 18;
        Coordinate b6_origin = new Coordinate(b5_origin.x() + b5_w - 11, maxY);

        Building building6 = new Building(b6_origin, b6_w, b6_h, shadeColor);
        Group building6Group = building6.makeBuilding();

        // Building 7 - 3D
        int b7_w = 66;
        int b7_h = (b5_h - b6_h) / 2 + b6_h;
        int b7_mid_offset = -8;
        int b7_height_offset = 5;
        Coordinate b7_origin = new Coordinate(b6_origin.x() + b6_w - 3, maxY);

        Building building7 = new ThreeDimensionalBuilding(b7_origin, b7_w, b7_h, b7_mid_offset, b7_height_offset, sunColor, shadeColor, topColor);
        Group building7Group = building7.makeBuilding();

        // Building 8 - Flat Sun
        int b8_b_w = 110;
        int b8_b_h = b1_h + 40;
        Coordinate b8_bottom_origin = new Coordinate(b7_origin.x() + b7_w + 3, maxY);

        Building building8Bottom = new Building(b8_bottom_origin, b8_b_w, b8_b_h, sunColor);
        Group building8BottomGroup = building8Bottom.makeBuilding();

        int b8_m_w = 80;
        int b8_m_h = 35;
        int b8_m_mid_offset = 25;
        int b8_m_height_offset = 0;
        Coordinate b8_middle_origin = new Coordinate(b8_bottom_origin.x() + 15, maxY - b8_b_h);

        Building building8Middle = new ThreeDimensionalBuilding(b8_middle_origin, b8_m_w, b8_m_h, b8_m_mid_offset, b8_m_height_offset, shadeColor, sunColor, shadeColor);
        Group building8MiddleGroup = building8Middle.makeBuilding();

        int b8_t_w = 40;
        int b8_t_h = 28;
        Coordinate b8_top_origin = new Coordinate(b8_middle_origin.x() + 20, b8_middle_origin.y() - b8_m_h);

        Building building8Top = new Building(b8_top_origin, b8_t_w, b8_t_h, shadeColor);
        Group building8TopGroup = building8Top.makeBuilding();

        Line building8Pole = new Line(b8_top_origin.x() + 20, b8_top_origin.y() - b8_t_h, b8_top_origin.x() + 20, b8_top_origin.y() - b8_t_h - 90);
        building8Pole.setStrokeWidth(4);
        building8Pole.setStroke(shadeColor);

        Group building8Group = new Group(building8BottomGroup, building8MiddleGroup, building8TopGroup, building8Pole);

        Group buildings = new Group(building1Group, building2Group, building3Group,
                building4Group, building5Group, building7Group, building6Group, building8Group);

        Group root = new Group(sun, buildings);
        Scene scene = new Scene(root, h, w, skyGradient);
        primaryStage.setTitle("Ben Godwin - UseGUI3");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
