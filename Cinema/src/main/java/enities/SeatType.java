package enities;

public class SeatType {
	private int seatTypeId;
	private String typeName;
	private float price;

	public SeatType() {

	}

	public SeatType(int seatTypeId, String typeName, float price) {
		super();
		this.seatTypeId = seatTypeId;
		this.typeName = typeName;
		this.price = price;
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SeatType [seatTypeId=" + seatTypeId + ", typeName=" + typeName + ", price=" + price + "]";
	}

}
