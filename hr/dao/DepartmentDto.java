package hr.dao;

public class DepartmentDto extends BaseDto {
	int departmentId;
	String deptName;
	String deptStreetAddress;
	String deptCity;
	String deptState;
	String deptCountry;
	int managerId;
	
	public DepartmentDto() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int deptId) {
		this.departmentId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String name) {
		this.deptName = name;
	}

	public String getDeptStreetAddress() {
		return deptStreetAddress;
	}

	public void setDeptStreetAddress(String address) {
		this.deptStreetAddress = address;
	}

	public String getDeptCity() {
		return deptCity;
	}

	public void setDeptCity(String city) {
		this.deptCity = city;
	}

	public String getDeptState() {
		return deptState;
	}

	public void setDeptState(String state) {
		this.deptState = state;
	}

	public String getDeptCountry() {
		return deptCountry;
	}

	public void setDeptCountry(String country) {
		this.deptCountry = country;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int id) {
		this.managerId = id;
	}
	
}
