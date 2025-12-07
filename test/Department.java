package test;

import java.util.List;

import hr.dao.DepartmentDao;
import hr.dao.DepartmentDto;
import hr.dao.impl.DepartmentDaoImpl;

/**
 * Department
 * 
 * Test class to access for Department.
 * 
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created.
 */

public class Department {

	public Department() {
		
	}

	public static void main(String[] args) {
		System.out.println("Entering test.Department.main");
		
		DepartmentDao deptDao = new DepartmentDaoImpl();
		DepartmentDto deptDto = null;
		List<DepartmentDto> depts = null;
		
		try {
			int test = 4;
			switch(test) {
				case 1: 
					deptDto = deptDao.get(Integer.valueOf(101));
					System.out.println("Returned Department(1):" + deptDto.toJson());
					break;
					
				case 2:
					deptDto = deptDao.getRow("dept_name", "Sales");
					System.out.println("Returned Department(1):" + deptDto.toJson());
					break;
					
				case 3:
					depts = deptDao.getRows("dept_city", "SJ");
					for (int i = 0; i < depts.size(); i++) {
						deptDto = depts.get(i);
						System.out.println("\nReturned Department(" + deptDto.getDepartmentId() + "):" + deptDto.toJson());
					}
					break;
				
				default:
					depts = deptDao.getAll();
					for (int i = 0; i < depts.size(); i++) {
						deptDto = depts.get(i);
						System.out.println("\nReturned Department(" + deptDto.getDepartmentId() + "):" + deptDto.toJson());
					}
			}			
		}
		catch (Throwable th) {
			System.out.println(th.getMessage());
		}
	}
}
