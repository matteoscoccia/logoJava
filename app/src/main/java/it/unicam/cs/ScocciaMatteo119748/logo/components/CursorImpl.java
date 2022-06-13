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
    private int penSize;

    public CursorImpl() {
        position = new Point(0,0);
        direction = 0;
        lineColor = Color.BLACK;
        areaColor = Color.WHITE;
        plot = false;
        penSize = 1;
    }

    public CursorImpl(Point position, int direction, Color lineColor, Color areaColor, boolean plot, int penSize) {
        this.position = position;
        this.direction = direction;
        this.lineColor = lineColor;
        this.areaColor = areaColor;
        this.plot = plot;
        this.penSize = penSize;
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
    public int getPenSize() {
        return penSize;
    }

    @Override
    public void setPenSize(int size) {
        this.penSize = size;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
