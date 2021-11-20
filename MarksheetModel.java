package com.rays.JBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarksheetModel {
	
	
	
	  public void add(MarksheetBean bean) throws Exception {
	  Class.forName("com.mysql.jdbc.Driver"); Connection conn =
	  DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root",
	  "root");
	  
	  PreparedStatement ps = conn.prepareStatement("INSERT INTO marksheetb VALUES(?,?,?,?,?,?)");
	  ps.setInt(1, bean.getId());
	  ps.setString(2, bean.getRollno());
	  ps.setString(3, bean.getName());
	  ps.setInt(4, bean.getPhy());
	  ps.setInt(5,bean.getChe());
	  ps.setInt(6, bean.getMat());
	  
	  int i = ps.executeUpdate();
	  
	  System.out.println(i+ "Inserted"); 
	  conn.close();
	  ps.close();
	  }
	 
	
	
	
	  public void update(MarksheetBean bean) throws Exception {
	  Class.forName("com.mysql.jdbc.Driver"); Connection conn =
	  DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
	  
	  PreparedStatement ps = conn.prepareStatement("UPDATE marksheetb SET rollno=?, name = ?, phy=?, che=?, mat=? WHERE id = ?"
	  );
	  
	  ps.setString(1, bean.getName());
	  ps.setInt(2, bean.getPhy());
	  ps.setInt(3,bean.getChe());
	  ps.setInt(4, bean.getMat());
	  ps.setString(5, bean.getRollno());
	  ps.setInt(6, bean.getId());
	  int i = ps.executeUpdate();
	  System.out.println(i+ "Updated"); 
	  conn.close();
	  ps.close();
	  
	  }
	 
	
	
	
	
	  public void delete(MarksheetBean bean) throws Exception {
	  Class.forName("com.mysql.jdbc.Driver"); Connection conn =
	  DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root",
	  "root"); 
	  PreparedStatement ps = conn.prepareStatement("DELETE FROM marksheetb WHERE rollno = ?");
	  
	  ps.setString(1, bean.getRollno());
	  int i = ps.executeUpdate();
	  System.out.println(i+
	  "Deleted"); 
	  conn.close();
	  ps.close();
	  }
	 
	 
	
	 public void getrollN(MarksheetBean bean) throws Exception {
		 Class.forName("com.mysql.jdbc.Driver"); 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		 PreparedStatement ps =  conn.prepareStatement("SELECT * FROM marksheetb WHERE rollno = ?");
		 ps.setString(1, bean.getRollno());
		 ResultSet i = ps.executeQuery(); 
		 while(i.next()) {
			 System.out.println(i.getInt(1)); 
			 System.out.println(i.getString(2));
			 System.out.println(i.getString(3));
			 System.out.println(i.getInt(4));
			 System.out.println(i.getInt(5));
			 System.out.println(i.getInt(6));
		 
		 
		 }
		 conn.close();
		  ps.close();
	 }
		 
	  
	  public ArrayList getMeritList(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); Connection conn =
		DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps =conn.prepareStatement("SELECT *, (PHY+CHE+MAT)AS TOTAL, (PHY+CHE+MAT)/3 AS PERCENTAGE FROM marksheetb WHERE PHY>40 AND CHE>40 AND MAT>40 ORDER BY TOTAL DESC LIMIT 0,5");
		
		ResultSet i = ps.executeQuery();
		ArrayList aL = new ArrayList();
		while(i.next()) {
			bean.setId(i.getInt(1)); 
			bean.setRollno(i.getString(2));
			bean.setName(i.getString(3));
			bean.setPhy(i.getInt(4));
			bean.setChe(i.getInt(5));
			 bean.setMat(i.getInt(6));
			 
			 aL.add(bean);
		}
		return aL;
		
		
	  }
	  
	  public void search(MarksheetBean bean) throws Exception {
		  
		Class.forName("com.mysql.jdbc.Driver"); Connection conn =
		DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		PreparedStatement ps =conn.prepareStatement("SELECT *FROM marksheetb where name=? ");
		ps.setString(1, bean.getName());
	  
		ResultSet i = ps.executeQuery();
		while(i.next()) {
			System.out.print(i.getInt(1)); 
			 System.out.print("	\t"+i.getString(2));
			 System.out.print("	\t"+i.getString(3));
			 System.out.print("	\t"+i.getInt(4));
			 System.out.print("	\t"+i.getInt(5));
			 System.out.print("	\t"+i.getInt(6));
			
		}
		
		conn.close();
		  ps.close();
		  
	  }
	  
	  
	 }
