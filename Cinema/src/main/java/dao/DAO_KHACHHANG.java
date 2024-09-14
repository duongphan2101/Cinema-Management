package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import enities.Customer;

public class DAO_KHACHHANG {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
	public Customer getCustomerbySDT(String sdt) {
        String query = "select * from Customer where phone = ?";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sdt);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                		rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3));
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

   
    public void addCustomer(Customer cus) {
        String query = "INSERT INTO Customer (name, phone) VALUES (?, ?)";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Customer.getName()); 
            ps.setString(2, Customer.getPhone());
            ps.executeUpdate();    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
