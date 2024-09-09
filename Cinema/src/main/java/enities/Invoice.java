package enities;

public class Invoice {
	private int invoiceId;
	private String customerName;
	private int customerId;
	private float totalAmount;
	private String purchaseTime;
	private int employeeId;
	private int ticketId;

	public Invoice() {

	}

	public Invoice(int invoiceId, String customerName, int customerId, float totalAmount, String purchaseTime,
			int employeeId, int ticketId) {
		super();
		this.invoiceId = invoiceId;
		this.customerName = customerName;
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		this.purchaseTime = purchaseTime;
		this.employeeId = employeeId;
		this.ticketId = ticketId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", customerName=" + customerName + ", customerId=" + customerId
				+ ", totalAmount=" + totalAmount + ", purchaseTime=" + purchaseTime + ", employeeId=" + employeeId
				+ ", ticketId=" + ticketId + "]";
	}

}
