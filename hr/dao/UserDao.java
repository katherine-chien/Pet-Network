package hr.dao;

import java.util.List;

public interface UserDao {
    //fo the single user by primary key
    UserDto get(int userId);


    
    // Single row by a WHERE clause
    //  "email='x@x.com'"
    UserDto getRow(String whereClause);

    // multiple rows by WHERE clause
    List<UserDto> getRows(String whereClause);

    // Get all rows
    List<UserDto> getAll();

    // Insert a new user, returns generated id or affected rows per your BaseDao convention
    int save(UserDto user);         


    // Update existing user, returns rows affected
    int update(UserDto user); 

    // delete by PK
    int delete(int userId); 

}
