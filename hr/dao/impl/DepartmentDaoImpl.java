package hr.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import hr.dao.BaseDto;
import hr.dao.exception.DaoException;

import hr.dao.DepartmentDao;
import hr.dao.DepartmentDto;

public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {
	String _tableName = "department";
	String _primaryKey = "department_id";
	Properties _deptQueries = null;
	
	public DepartmentDaoImpl() {
		super();
		
		_deptQueries = new Properties();
		try {
			_deptQueries.load(this.getClass().getClassLoader().getResourceAsStream("hr/sql/sql.properties"));
			//String query = _empQueries.getProperty("DEPT_UPDATE");
			//System.out.println("Update query: \n" + query);
		}
		catch (IOException io) {
			System.out.println("Exception during sql.properties load: " + io);
		}
	}
	
	public DepartmentDto get(Integer id) throws DaoException {
		return (DepartmentDto) super.get(id);
	}
	
	public DepartmentDto getRow(String field, Object value) throws DaoException {
		return (DepartmentDto) super.getRow(field, value);
	}
	
	
	/**
	 * save
	 * 
	 * Convert the DTO into a SQL row and INSERT into the table
	 *   
	 * @param EmployeeDto t - DTO that contains the values for the new row  
	 */
    public void save(DepartmentDto t) throws DaoException {
    	// write to DB
    	
    	return;
    }
    
	/**
	 * update
	 * 
	 * Update the corresponding row in the database for the DTO with the 
	 * values in params
	 *   
	 * @param EmployeeDto t - pull the primary key out of t
	 * @param String[] params - values to update the row 
	 * 	 
	 */
    public void update(DepartmentDto t, String[] params) throws DaoException {
    	// update DB
    	
    	return;
    }
    
	/**
	 * delete
	 * 
	 * Delete the corresponding row in the database for the DTO
	 *   
	 * @param EmployeeDto t - pull the primary key out of t
	 * 	 
	 */
    public void delete(DepartmentDto t) throws DaoException {
    	// delete from DB
    	
    	return;
    }
    
    /**
     * convertRStoDto
     * 
     * Utility method that copies the values in the ResultSet into the DTO.
     * Needed specific implementation for the method getMultipleRows in the
     * BaseDaoImpl.
     * 
     * @param ResultSet result - the source values from a query to the DB
     * @param BaseDto dto - the destination Data Transfer Object
     */
    void convertRStoDto(ResultSet result, BaseDto dto) throws DaoException {
    	DepartmentDto dept = (DepartmentDto) dto;
    	try {
    		dept.setDepartmentId(result.getInt(1));
    		dept.setDeptName(result.getString(2));
    		dept.setDeptStreetAddress(result.getString(3));
    		dept.setDeptCity(result.getString(4));
    		dept.setDeptState(result.getString(5));
    		dept.setDeptCountry(result.getString(6));
    		dept.setManagerId(result.getInt(7));
    	}
    	catch (SQLException se) {
    		throw new DaoException(se.getMessage());
    	}
    }
    
    /**
     * getAllRowsQuery
     * 
     * Returns the query for retrieving all rows for this table
     * 
     * @return String - equivalent to "select * from tableName"
     */
    String getAllRowsQuery() {
		return _deptQueries.getProperty("DEPT_GET_ALL");
    }
    
    /**
     * getInsertQuery
     * 
     * Returns the INSERT query for this table
     * 
     * @return String - INSERT query
     */
    String getInsertQuery() {
		return _deptQueries.getProperty("DEPT_INSERT");
    }
    
    /**
     * getDeleteQuery
     * 
     * Returns the DELETE query for this table
     * 
     * @return String - DELETE query
     */
    String getDeleteQuery() {
		return _deptQueries.getProperty("DEPT_DELETE_ID");
    }
    
    /**
     * getUpdateQuery
     * 
     * Returns the UPDATE query for this table
     * 
     * @return String - UPDATE query
     */
    String getUpdateQuery() {
		return _deptQueries.getProperty("DEPT_UPDATE_ID");
    }
    
    /**
     * getPrimaryKey
     * 
     * Returns the Primary Key for this table
     * 
     * @return String - Primary Key 
     */
    String getPrimaryKey() {
		return _primaryKey;
    }
   
    
    /**
     * getDto
     * 
     * Returns the appropriate Data Transfer Object for this Data Access Object.
     * 
     * @return appropriate DTO
     */
    BaseDto getDto() {
    	return new DepartmentDto();
    }
}
