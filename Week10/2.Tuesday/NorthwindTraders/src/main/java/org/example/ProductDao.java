package org.example;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProductDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public ProductDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    //CRUD functions
    //ReadAll (getAll), ReadById (getById), Update, Delete, Create
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products";

        try(Connection conn = DriverManager.getConnection(connectionString, userName, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            //loop through rows until you run out
            while(rs.next()){
                //How do we grab the data from SQL?
                Product newProduct = new Product();
                newProduct.setProductId(rs.getInt("ProductID"));
                newProduct.setProductName(rs.getString("ProductName"));
                newProduct.setSupplierId(rs.getInt("SupplierID"));
                newProduct.setCategoryId(rs.getInt("CategoryID"));
                newProduct.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                newProduct.setUnitPrice(rs.getDouble("UnitPrice"));

                list.add(newProduct);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return list;
    }

    public Product getById(int id){
        String query = "SELECT * FROM Products WHERE ProductID = ?";

        try(Connection conn = DriverManager.getConnection(connectionString, userName, password);
            PreparedStatement stmt = conn.prepareStatement(query);){

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Product newProduct = new Product();
                    newProduct.setProductId(rs.getInt("ProductID"));
                    newProduct.setProductName(rs.getString("ProductName"));
                    newProduct.setSupplierId(rs.getInt("SupplierID"));
                    newProduct.setCategoryId(rs.getInt("CategoryID"));
                    newProduct.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                    newProduct.setUnitPrice(rs.getDouble("UnitPrice"));

                    return newProduct;
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    //DELETE
    public void delete(int id){
        String query = "DELETE FROM Products WHERE ProductID = ?";

        try(Connection conn = DriverManager.getConnection(connectionString, userName, password);
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    //CREATE
    public void create(Product product){
        String query = "INSERT INTO products (ProductName, UnitPrice) VALUES(?, ?)";

        try(Connection conn = DriverManager.getConnection(connectionString, userName, password);
           PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getUnitPrice());

            //etc. Remember, you don't need to set the id, let SQL do it
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    //UPDATE
    public void update(Product product){
        String query = "UPDATE products SET ProductName = ?, UnitsInStock = ? WHERE ProductID = ?";

        try(Connection conn = DriverManager.getConnection(connectionString, userName, password);
           PreparedStatement stmt = conn.prepareStatement(query)){

            //replace ? with actual data
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getUnitsInStock());
            stmt.setInt(3, product.getProductId());

            stmt.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
