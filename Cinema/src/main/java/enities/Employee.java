package enities;

public class Employee {
	private static int employeeId;
	private static String name;
	private static EmployeeType employeeType;
	private static String birthDate;
	private static String phone;
	private static String email;

	public Employee() {
		
	}
	public Employee(int employeeId) {
		super();
		Employee.employeeId = employeeId;
	}


	public Employee(int employeeId, String name, EmployeeType employeeType, String birthDate, String phone,
			String email) {
		super();
		Employee.employeeId = employeeId;
		Employee.name = name;
		Employee.employeeType = employeeType;
		Employee.birthDate = birthDate;
		Employee.phone = phone;
		Employee.email = email;
	}
	public static int getEmployeeId() {
		return employeeId;
	}
	public static void setEmployeeId(int employeeId) {
		Employee.employeeId = employeeId;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Employee.name = name;
	}
	public static EmployeeType getEmployeeType() {
		return employeeType;
	}
	public static void setEmployeeType(EmployeeType employeeType) {
		Employee.employeeType = employeeType;
	}
	public static String getBirthDate() {
		return birthDate;
	}
	public static void setBirthDate(String birthDate) {
		Employee.birthDate = birthDate;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		Employee.phone = phone;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Employee.email = email;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", employeeType=" + employeeType
				+ ", birthDate=" + birthDate + ", phone=" + phone + ", email=" + email + "]";
	}
}
