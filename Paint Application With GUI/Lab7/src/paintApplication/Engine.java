/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintApplication;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Saad
 */
public class Engine implements DrawingEngine {

    public ArrayList<Shape> Shapes;

    public Engine() {
        this.Shapes = new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        this.Shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.Shapes.remove(shape);
    }

//    @Override
//    public Shape[] getShapes() {
//        return this.Shapes.toArray(Shape[]::new);
//    }

    @Override
    public void refresh(Graphics canvas) {
        canvas.clearRect(0, 0, 830, 490);
        for (int i = 0; i < this.Shapes.size(); i++) {
            Shapes.get(i).draw(canvas);
        }
        
    }
}
