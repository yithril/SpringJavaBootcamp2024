package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//CRUD functions
public class CategoryRepository {
    private BasicDataSource basicDataSource;

    public CategoryRepository(String url, String userName, String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public List<Category> getAllCategories(String userName, String password){
        String url ="jdbc:mysql://localhost:3306/northwind";

        String query = "SELECT * FROM categories";
        List<Category> categoryList = new ArrayList<>();

        //try-with
        try(Connection conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //grab the data, put it in a java object
                int categoryId = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                String description = rs.getString("Description");

                Category category = new Category(categoryId, categoryName, description);
                categoryList.add(category);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return categoryList;
    }

    public Optional<Category> getCategoryById(int id){
        String query = "SELECT * FROM categories WHERE CategoryID = ?";

        try(Connection conn = basicDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);

            try(ResultSet rs  = ps.executeQuery()){
                if(rs.next()){
                    int categoryId = rs.getInt("CategoryID");
                    String categoryName = rs.getString("CategoryName");
                    String description = rs.getString("Description");

                    return Optional.of(new Category(categoryId, categoryName, description));
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    public void createCategory(Category category){
        String query = "INSERT INTO categories(CategoryName, Description) VALUES(?,?)";

        try(Connection conn = basicDataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());

            ps.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateCategory(Category category){
        String query = "UPDATE categories SET Description = ? WHERE CategoryID = ?";

        try(Connection conn = basicDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, category.getDescription());
            ps.setInt(2, category.getCategoryID());

            ps.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void deleteCategory(int id){
        String query = "DELETE FROM categories WHERE CategoryID = ?";

        try(Connection conn = basicDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,id);

            ps.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
