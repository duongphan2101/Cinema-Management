package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import enities.Theater;

public class DAO_Theater {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Theater getTheaterbyID(int id){
		String query = "select * from Theater where theater_id = ?";
		Theater theater = null;
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				theater = new Theater(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4));
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
	    return theater;
	}
	
	public static void main(String[] args) {
		DAO_Theater dao = new DAO_Theater();
		Theater t = dao.getTheaterbyID(1);
		System.out.println(t);
	}
}
