package com.spy.servlet.dab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class Studentdab 
{

	
	public boolean authentication(String user,String password)
	{
		
		Connection con=null;
		PreparedStatement p =null;
		ResultSet rs=null;
		
		JavaBean bean=new JavaBean();
		
		
		
		
		/*1
		 * load the driver
		 */
		
		try 
		{

			
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			/*
			 * get db connection via driver
			 * dburl-
			 * jdbc:mysql://[host:port],[host:port].../[database] »
	                     [?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]
			 */
			
			
			String dburl="jdbc:mysql://bhavesh-pc:3306/test?user=j2ee&password=j2ee";
			con=DriverManager.getConnection(dburl);
			
			/*
			 * issue sql query via driver
			 */
			
			String q ="select *from password_info where user=? and current_password=?";
			
			 p= con.prepareStatement(q);
			 
			 
			 p.setString(1,user);
			 p.setString(2,password);
			// p.setString(2,password);
				
			/*
			 * process result return by sql query
			 */
			rs=p.executeQuery();
			
		if(rs.next())
			{
			
		   return true;
			
			}
			else
			{
				
				System.out.println("entry not found");
				
				return false;
				
			
			}
			
			
		}
		
		
		
		
		catch (Exception e)
	    {
			
			e.printStackTrace();
		}
		
		
		
			/*
			 * close all jdbc object
			 */
			
			finally
			{
			
				try {
					if(con!=null)
					{
						con.close();
					}
					if(p!=null)
					{
						p.close();
					}
				
				} 
				catch(Exception e) 
				{
					
					e.printStackTrace();
				}
					
			}
		return false;
	}	
}
