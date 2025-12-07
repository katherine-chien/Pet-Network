package test;

import java.util.List;

import hr.dao.EmployeeDao;
import hr.dao.EmployeeDto;
import hr.dao.impl.EmployeeDaoImpl;

/** 
 * Employee
 * 
 * Test class to access for Employee.
 * 
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created.
 */

public class Employee {

	public Employee() {
		
	}

	public static void main(String[] args) {
		System.out.println("Entering test.Employee.main");
		
		EmployeeDao emplDao = new EmployeeDaoImpl();
		EmployeeDto emplDto = null;
		List<EmployeeDto> empls = null;
		
		try {
			int test = 4;
			switch(test) {
				case 1: 
					emplDto = emplDao.get(Integer.valueOf(1));
					System.out.println("Returned Employee(1):" + emplDto.toJson());
					break;
					
				case 2:
					emplDto = emplDao.getRow("lname", "Doe");
					System.out.println("Returned Employee(1):" + emplDto.toJson());
					break;
					
				case 3:
					empls = emplDao.getRows("state", "CA");
					for (int i = 0; i < empls.size(); i++) {
						emplDto = empls.get(i);
						System.out.println("\nReturned Employee(" + emplDto.getEmployeeId() + "):" + emplDto.toJson());
					}
					break;
				
				default:
					empls = emplDao.getAll();
					for (int i = 0; i < empls.size(); i++) {
						emplDto = empls.get(i);
						System.out.println("\nReturned Employee(" + emplDto.getEmployeeId() + "):" + emplDto.toJson());
					}
			}			
		}
		catch (Throwable th) {
			System.out.println(th.getMessage());
		}

	}

}
