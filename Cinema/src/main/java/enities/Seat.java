package enities;

public class Seat {
	private int seatId;
	private int showtimeId;
	private String seatNumber;
	private SeatStatus seatStatus;
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int seatId) {
		super();
		this.seatId = seatId;
	}


	public Seat(int seatId, int showtimeId, String seatNumber, SeatStatus seatStatus) {
		super();
		this.seatId = seatId;
		this.showtimeId = showtimeId;
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", showtimeId=" + showtimeId + ", seatNumber=" + seatNumber + ", seatStatus="
				+ seatStatus + "]";
	}	
}
