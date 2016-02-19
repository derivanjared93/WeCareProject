package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.exception.CustomException;
import com.project.exception.StatusCode;
import com.project.exception.WrongEntryException;
import com.project.jdbc.mysql.ConnectionPool;
import com.project.pojo.Food;

public class MySqlFoodDAO implements FoodDAO 
{

	public int addFood(Food f) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		 String query = "INSERT INTO `project`.`inventory` "
		 		+ "(`inv_name`, `inv_price`, `inv_category`, `inv_WIC`, `inv_amount`, `inv_brand`)"
					+ "VALUES(?,?,?,?,?,?)";
		System.out.println("Insert Query: " + query);
		Connection con = ConnectionPool.getConnection();
		PreparedStatement pstmt = null;
		try 
		{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, f.getFoodName());
			pstmt.setDouble(2, f.getFoodPrice());
			pstmt.setString(3, f.getFoodCategory().name());
			pstmt.setBoolean(4, f.isWIC());
			pstmt.setInt(6, f.getFoodAmount());
			pstmt.setString(7, f.getFoodBrand());
			returnValue = ConnectionPool.executeUpdate(pstmt);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new CustomException(e, StatusCode.DB_ERROR);
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
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return returnValue;

	}

	public int deleteFood(int foodID) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		String query = "DELETE FROM `project`.`inventory` WHERE `inv_id`= ?";
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
			pstmt.setInt(1, foodID);
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

	public int updateFood(Food f) throws CustomException, WrongEntryException 
	{
		int returnValue = -1;
		String query = "UPDATE `project`.`inventory` SET `inv_name`= ? , `inv_price`= ? , `inv_category`= ? , `inv_WIC`= ? , `inv_amount`= ? , `inv_brand`= ?  WHERE `inv_id`= ? ";
		//				UPDATE `project`.`inventory` SET `inv_name`='?', `inv_price`='?', `inv_category`='?', 
		//								                 `inv_WIC`='?', `inv_amount`='?', `inv_brand`='?' WHERE `inv_id`='?';
		Connection con = ConnectionPool.getConnection();
		PreparedStatement pstmt = null;
		try
		{			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, f.getFoodName());
			pstmt.setDouble(2, f.getFoodPrice());
			pstmt.setString(3, f.getFoodCategory().name());
			pstmt.setBoolean(4, f.isWIC());
			pstmt.setInt(5, f.getFoodAmount());
			pstmt.setString(6, f.getFoodBrand());
			pstmt.setInt(7, f.getFoodID());
			returnValue = ConnectionPool.executeUpdate(pstmt);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Update Query: " + query);
		return returnValue;
	}

	public List<Food> getFood(int foodID) throws CustomException, WrongEntryException 
	{
		ResultSet resultSet = null;
		Connection con = ConnectionPool.getConnection();
		String query = "SELECT * FROM `project`.`inventory` ";
		PreparedStatement pstmt = null;
		
		if(foodID != 0)
		{
			query += " WHERE inv_id = ? ";
		}
		
		try
		{
			pstmt = con.prepareStatement(query);
			if(foodID != 0)
			{
				pstmt.setInt(1, foodID);
			}
			resultSet =  ConnectionPool.executeQuery(pstmt);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
		List<Food> foodList = new ArrayList<Food>();
		
		if(resultSet == null)
		{
			return foodList;
		}
		
		try
		{
			while(resultSet.next())
			{
				Food f = new Food();
				f.setFoodID(resultSet.getInt("inv_id"));
				f.setFoodName(resultSet.getString("inv_name"));
				f.setFoodPrice(resultSet.getDouble("inv_price"));
				f.setFoodCategory(resultSet.getString("inv_category"));//inv_category
				f.setWIC(resultSet.getBoolean("inv_WIC"));//inv_WIC
				f.setFoodAmount(resultSet.getInt("inv_amount"));//inv_amount
				f.setFoodBrand(resultSet.getString("inv_brand"));//inv_brand
				foodList.add(f);
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
		return foodList;	
	}
	
	public List<Food> getFoodByWIC(boolean isWIC) throws CustomException, WrongEntryException 
	{
		ResultSet resultSet = null;
		Connection con = ConnectionPool.getConnection();
		String query = "SELECT * FROM `project`.`inventory` WHERE inv_WIC = ? ";
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
			
		List<Food> foodList = new ArrayList<Food>();
		
		if(resultSet == null)
		{
			return foodList;
		}
		
		try
		{
			while(resultSet.next())
			{
				Food f = new Food();
				f.setFoodID(resultSet.getInt("inv_id"));
				f.setFoodName(resultSet.getString("inv_name"));
				f.setFoodPrice(resultSet.getDouble("inv_price"));
				f.setFoodCategory(resultSet.getString("inv_category"));//inv_category
				f.setWIC(resultSet.getBoolean("inv_WIC"));//inv_WIC
				f.setFoodAmount(resultSet.getInt("inv_amount"));//inv_amount
				f.setFoodBrand(resultSet.getString("inv_brand"));//inv_brand
				foodList.add(f);
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
		return foodList;	
		
	}

}
