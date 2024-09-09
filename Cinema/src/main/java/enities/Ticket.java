package enities;

public class Ticket {
	private int ticketId;
	private int showtimeId;
	private String seatNumber;
	private float price;
	private String purchaseTime;

	public Ticket() {

	}

	public Ticket(int ticketId, int showtimeId, String seatNumber, float price, String purchaseTime) {
		super();
		this.ticketId = ticketId;
		this.showtimeId = showtimeId;
		this.seatNumber = seatNumber;
		this.price = price;
		this.purchaseTime = purchaseTime;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", showtimeId=" + showtimeId + ", seatNumber=" + seatNumber + ", price="
				+ price + ", purchaseTime=" + purchaseTime + "]";
	}

}
