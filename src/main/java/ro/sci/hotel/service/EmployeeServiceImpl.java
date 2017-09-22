package ro.sci.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.hotel.model.employee.Address;
import ro.sci.hotel.model.employee.Employee;
import ro.sci.hotel.repository.EmployeeRepository;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService<Employee>{


    private EmployeeRepository<Employee> employeeRepository;

    private AddressService<Address> addressService;

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = this.employeeRepository.getAll();

        for (Employee employee : employees) {

            Address address = addressService.searchByEmployeeId(employee.getEmployeeId());
            employee.setAddress(address);
        }
        return employees;
    }

    @Override
    public void create(Employee employee) {
        this.employeeRepository.create(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.employeeRepository.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        this.employeeRepository.update(employee);
    }

    @Override
    public Employee searchByEmployeeId(Integer employeeId) {
        return this.employeeRepository.searchByEmployeeId(employeeId);
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return this.employeeRepository.searchByFirstName(firstName);
    }

    @Override
    public void setEmployeeRepository(EmployeeRepository<Employee> employeeRepository) {
        this.employeeRepository =employeeRepository;
    }
}
