package it.unicam.cs.ScocciaMatteo119748.logo.playground;

import java.awt.*;

/**
 * Default implementation of the drawing area
 */
public class PlaygroundImpl implements Playground{

    private final int height;
    private final int width;
    private final Color background;

    /**
     * Default constructor of the playground, sets the background color to white
     * @param width width of the field
     * @param height height of the field
     */
    public PlaygroundImpl(int width, int height) {
        this.height = height;
        this.width = width;
        background = new Color(255,255,255);
    }

    /**
     * Builds the playground and sets the background to the specified color
     * @param width width of the field
     * @param height height of the field
     * @param background background color of the field
     */
    public PlaygroundImpl(int width, int height, Color background) {
        this.height = height;
        this.width = width;
        this.background = background;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Gets the starting point of the drawing
     * @return the home of the field (width/2),(height/2)
     */
    @Override
    public Point getHome() {
        return new Point((width/2), (height/2));
    }

    @Override
    public Color getBackground() {
        return background;
    }
}
