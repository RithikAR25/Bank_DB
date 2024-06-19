package com.ilp04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public ArrayList<Customer> getAllCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        ArrayList<Customer> customerList = customerDAO.getAllCustomers(connection);
        customerDAO.closeConnection(connection);
        return customerList;
    }

    @Override
    public int insertIntoCustomer(Customer customer) {
        int result = 0;
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        try {
            String sql = "INSERT INTO customer (customer_firstname, customer_lastname, address, phonenumber, aadharno) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomer_firstname());
            statement.setString(2, customer.getCustomer_lastname());
            statement.setString(3, customer.getAddress());
            statement.setLong(4, customer.getPhonenumber());
            statement.setLong(5, customer.getAadharno());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            customerDAO.closeConnection(connection);
        }
        return result;
    }



    @Override
    public int updateCustomerField(int customerCode, String fieldName, String newValue) {
        int result = 0;
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        try {
            String sql = "UPDATE customer SET " + fieldName + " = ? WHERE customer_code = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (fieldName.equals("phonenumber") || fieldName.equals("aadharno")) {
                statement.setLong(1, Long.parseLong(newValue));
            } else {
                statement.setString(1, newValue);
            }
            statement.setInt(2, customerCode);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            customerDAO.closeConnection(connection);
        }
        return result;
    }
}
