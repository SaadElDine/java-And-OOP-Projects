/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paintApplication;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */
public class CircleWindow extends javax.swing.JFrame implements Node {

    /**
     * Creates new form CircleWindow
     */
    
    private Node parent;
    private Circle circle;
    private Color borderColor0 = Color.black;
    private Color fillColor0 = null;
    private Canvas canvas;
    private JComboBox<String> jComboBox;
    private Engine engine;
    private int numberOfcircles;
    
    public CircleWindow(Canvas canvas, JComboBox<String> jComboBox, Engine engine) {
        initComponents();
        circle = null;
        this.canvas = canvas;
        this.jComboBox = jComboBox;
        this.engine = engine; 
    }
    
    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
    
    @Override
    public Node getParentNode() {
        return this.parent;
    }
    
    public boolean isNumeric(String str) {
        for(int i=0; i<str.length(); i++) {
            if (!(str.charAt(i) >='0' && str.charAt(i)<='9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iy1 = new javax.swing.JTextField();
        borderColor = new javax.swing.JButton();
        drawCircle = new javax.swing.JButton();
        fillColor = new javax.swing.JButton();
        x1 = new javax.swing.JLabel();
        side = new javax.swing.JLabel();
        y1 = new javax.swing.JLabel();
        ix1 = new javax.swing.JTextField();
        iraduis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Draw Circle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iy1.setBackground(new java.awt.Color(0, 0, 0));
        iy1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        iy1.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(iy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 85, 157, 40));

        borderColor.setBackground(new java.awt.Color(0, 0, 0));
        borderColor.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        borderColor.setForeground(new java.awt.Color(255, 153, 0));
        borderColor.setText("Border Color");
        borderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorActionPerformed(evt);
            }
        });
        getContentPane().add(borderColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 202, 190, 40));

        drawCircle.setBackground(new java.awt.Color(0, 0, 0));
        drawCircle.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        drawCircle.setForeground(new java.awt.Color(255, 153, 0));
        drawCircle.setText("Draw Circle");
        drawCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawCircleActionPerformed(evt);
            }
        });
        getContentPane().add(drawCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 260, 331, 75));

        fillColor.setBackground(new java.awt.Color(0, 0, 0));
        fillColor.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        fillColor.setForeground(new java.awt.Color(255, 153, 0));
        fillColor.setText("Fill Color");
        fillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillColorActionPerformed(evt);
            }
        });
        getContentPane().add(fillColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 202, 190, 40));

        x1.setBackground(new java.awt.Color(255, 153, 0));
        x1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        x1.setForeground(new java.awt.Color(0, 0, 0));
        x1.setText("      Center.x");
        x1.setOpaque(true);
        getContentPane().add(x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 25, 156, 40));

        side.setBackground(new java.awt.Color(255, 153, 0));
        side.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        side.setForeground(new java.awt.Color(0, 0, 0));
        side.setText("          Raduis");
        side.setOpaque(true);
        getContentPane().add(side, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 143, 156, 40));

        y1.setBackground(new java.awt.Color(255, 153, 0));
        y1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        y1.setForeground(new java.awt.Color(0, 0, 0));
        y1.setText("       Center.y");
        y1.setOpaque(true);
        getContentPane().add(y1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 84, 156, 40));

        ix1.setBackground(new java.awt.Color(0, 0, 0));
        ix1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        ix1.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(ix1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 26, 157, 40));

        iraduis.setBackground(new java.awt.Color(0, 0, 0));
        iraduis.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        iraduis.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(iraduis, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 144, 157, 40));

        setSize(new java.awt.Dimension(414, 393));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void drawCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawCircleActionPerformed
        // TODO add your handling code here:
        String strx1 = ix1.getText();
        String stry1 = iy1.getText();
        String strRaduis = iraduis.getText();
        
        if (strx1.equals("") || stry1.equals("") || strRaduis.equals("")) {
            JOptionPane.showMessageDialog(null, "Some Fields are Empty !");
        }
        
        else if (!isNumeric(strx1) || !isNumeric(stry1) || !isNumeric(strRaduis)) {
            JOptionPane.showMessageDialog(null, "Only Positive Numeric Values Are Allowed, Please Try Again!");
            if (!isNumeric(strx1)) {ix1.setText("");}
            if (!isNumeric(stry1)) {iy1.setText("");}
            if (!isNumeric(strRaduis)) {iraduis.setText("");}
        }
        
        else {
            
            int cx = Integer.parseInt(strx1);
            int cy = Integer.parseInt(stry1);
            int raduisInt = Integer.parseInt(strRaduis);
            
            cx = cx - raduisInt;
            cy = cy - raduisInt;
            raduisInt = raduisInt * 2;
            
            circle = new Circle(raduisInt, raduisInt,new Point(cx,cy));     
            circle.setColor(borderColor0);
            circle.setFillColor(fillColor0);
            this.engine.addShape(circle);
            this.circle.draw(canvas.getGraphics());
            borderColor0 = Color.BLACK;
            fillColor0 = null;
            String circleName = "circle" + this.numberOfcircles;
            this.jComboBox.addItem(circleName);
            this.numberOfcircles++;
            this.engine.refresh(canvas.getGraphics()); 
            this.setVisible(false);
//             Paint paint = (Paint) this.getParentNode();
//             paint.setVisible(true);
            ix1.setText("");
            iraduis.setText("");
            iy1.setText("");
            iraduis.setText("");
        }
    }//GEN-LAST:event_drawCircleActionPerformed

    private void fillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillColorActionPerformed
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(null, "Enter Color :", Color.yellow);
        if(color != null) {
            this.fillColor0 = color;
        }
    }//GEN-LAST:event_fillColorActionPerformed

    private void borderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorActionPerformed
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(null, "Enter Color :", Color.yellow);
        if(color != null) {
            this.borderColor0 = color;
        }
    }//GEN-LAST:event_borderColorActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CircleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CircleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CircleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CircleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CircleWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borderColor;
    private javax.swing.JButton drawCircle;
    private javax.swing.JButton fillColor;
    private javax.swing.JTextField iraduis;
    private javax.swing.JTextField ix1;
    private javax.swing.JTextField iy1;
    private javax.swing.JLabel side;
    private javax.swing.JLabel x1;
    private javax.swing.JLabel y1;
    // End of variables declaration//GEN-END:variables
}
