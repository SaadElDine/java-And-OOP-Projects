package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import viewModel.AddProductViewModel;


public class AddProduct extends javax.swing.JFrame implements MouseListener,Observer {

    private String ImagePath;
    private Subject mainWindow;
    
    public AddProduct() {
        initComponents();
        jButton1.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        image1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 450, 60));

        jButton2.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Click To Add Picture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 320, 60));

        image1.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        image1.setForeground(new java.awt.Color(0, 0, 0));
        image1.setText("                       Add Picture Here");
        image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 480, 310));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 50));

        txtID.setColumns(20);
        txtID.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        txtID.setForeground(new java.awt.Color(0, 0, 0));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 320, 60));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 50));

        txtName.setColumns(20);
        txtName.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 320, 60));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("price");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 60));

        txtPrice.setColumns(20);
        txtPrice.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 320, 60));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1271, 139, -1, -1));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Picture");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 60));

        setSize(new java.awt.Dimension(980, 511));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddProductViewModel a = new AddProductViewModel();
        
        if (a.validateThenaddProduct(txtID.getText(), txtName.getText(), txtPrice.getText(), this.ImagePath)) {
            //JOptionPane.showMessageDialog(null, "new Car will be added successfully to the data base table if the id wasn't used yet!");
            txtID.setText("");
            txtName.setText("");
            txtPrice.setText("");
            this.image1.setIcon(null);
        } else {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser("E:\\Term 5\\Programming 2\\Lab\\Lab 10\\Peugeot");
        FileNameExtensionFilter f = new FileNameExtensionFilter("IMAGES", "png", "jpg" , "jpeg");
        browseImageFile.addChoosableFileFilter(f);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            this.ImagePath = selectedImagePath;
            //JOptionPane.showMessageDialog(null, selectedImagePath);
            ImageIcon i = new ImageIcon(selectedImagePath);
            Image image = i.getImage().getScaledInstance(this.image1.getWidth(), this.image1.getHeight(), Image.SCALE_SMOOTH);
            this.image1.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        txtID.setText("");
            txtName.setText("");
            txtPrice.setText("");
            this.image1.setIcon(null);
        ((mainFrame) mainWindow).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        try {
//            UIManager.setLookAndFeel(new FlatDarkLaf());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(AddProduct.class
////                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
////
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(AddProduct.class
////                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
////
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(AddProduct.class
////                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
////
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(AddProduct.class
////                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddProduct().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        jButton1.setBackground(Color.BLACK);
        jButton1.setForeground(Color.GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        jButton1.setBackground(Color.GRAY);
        jButton1.setForeground(Color.BLACK);
    }

    @Override
    public void update() {
        ((mainFrame) mainWindow).setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void setSubject(Subject mainWindow) {
        this.mainWindow = mainWindow;   
    }
}
