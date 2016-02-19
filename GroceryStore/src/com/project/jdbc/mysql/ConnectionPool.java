package com.project.jdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;
import com.project.exception.WrongEntryException;
import com.project.exception.StatusCode;
import com.project.exception.CustomException;

//
public class ConnectionPool
{
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/project";
	
	static
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		}
		catch(Exception e)
		{
			System.out.println("Error Loading Driver");
		}
	}
	
	public static void main(String[] args) 
	{
		DataSource unpooled;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			
			unpooled = DataSources.unpooledDataSource(DATABASE_URL, "root", "derivan");
			DataSource pooled = DataSources.pooledDataSource(unpooled);
			con = pooled.getConnection();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");
			while(rs.next())
			{
				System.out.print(rs.getString(1)+ " ");
				System.out.print(rs.getString(2)+ " ");
				System.out.print(rs.getString(3)+ " ");
				System.out.print(rs.getString(4)+ " \n");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			attemptClose(rs);
			attemptClose(stmt);
			attemptClose(con);
		}
	}

	public static int executeUpdate(Connection con, String query)
	{
		Statement statement = null;
		int returnValue = -1;
		try
		{
			statement = con.createStatement();
			returnValue = statement.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			System.out.println("Error executing query " + e);
			
		}
		finally
		{
			try
			{
				statement.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return returnValue;
		
	}

	public static ResultSet executeQuery(Connection con, String query) throws WrongEntryException
	{
		Statement statement = null;
		ResultSet resultSet = null;
		try
		{
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);

		}
		catch(SQLException e)
		{
			System.out.println(query);
			System.out.println("Error executing query " + e);
			throw new WrongEntryException(e, StatusCode.NEW);
		}
		return resultSet;
	}
	
	public static Connection getConnection() throws CustomException
	{
		DataSource unpooled;
		Connection con = null;
		try
		{
			unpooled = DataSources.unpooledDataSource(DATABASE_URL, "root", "derivan");
			DataSource pooled = DataSources.pooledDataSource(unpooled);
			con = pooled.getConnection();
		}
		catch(SQLException e)
		{			
			System.out.println("Error getting connection"+e);
			throw new CustomException(e, StatusCode.DB_ERROR);
		}
		return con;
	}
	
	static void attemptClose(Statement o)
	{ 
		try{ if(o != null) o.close(); }
		catch(Exception e){e.printStackTrace();}
	}
	
	static void attemptClose(ResultSet o)
	{
		try{ if(o != null) o.close(); }
		catch(Exception e){e.printStackTrace();}
	}
	
	static void attemptClose(Connection o)
	{
		try{ if(o != null) o.close(); }
		catch(Exception e){e.printStackTrace();}
	}

	//Overloaded version of executeQuery using PreparedStatement
	public static ResultSet executeQuery(PreparedStatement pstst)
	{
		ResultSet rs = null;
		try
		{
			rs = pstst.executeQuery();

		}
		catch(SQLException e)
		{
			System.out.println("Error executing query " + e);
		}
		return rs;
	}
	
	//Overloaded version of executeUpdate using PreparedStatement
	public static int executeUpdate(PreparedStatement pstst) throws WrongEntryException
	{
		int returnValue = -1;
		try
		{
			returnValue = pstst.executeUpdate();
			
		}
		catch(SQLException e)
		{
			//System.out.println("Error executing query " + e);
			throw new WrongEntryException(e, StatusCode.NEW);
		}
		return returnValue;
		
	}


}
