/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Saad
 */
public class Triangle extends AbstractShapeClass {
    
    private Point point2;
    private Point point3;
    
    public Triangle(Point point1,Point point2,Point point3) {
        super(point1);
        this.point2 = point2;
        this.point3 = point3;
    }
    
    public Point getPoint2() {
        return this.point2;
    }
    
    public Point getPoint3() {
        return this.point3;
    }

    @Override
    public void draw(Graphics canvas) {
   
        if(isSelected()) {
            canvas.setColor(Color.GRAY);
            canvas.fillRect(getPosition().x-5, getPosition().y-5, 10,10);
            canvas.fillRect(this.point2.x-5, this.point2.y-5, 10,10); 
            canvas.fillRect(this.point3.x-5, this.point3.y-5, 10,10);
        }
        
        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillPolygon(new Polygon(new int[] {super.getPosition().x, point2.x , point3.x} ,new int[] {super.getPosition().y, point2.y , point3.y} , 3));
        }
        
        canvas.setColor(this.getColor());
        canvas.drawPolygon(new Polygon(new int[] {super.getPosition().x, point2.x , point3.x} ,new int[] {super.getPosition().y, point2.y , point3.y} , 3));
    }

    @Override
    public Boolean contains(Point point) {
        Polygon tri = new Polygon(new int[]{getPosition().x, point2.x, point3.x}, new int[]{getPosition().y, point2.y, point2.y}, 3);
        return tri.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int deltaX = point.x - getDraggingPoint().x;
        int deltaY = point.y - getDraggingPoint().y;
        point2 = new Point(point2.x + deltaX, point2.y + deltaY);
        point3 = new Point(point3.x + deltaX, point3.y + deltaY);
        setPosition(new Point(getPosition().x + deltaX, getPosition().y + deltaY));
    }

    @Override
    public void resize(Point p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Point newPosition = new Point();
        Point newPoint2 = new Point();
        Point newPoint3 = new Point();
        int deltaX = getDraggingPoint().x - p.x;
        int deltaY = getDraggingPoint().y - p.y;
        if(getEdge() == 1) {
            newPosition.x = getPosition().x - deltaX;
            newPosition.y = getPosition().y - deltaY;
            setPosition(newPosition);
        }
        
        if(getEdge() == 2) {
            newPoint2.x = point2.x - deltaX;
            newPoint2.y = point2.y - deltaY;
            this.point2 = newPoint2;
        }
        if(getEdge() == 3) {
            newPoint3.x = point3.x - deltaX;
            newPoint3.y = point3.y - deltaY;
            this.point3 = newPoint3;
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
        r = new Rectangle(new Point(this.point2.x - 5,this.point2.y - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(2);
            return true;
        }
        r = new Rectangle(new Point(this.point3.x - 5,this.point3.y - 5), 10, 10);
        if(r.contains(point)) {
            setEdge(3);
            return true;
        }
        return false;
    }
}
