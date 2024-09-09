package enities;

public class MovieStatus {
	private int statusId;
	private int movieId;
	private String status;
	public MovieStatus() {
		
	}
	public MovieStatus(int statusId, int movieId, String status) {
		super();
		this.statusId = statusId;
		this.movieId = movieId;
		this.status = status;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MovieStatus [statusId=" + statusId + ", movieId=" + movieId + ", status=" + status + "]";
	}
	
	
}
