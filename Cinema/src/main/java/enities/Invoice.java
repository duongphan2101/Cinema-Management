package enities;

public class Invoice {
	private int invoiceId;
	private String customerName;
	private Customer customer;
	private float totalAmount;
	private String purchaseTime;
	private int employeeId;
	private int ticketId;

	public Invoice() {

	}

	public Invoice(int invoiceId, String customerName, Customer customer, float totalAmount, String purchaseTime,
			int employeeId, int ticketId) {
		super();
		this.invoiceId = invoiceId;
		this.customerName = customerName;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.purchaseTime = purchaseTime;
		this.employeeId = employeeId;
		this.ticketId = ticketId;
	}

	public Invoice(int invoiceId) {
		super();
		this.invoiceId = invoiceId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "Invoice [invoiceId=" + invoiceId + ", customerName=" + customerName + ", customer=" + customer
				+ ", totalAmount=" + totalAmount + ", purchaseTime=" + purchaseTime + ", employeeId=" + employeeId
				+ ", ticketId=" + ticketId + "]";
	}
}
