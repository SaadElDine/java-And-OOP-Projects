/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Saad
 */

public abstract class AbstractShapeClass implements Shape, Movable {
   
    private Color borderColor;
    private Color fillColor;
    private Point position;
    private Point draggingPoint;
    private boolean selected;
    private int edge;
    
    
    public AbstractShapeClass(Point position) {
        
        this.setPosition(position);
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }
    
    public boolean isSelected() {
        return this.selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    public void setPosition(Point point1) {
        this.position = point1;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public Color getColor() {
        return this.borderColor;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }
    
    @Override
    public void setDraggingPoint(Point point) {
        this.draggingPoint = point;
    }
    
    @Override
    public Point getDraggingPoint() {
        return this.draggingPoint;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
}
