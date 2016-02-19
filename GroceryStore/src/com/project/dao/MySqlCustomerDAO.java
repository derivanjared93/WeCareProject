package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public int deleteCustomer(int customerID) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		String query = "DELETE FROM `project`.`customer` WHERE `cust_id`= ?";
		System.out.println("Delete Query: " + query);
		Connection con = null;
		try 
		{
			con = ConnectionPool.getConnection();
		} 
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		try 
		{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerID);
			returnValue = ConnectionPool.executeUpdate(pstmt);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				pstmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return returnValue;
		
	}
		
	public int updateCustomer(Customer c) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		String query = "UPDATE `project`.`customer` SET `cust_fname`= ?, `cust_lname`= ? , `cust_password`= ? , `cust_CC`= ? , `cust_WIC`= ? , `cust_admin`= ?  WHERE `cust_id` = ? ";
		//			   "UPDATE `project`.`customer` SET `cust_fname`= ?, `cust_lname`= ? , `cust_password`= ? , 
		//						`cust_CC`= ? , `cust_WIC`= ? , `cust_admin`= ?  WHERE employee_id = ? ";
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
			pstmt.setBoolean(6, c.isAdmin());
			pstmt.setInt(7, c.getCustomerID());
			returnValue = ConnectionPool.executeUpdate(pstmt);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Update Query: " + query);
		return returnValue;
	}

	public List<Customer> getCustomerByID(int customerID) throws CustomException, WrongEntryException 
	{
		ResultSet resultSet = null;
		Connection con = ConnectionPool.getConnection();
		String query = "SELECT * FROM `project`.`customer` ";
		PreparedStatement pstmt = null;
		
		if(customerID != 0)
		{
			query += " WHERE cust_id = ? ";
		}
		
		try
		{
			pstmt = con.prepareStatement(query);
			if(customerID != 0)
			{
				pstmt.setInt(1, customerID);
			}
			resultSet =  ConnectionPool.executeQuery(pstmt);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
		List<Customer> custList = new ArrayList<Customer>();
		
		if(resultSet == null)
		{
			return custList;
		}
		
		try
		{
			while(resultSet.next())
			{
				Customer c = new Customer();
				c.setCustomerID(resultSet.getInt("cust_id"));
				c.setFirstName(resultSet.getString("cust_fname"));
				c.setLastName(resultSet.getString("cust_lname"));
				c.setPassword(resultSet.getString("cust_password"));
				c.setCcNumber(resultSet.getString("cust_CC"));
				c.setWIC(resultSet.getBoolean("cust_WIC"));
				c.setEmail(resultSet.getString("cust_email"));
				c.setAdmin(resultSet.getBoolean("cust_admin"));
				custList.add(c);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error Message: " + e);
		}
		finally
		{
			try
			{
				//statement.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return custList;	
	}

	public List<Customer> getCustomerByName(String name, int firstLast) throws CustomException, WrongEntryException 
	{

		return null;
	}

	public List<Customer> getCustomerByWIC(boolean isWIC) throws CustomException, WrongEntryException 
	{
		ResultSet resultSet = null;
		Connection con = ConnectionPool.getConnection();
		String query = "SELECT * FROM `project`.`customer` WHERE cust_WIC = ? ";
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.setBoolean(1, isWIC);
			resultSet =  ConnectionPool.executeQuery(pstmt);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
		List<Customer> custList = new ArrayList<Customer>();
		
		if(resultSet == null)
		{
			return custList;
		}
		
		try
		{
			while(resultSet.next())
			{
				Customer c = new Customer();
				c.setCustomerID(resultSet.getInt("cust_id"));
				c.setFirstName(resultSet.getString("cust_fname"));
				c.setLastName(resultSet.getString("cust_lname"));
				c.setPassword(resultSet.getString("cust_password"));
				c.setCcNumber(resultSet.getString("cust_CC"));
				c.setWIC(resultSet.getBoolean("cust_WIC"));
				c.setEmail(resultSet.getString("cust_email"));
				c.setAdmin(resultSet.getBoolean("cust_admin"));
				custList.add(c);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error Message: " + e);
		}
		finally
		{
			try
			{
				//statement.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return custList;	
	}

	public List<Order> getCustomerOrders(int customerID) throws CustomException, WrongEntryException 
	{
		ResultSet resultSet = null;
		Connection con = ConnectionPool.getConnection();
		String query = "SELECT * FROM `project`.`orders` WHERE cust_id = ? ";
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerID);
			resultSet =  ConnectionPool.executeQuery(pstmt);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
		List<Order> orderList = new ArrayList<Order>();
		
		if(resultSet == null)
		{
			return orderList;
		}
		
		try
		{
			while(resultSet.next())
			{
				Order o = new Order();
				o.setOrderID(resultSet.getInt("order_id"));
				o.setCustomerID(resultSet.getInt("cust_id"));
				o.setOrderTotal(resultSet.getDouble("order_total"));
				o.setOrderDate(resultSet.getString("order_date"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error Message: " + e);
		}
		finally
		{
			try
			{
				//statement.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return orderList;	

	}


}
