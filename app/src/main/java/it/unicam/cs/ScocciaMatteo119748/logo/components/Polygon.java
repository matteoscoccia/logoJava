package it.unicam.cs.ScocciaMatteo119748.logo.components;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

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

    public Polygon(){
        numEdges = 0;
        areaColor = new Color(255,255,255);
        edges = new ArrayList<>();
    }

    public int getNumEdges() {
        return numEdges;
    }

    public Color getAreaColor() {
        return areaColor;
    }

    public ArrayList<T> getEdges() {
        return edges;
    }

    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    public void addEdge(T edge){
        this.edges.add(edge);
        updateEdgesCount();
    }

    private void updateEdgesCount() {
        this.numEdges = edges.size();
    }

    public void setEdges(ArrayList<T> edges) {
        this.edges = edges;
        updateEdgesCount();
    }

    public boolean checkPolygonClosed() {
        Iterator<T> edgesIterator = edges.iterator();
        while(edgesIterator.hasNext()){
            T edge = edgesIterator.next();
            if(edgesIterator.hasNext()){//It's not the last edge
                if(edge.getStartingPoint().getX() == edges.get(edges.size() - 1).getEndingPoint().getX()
                        && edge.getStartingPoint().getY() == edges.get(edges.size() - 1).getEndingPoint().getY()) {//The polygon is closed
                    closePolygon(edge);
                    return true;
                }
            }
        }
        return false;
    }

    private void closePolygon(T edge) {
        int firstEdgeIndex = edges.indexOf(edge);
        edges.removeAll(edges.subList(0,firstEdgeIndex));//Removes all the previous edges
        updateEdgesCount();
    }

    public Polygon<T> copy(){
        return new Polygon<T>(numEdges, areaColor, edges);
    }

    @Override
    public String getOutputRepresentation() {
        String printresult;
        printresult = "\nPOLYGON " + numEdges + " " + areaColor.getRed() +
                " " + areaColor.getGreen() + " " + areaColor.getBlue();
        for (AbstractLine edge :
                edges) {
            printresult += "\n" + edge.getStartingPoint().getX() + " " + edge.getStartingPoint().getY() +
                    " " + edge.getColor().getRed() + " " + edge.getColor().getGreen() + " " + edge.getColor().getBlue()
                    + " " + edge.getSize();
        }
        return printresult;
    }

    @Override
    public String getExecution() {
        String execution = "\nDrawn POLYGON with " + numEdges + " edges filled with [R,G,B] = " + areaColor.getRed() +
                " " + areaColor.getGreen() + " " + areaColor.getBlue() +
                "\n ";
        for (AbstractLine edge :
                edges) {
            execution += "\n" + edge.getStartingPoint().getX() + " " + edge.getStartingPoint().getY() +
                    " " + edge.getColor().getRed() + " " + edge.getColor().getGreen() + " " + edge.getColor().getBlue()
                    + " " + edge.getSize();
        }
        return execution;
    }


}
