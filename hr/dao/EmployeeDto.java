package hr.dao;

/**
 * EmployeeDto
 * 
 * Data Transfer Object for Employee 
 *   
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created
 */
public class EmployeeDto extends BaseDto {
	int employeeId;
	String lastName;
	String firstName;
	String email;
	String streetAddress;
	String city;
	String state;
	String country;
	int departmentId;

	public EmployeeDto() {
		super();
	}
	
	public void setEmployeeId(int id) {
		employeeId = id;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setEmail(String addr) {
		email = addr;
	}
	
	public String getEmail() {
		return email;
	}

	public void setStreetAddress(String addr) {
		streetAddress = addr;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setCity(String name) {
		city = name;
	}
	
	public String getCity() {
		return city;
	}

	public void setState(String name) {
		state = name;
	}
	
	public String getState() {
		return state;
	}

	public void setCountry(String name) {
		country = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setDepartmentId(int id) {
		departmentId = id;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
}
