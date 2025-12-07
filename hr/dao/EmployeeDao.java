package hr.dao;

import java.util.List;

import hr.dao.exception.DaoException;

/**
 * EmployeeDao
 * 
 * Interface for Data Access Object, EmployeeDao 
 *   
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created
 */


public interface EmployeeDao {
    EmployeeDto get(Integer id) throws DaoException;
    
    EmployeeDto getRow(String field, Object value) throws DaoException;
    
    List<EmployeeDto> getRows(String field, Object value) throws DaoException;
    
    List<EmployeeDto> getAll() throws DaoException;
    
    void save(EmployeeDto t) throws DaoException;
    
    void update(EmployeeDto t, String[] params) throws DaoException;
    
    void delete(EmployeeDto t) throws DaoException;

}
