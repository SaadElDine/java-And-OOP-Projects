/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paintApplication;
import java.awt.Point;

/**
 *
 * @author Saad
 */
public interface Movable {
    
    public void setDraggingPoint(Point point);
    public Point getDraggingPoint();
    public Boolean contains(Point point);
    public Boolean containsB(Point point);
    public void moveTo(Point point);
    public void resize(Point p) ;
}
