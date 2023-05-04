
package viewModel;
import java.sql.*;
import java.util.ArrayList;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;
import model.Product;


public class AddProductViewModel {

    public boolean validateThenaddProduct(String id_str, String name, String price_str, String picturePath) {
        int id;
        float price;
        
        if(id_str.equals("") ||name.equals("") || price_str.equals("")) {
            JOptionPane.showMessageDialog(null, "Some fields are empty!");
            return false;
        }
        
        else if(picturePath == null) {
            JOptionPane.showMessageDialog(null, "You must add a picture of the car!");
            return false;
        }
        
        try {
            id = Integer.parseInt(id_str);
            price = Float.parseFloat(price_str);
            ViewProductViewModel productModel = new ViewProductViewModel();
            ArrayList<Product> products = productModel.getProducts();
            for(int i = 0;i < products.size();i++) {
                if(products.get(i).getId() == id) {
                    JOptionPane.showMessageDialog(null, "Sorry, This ID was already taken!");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            return false;
        }
        Product p = new Product(id, name, price,picturePath);
        SaveProduct(p);
        return true;
    }

    public void SaveProduct(Product product) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab10", "root", "12345678");
            //Statement stmt = con.createStatement();
            //stmt.executeUpdate("insert into products values(" + x.getId() + ",'" + x.getName() + "'," + x.getPrice() + x.getPicturePath() + ")");
            PreparedStatement p = con.prepareStatement("insert into products(ID,Name,Price,PicturePath)VALUES(?,?,?,?)");
            p.setInt(1,product.getId());
            p.setString(2,product.getName());
            p.setFloat(3,product.getPrice());
            p.setString(4,product.getPicturePath());
            p.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "new Car was added successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
