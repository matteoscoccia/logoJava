package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a shape of the drawing which can be made of lines (straight lines or other lines which extend AbstractLine)
 * @param <T> The type of lines the polygon is made of
 */
public class Polygon<T extends AbstractLine> implements ExecutionResult{

    private int numEdges;
    private Color areaColor;
    private ArrayList<T> edges;

    public Polygon(int numEdges, Color areaColor, ArrayList<T> edges) {
        this.numEdges = numEdges;
        this.areaColor = areaColor;
        this.edges = edges;
    }
}
