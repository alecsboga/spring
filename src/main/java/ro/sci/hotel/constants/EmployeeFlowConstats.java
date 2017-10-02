package ro.sci.hotel.constants;

import java.util.logging.Logger;

public final class EmployeeFlowConstats {


private EmployeeFlowConstats (){ }

    public static final String DATABASE_ERROR = "Database error!";

    public static final String EXCEPTION_THROWN = "Exception thrown";

    public static final String WRITING_DB_FINISHED="Writing in db has finished!";

    public static final String Employee_DELETED="Deletion of employee by ID successful";

    public static final String ID = "employee_id";

    public static final String FIRSTNAME = "first_name";

    public static final String LASTNAME = "last_name";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String PHONENUMBER = "employee_phone_number";

    public static final String EMPLOYMENTDATE = "employment_date";

    public static final String EMPLOYEEROLE = "employee_role";

    public static final String PRICE = "price";

    public static final String CURRENCY = "currency";

    public static final String SQL_SELECT_ALL_FROM_EMPLOYEE = "SELECT employee_id, first_name, last_name, email, employee_phone_number, employment_date, price, employee_role FROM employee";
    public static final String SQL_INSERT_EMPLOYEE= "INSERT INTO employees " +
            "(first_name," +
            "last_name" +
            "email" +
            "employee_phone_number" +
            "employement_date" +
            "salary" +
            "employee_role)" +
            "VALUES (?,?,?,?,?,?,?)";

    public static final  String DELETE_EMPLOYEE="Delete from employees where id=(?)";

    public static final  String  SQL_SELECT_USERNAME_PASSWORD="SELECT * FROM employee where username=? AND password=?";

    public static final  String SQL_SEARCH_BY_ID ="SELECT" +
            "first_name" +
            "last_name" +
            "email" +
            "employee_phone_number" +
            "employee_date" +
            "salary" +
            "employee_role" +
            "FROM employee WHERE id=(?)";
}
