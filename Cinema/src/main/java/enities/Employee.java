package enities;

public class Employee {
	private int employeeId;
	private String name;
	private EmployeeType employeeType;
	private String birthDate;
	private String phone;
	private String email;

	public Employee() {
		
	}
	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}


	public Employee(int employeeId, String name, EmployeeType employeeType, String birthDate, String phone,
			String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.employeeType = employeeType;
		this.birthDate = birthDate;
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
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", employeeType=" + employeeType
				+ ", birthDate=" + birthDate + ", phone=" + phone + ", email=" + email + "]";
	}
}
