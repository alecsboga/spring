package ro.sci.hotel.repository;

import org.springframework.stereotype.Repository;
import ro.sci.hotel.model.employee.Employee;
import ro.sci.hotel.model.util.Currency;
import ro.sci.hotel.model.util.Price;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.UIManager.getInt;

/**
 * Created by tudorradovici on 17/09/17.
 */
@Repository("employeeRepository")
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository<Employee> {

    private static final Logger LOGGER = Logger.getLogger("Employee");

    private static final String DATABASE_ERROR = "Database error!";

    private static final String EXCEPTION_THROWN = "Exception thrown";

    private static final String WRITING_DB_FINISHED="Writing in db has finished!";

    private static final String Employee_DELETED="Deletion of employee by ID successful";

    private static final String ID = "id";

    private static final String FIRSTNAME = "first_name";

    private static final String LASTNAME = "last_name";

    private static final String EMAIL = "email";

    private static final String PHONENUMBER = "employee_phone_number";

    private static final String EMPLOYMENTDATE = "employment_date";

    private static final String EMPLOYEEROLE = "employee_role";

    private static final String PRICE = "price";

    private static final String CURRENCY = "currency";

    private static final String SQL_SELECT_ALL_FROM_EMPLOYEE = "SELECT" +
            "first_name" +
            "last_name" +
            "email" +
            "employee_phone_number" +
            "employee_date" +
            "salary" +
            "employee_role" +
            "FROM employee";
    private static final String SQL_INSERT_EMPLOYEE= "INSERT INTO employees " +
            "(first_name," +
            "last_name" +
            "email" +
            "employee_phone_number" +
            "employement_date" +
            "salary" +
            "employee_role)" +
            "VALUES (?,?,?,?,?,?,?)";

    private static final  String DELETE_EMPLOYEE="Delete from employees where id=(?)";

    private static final  String SQL_SEARCH_BY_ID ="SELECT" +
            "first_name" +
            "last_name" +
            "email" +
            "employee_phone_number" +
            "employee_date" +
            "salary" +
            "employee_role" +
            "FROM employee WHERE id=(?)";


    @Override
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();

        try (Connection conn = newConnection(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(SQL_SELECT_ALL_FROM_EMPLOYEE)) {

            while (rs.next()) {

                Employee employee = new Employee();
                employee.setId(rs.getInt(ID));
                employee.setFirstName(rs.getString(FIRSTNAME));
                employee.setLastName(rs.getString(LASTNAME));
                employee.setEmail(EMAIL);
                //employee.setEmployeeAddress();
                employee.setEmployeePhoneNumber(rs.getString(PHONENUMBER));
                employee.setEmploymentDate(rs.getDate(EMPLOYMENTDATE));
                employee.setSalary(new Price(rs.getDouble(PRICE), Currency.valueOf(rs.getString(CURRENCY))));
                employee.setEmployeeRole(rs.getString(EMPLOYEEROLE));

                employees.add(employee);

            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }
        return employees;
    }

    @Override
    public void create(Employee employee) {
        try(Connection conn = newConnection();
            PreparedStatement stm = conn.prepareStatement(SQL_INSERT_EMPLOYEE)){

            conn.setAutoCommit(false);

            stm.setString(1,employee.getFirstName());
            stm.setString(2,employee.getLastName());
            stm.setString(3,employee.getEmail());
            stm.setString(4,employee.getEmployeePhoneNumber());
            //stm.setDate(5,employee.getEmploymentDate());
            stm.setDouble(6, employee.getSalary().getValue());
            stm.setString(7,employee.getEmployeeRole());

            conn.commit();
            conn.setAutoCommit(true);
            stm.execute();

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }
        LOGGER.log(Level.INFO, WRITING_DB_FINISHED);
    }

    @Override
    public void delete(Employee employee) {
        try(Connection conn = newConnection();
        PreparedStatement stm=conn.prepareStatement(DELETE_EMPLOYEE)){

            stm.setInt(1,employee.getId());
            stm.execute();


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, DATABASE_ERROR);
            throw new RuntimeException(EXCEPTION_THROWN);
        }
        LOGGER.log(Level.INFO,Employee_DELETED);

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public List<Employee> searchByEmpoyeeId(Integer employeeId) {

        List<Employee> employees = new ArrayList<>();

        return employees;
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return null;
    }
}
