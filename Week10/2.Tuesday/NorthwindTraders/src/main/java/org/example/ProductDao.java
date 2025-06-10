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
        String query = "";
    }
}
