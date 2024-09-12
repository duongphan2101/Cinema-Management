package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import enities.Movie;
import enities.Showtime;
import enities.Theater;

public class DAO_ShowTime {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Showtime> getAllShowTime(){
		List<Showtime> list = new ArrayList<Showtime>();
		String query = "select * from ShowTime";
		DAO_Movie dao = new DAO_Movie();
		DAO_Theater dao1 = new DAO_Theater();
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Movie movie = dao.getMoviebyID(rs.getInt(2));
				Theater theater = dao1.getTheaterbyID(rs.getInt(3));
				list.add(new Showtime(rs.getInt(1),
						movie,
						theater,
						rs.getString(4),
						rs.getString(5))
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		DAO_ShowTime dao = new DAO_ShowTime();
		List<Showtime> lst = dao.getAllShowTime();
		System.out.println(lst);
	}
}
