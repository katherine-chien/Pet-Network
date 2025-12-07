package hr.dao;

import java.util.List;

import hr.dao.exception.DaoException;

public interface DepartmentDao {

	/**
	 * DepartmentDao
	 * 
	 * Interface for Data Access Object, DepartmentDao 
	 *   
	 * Modifications:
	 * 
	 * 		04/20/2024 - jhui - Created
	 */
    DepartmentDto get(Integer id) throws DaoException;
    
    DepartmentDto getRow(String field, Object value) throws DaoException;
    
    List<DepartmentDto> getRows(String field, Object value) throws DaoException;
    
    List<DepartmentDto> getAll() throws DaoException;
    
    void save(DepartmentDto t) throws DaoException;
    
    void update(DepartmentDto t, String[] params) throws DaoException;
    
    void delete(DepartmentDto t) throws DaoException;

}
