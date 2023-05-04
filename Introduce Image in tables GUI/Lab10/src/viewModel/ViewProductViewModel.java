
 
package viewModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author sami7592
 */
public class ViewProductViewModel {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> p = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab10", "root", "12345678");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                float price=rs.getFloat(3);
                String path=rs.getString(4);
                Product p1=new Product(id, name, price,path);
                p.add(p1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
}
