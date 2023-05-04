/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Saad
 */
public class Text extends AbstractShapeClass {
    
    private String text;
    

    public Text(Point position, String text) {
        super(position);
        this.text = text;  
    }
    
    @Override
    public void draw(Graphics canvas) {
        canvas.drawString(this.text, getPosition().x, getPosition().y);
    }  

    /**
     *
     * @param point
     * @return
     */
    @Override
    public Boolean contains(Point point) {   
        java.awt.Rectangle rec = new java.awt.Rectangle();
        rec.setLocation(getPosition());
        rec.setSize(100, 100);
        return rec.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int deltaX = point.x - getDraggingPoint().x;
        int deltaY = point.y - getDraggingPoint().y;
        setPosition(new Point(getPosition().x + deltaX, getPosition().y + deltaY));
    }

    @Override
    public void resize(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean containsB(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
