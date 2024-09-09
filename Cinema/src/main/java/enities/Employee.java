package enities;

public class Employee {
	private int employeeId;
	private String name;
	private int typeId;
	private String hireDate;
	private String phone;
	private String email;

	public Employee() {
		
	}

	public Employee(int employeeId, String name, int typeId, String hireDate, String phone, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.typeId = typeId;
		this.hireDate = hireDate;
		this.phone = phone;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", typeId=" + typeId + ", hireDate=" + hireDate
				+ ", phone=" + phone + ", email=" + email + "]";
	}

}
