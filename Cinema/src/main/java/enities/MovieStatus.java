package enities;

public class MovieStatus {
	private int statusId;
	private String status;
	
	public MovieStatus(int statusId) {
		super();
		this.statusId = statusId;
	}
	public MovieStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MovieStatus [statusId=" + statusId + ", status=" + status + "]";
	}	

}
