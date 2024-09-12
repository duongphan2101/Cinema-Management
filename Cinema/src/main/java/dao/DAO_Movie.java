package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import enities.Movie;
import enities.MovieStatus;

public class DAO_Movie {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Movie> getAllMovie(){
		List<Movie> list = new ArrayList<Movie>();
		String query = "select * from Movie";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Movie(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6), 
						new MovieStatus(rs.getInt(7)),
						rs.getString(8))
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Movie> getAllMovieDangChieu(){
		List<Movie> list = new ArrayList<Movie>();
		String query = "select m.* from Movie m\r\n"
				+ "inner join MovieStatus ms on m.status_id = ms.status_id \r\n"
				+ "where ms.status_id = 1";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Movie(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6), 
						new MovieStatus(rs.getInt(7)),
						rs.getString(8))
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Movie getMoviebyID(int id){
		String query = "select * from Movie where movie_id = ?";
		Movie movie = null;
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
	            movie = new Movie(rs.getInt(1), 
	                              rs.getString(2), 
	                              rs.getString(3), 
	                              rs.getInt(4), 
	                              rs.getString(5), 
	                              rs.getString(6), 
	                              new MovieStatus(rs.getInt(7)), 
	                              rs.getString(8));  
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
	    return movie;
	}
	
	public static void main(String[] args) {
		DAO_Movie dao = new DAO_Movie();
		Movie m = dao.getMoviebyID(1);
		System.out.println(m);
	}

}
