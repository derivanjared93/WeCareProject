package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.project.exception.StatusCode;
import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.jdbc.mysql.ConnectionPool;
import com.project.pojo.Customer;
import com.project.pojo.Order;

public class MySqlCustomerDAO implements CustomerDAO {

	public int addCustomer(Customer c) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		 String query = "INSERT INTO `project`.`customer` (`cust_fname`, `cust_lname`, `cust_password`, `cust_CC`, `cust_WIC`, `cust_email`, `cust_admin`)"
					+ "VALUES(?,?,?,?,?,?,?)";
		System.out.println("Insert Query: " + query);
		//Connection con = ConnectionManager.getConnection();
		Connection con = ConnectionPool.getConnection();
		PreparedStatement pstmt = null;
		try 
		{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getFirstName());
			pstmt.setString(2, c.getLastName());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, c.getCcNumber());
			pstmt.setBoolean(5, c.isWIC());
			pstmt.setString(6, c.getEmail());
			pstmt.setBoolean(7, c.isAdmin());
			returnValue = ConnectionPool.executeUpdate(pstmt);
			
		} 
		catch (SQLException e1) 
		{
		//	e1.printStackTrace();
			throw new CustomException(e1, StatusCode.DB_ERROR);
		}
		finally
		{
			try 
			{
				if(pstmt !=null)
				{
					pstmt.close();
				}
				
				if(con!= null)
				{
					con.close();
				}
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		return returnValue;
	}
	
	public int deleteCustomer(int employeeID) throws CustomException, WrongEntryException 
	{
		return 0;
	}
	
	public int updateCustomer(Customer c) throws CustomException, WrongEntryException 
	{
		return 0;
	}


	public List<Customer> getCustomerByID(int customerID) throws CustomException, WrongEntryException {

		return null;
	}


	public List<Customer> getCustomerByName(String name, int firstLast) throws CustomException, WrongEntryException {

		return null;
	}


	public List<Customer> getCustomerByWIC(boolean isWIC) throws CustomException, WrongEntryException {
		return null;
	}


	public List<Order> getCustomerOrders(int customerID) throws CustomException, WrongEntryException 
	{
		return null;
	}

}
