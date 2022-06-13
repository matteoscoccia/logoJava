package it.unicam.cs.ScocciaMatteo119748.logo.playground;

import java.awt.*;

/**
 * Represents the field where the logo output will be drawn
 */
public interface Playground {

    int getHeight();

    int getWidth();

    /**
     * The starting point of the field
     * @return the starting point of the drawing
     */
    Point getHome();

    Color getBackground();

    void setBackground(Color background);
}
