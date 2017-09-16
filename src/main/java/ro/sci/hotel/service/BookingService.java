package ro.sci.hotel.service;

import java.sql.Date;
import java.util.List;

/**
 * Service interface for Booking Repository manipulation
 */
public interface BookingService<T> {

    /**
     * Read all booking from repository
     *
     * @return List<T> Booking lists
     */
    List<T> getAll();

    /**
     * Create a new booking and set startDAte and endDate in desired room
     * @param customerId Id of customer from db
     * @param startDate Arrival date
     * @param endDate Departure date
     * @param roomNumber Room number from db
     */
    void create(Integer customerId, Date startDate, Date endDate, Integer roomNumber);

    /**
     * Detele a booking entry from repository
     *
     * @param t Booking to be deleted
     */
    void delete(T t);

    /**
     * Update a booking entry in repository
     *
     * @param t Booking to pe updated
     */
    void update(T t);

    /**
     * Search bookings by customer id
     * @param customerId searched
     * @return List<T> searched bookings list
     */
    List<T> searchByCustomerId(Integer customerId);

    /**
     * Search bookings by room number
     * @param roomNumber searched
     * @return List<T> searched bookings list
     */
    List<T> searchByRoomNumber(Integer roomNumber);

    /**
     * Search booking by interval
     * @param startDate date of arrival
     * @param endDate date of departure
     * @return List<T> searched bookings list
     */
    List<T> searchByDate(Date startDate, Date endDate);

    /**
     * Search bookings by price
     * @param price seached
     * @return List<T> searched bookings list
     */
    List<T> searchByPrice(Double price);

    /**
     * Search bookings by event id
     * @param eventId searched
     * @return List<T> searched bookings list
     */
    List<T> searchByEvent(Integer eventId);

    /**
     * Search bookings by customer id and room number
     * @param customerId searched
     * @param roomNumber searched
     * @return List<T> searched bookings list
     */
    List<T> searchByCustomerIdAndRoomNumber(Integer customerId, Integer roomNumber);
}
