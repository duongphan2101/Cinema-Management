package enities;

public class Showtime {
    private int showtimeId;
    private int movieId;
    private int theaterId;
    private String showDate;
    private String startTime;
	public Showtime() {
		
	}
	public Showtime(int showtimeId, int movieId, int theaterId, String showDate, String startTime) {
		super();
		this.showtimeId = showtimeId;
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.showDate = showDate;
		this.startTime = startTime;
	}
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "Showtime [showtimeId=" + showtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId
				+ ", showDate=" + showDate + ", startTime=" + startTime + "]";
	}
    
    
}
