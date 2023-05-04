/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.Math.*;

/**
 *
 * @author Saad
 */

public class Rectangle extends AbstractShapeClass{
    
    private int width;
    private int height;

    public Rectangle(Point point, int width, int height) {
        super(point);
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
//    public boolean URCorners(Point p) {
//        int x = getPosition().x;
//        int y = getPosition().y;
//        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y - 5, 10, 10);
//        return r.contains(p.getX(), p.getY());
//    }
//
//    public boolean ULCorners(Point p) {
//        int x = getPosition().x;
//        int y = getPosition().y;
//        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
//        return r.contains(p.getX(), p.getY());
//    }
    
    @Override
    public void draw(Graphics canvas) {
        
        if (isSelected()) {
            canvas.setColor(Color.GRAY);
            canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
            canvas.fillRect(getPosition().x + width - 5, getPosition().y - 5, 10, 10);
            canvas.fillRect(getPosition().x - 5, getPosition().y + height - 5, 10, 10);
            canvas.fillRect(getPosition().x + width - 5, getPosition().y + height - 5, 10, 10);
        }
        
        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillRect(getPosition().x, getPosition().y, this.width, this.height);
        }
        canvas.setColor(this.getColor());
        canvas.drawRect(getPosition().x, getPosition().y, this.width, this.height);  
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
        rec.setSize(width, height);
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
//        int x1 = getPosition().x;
//        int y1 = getPosition().y;
//        int x2 = p.x;
//        int y2 = p.y;
//        if (containsB(getDraggingPoint())) {
//            if (x1 > x2 && y1 > y2) {
//                width = width + Math.abs(x1 - x2);
//                height = height + Math.abs(y1 - y2);
//                setPosition(p);
//            } else if (x1 < x2 && y1 < y2) {
//                width = width - Math.abs(x1 - x2);
//                height = height - Math.abs(y1 - y2);
//                setPosition(p);
//            }
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = getPosition().x + this.width;
        int y2 = getPosition().y;
        int x3 = getPosition().x + this.width;
        int y3 = getPosition().y + this.height;
        int x4 = getPosition().x;
        int y4 = getPosition().y + this.height;
        Point newPosition = new Point();   
        int deltaX = getDraggingPoint().x - p.x ;
        int deltaY = getDraggingPoint().y - p.y;
        //int absdeltaX = Math.abs(getDraggingPoint().x - p.x) ;
        //int absdeltaY = Math.abs(getDraggingPoint().y - p.y) ;
        if(getEdge() == 1) {
            if (getDraggingPoint().x <= x2 && getDraggingPoint().y <= y3 ) {
                this.height = this.height + deltaY;
                this.width = this.width + deltaX;
                newPosition.x = getPosition().x - deltaX;
                newPosition.y = getPosition().y - deltaY;
                setPosition(newPosition);
            }
            else if (getDraggingPoint().x > x2 && getDraggingPoint().y <= y3 ) {
                setEdge(2);
//                this.height = this.height + absdeltaY;
//                this.width = this.width + absdeltaX;
//                newPosition.x = deltaX - getPosition().x;
//                newPosition.y = deltaY - getPosition().y;
//                setPosition(newPosition);
            }
            else if (getDraggingPoint().x <= x2 && getDraggingPoint().y > y3) {
                setEdge(3);
            }
            
        }
        if(getEdge() == 2) {
            if (getDraggingPoint().x >= x1 && getDraggingPoint().y <= y4) {
                this.height = this.height + deltaY;
                this.width = this.width - deltaX;
                newPosition.x = getPosition().x;
                newPosition.y = getPosition().y - deltaY;
                setPosition(newPosition);
            }
            else if(getDraggingPoint().x < x1 && getDraggingPoint().y <= y4) {
                setEdge(1);
//                this.height = this.height + absdeltaY;
//                this.width = this.width - absdeltaX;
//                newPosition.x = getPosition().x;
//                newPosition.y = deltaY - getPosition().y;
//                setPosition(newPosition);
            }
            else if (getDraggingPoint().x >= x1 && getDraggingPoint().y > y4) {
                setEdge(4);
            }
        }
        
        if(getEdge() == 3) {
            if (getDraggingPoint().x >= x4 && getDraggingPoint().y >= y2) {
                this.height = this.height - deltaY;
                this.width = this.width - deltaX;
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
                this.height = this.height - deltaY;
                this.width = this.width + deltaX;
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
        r = new Rectangle(new Point(getPosition().x + width - 5,getPosition().y - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(2);
            return true;
        }
        r = new Rectangle(new Point(getPosition().x + width - 5,getPosition().y + height - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(3);
            return true;
        }
        r = new Rectangle(new Point(getPosition().x - 5,getPosition().y + height - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(4);
            return true;
        }
        return false;
    }
}
