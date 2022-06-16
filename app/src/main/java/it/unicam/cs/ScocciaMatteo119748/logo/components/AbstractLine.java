package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;

/**
 * This represents an abstract line of the drawing, it can be extended to implement several types of lines including a straight line
 */
public abstract class AbstractLine implements ExecutionResult{

    protected Point startingPoint;
    protected Point endingPoint;
    protected Color color;
    protected int size;

    public Point getStartingPoint(){
        return startingPoint;
    }

    Point getEndingPoint(){
        return endingPoint;
    }

    Color getColor(){
        return color;
    }

    int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
