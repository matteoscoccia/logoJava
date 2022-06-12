package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;

/**
 * Basic implementation of the cursor interface
 */
public class CursorImpl implements Cursor{

    private Point position;
    private int direction;
    private Color lineColor;
    private Color areaColor;
    private boolean plot;

    public CursorImpl() {
        position = new Point(0,0);
        direction = 0;
        lineColor = Color.BLACK;
        areaColor = Color.WHITE;
        plot = false;
    }

    public CursorImpl(Point position, int direction, Color lineColor, Color areaColor, boolean plot) {
        this.position = position;
        this.direction = direction;
        this.lineColor = lineColor;
        this.areaColor = areaColor;
        this.plot = plot;
    }

    @Override
    public Color getLineColor() {
        return lineColor;
    }

    @Override
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public Color getAreaColor() {
        return areaColor;
    }

    @Override
    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    @Override
    public boolean isPlot() {
        return plot;
    }

    @Override
    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void setPosition(Point position) {

    }

    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public void setDirection(int direction) {

    }
}
