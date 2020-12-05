package com.xu.access;

import java.awt.List;
import java.awt.PopupMenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBS {

	public Connection getConnection(){
       try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("连接成功!!!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
       
    }
	//添加数据
	public void Adddata(String a) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\97803\\Desktop\\MACHINE01.accdb","","");
		Statement stmt=con.createStatement();
		int add=stmt.executeUpdate(a);
		if(add>0){
			System.out.println("添加成功!!!");
		}else{
			System.out.println("添加失败!!!");
		}
		//在每一个对于数据库的操作完成之后都要关闭Statement对象
		stmt.close();
		//在每一个对于数据库的操作完成之后都要关闭Connection对象
		con.close();
	}
	
	public ArrayList Reacherdata(String chartname ,int title) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\97803\\Desktop\\MACHINE01.accdb","","");
		Statement stmt=con.createStatement();
		ArrayList list = new ArrayList();
		ResultSet rs=stmt.executeQuery(chartname);
		
		while(rs.next()){          
			
			
			list.add(rs.getInt(title));//获取键名及值
		
			
			System.out.println(rs.getString(title));
		}	  
		//在每一个对于数据库的操作完成之后都要关闭Statement对象
		stmt.close();
		//在每一个对于数据库的操作完成之后都要关闭Connection对象
		con.close();
		return list;
	}
	
	
	public void Deletedata() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\97803\\Desktop\\MACHINE01.accdb","","");
		Statement stmt=con.createStatement();
		int del=stmt.executeUpdate("delete test where name ='电机'");
		if(del>0){
			System.out.println("删除成功!!!");
		}else{
			System.out.println("删除失败!!!");
		}
		//在每一个对于数据库的操作完成之后都要关闭Statement对象
		stmt.close();
		//在每一个对于数据库的操作完成之后都要关闭Connection对象
		con.close();

	}
	
	public void Changedata(String a) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\97803\\Desktop\\MACHINE01.accdb","","");
		Statement stmt=con.createStatement();
		int upd=stmt.executeUpdate(a);
		if(upd>0){
			System.out.println("修改成功!!!");
		}else{
			System.out.println("修改失败!!!");
		}
		//在每一个对于数据库的操作完成之后都要关闭Statement对象
		stmt.close();
		//在每一个对于数据库的操作完成之后都要关闭Connection对象
		con.close();

	}



	
	
		public static void main(String[] args) throws Exception {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\97803\\Desktop\\MACHINE01.accdb","","");
			Statement stmt=con.createStatement();
			int add=stmt.executeUpdate("insert into test(VOL,CUR) values(10,30)");
			if(add>0){
				System.out.println("添加成功!!!");
			}else{
				System.out.println("添加失败!!!");
			}
			//在每一个对于数据库的操作完成之后都要关闭Statement对象
			stmt.close();
			//在每一个对于数据库的操作完成之后都要关闭Connection对象
			con.close();
		}	
	}





