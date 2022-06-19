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

    /**
     * Returns the execution of the line
     * @return string execution
     */
    @Override
    public String getOutputRepresentation() {
        return "\nLINE " + startingPoint.getX() + " " + startingPoint.getY()
                + " " + endingPoint.getX() + " " + endingPoint.getY()
                + " " + color.getRed() + " " + color.getGreen() + " " + color.getBlue()
                + " " + size;
    }

    /**
     * Returns the representation to be printed on a file
     * @return string representation
     */
    @Override
    public String getExecution() {
        return "\nDrawn a LINE from: [" + startingPoint.getX() + "," + startingPoint.getY()
                + "] to [" + endingPoint.getX() + " " + endingPoint.getY()
                + "] colored in [RGB] " + color.getRed() + " " + color.getGreen() + " " + color.getBlue()
                + " with thickness " + size;
    }
}
