package enities;

public class Seat {
	private int seatId;
	private int showtimeId;
	private String seatNumber;
	private int seatTypeId;
	private String status;

	public Seat() {

	}

	public Seat(int seatId, int showtimeId, String seatNumber, int seatTypeId, String status) {
		super();
		this.seatId = seatId;
		this.showtimeId = showtimeId;
		this.seatNumber = seatNumber;
		this.seatTypeId = seatTypeId;
		this.status = status;
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

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", showtimeId=" + showtimeId + ", seatNumber=" + seatNumber + ", seatTypeId="
				+ seatTypeId + ", status=" + status + "]";
	}

}
