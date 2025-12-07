/**
 * HR SQL Queries
 *
 * This file contains all of the queries used in the HR system
 *
 * Modifications:
 *
 *		04/20/2024 - jhui - Created.
 */
 
 
/**
 * Employee SQL Queries
 *
 * This section contains all of the queries used for the Employee table
 *
 * Modifications:
 *
 *		04/20/2024 - jhui - Created.
 */
 
 EMP_GET_ALL = SELECT employee_id, lname, fname, email, street_address, city, state, country, department_id FROM Employee
 EMP_GET_ID = SELECT employee_id, lname, fname, email, street_address, city, state, country, department_id \
              FROM Employee \
              WHERE employee_id = ?
 
 EMP_INSERT = INSERT INTO Employee VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)
 EMP_DELETE_ID = DELETE FROM Employee WHERE employee_id = ?
 EMP_UPDATE_ID = UPDATE Employee SET lname = ?, fname = ?, email = ?, street_address = ?, \
                        city = ?, state = ?, country = ?, department_id = ? \
                 WHERE employee_id = ?
              
/**
 * Department SQL Queries
 *
 * This section contains all of the queries used for the Department table
 *
 * Modifications:
 *
 *		04/20/2024 - jhui - Created.
 */
 
 DEPT_GET_ALL = SELECT department_id, dept_name, dept_street_address, dept_city, dept_state, dept_country, manager_id FROM department
 DEPT_GET_ID = SELECT department_id, dept_name, dept_street_address, dept_city, dept_state, dept_country, manager_id \
               FROM department \
               WHERE department_id = ?
 
 DEPT_INSERT = INSERT INTO department VALUES (null, ?, ?, ?, ?, ?, ?, ?)
 DEPT_DELETE_ID = DELETE FROM department WHERE department_id = ?
 DEPT_UPDATE_ID = UPDATE department SET dept_name = ?, dept_street_address = ?, dept_city = ?, dept_state = ?, dept_country = ?, manager_id = ? \
                  WHERE department_id = ?
              


 
/**
 * User SQL Queries 
 *
 * Queries for the User table in the Pet Network project.
 *
 * Modifications:
 *      Added for Milestone 4
 */

USER_GET_ALL = SELECT user_id, role, password_hash, email, username, created_at FROM User
USER_GET_ID = SELECT user_id, role, password_hash, email, username, created_at \
              FROM User \
              WHERE user_id = ?

USER_INSERT = INSERT INTO User (role, password_hash, email, username, created_at) \
              VALUES (?, ?, ?, ?, ?)

USER_UPDATE_ID = UPDATE User SET role = ?, password_hash = ?, email = ?, username = ? \
                 WHERE user_id = ?

USER_DELETE_ID = DELETE FROM User WHERE user_id = ?


/**
 * Pet SQL Queries
 *
 * Queries for the Pet table in the Pet Network project
 *
 *
 * Modifications:
 *     Added for Milestone 4
 */

PET_GET_ALL = SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info FROM Pet
PET_GET_ID = SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info \
             FROM Pet \  
             WHERE pet_id = ?

PET_INSERT = INSERT INTO Pet (owner_user_id, name, species, breed, birthdate, vaccination_info) \
             VALUES (?, ?, ?, ?, ?, ?)

PET_UPDATE_ID = UPDATE Pet SET owner_user_id = ?, name = ?, species = ?, breed = ?, \
                birthdate = ?, vaccination_info = ? \
                WHERE pet_id = ?

PET_DELETE_ID = DELETE FROM Pet WHERE pet_id = ? 


/**
 * Appointment SQL Queries
 *
 * Queries for the Appointment table in the Pet Network project.
 *
 * Modifications:
 *      Added for Milestone 4
 */

APPT_GET_ALL = SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes FROM Appointment

APPT_GET_ID = SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes \
              FROM Appointment \
              WHERE appointment_id = ? 


APPT_INSERT = INSERT INTO Appointment (vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes) \
              VALUES (?, ?, ?, ?, ?, ?, ?)

APPT_UPDATE_ID = UPDATE Appointment SET vet_id = ?, pet_id = ?, created_by_user_id = ?, \
                 start_time = ?, end_time = ?, status = ?, notes = ? \
                 WHERE appointment_id = ?

APPT_DELETE_ID = DELETE FROM Appointment WHERE appointment_id = ?




