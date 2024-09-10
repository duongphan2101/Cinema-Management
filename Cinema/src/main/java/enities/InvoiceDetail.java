package enities;

public class InvoiceDetail {
	private int invoiceId;
	private int ticketId;
	private int quantity;
	private float pricePerTicket;

	public InvoiceDetail() {

	}

	public InvoiceDetail(int invoiceId, int ticketId, int quantity, float pricePerTicket) {
		super();
		this.invoiceId = invoiceId;
		this.ticketId = ticketId;
		this.quantity = quantity;
		this.pricePerTicket = pricePerTicket;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPricePerTicket() {
		return pricePerTicket;
	}

	public void setPricePerTicket(float pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [invoiceId=" + invoiceId + ", ticketId=" + ticketId + ", quantity=" + quantity
				+ ", pricePerTicket=" + pricePerTicket + "]";
	}

	

}
