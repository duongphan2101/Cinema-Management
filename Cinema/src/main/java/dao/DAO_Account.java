package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import enities.Account;
import enities.Employee;

public class DAO_Account {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	 
	    public Account getAccount(String user, String pass) {
	        String query = "select * from Account where username = ? and password = ? "; 
	        try {
	            new DBConnect();
	            conn = DBConnect.getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	            	DAO_Employee dao = new DAO_Employee();
	            	Employee e = dao.getEmployeeByID(rs.getInt(4));
	               return new Account(rs.getInt(1),
	            		   rs.getString(2),
	            		   rs.getString(3),
	            		   e);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	    }
	    
	    public static void main(String[] args) {
			DAO_Account dao = new DAO_Account();
			Account a = dao.getAccount("tranthib", "123");
			System.out.println(a);
		}
}
