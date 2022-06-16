package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;

/**
 * The most basic implementation of a line of the drawing, representing a straight line
 */
public class StraightLine extends AbstractLine{

    public StraightLine(Point startingPoint, Point endingPoint, Color color, int size) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "StraightLine{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}
