package UseGUI3;

// Extension of Building class - creates a building that appears 3D

/*
*           3D-BUILDING
*
*     width is still distance between origin and C2
*     height is distance between C2 and C3 (or origin and C4)
*
*     verticalOffset:
*           the vertical distance between the top of the building (y of C3 and C4),
*           and the y of C6 and C7
*           C7.y() = C3.y() + verticalOffset
*           C6.y() = C3.y() - verticalOffset
*
*     midpointOffset:
*           the horizontal distance between the true midpoint and the (origin.x() + (with / 2))
*           and the x of C5/6 and C7
*           C5.x() = C6.x() = origin.x() + (width / 2) + midpointOffset
*           C7.x() = origin.x() + (width / 2) - midpointOffset
*
*                 C7
*                  ^
*               /      \
*         C4  /           \      C3
*            |  \  C6   /  |
*            |      ∨      |
*            |      |      |
*            |      |      |
*            |      |      |
*            |      |      |
*            |      |      |
*            |      |      |
*     Origin  ---------------  C2
*                   C5
* */

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;

public class ThreeDimensionalBuilding extends Building {
    public Coordinate coord5; // bottom middle
    public Coordinate coord6; // middle middle
    public Coordinate coord7; // top middle
    public Color rightColor; // color of building's right side
    public Color topColor; // color of building's top side

    public ThreeDimensionalBuilding(
            Coordinate origin,
            double width,
            double height,
            double midpointOffset,
            double verticalOffset,
            Color leftColor,
            Color rightColor,
            Color topColor
    ) {
        super(origin, width, height, leftColor);
        coord5 = new Coordinate(
                origin.x() + (width / 2) + midpointOffset,
                origin.y()
        );
        coord6 = new Coordinate(
                origin.x() + (width / 2) + midpointOffset,
                origin.y() - height + verticalOffset
        );
        coord7 = new Coordinate(
                origin.x() + (width / 2) - midpointOffset,
                origin.y() - height - verticalOffset
        );
        this.rightColor = rightColor;
        this.topColor = topColor;
    }

    @Override
    /* takes the coordinates and makes three polygons: left, right, and top,
    *   then returns them in a group */
    public Group makeBuilding() {
        Polygon leftSide = new Polygon(
                super.getOrigin().x(), super.getOrigin().y(),
                coord5.x(), coord5.y(),
                coord6.x(), coord6.y(),
                super.getC4().x(), super.getC4().y()
        );
        leftSide.setFill(super.getColor());

        Polygon rightSide = new Polygon(
                coord5.x(), coord5.y(),
                super.getC2().x(), super.getC2().y(),
                super.getC3().x(), super.getC3().y(),
                coord6.x(), coord6.y()
        );
        rightSide.setFill(rightColor);

        Polygon topSide = new Polygon(
                super.getC4().x(), super.getC4().y(),
                coord6.x(), coord6.y(),
                super.getC3().x(), super.getC3().y(),
                coord7.x(), coord7.y()
        );
        topSide.setFill(topColor);

        return new Group(leftSide, rightSide, topSide);
    }

    public Coordinate getC5() {
        return coord5;
    }

    public Coordinate getC6() {
        return coord6;
    }

    public Coordinate getC7() {
        return coord7;
    }
}
