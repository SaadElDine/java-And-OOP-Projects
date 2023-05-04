/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package paintApplication;
import java.awt.*;
import java.awt.geom.Line2D;
import java.lang.Math.*;


/**
 *
 * @author Saad
 */

public class LineSegment extends AbstractShapeClass {

    private Point point2;
  
    public LineSegment (Point point1, Point point2) {
        super(point1);
        this.point2 = point2;
    }
    
    public Point getPoint2() {
        return this.point2;
    }
    
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawLine(getPosition().x, getPosition().y, this.point2.x, this.point2.y);
        if(isSelected()) {
            canvas.setColor(Color.GRAY);
            canvas.fillRect(getPosition().x-5, getPosition().y-5, 10,10);
            canvas.fillRect(this.point2.x-5, this.point2.y-5, 10,10);            
        }
    }

    @Override
    public Boolean contains(Point point) {
        //Line2D.Float line2D = new Line2D.Float(getPosition().x, getPosition().y, this.point2.x, this.point2.y);
//        double totalDist = Math.sqrt(Math.pow(getPosition().x - this.point2.x , 2) + Math.pow(getPosition().y- this.point2.y, 2));
//        double dist1 = Math.sqrt(Math.pow(point.x- this.point2.x , 2) + Math.pow(point.y- this.point2.y, 2));
//        double dist2 = Math.sqrt(Math.pow(getPosition().x - point.x , 2) + Math.pow(getPosition().y- point.y, 2));
//        return totalDist >= dist1 + dist2;
        int x1, y1, x2, y2;
        x1 = getPosition().x;
        y1 = getPosition().y;
        x2 = point2.x;
        y2 = point2.y;
        Line2D.Float x = new Line2D.Float(x1, y1, x2, y2);
        double distance = x.ptSegDist(point);
        if (distance < 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void moveTo(Point point) {
        int deltaX = point.x - getDraggingPoint().x;
        int deltaY = point.y - getDraggingPoint().y;
        point2 = new Point(point2.x + deltaX, point2.y + deltaY);
        setPosition(new Point(getPosition().x + deltaX, getPosition().y + deltaY));        
    }

    @Override
    public void resize(Point p) {
        Point newPosition = new Point();
        Point newPoint2 = new Point();
        int deltaX = getDraggingPoint().x - p.x;
        int deltaY = getDraggingPoint().y - p.y ;
        if(getEdge() == 1) {
            newPosition.x = getPosition().x - deltaX;
            newPosition.y = getPosition().y - deltaY;
            setPosition(newPosition);
        }
        
        if(getEdge() == 2) {
            newPoint2.x = this.point2.x - deltaX;
            newPoint2.y = this.point2.y - deltaY;
            this.point2 = newPoint2;
        }
    }

    @Override
    public Boolean containsB(Point point) {
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
        return false;
    }
    
}
