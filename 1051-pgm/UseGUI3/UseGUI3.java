// Ben Godwin
// Lab 6.5 - UseGUI3.java
// I assert that the program I am submitting is the result of my own efforts

// Specification - this program uses JavaFX two dimensional shapes to recreate
// a painting by Donna Blossom
// original - https://i.etsystatic.com/8287806/r/il/b8886b/1079521439/il_570xN.1079521439_4al5.jpg

package UseGUI3; 

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class UseGUI3 extends Application {
    // Static variables needed by servant classes
    public static final int MAX_X = 1000; // window height
    public static final int MAX_Y = 1000; // window width

    public void start(Stage primaryStage) {

        // ==========================================================
        //                        _____  _
        //                       / ____ | |
        //                      | (___  | | __ __  _
        //                       \___ \ | |/ /| | | |
        //                       ____)  |   < | |_| |
        //                      |_____/ |_|\_\ \__, |
        //                                      __/ |
        //                                     |___/
        // ==========================================================

        // Sky colors in order of light to dark
        Color skyColor1 = Color.rgb(242, 226, 180);
        Color skyColor2 = Color.rgb(244, 201, 131);
        Color skyColor3 = Color.rgb(242, 175, 90);
        Color skyColor4 = Color.rgb(238, 140, 55);
        Color skyColor5 = Color.rgb(234, 106, 50);

        // Stop array of sky colors from light to dark
        Stop[] skyStops = new Stop[] {
                new Stop(0, skyColor1),
                new Stop(.2, skyColor2),
                new Stop(.4, skyColor3),
                new Stop(.6, skyColor4),
                new Stop(.8, skyColor5)};

        // Gradient for sky color
        LinearGradient skyGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                skyStops
        );

        // ==========================================================
        //                      _____
        //                     / ____|
        //                    | (___   _   _  _ __
        //                     \___ \ | | | || '_ \
        //                     ____) || |_| || | | |
        //                    |_____/  \__,_||_| |_|
        // ==========================================================

        // Sun colors from light to dark
        Color sunShadeColor1 = Color.rgb(242, 236, 200, 1);
        Color sunShadeColor2 = Color.rgb(249, 238, 108, 1);
        Color sunShadeColor3 = Color.rgb(249, 234, 39, 1);
        Color sunShadeColor4 = Color.rgb(252, 208, 12, .9);
        Color sunStrokeColor = Color.rgb(238, 140, 55, .8); // for sun outline

        // For use in setting up sun Ellipse, and centering the RadialGradient for sun color
        Coordinate sunCenter = new Coordinate(662, 516);
        Coordinate sunSize = new Coordinate(190, 175);

        // Stop array for sun colors from light to dark
        Stop[] sunStops = new Stop[] {
                new Stop(0, sunShadeColor1),
                new Stop(.4, sunShadeColor2),
                new Stop(.65, sunShadeColor3),
                new Stop(1, sunShadeColor4)
        };

        // Radial gradient of sun colors - lightest in the center, darkest at the outside
        // center of gradient is down and to the left of sun's center
        RadialGradient sunGradient = new RadialGradient(
                0,
                .1,
                sunCenter.x() - 13,
                sunCenter.y() + 15,
                sunSize.x(),
                false,
                CycleMethod.NO_CYCLE,
                sunStops
        );

        DropShadow sunDropShadow = new DropShadow();
        sunDropShadow.setBlurType(BlurType.GAUSSIAN);
        sunDropShadow.setRadius(30);
        sunDropShadow.setSpread(0.0);
        sunDropShadow.setOffsetX(0);
        sunDropShadow.setOffsetY(-8);
        sunDropShadow.setColor(skyColor5);

        Ellipse sun = new Ellipse(
                sunCenter.x(),
                sunCenter.y(),
                sunSize.x(),
                sunSize.y()
        );
        sun.setFill(sunGradient);
        sun.setStroke(sunStrokeColor);
        sun.setStrokeWidth(2);
        sun.setEffect(sunDropShadow);

        // Arc for "eclipse" between sun and buildings
        Path sunArc = new Path(
                new MoveTo(300, MAX_Y),
                new CubicCurveTo(410, 297, 1040, 545, 910, MAX_Y)
        );
        sunArc.setStrokeWidth(2);
        sunArc.setStroke(Color.rgb(238, 140, 55, .4));
        sunArc.setFill(Color.rgb(249, 68, 15, .15));

        // This ellipse will be used to create a dropshadow around the sunArc
        // but only inside the sun ellipse
        Shape dropShadowArc = new Ellipse(
                sunCenter.x() - 13.4,
                sunCenter.y() + 221.3,
                sunSize.x() + 26.5,
                sunSize.y()
        );

        // colors for second arc Stroke and DropShadow, intensity of arcStroke has (some) effect on dropShadow
        Color arcStroke = Color.rgb(234, 106, 50, .1);
        Color arcDropShadowColor = Color.rgb(242, 236, 200);

        // DropShadow definition
        DropShadow arcDropShadow = new DropShadow();
        arcDropShadow.setBlurType(BlurType.GAUSSIAN);
        arcDropShadow.setRadius(20);
        arcDropShadow.setOffsetY(-15);
        arcDropShadow.setSpread(0);
        arcDropShadow.setColor(arcDropShadowColor);

        // second arc is the intersection between itself and the sun ellipse
        dropShadowArc = Path.intersect(dropShadowArc, sun);
        dropShadowArc.setStrokeWidth(2);
        dropShadowArc.setStroke(arcStroke);
        // fill changes intensity of dropShadow (unfortunately??)
        dropShadowArc.setFill(Color.rgb(249, 234, 39, .6)); // alpha affects dropShadow intensity
        dropShadowArc.setEffect(arcDropShadow);

        Group arcGroup = new Group(dropShadowArc, sunArc);

        // ==========================================================
        //       ____          _  _      _  _
        //      |  _ \        (_)| |    | |(_)
        //      | |_) | _   _  _ | |  __| | _  _ __    __ _  ___
        //      |  _ < | | | || || | / _` || || '_ \  / _` |/ __|
        //      | |_) || |_| || || || (_| || || | | || (_| |\__ \
        //      |____/  \__,_||_||_| \__,_||_||_| |_| \__, ||___/
        //                                             __/ |
        //                                            |___/
        // ==========================================================

        // Building side colors
        Color darkSideColor = Color.rgb(48, 51, 68);
        Color lightSideColor = Color.rgb(91, 110, 129);
        Color brightSideColor = Color.WHITE;

        // Stop array for colors in spire gradient
        Stop[] spireGradientStops = new Stop[] {
                new Stop(0, darkSideColor),
                new Stop(.25, lightSideColor),
//                new Stop(.45, lightSideColor),
                new Stop(.5, Color.rgb(164, 173, 183)),
//                new Stop(.55, lightSideColor),
                new Stop(.75, lightSideColor),
                new Stop(1, darkSideColor)
        };
        // linear gradient for spires, dark on top and bottom, light in middle
        LinearGradient spireGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                spireGradientStops
        );

        // ----------------------------------------------------------
        // Building 1 - 3D
        // ----------------------------------------------------------
        Coordinate b1_origin = new Coordinate(-25, MAX_Y);
        Building building1 = new ThreeDimensionalBuilding(
                b1_origin,
                75,
                MAX_Y / 3,
                10,
                5,
                darkSideColor,
                lightSideColor,
                brightSideColor
        );
        Group building1Group = building1.makeBuilding();

        // Outline for upper right side of building
        Line building1Outline = new Line(
                building1.getC3().x() - 1,
                building1.getC3().y() + 1,
                building1.getC3().x() - 1,
                building1.getC3().y() + 80
        );
        building1Outline.setStrokeWidth(2);
        building1Outline.setStroke(brightSideColor);

        building1Group.getChildren().add(building1Outline);

        // ----------------------------------------------------------
        // Building 2 - Flat (Dark)
        // ----------------------------------------------------------
        Coordinate b2_origin = new Coordinate(
                building1.getOrigin().x() + building1.getWidth(),
                MAX_Y
        );
        Building building2 = new Building(
                b2_origin,
                18,
                (building1.getHeight() / 2) + 15,
                darkSideColor
        );
        Group building2Group = building2.makeBuilding();

        // ----------------------------------------------------------
        // Building 3 - Flat (Dark)
        // ----------------------------------------------------------
        Coordinate b3_origin = new Coordinate(
                building2.getOrigin().x() + building2.getWidth(),
                MAX_Y
        );
        Building building3 = new Building(
                b3_origin,
                80,
                building2.getHeight() + 40,
                darkSideColor
        );
        Group building3Group = building3.makeBuilding();

        // ----------------------------------------------------------
        // Building 4 - Flat (Dark)
        // ----------------------------------------------------------
        Coordinate b4_origin = new Coordinate(
                building3.getOrigin().x() + building3.getWidth(),
                MAX_Y
        );
        Building building4 = new Building(
                b4_origin,
                53,
                building2.getHeight() - 45,
                darkSideColor
        );
        Group building4Group = building4.makeBuilding();

        // ----------------------------------------------------------
        // Building 5 - 3D
        // ----------------------------------------------------------
        Coordinate b5_origin = new Coordinate(
                building4.getOrigin().x() + building4.getWidth(),
                MAX_Y
        );
        Building building5 = new ThreeDimensionalBuilding(
                b5_origin,
                66,
                building1.getHeight() - 10,
                -4,
                2,
                darkSideColor,
                lightSideColor,
                brightSideColor
        );
        Group building5Group = building5.makeBuilding();

        // ----------------------------------------------------------
        // Building 6 - Flat (Dark)
        // ----------------------------------------------------------
        Coordinate b6_origin = new Coordinate(
                building5.getOrigin().x() + building5.getWidth() - 11,
                MAX_Y
        );
        Building building6 = new Building(
                b6_origin,
                79,
                building3.getHeight() + 18,
                darkSideColor
        );
        Group building6Group = building6.makeBuilding();

        // Outline for top of building
        Line building6Outline = new Line(
                building5.getC3().x(),
                building6.getC4().y() - 1,
                building5.getC3().x() + 45,
                building6.getC4().y() - 1
        );
        building6Outline.setStrokeWidth(2);
        building6Outline.setStroke(brightSideColor);

        building6Group.getChildren().add(building6Outline);

        // ----------------------------------------------------------
        // Building 7 - 3D
        // ----------------------------------------------------------
        Coordinate b7_origin = new Coordinate(
                building6.getOrigin().x() + building6.getWidth() - 3,
                MAX_Y
        );
        Building building7 = new ThreeDimensionalBuilding(
                b7_origin,
                66,
                (building5.getHeight() - building6.getHeight()) / 2 + building6.getHeight(),
                -8,
                5,
                lightSideColor,
                darkSideColor,
                brightSideColor
        );
        Group building7Group = building7.makeBuilding();


        // ----------------------------------------------------------
        // Building 8 - 3 Levels with Spire
        // ----------------------------------------------------------

        // ***********
        // Bottom Level
        // ************
        Coordinate b8_bottom_origin = new Coordinate(
                building7.getOrigin().x() + building7.getWidth() + 3,
                MAX_Y
        );
        Building building8Bottom = new Building(
                b8_bottom_origin,
                110,
                building1.getHeight() + 40,
                lightSideColor
        );
        Group building8BottomGroup = building8Bottom.makeBuilding();

        // Dark outline for left side
        Line building8LeftOutline = new Line(
                building8Bottom.getOrigin().x() + 1,
                building8Bottom.getOrigin().y(),
                building8Bottom.getC4().x() + 1,
                building8Bottom.getC4().y() + 1
        );
        building8LeftOutline.setStrokeWidth(2);
        building8LeftOutline.setStroke(darkSideColor);

        // Bright outline for right side of bottom
        Line building8RightOutline = new Line(
                building8Bottom.getC3().x() - 1,
                building8Bottom.getC3().y() + 1,
                building8Bottom.getC3().x() - 1,
                building8Bottom.getC3().y() + 45.
        );
        building8RightOutline.setStrokeWidth(2);
        building8RightOutline.setStroke(brightSideColor);

        // ***********
        // Middle Level
        // ************
        Coordinate b8_middle_origin = new Coordinate(
                building8Bottom.getOrigin().x() + 15,
                MAX_Y - building8Bottom.getHeight()
        );
        Rectangle building8Middle = new Rectangle(
                b8_middle_origin.x(),
                b8_middle_origin.y() - 35,
                80,
                35
        );

        // Stops for middle level gradient
        Stop[] shadeStops = new Stop[] {
                new Stop(0, darkSideColor),
                new Stop(.65, darkSideColor),
                new Stop(1, lightSideColor)
        };
        // linear gradient for middle level - dark on left to light on right
        LinearGradient middleLevelGradient = new LinearGradient(
                0,
                0,
                1,
                0,
                true,
                CycleMethod.NO_CYCLE,
                shadeStops
        );
        building8Middle.setFill(middleLevelGradient);
        Group building8MiddleGroup = new Group(building8Middle);

        // Bright outline for right side of middle level
        Line building8MiddleOutline = new Line(
                b8_middle_origin.x() + 80,
                b8_middle_origin.y() - 34,
                b8_middle_origin.x() + 80,
                b8_middle_origin.y() - 1
        );
        building8MiddleOutline.setStrokeWidth(2);
        building8MiddleOutline.setStroke(brightSideColor);

        // ***********
        // Top Level
        // ************
        Coordinate b8_top_origin = new Coordinate(
                b8_middle_origin.x() + 20,
                b8_middle_origin.y() - 35
        );
        Building building8Top = new Building(
                b8_top_origin,
                40,
                28,
                darkSideColor
        );
        Group building8TopGroup = building8Top.makeBuilding();

        // Bright outline for right side of top level
        Line building8TopOutline = new Line(
                building8Top.getC2().x(),
                building8Top.getC2().y() - 1,
                building8Top.getC3().x(),
                building8Top.getC3().y() + 1
        );
        building8TopOutline.setStrokeWidth(2);
        building8TopOutline.setStroke(brightSideColor);

        // ***********
        // Spire
        // ************
        Polygon building8Spire2 = new Polygon(
                building8Top.getOrigin().x() + 17.5,
                building8Top.getOrigin().y() - building8Top.getHeight(),
                building8Top.getOrigin().x() + 20,
                building8Top.getOrigin().y() - building8Top.getHeight() - 120,
                building8Top.getOrigin().x() + 22.5,
                building8Top.getOrigin().y() - building8Top.getHeight()
        );
        building8Spire2.setStroke(spireGradient);
        building8Spire2.setFill(spireGradient);

        Coordinate building8SpireBaseOrigin = new Coordinate(
                building8Top.getOrigin().x() + (building8Top.getWidth() / 2 - 8),
                building8Top.getOrigin().y() - building8Top.getHeight()
        );

        Building building8SpireBase = new Building(
                building8SpireBaseOrigin,
                16,
                4,
                darkSideColor
        );
        Group building8SpireBaseGroup = building8SpireBase.makeBuilding();

        // Building 8 Group (wooooooof that's a big boy)
        Group building8Group = new Group(
                building8BottomGroup, building8MiddleGroup,
                building8TopGroup,
                building8MiddleOutline, building8TopOutline,
                building8RightOutline, building8LeftOutline, building8Spire2, building8SpireBaseGroup
        );

        // ----------------------------------------------------------
        // Building 9 - 3D, right side white
        // ----------------------------------------------------------
        Coordinate b9_origin = new Coordinate(485, MAX_Y);
        ThreeDimensionalBuilding building9 = new ThreeDimensionalBuilding(
                b9_origin,
                115,
                building8Bottom.getHeight() + 17,
                24,
                6,
                darkSideColor,
                brightSideColor,
                brightSideColor
        );
        Group building9Group = building9.makeBuilding();

        // Outlines - using separate lines for different stroke widths
        // Top left, from C4 to C7
        Line building9Outline1 = new Line(
                building9.getC4().x(),
                building9.getC4().y(),
                building9.getC7().x(),
                building9.getC7().y()
        );
        building9Outline1.setStrokeWidth(1);
        building9Outline1.setStroke(darkSideColor);

        // Top right, from C7 to C3
        Line building9Outline2 = new Line(
                building9.getC7().x(),
                building9.getC7().y(),
                building9.getC3().x(),
                building9.getC3().y()
        );
        building9Outline2.setStrokeWidth(.8);
        building9Outline2.setStroke(darkSideColor);

        // Middle right, from C6 to C3
        Line building9Outline3 = new Line(
                building9.getC6().x(),
                building9.getC6().y(),
                building9.getC3().x(),
                building9.getC3().y()
        );
        building9Outline3.setStrokeWidth(.4);
        building9Outline3.setStroke(darkSideColor);

        // Right side, from C3 to top of next building
        Line building9Outline4 = new Line(
                building9.getC3().x() - .7,
                building9.getC3().y() + .7,
                building9.getC3().x() - .7,
                MAX_Y - building6.getHeight() + 14
        );
        building9Outline4.setStrokeWidth(1);
        building9Outline4.setStroke(darkSideColor);

        building9Group.getChildren().addAll(
                building9Outline1, building9Outline2,
                building9Outline3, building9Outline4
        );

        // ----------------------------------------------------------
        // Building 10 - 3D
        // ----------------------------------------------------------
        Coordinate b10_origin = new Coordinate(566, MAX_Y);
        ThreeDimensionalBuilding building10 = new ThreeDimensionalBuilding(
                b10_origin,
                140,
                building6.getHeight() + 15,
                7,
                3,
                lightSideColor,
                darkSideColor,
                brightSideColor
        );
        Group building10Group = building10.makeBuilding();

        // Overlapping white and blue line for right side outline effect
        // Blue line, starts inside then overlaps white line
        Line building10Outline1 = new Line(
                building10.getC3().x() - 3,
                building10.getC3().y() + 1.8,
                building10.getC3().x() - 1,
                MAX_Y - building4.getHeight() + 20
        );
        building10Outline1.setStrokeWidth(2);
        building10Outline1.setStroke(lightSideColor);

        // White line, stays on the outside and is overlapped by blue line
        Line building10Outline2 = new Line(
                building10.getC3().x() - 1,
                building10.getC3().y() + 1,
                building10.getC3().x() - 1,
                MAX_Y - building4.getHeight() + 20
        );
        building10Outline2.setStrokeWidth(2);
        building10Outline2.setStroke(brightSideColor);

        building10Group.getChildren().addAll(building10Outline2, building10Outline1);

        // ----------------------------------------------------------
        // Building 11 - Flat
        // ----------------------------------------------------------
        Coordinate b11_origin = new Coordinate(
                building10.getOrigin().x() + building10.getWidth(),
                MAX_Y
        );
        Building building11 = new Building(
                b11_origin,
                100,
                building4.getHeight() + 40,
                darkSideColor
        );
        Group building11Group = building11.makeBuilding();

        // ----------------------------------------------------------
        // Building 12 - Flat
        // ----------------------------------------------------------
        Coordinate b12_origin = new Coordinate(
                building11.getOrigin().x() + building11.getWidth(),
                MAX_Y
        );
        Building building12 = new Building(
                b12_origin,
                75,
                building7.getHeight() + 20,
                darkSideColor
        );
        Group building12Group = building12.makeBuilding();

        // Outlines, overlapping lines to create effect on left side
        // White line, stays outside and is overlapped by blue
        Line building12LeftOutline1 = new Line(
                building12.getC4().x() + 1,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 1,
                building12.getOrigin().y()
        );
        building12LeftOutline1.setStrokeWidth(2);
        building12LeftOutline1.setStroke(brightSideColor);

        // Vertical blue line, inside at top then overlaps white line by bottom
        Line building12LeftShade2 = new Line(
                building12.getC4().x() + 3.2,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 1,
                building12.getOrigin().y()
        );
        building12LeftShade2.setStrokeWidth(3);
        building12LeftShade2.setStroke(lightSideColor);

        // Horizontal blue line for top of building outline
        Line building12TopShade = new Line(
                building12.getC4().x() + 3.2,
                building12.getC4().y() + 1,
                building12.getOrigin().x() + 30,
                building12.getC4().y() + 1
        );
        building12TopShade.setStrokeWidth(3);
        building12TopShade.setStroke(lightSideColor);

        building12Group.getChildren().addAll(
                building12LeftOutline1, building12LeftShade2, building12TopShade
        );

        // ----------------------------------------------------------
        // Building 13 - Flat
        // ----------------------------------------------------------
        Coordinate b13_origin = new Coordinate(875, MAX_Y);
        Polygon building13 = new Polygon(
                b13_origin.x(), b13_origin.y(),
                b13_origin.x() + 65, b13_origin.y(),
                b13_origin.x() + 65, b13_origin.y() - building8Bottom.getHeight() + 8,
                b13_origin.x(), b13_origin.y() - building8Bottom.getHeight()
        );
        building13.setFill(lightSideColor);
        Group building13Group = new Group(building13);

        // ----------------------------------------------------------
        // Building 14 - 3D
        // ----------------------------------------------------------
        Coordinate b14_origin = new Coordinate(875, MAX_Y);
        ThreeDimensionalBuilding building14 = new ThreeDimensionalBuilding(
                b14_origin, 100,
                building8Bottom.getHeight() + 50,
                15,
                8,
                darkSideColor,
                darkSideColor,
                brightSideColor
        );
        Group building14Group = building14.makeBuilding();

        // Outlines for top of building
        Path building14TopOutline = new Path(
                new MoveTo(building14.getC4().x() + 1, building14.getC4().y()),
                new LineTo(building14.getC7().x() + 1, building14.getC7().y()),
                new LineTo(building14.getC3().x() + 1, building14.getC3().y())
        );
        building14TopOutline.setStrokeWidth(2);
        building14TopOutline.setStroke(darkSideColor);

        // Bright outline for left side
        Line building14LeftOutline = new Line(
                building14.getC4().x() + 1,
                building14.getC4().y() + 3,
                building14.getC4().x() + 1,
                building14.getC4().y() + 43
        );
        building14LeftOutline.setStrokeWidth(2);
        building14LeftOutline.setStroke(brightSideColor);

        // Light sky colored outline for right side
        Line building14RightOutline = new Line(
                building14.getC3().x() + 3,
                building14.getC3().y() + 5,
                building14.getC2().x() + 3,
                building14.getC2().y()
        );
        building14RightOutline.setStrokeWidth(2);
        building14RightOutline.setStroke(skyColor3);

        building14Group.getChildren().addAll(
                building14TopOutline,
                building14LeftOutline,
                building14RightOutline
        );

        // ----------------------------------------------------------
        // Building 15 - Flat
        // ----------------------------------------------------------
        Coordinate b15_origin = new Coordinate(925, MAX_Y);
        Building building15 = new ThreeDimensionalBuilding(
                b15_origin,
                (MAX_X - b15_origin.x()) * 2,
                building8Bottom.getHeight() + 180,
                10,
                6,
                darkSideColor,
                darkSideColor,
                darkSideColor
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
        building15LightShade.setFill(brightSideColor);

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
        building15DarkShade.setFill(lightSideColor);

        building15Group.getChildren().addAll(
                building15LightShade, building15DarkShade
        );

        // ----------------------------------------------------------
        // Building 16 - Flat with two triangle top
        // ----------------------------------------------------------
        Coordinate b16_origin = new Coordinate(
                building3.getOrigin().x() + 10,
                MAX_Y
        );
        Building building16 = new Building(
                b16_origin,
                91,
                building9.getHeight() - 25,
                lightSideColor
        );
        Group building16Group = building16.makeBuilding();

        // Dark colored outline for left side of the building
        Line building16LeftShade = new Line(
                building16.getOrigin().x() + 1, building16.getOrigin().y(),
                building16.getC4().x() + 1, building16.getC4().y()
        );
        building16LeftShade.setStrokeWidth(3);
        building16LeftShade.setStroke(darkSideColor);


        // ***********
        // Top half of building
        // ***********

        // Three triangles create the "tapered look"
        int triangle1Height = 85;
        int triangle2Height = 94;
        int triangle3Height = 108;

        // This triangle is the width of the building but shortest (sides here are shallow)
        Polygon building16Triangle1 = new Polygon(
                building16.getC4().x(),
                building16.getC4().y(),
                building16.getC3().x(),
                building16.getC3().y(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                MAX_Y - building16.getHeight() - triangle1Height
        );
        building16Triangle1.setFill(lightSideColor);

        // Middle part of the sides, slightly steeper (narrower and taller)
        Polygon building16Triangle2 = new Polygon(
                building16.getC4().x() + building16.getWidth() / 16.0,
                MAX_Y - building16.getHeight(),
                building16.getC3().x() - building16.getWidth() / 16.0,
                MAX_Y - building16.getHeight(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                MAX_Y - building16.getHeight() - triangle2Height
        );
        building16Triangle2.setFill(lightSideColor);

        // Top part of the sides, steepest (narrowest and tallest)
        Polygon building16Triangle3 = new Polygon(
                building16.getC4().x() + building16.getWidth() / 4.0,
                MAX_Y - building16.getHeight(),
                building16.getC3().x() - building16.getWidth() / 4.0,
                MAX_Y - building16.getHeight(),
                building16.getC4().x() + building16.getWidth() / 2.0,
                MAX_Y - building16.getHeight() - triangle3Height
        );
        building16Triangle3.setFill(lightSideColor);

        // Outline for sunny effect on top right
        // Colors for outline gradient
        Color building16OutlineLightColor = Color.rgb(225, 208, 198);
        Color building16OutlineDarkColor = Color.rgb(158, 159, 144);

        // Stops for outline gradient
        Stop[] building16OutlineStops = new Stop[] {
                new Stop(0, building16OutlineLightColor),
                new Stop(1, building16OutlineDarkColor)
        };
        // Linear gradient for outline shading
        LinearGradient building16OutlineGradient = new LinearGradient(
                0,
                0,
                1,
                0,
                true,
                CycleMethod.NO_CYCLE,
                building16OutlineStops
        );

        // Outline for sunny effect on top right side, angles with the right side
        Path building16TopOutline = new Path(
                new MoveTo(
                        building16.getOrigin().x() + building16.getWidth() / 2.0,
                        MAX_Y - building16.getHeight() - 105
                ),
                new LineTo(
                        building16.getOrigin().x() + building16.getWidth() / 2.0 + 6,
                        MAX_Y - building16.getHeight() - 77.5
                ),
                new LineTo(142, 586)
        );
        building16TopOutline.setStroke(building16OutlineGradient);
        building16TopOutline.setStrokeWidth(2);

        // ************
        // Spire
        // *************
        Line building16Spire = new Line(
                building16.getOrigin().x() + building16.getWidth() / 2.0,
                MAX_Y - building16.getHeight() - 89,
                building16.getOrigin().x() + building16.getWidth() / 2.0,
                MAX_Y - building16.getHeight() - 125
        );
        // Spire is vertically offset so "middle" of gradient is at the top of the
        // tall triangle, blends in initially then dark color at the top
        building16Spire.setStrokeWidth(2);
        building16Spire.setStroke(spireGradient);

        building16Group.getChildren().addAll(
                building16Spire, building16Triangle2,
                building16Triangle3, building16Triangle1,
                building16LeftShade, building16TopOutline
        );

        // ---------------------------------------------
        // Buildings Group
        // ---------------------------------------------
        Group buildings = new Group(
                building16Group, building1Group, building2Group,
                building3Group, building4Group, building5Group,
                building7Group, building6Group, building9Group,
                building8Group, building10Group, building11Group,
                building12Group, building15Group, building14Group,
                building13Group
        );

        // ==========================================================
        //             _____  _                    _
        //            / ____|| |                  | |
        //           | |     | |  ___   _   _   __| | ___
        //           | |     | | / _ \ | | | | / _` |/ __|
        //           | |____ | || (_) || |_| || (_| |\__ \
        //            \_____||_| \___/  \__,_| \__,_||___/
        // ==========================================================

        Color lightCLoudColor = Color.rgb(237, 243, 240);
        Color darkCloudColor = Color.rgb(183, 192, 202);

        // Stops for gradually shifting from light color to dark color
        Stop[] cloudStops = new Stop[] {
                new Stop(0, lightCLoudColor),
                new Stop(1, darkCloudColor)
        };
        // Stops for light color in the middle, dark color on the ends
        Stop[] cloudStops2 = new Stop[] {
                new Stop(0, darkCloudColor),
                new Stop(.63, lightCLoudColor),
                new Stop(.82, lightCLoudColor),
                new Stop(1, darkCloudColor)
        };

        // Gradient for light on top, dark on bottom
        LinearGradient cloudLightTopGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                cloudStops
        );
        // Gradient for dark on the left, light on the right
        LinearGradient cloudDarkLeftGradient = new LinearGradient(
                1,
                0,
                0,
                0,
                true,
                CycleMethod.NO_CYCLE,
                cloudStops
        );
        // Gradient for dark on top, light on bottom
        LinearGradient cloudDarkTopGradient = new LinearGradient(
                0,
                1,
                0,
                0,
                true,
                CycleMethod.NO_CYCLE,
                cloudStops
        );
        // Gradient for dark on top and bottom, light in the middle
        LinearGradient cloudLightMiddleGradient = new LinearGradient(
                0, 1, 0, 0,
                true,
                CycleMethod.NO_CYCLE,
                cloudStops2
        );

        // ----------------------------------------------------------
        // Cloud 1
        // ----------------------------------------------------------
        Path cloud1 = new Path(
                new MoveTo(0, 2.5),
                new HLineTo(600),
                new CubicCurveTo(518, 95, 425, 45, 370, 75),
                new CubicCurveTo(300, 115, 150, 55, 0, 90)
        );
        cloud1.setStroke(cloudLightTopGradient);
        cloud1.setFill(cloudLightTopGradient);

        // ----------------------------------------------------------
        // Cloud 2
        // ----------------------------------------------------------
        Path cloud2 = new Path(
                new MoveTo(0, 188),
                new CubicCurveTo(110, 183, 140, 163, 255, 178),
                new CubicCurveTo(360, 178, 385, 118, 335, 80),
                new HLineTo(0)
        );
        cloud2.setStroke(cloudLightTopGradient);
        cloud2.setFill(cloudLightTopGradient);

        // ----------------------------------------------------------
        // Cloud 3
        // ----------------------------------------------------------
        Path cloud3 = new Path(
                new MoveTo(0, 160),
                new CubicCurveTo(125, 140, 285, 220, 345, 255),
                new CubicCurveTo(145, 280, 80, 250, 0, 250)
        );
        cloud3.setStroke(cloudDarkLeftGradient);
        cloud3.setFill(cloudDarkLeftGradient);

        // ----------------------------------------------------------
        // Cloud 4
        // ----------------------------------------------------------
        Path cloud4 = new Path(
                new MoveTo(0, 290),
                new CubicCurveTo(95, 285, 200, 330, 310, 347),
                new QuadCurveTo(150, 365, 0, 353)
        );
        cloud4.setStroke(cloudDarkLeftGradient);
        cloud4.setFill(cloudDarkLeftGradient);

        // ----------------------------------------------------------
        // Cloud 5
        // ----------------------------------------------------------
        Path cloud5 = new Path(
                new MoveTo(MAX_X, 362),
                new QuadCurveTo(700, 365, 450, 358),
                new QuadCurveTo(385, 355, 440, 338),
                new QuadCurveTo(635, 275, MAX_X, 310)
        );
        cloud5.setStroke(cloudDarkTopGradient);
        cloud5.setFill(cloudDarkTopGradient);

        // ----------------------------------------------------------
        // Cloud 6
        // ----------------------------------------------------------
        Path cloud6 = new Path(
                new MoveTo(0, 417),
                new CubicCurveTo(220, 444, 360, 390, 670, 425),
                new CubicCurveTo(565, 478, 445, 430, 338, 465),
                new CubicCurveTo(228, 515, 170, 497, 118, 495),
                new QuadCurveTo(65, 488, 0, 528)
        );
        cloud6.setStroke(cloudLightMiddleGradient);
        cloud6.setFill(cloudLightMiddleGradient);

        // ----------------------------------------------------------
        // Cloud 7
        // ----------------------------------------------------------
        Path cloud7 = new Path(
                new MoveTo(72, 330),
                new CubicCurveTo(180, 310, 350, 195, 585, 230),
                new QuadCurveTo(652, 245, 725, 245),
                new QuadCurveTo(900, 225, 1200, 350),
                new HLineTo(800),
                new QuadCurveTo(715, 350, 515, 312),
                new CubicCurveTo(427, 300, 360, 335, 310, 327),
                new CubicCurveTo(207, 313, 140, 345, 72, 330)
        );
        cloud7.setStroke(cloudDarkTopGradient);
        cloud7.setFill(cloudDarkTopGradient);

        // ----------------------------------------------------------
        // Clouds Group
        // ----------------------------------------------------------
        Group cloudGroup = new Group(cloud6, cloud3, cloud2, cloud4, cloud1, cloud7, cloud5);

        // Set strokeLineJoin to round on each cloud Path in cloudGroup
        for (Node child : cloudGroup.getChildren()) {
            ((Path) child).setStrokeWidth(5);
            ((Path) child).setStrokeLineJoin(StrokeLineJoin.ROUND);
        }

        // ==========================================================
        //                _____        _
        //               / ____|      | |
        //              | (___    ___ | |_  _   _  _ __
        //               \___ \  / _ \| __|| | | || '_ \
        //               ____) ||  __/| |_ | |_| || |_) |
        //              |_____/  \___| \__| \__,_|| .__/
        //                                        | |
        //                                        |_|
        // ==========================================================

        // Set root node and scene
        Group root = new Group(sun, arcGroup, cloudGroup, buildings);
        Scene scene = new Scene(root, MAX_X, MAX_Y, skyGradient);

        // Primary stage setup
        primaryStage.setTitle("Ben Godwin - New York Sunset");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
