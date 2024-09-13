package enities;

public class Movie {
	private int movieId;
	private String title;
	private String genre;
	private int duration;
	private String releaseDate;
	private String director;
<<<<<<< HEAD
	private MovieStatus movieStatus;
	private String img;
	
=======
	private int statusId;

>>>>>>> 619344006679bd7bb2522fa8044d0c588bc7ca4a
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int movieId, String title, String genre, int duration, String releaseDate, String director,
<<<<<<< HEAD
			MovieStatus movieStatus, String img) {
=======
			int statusId) {
>>>>>>> 619344006679bd7bb2522fa8044d0c588bc7ca4a
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.director = director;
<<<<<<< HEAD
		this.movieStatus = movieStatus;
		this.img = img;
	}

	public Movie(int movieId) {
		super();
		this.movieId = movieId;
=======
		this.statusId = statusId;
>>>>>>> 619344006679bd7bb2522fa8044d0c588bc7ca4a
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

<<<<<<< HEAD
	public MovieStatus getMovieStatus() {
		return movieStatus;
	}

	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
=======
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
>>>>>>> 619344006679bd7bb2522fa8044d0c588bc7ca4a
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", duration=" + duration
<<<<<<< HEAD
				+ ", releaseDate=" + releaseDate + ", director=" + director + ", movieStatus=" + movieStatus + ", img="
				+ img + "]";
	}
=======
				+ ", releaseDate=" + releaseDate + ", director=" + director + ", statusId=" + statusId + "]";
	}

	

>>>>>>> 619344006679bd7bb2522fa8044d0c588bc7ca4a
}
