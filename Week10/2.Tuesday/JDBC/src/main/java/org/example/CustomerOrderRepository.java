package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderRepository {
    private BasicDataSource basicDataSource;
    public CustomerOrderRepository(String url, String userName, String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }
    public List<CustomerOrderHistory> getCustomerOrderHistory(String customerId){
        String query = "{CALL CustOrderHist(?)}";
        List<CustomerOrderHistory> orderHistory = new ArrayList<>();

        try(Connection connection = basicDataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setString(1, customerId);

            ResultSet resultSet = callableStatement.executeQuery();

            while(resultSet.next()){
                String productName = resultSet.getString("ProductName");
                int total = resultSet.getInt("TOTAL");

                CustomerOrderHistory history = new CustomerOrderHistory(productName, total);

                orderHistory.add(history);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return orderHistory;
    }
}
