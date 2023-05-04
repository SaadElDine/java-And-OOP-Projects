/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paintApplication;
import java.awt.Graphics;

/**
 *
 * @author Saad
 */
public interface DrawingEngine {
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public void refresh(Graphics canvas);   
}
