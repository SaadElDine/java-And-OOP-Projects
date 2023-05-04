/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Saad
 */

public class Circle extends AbstractShapeClass {
    
    private int radiusV;
    private int radiusH;


    public Circle(int radiusV, int radiusH, Point point) {
        super(point);
        this.radiusV = radiusV;
        this.radiusH = radiusH;

    }

    public int getRadiusV() {
        return radiusV;
    }

    public int getRadiusH() {
        return radiusH;
    }  
   
    @Override
    public void draw(Graphics canvas) {
        if (isSelected()) {
            canvas.setColor(Color.GRAY);
            canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
            canvas.fillRect(getPosition().x + (radiusH) - 5, getPosition().y - 5, 10, 10);
            canvas.fillRect(getPosition().x - 5, getPosition().y + (radiusV) - 5, 10, 10);
            canvas.fillRect(getPosition().x + (radiusH) - 5, getPosition().y + (radiusV) - 5, 10, 10);
        }
        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillOval(getPosition().x, getPosition().y, this.radiusH, this.radiusV);
        }
        
        canvas.setColor(this.getColor());
        canvas.drawOval(getPosition().x, getPosition().y, this.radiusH, this.radiusV);  
    }

    @Override
    public Boolean contains(Point point) {
//        java.awt.Rectangle rec = new java.awt.Rectangle();
//        rec.setLocation(getPosition());
//        rec.setSize(radiusV, radiusH);
//        return rec.contains(point);
          Ellipse2D.Float circle = new Ellipse2D.Float(getPosition().x, getPosition().y, radiusH, radiusV);
          return circle.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int deltaX = point.x - getDraggingPoint().x;
        int deltaY = point.y - getDraggingPoint().y;
        setPosition(new Point(getPosition().x + deltaX, getPosition().y + deltaY));
    }

    @Override
    public void resize(Point p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = getPosition().x + this.radiusH;
        int y2 = getPosition().y;
        int x3 = getPosition().x + this.radiusH;
        int y3 = getPosition().y + this.radiusV;
        int x4 = getPosition().x;
        int y4 = getPosition().y + this.radiusV;
        int deltaX = getDraggingPoint().x - p.x;
        int deltaY = getDraggingPoint().y - p.y;
        Point newPosition=new Point();
        if(getEdge() == 1) {
            if (getDraggingPoint().x <= x2 && getDraggingPoint().y <= y3 ) {
                radiusV = radiusV + deltaY;
                radiusH = radiusH + deltaX;
                newPosition.x = getPosition().x - deltaX;
                newPosition.y = getPosition().y - deltaY;
                setPosition(newPosition);
            }
            else if (getDraggingPoint().x > x2 && getDraggingPoint().y <= y3 ) {
                setEdge(2);
            }
            else if (getDraggingPoint().x <= x2 && getDraggingPoint().y > y3) {
                setEdge(3);
            }
        }
        if(getEdge() == 2) {
            if (getDraggingPoint().x >= x1 && getDraggingPoint().y <= y4) {
                radiusV = radiusV + deltaY;
                radiusH = radiusH - deltaX;
                newPosition.x = getPosition().x;
                newPosition.y = getPosition().y - deltaY;
                setPosition(newPosition);
            }
            else if(getDraggingPoint().x < x1 && getDraggingPoint().y <= y4) {
                setEdge(1);
            }
            else if (getDraggingPoint().x >= x1 && getDraggingPoint().y > y4) {
                setEdge(4);
            }
        }
        if(getEdge() == 3) {
            if (getDraggingPoint().x >= x4 && getDraggingPoint().y >= y2) {
                radiusV = radiusV - deltaY;
                radiusH = radiusH - deltaX;
                newPosition.x = getPosition().x;
                newPosition.y = getPosition().y;
                setPosition(newPosition);
            }
            else if (getDraggingPoint().x < x4 && getDraggingPoint().y >= y2) {
                setEdge(4);
            }
            else if (getDraggingPoint().x >= x4 && getDraggingPoint().y < y2) {
                setEdge(2);
            }
        }
        if(getEdge() == 4) {
            if (getDraggingPoint().x <= x3 && getDraggingPoint().y >= y1) {
                radiusV = radiusV - deltaY;
                radiusH = radiusH + deltaX;
                newPosition.x = getPosition().x - deltaX;
                newPosition.y = getPosition().y;
                setPosition(newPosition);
            }
            else if (getDraggingPoint().x > x3 && getDraggingPoint().y >= y1) {
                setEdge(3);
            }
            else if (getDraggingPoint().x <= x3 && getDraggingPoint().y <= y1) {
                setEdge(1);
            }  
        }
    }

    @Override
    public Boolean containsB(Point point) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Rectangle r = new Rectangle(new Point(getPosition().x - 5,getPosition().y - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(1);
            return true;
        }
        r = new Rectangle(new Point(getPosition().x + (radiusH) - 5,getPosition().y - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(2);
            return true;
        }
        r = new Rectangle(new Point(getPosition().x + (radiusH) - 5,getPosition().y + (radiusV) - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(3);
            return true;
        }
        r = new Rectangle(new Point(getPosition().x - 5,getPosition().y + (radiusV) - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(4);
            return true;
        }
        return false;
    }
}
