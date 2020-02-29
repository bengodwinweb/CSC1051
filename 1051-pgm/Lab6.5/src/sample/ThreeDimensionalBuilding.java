package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;

public class ThreeDimensionalBuilding extends Building {
    public Coordinate coord5;
    public Coordinate coord6;
    public Coordinate coord7;
    public Color rightColor;
    public Color topColor;

    public ThreeDimensionalBuilding(
            Coordinate origin,
            double width,
            double height,
            double midpointOffset,
            double heightOffset,
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
                origin.y() - height + heightOffset
        );
        coord7 = new Coordinate(
                origin.x() + (width / 2) - midpointOffset,
                origin.y() - height - heightOffset
        );
        this.rightColor = rightColor;
        this.topColor = topColor;
    }

    @Override
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
