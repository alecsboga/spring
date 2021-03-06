package ro.sci.hotel.service;

import java.util.List;

import ro.sci.hotel.model.employee.Address;
import ro.sci.hotel.repository.AddressRepository;

public interface AddressService<T> {

    /**
     * @return List of all addresses
     */
    List<T> getAll();

    /**
     * Creates a new address
     */
    void create(Address address);

    /**
     * Deletes an address
     */
    void delete(T t);

    /**
     * Update the information of an address
     */
    void update(T t);

    /**
     * Searches for an address of an employee
     *
     * @return address of an employee
     */
    T searchByEmployeeId(Integer EmployeeId);

    void setAddressRepository(AddressRepository<Address> addressRepository);
}
