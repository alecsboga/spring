package ro.sci.hotel.repository;

import java.util.List;

import ro.sci.hotel.model.employee.Employee;
import ro.sci.hotel.model.employee.Login;

/**
 * Employee repository DAO
 */
public interface EmployeeRepository<T> {
    /**
     * @return List of all employees.
     */
    List<T> getAll();

    /**
     * Creates a new employee
     *
     * @param employee Employee will be added to the DB.
     */
    void create(Employee employee);

    /**
     * Deletes an employee
     *
     * @param t Employee will be deleted from the DB.
     */
    void delete(T t);

    /**
     * Updates the information a
     */
    void update(T t);

    /**
     * Search by ID
     *
     * @return employee with a certain ID
     */
    T searchByEmployeeId(Integer employeeId);

    /**
     * Searches the DB by firstName;
     * @param firstName
     * @return list of employee with a certain firstName;
     */

    /**
     * Validates if a user exists
     */
    T validateEmployee(Login login);

    List<T> searchByFirstName(String firstName);

}
