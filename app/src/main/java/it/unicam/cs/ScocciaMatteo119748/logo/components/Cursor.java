package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;

/**
 * Represents the cursor of the drawing
 */
public interface Cursor {

    Point getPosition();

    void setPosition(Point position);

    int getDirection();

    void setDirection(int direction);

    Color getLineColor();

    void setLineColor(Color lineColor);

    Color getAreaColor();

    void setAreaColor(Color areaColor);

    boolean isPlot();

    void setPlot(boolean plot);

    int getPenSize();

    void setPenSize(int size);

}
