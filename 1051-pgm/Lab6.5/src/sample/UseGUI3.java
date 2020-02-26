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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UseGUI3 extends Application {
    public static final int h = 1000;
    public static final int w = 1000;
    public static final int maxX = 1000;
    public static final int maxY = 1000;
    public static final Color shadeColor = Color.rgb(48, 51, 68);
    public static final Color sunColor = Color.rgb(91, 110, 129);
    public static final Color topColor = Color.WHITE;

    public void start(Stage primaryStage) {
        //
        // -- SKY --
        //
        Color sky1 = Color.rgb(242, 226, 180);
        Color sky2 = Color.rgb(244, 201, 131);
        Color sky3 = Color.rgb(242, 175, 90);
        Color sky4 = Color.rgb(238, 140, 55);
        Color sky5 = Color.rgb(234, 106, 50);

        Stop[] skyStops = new Stop[] {
                new Stop(0, sky1),
                new Stop(.2, sky2),
                new Stop(.4, sky3),
                new Stop(.6, sky4),
                new Stop(.8, sky5)};
        LinearGradient skyGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                skyStops
        );

        //
        // -- SUN --
        //
        Color sun1 = Color.rgb(246, 230, 87);
        Color sun2 = Color.rgb(242, 236, 182);
        Color sun3 = Color.rgb(244, 208, 98);
        Color sun4 = Color.rgb(230, 180, 67);

        Coordinate sunCenter = new Coordinate(652, 545);
        Coordinate sunSize = new Coordinate(170, 152);

        Stop[] sunStops = new Stop[] {
                new Stop(0, Color.WHITE),
                new Stop(.33, sun2),
                new Stop(66, sun1),
                new Stop(1, sun3)
        };
        RadialGradient sunGradient = new RadialGradient(
                0,
                .1,
                sunCenter.x(),
                sunCenter.y(),
                sunSize.x(),
                false,
                CycleMethod.NO_CYCLE,
                sunStops
        );

        Ellipse sun = new Ellipse(
                sunCenter.x(),
                sunCenter.y(),
                sunSize.x(),
                sunSize.y()
        );
        sun.setFill(sunGradient);
        sun.setStroke(sun4);
        sun.setStrokeWidth(2);

        //
        // -- BUILDINGS --
        //

        // Building 1 - 3D
        Coordinate b1_origin = new Coordinate(-25, maxY);
        Building building1 = new ThreeDimensionalBuilding(
                b1_origin,
                75,
                maxY / 3,
                10,
                5,
                shadeColor,
                sunColor,
                topColor
        );

        Line building1Shade = new Line(
                building1.getC3().x() - 1,
                building1.getC3().y() + 1,
                building1.getC3().x() - 1,
                building1.getC3().y() + 80
        );
        building1Shade.setStrokeWidth(2);
        building1Shade.setStroke(topColor);

        Group building1Group = building1.makeBuilding();
        building1Group.getChildren().add(building1Shade);

        // Building 2 - Flat Shade
        Coordinate b2_origin = new Coordinate(
                building1.getOrigin().x() + building1.getWidth(),
                maxY
        );
        Building building2 = new Building(
                b2_origin,
                18,
                (building1.getHeight() / 2) + 15,
                shadeColor
        );
        Group building2Group = building2.makeBuilding();

        // Building 3 - Flat Shade
        Coordinate b3_origin = new Coordinate(
                building2.getOrigin().x() + building2.getWidth(),
                maxY
        );
        Building building3 = new Building(
                b3_origin,
                66,
                building2.getHeight() + 40,
                shadeColor
        );
        Group building3Group = building3.makeBuilding();

        // Building 4 - Flat Shade
        Coordinate b4_origin = new Coordinate(
                building3.getOrigin().x() + building3.getWidth(),
                maxY
        );
        Building building4 = new Building(
                b4_origin,
                67,
                building2.getHeight() - 45,
                shadeColor
        );
        Group building4Group = building4.makeBuilding();

        // Building 5 - 3D
        Coordinate b5_origin = new Coordinate(
                building4.getOrigin().x() + building4.getWidth(),
                maxY
        );
        Building building5 = new ThreeDimensionalBuilding(
                b5_origin,
                66,
                building1.getHeight() - 10,
                -4,
                2,
                shadeColor,
                sunColor,
                topColor
        );
        Group building5Group = building5.makeBuilding();

        // Building 6 - Flat Shade
        Coordinate b6_origin = new Coordinate(
                building5.getOrigin().x() + building5.getWidth() - 11,
                maxY
        );
        Building building6 = new Building(
                b6_origin,
                79,
                building3.getHeight() + 18,
                shadeColor
        );
        Group building6Group = building6.makeBuilding();

        Line building6Shade = new Line(
                building5.getC3().x(),
                building6.getC4().y() - 1,
                building5.getC3().x() + 45,
                building6.getC4().y() - 1
        );
        building6Shade.setStrokeWidth(2);
        building6Shade.setStroke(topColor);
        building6Group.getChildren().add(building6Shade);

        // Building 7 - 3D
        Coordinate b7_origin = new Coordinate(
                building6.getOrigin().x() + building6.getWidth() - 3,
                maxY
        );
        Building building7 = new ThreeDimensionalBuilding(
                b7_origin,
                66,
                (building5.getHeight() - building6.getHeight()) / 2 + building6.getHeight(),
                -8,
                5,
                sunColor,
                shadeColor,
                topColor
        );
        Group building7Group = building7.makeBuilding();

        // Building 8 - Flat Sun
        Coordinate b8_bottom_origin = new Coordinate(
                building7.getOrigin().x() + building7.getWidth() + 3,
                maxY
        );
        Building building8Bottom = new Building(
                b8_bottom_origin,
                110,
                building1.getHeight() + 40,
                sunColor
        );
        Group building8BottomGroup = building8Bottom.makeBuilding();

        Stop[] shadeStops = new Stop[] {
                new Stop(0, shadeColor),
                new Stop(.65, shadeColor),
                new Stop(1, sunColor)
        };
        LinearGradient shadeGradient = new LinearGradient(
                0,
                0,
                1,
                0,
                true,
                CycleMethod.NO_CYCLE,
                shadeStops
        );

        Stop[] spireStops = new Stop[] {
                new Stop(0, shadeColor),
                new Stop(.5, sunColor),
                new Stop(1, shadeColor)
        };
        LinearGradient spireGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                spireStops
        );

        Coordinate b8_middle_origin = new Coordinate(
                building8Bottom.getOrigin().x() + 15,
                maxY - building8Bottom.getHeight()
        );
        Rectangle building8Middle = new Rectangle(
                b8_middle_origin.x(),
                b8_middle_origin.y() - 35,
                80,
                35
        );
        building8Middle.setFill(shadeGradient);
        Group building8MiddleGroup = new Group(building8Middle);

        Coordinate b8_top_origin = new Coordinate(
                b8_middle_origin.x() + 20,
                b8_middle_origin.y() - 35
        );
        Building building8Top = new Building(
                b8_top_origin,
                40,
                28,
                shadeColor
        );
        Group building8TopGroup = building8Top.makeBuilding();

        Line building8Pole = new Line(
                building8Top.getOrigin().x() + 20,
                building8Top.getOrigin().y() - building8Top.getHeight(),
                building8Top.getOrigin().x() + 20,
                building8Top.getOrigin().y() - building8Top.getHeight() - 90
        );
        building8Pole.setStrokeWidth(4);
        building8Pole.setStroke(spireGradient);

        Line building8MiddleShade = new Line(
                b8_middle_origin.x() + 80,
                b8_middle_origin.y() - 34,
                b8_middle_origin.x() + 80,
                b8_middle_origin.y() - 1
        );
        building8MiddleShade.setStrokeWidth(2);
        building8MiddleShade.setStroke(topColor);

        Line building8TopShade = new Line(
                building8Top.getC2().x(),
                building8Top.getC2().y() - 1,
                building8Top.getC3().x(),
                building8Top.getC3().y() + 1
        );
        building8TopShade.setStrokeWidth(2);
        building8TopShade.setStroke(topColor);

        Line building8RightShade = new Line(
                building8Bottom.getC3().x() - 1,
                building8Bottom.getC3().y() + 1,
                building8Bottom.getC3().x() - 1,
                building8Bottom.getC3().y() + 45.
        );
        building8RightShade.setStrokeWidth(2);
        building8RightShade.setStroke(topColor);

        Line building8LeftShade = new Line(
                building8Bottom.getOrigin().x() + 1,
                building8Bottom.getOrigin().y(),
                building8Bottom.getC4().x() + 1,
                building8Bottom.getC4().y() + 1
        );
        building8LeftShade.setStrokeWidth(2);
        building8LeftShade.setStroke(shadeColor);

        Group building8Group = new Group(
                building8BottomGroup, building8MiddleGroup,
                building8TopGroup, building8Pole,
                building8MiddleShade, building8TopShade,
                building8RightShade, building8LeftShade
        );

        // Building 9 - 3D, right side white
        Coordinate b9_origin = new Coordinate(485, maxY);
        Building building9 = new ThreeDimensionalBuilding(
                b9_origin,
                115,
                building8Bottom.getHeight() + 27,
                24,
                10,
                shadeColor,
                topColor,
                topColor
        );
        Group building9Group = building9.makeBuilding();

        // Building 10 - 3D
        Coordinate b10_origin = new Coordinate(566, maxY);
        Building building10 = new ThreeDimensionalBuilding(
                b10_origin,
                140,
                building6.getHeight() + 15,
                7,
                3,
                sunColor,
                shadeColor,
                topColor
        );
        Group building10Group = building10.makeBuilding();

        Line building10Shade1 = new Line(
                building10.getC3().x() - 3,
                building10.getC3().y() + 1.8,
                building10.getC3().x() - 1,
                maxY - building4.getHeight() + 20
        );
        building10Shade1.setStrokeWidth(2);
        building10Shade1.setStroke(sunColor);

        Line building10Shade2 = new Line(
                building10.getC3().x() - 1,
                building10.getC3().y() + 1,
                building10.getC3().x() - 1,
                maxY - building4.getHeight() + 20
        );
        building10Shade2.setStrokeWidth(2);
        building10Shade2.setStroke(topColor);
        building10Group.getChildren().addAll(building10Shade2, building10Shade1);

        // Building 11 - Flat
        Coordinate b11_origin = new Coordinate(
                building10.getOrigin().x() + building10.getWidth(),
                maxY
        );
        Building building11 = new Building(
                b11_origin,
                100,
                building4.getHeight() + 40,
                shadeColor
        );
        Group building11Group = building11.makeBuilding();

        // Building 12 - Flat
        Coordinate b12_origin = new Coordinate(
                building11.getOrigin().x() + building11.getWidth(),
                maxY
        );
        Building building12 = new Building(
                b12_origin,
                75,
                building7.getHeight() + 20,
                shadeColor
        );
        Group building12Group = building12.makeBuilding();

        Line building12LeftShade1 = new Line(
                building12.getC4().x() + 1,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 1,
                building12.getOrigin().y()
        );
        building12LeftShade1.setStrokeWidth(2);
        building12LeftShade1.setStroke(topColor);

        Line building12LeftShade2 = new Line(
                building12.getC4().x() + 3.2,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 1,
                building12.getOrigin().y()
        );
        building12LeftShade2.setStrokeWidth(3);
        building12LeftShade2.setStroke(sunColor);

        Line building12TopShade = new Line(
                building12.getC4().x() + 3.2,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 30,
                building12.getC4().y() + 1
        );
        building12TopShade.setStrokeWidth(3);
        building12TopShade.setStroke(sunColor);

        building12Group.getChildren().addAll(
                building12LeftShade1, building12LeftShade2, building12TopShade
        );

        // Building 13 - Flat
        Coordinate b13_origin = new Coordinate(875, maxY);
        Polygon building13 = new Polygon(
                b13_origin.x(), b13_origin.y(),
                b13_origin.x() + 65, b13_origin.y(),
                b13_origin.x() + 65, b13_origin.y() - building8Bottom.getHeight() + 8,
                b13_origin.x(), b13_origin.y() - building8Bottom.getHeight()
        );
        building13.setFill(sunColor);
        Group building13Group = new Group(building13);

        // Building 14 - 3D
        Coordinate b14_origin = new Coordinate(875, maxY);
        ThreeDimensionalBuilding building14 = new ThreeDimensionalBuilding(
                b14_origin, 100,
                building8Bottom.getHeight() + 50,
                15,
                8,
                shadeColor,
                shadeColor,
                topColor
        );
        Group building14Group = building14.makeBuilding();

        Line building14Shade1 = new Line(
                building14.getC4().x() + 1,
                building14.getC4().y(),
                building14.getC7().x() + 1,
                building14.getC7().y()
        );
        building14Shade1.setStrokeWidth(2);
        building14Shade1.setStroke(shadeColor);

        Line building14Shade2 = new Line(
                building14.getC7().x() + 1,
                building14.getC7().y(),
                building14.getC3().x() + 1,
                building14.getC3().y()
        );
        building14Shade2.setStrokeWidth(2);
        building14Shade2.setStroke(shadeColor);

        Line building14Shade3 = new Line(
                building14.getC4().x() + 1,
                building14.getC4().y() + 3,
                building14.getC4().x() + 1,
                building14.getC4().y() + 43
        );
        building14Shade3.setStrokeWidth(2);
        building14Shade3.setStroke(topColor);

        Line building14Shade4 = new Line(
                building14.getC3().x() + 3,
                building14.getC3().y() + 5,
                building14.getC2().x() + 3,
                building14.getC2().y()
        );
        building14Shade4.setStrokeWidth(2);
        building14Shade4.setStroke(sky3);

        building14Group.getChildren().addAll(
                building14Shade1,
                building14Shade2,
                building14Shade3,
                building14Shade4
        );

        // Building 15 - Flat
        Coordinate b15_origin = new Coordinate(925, maxY);
        Building building15 = new ThreeDimensionalBuilding(
                b15_origin,
                (maxX - b15_origin.x()) * 2,
                building8Bottom.getHeight() + 180,
                10,
                6,
                shadeColor,
                shadeColor,
                shadeColor
        );
        Group building15Group = building15.makeBuilding();

        Polygon building15LightShade = new Polygon(
                building15.getC4().x(),
                building15.getC4().y(),
                building15.getC4().x(),
                building15.getC4().y() + 112,
                building15.getC4().x() + 4,
                building15.getC4().y() + 106,
                building15.getC4().x() + 4,
                building15.getC4().y()
        );
        building15LightShade.setFill(topColor);

        Polygon building15DarkShade = new Polygon(
                building15.getC4().x() + 4,
                building15.getC4().y(),
                building15.getC4().x() + 4,
                building15.getC4().y() + 106,
                building15.getC4().x() + 8,
                building15.getC4().y() + 100,
                building15.getC4().x() + 8,
                building15.getC4().y()
        );
        building15DarkShade.setFill(sunColor);

        building15Group.getChildren().addAll(
                building15LightShade, building15DarkShade
        );

        // Building 16 - Flat with two triangle top
        Coordinate b16_origin = new Coordinate(
                building3.getOrigin().x() + 10,
                maxY
        );
        Building building16 = new Building(
                b16_origin, building3.getWidth() + 25,
                building9.getHeight() - 25,
                sunColor
        );
        Group building16Group = building16.makeBuilding();

        int triangle1Height = 76;
        int triangle2Height = 83;
        int triangle3Height = 95;

        Polygon building16Triangle1 = new Polygon(
                building16.getC4().x(),
                building16.getC4().y(),
                building16.getC3().x(),
                building16.getC3().y(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                maxY - building16.getHeight() - triangle1Height
        );
        building16Triangle1.setFill(sunColor);

        Polygon building16Triangle2 = new Polygon(
                building16.getC4().x() + building16.getWidth() / 16.0,
                maxY - building16.getHeight(),
                building16.getC3().x() - building16.getWidth() / 16.0,
                maxY - building16.getHeight(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                maxY - building16.getHeight() - triangle2Height
        );
        building16Triangle2.setFill(sunColor);

        Polygon building16Triangle3 = new Polygon(
                building16.getC4().x() + building16.getWidth() / 4.0,
                maxY - building16.getHeight(),
                building16.getC3().x() - building16.getWidth() / 4.0,
                maxY - building16.getHeight(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                maxY - building16.getHeight() - triangle3Height
        );
        building16Triangle3.setFill(sunColor);

        Line building16Spire = new Line(
                building16.getOrigin().x() + building16.getWidth() / 2.0,
                maxY - building16.getHeight() - 89,
                building16.getOrigin().x() + building16.getWidth() / 2.0,
                maxY - building16.getHeight() - 118
        );
        building16Spire.setStrokeWidth(2);
        building16Spire.setStroke(spireGradient);

        Line building16LeftShade = new Line(
                building16.getOrigin().x() + 1, building16.getOrigin().y(),
                building16.getC4().x() + 1, building16.getC4().y()
        );
        building16LeftShade.setStrokeWidth(3);
        building16LeftShade.setStroke(shadeColor);

        Line building16TopRightShade = new Line(
                building16.getOrigin().x() + building16.getWidth() / 2.0 + 0,
                maxY - building16.getHeight() - 88,
                building16.getOrigin().x() + building16.getWidth() / 2.0 + 5,
                maxY - building16.getHeight() - 70
        );
        building16TopRightShade.setStrokeWidth(2);
        building16TopRightShade.setStroke(topColor);

        Line building16BottomRightShade = new Line(
                building16.getOrigin().x() + building16.getWidth() / 2.0 + 5,
                maxY - building16.getHeight() - 70,
                137,
                572
        );

        System.out.println("X = " + (building16.getC3().x() - 1));
        System.out.println("Y = " + (building16.getC3().y() - 1));
        System.out.println("\nX = " + (building16.getC3().x() - 1));
        System.out.println("Y = " + (building16.getC3().y() - 1));

        building16BottomRightShade.setStrokeWidth(2);
        building16BottomRightShade.setStroke(topColor);

        building16Group.getChildren().addAll(
                building16Spire, building16Triangle2,
                building16Triangle3, building16Triangle1,
                building16LeftShade, building16TopRightShade,
                building16BottomRightShade
        );


        // Buildings Group
        Group buildings = new Group(
                building16Group, building1Group, building2Group,
                building3Group, building4Group, building5Group,
                building7Group, building6Group, building9Group,
                building8Group, building10Group, building11Group,
                building12Group, building15Group, building14Group,
                building13Group
        );

        // Set root node and scene
        Group root = new Group(sun, buildings);
        Scene scene = new Scene(root, h, w, skyGradient);

        // Primary stage setup
        primaryStage.setTitle("Ben Godwin - New York Sunset");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
