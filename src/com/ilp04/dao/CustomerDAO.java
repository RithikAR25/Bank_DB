package com.ilp04.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import com.ilp04.entity.Customer;
 
public class CustomerDAO {
	
	//get connection
	public Connection getConnection()
	{
		String connectionURL="jdbc:mysql://localhost:3306/bankdb?useSSL=false";
		String userName="root";
		String password="experion@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL,userName,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	//close connection
	public Connection closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	//get all customer details
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			while(resultSet.next())
			{
				int customerCode = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String address = resultSet.getString(4);
				long phNumber = resultSet.getLong(5);
				long aadharNo = resultSet.getLong(6);
				Customer customer = new Customer(customerCode,customerFirstName,customerLastName,address,phNumber,aadharNo);
				customerList.add(customer);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
 
		
		return customerList;
	}
 
}
 