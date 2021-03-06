package ro.sci.hotel.service;

import java.sql.Date;
import java.util.List;

import ro.sci.hotel.model.booking.Booking;
import ro.sci.hotel.model.customer.Customer;
import ro.sci.hotel.model.room.Room;

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
     *
     * @param booking to be added in db
     */
    void create(Booking booking, Room room, Customer customer);

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
     *
     * @param customerId searched
     * @return List<T> searched bookings list
     */
    List<T> searchByCustomerId(Integer customerId);

    /**
     * Search bookings by room number
     *
     * @param roomNumber searched
     * @return List<T> searched bookings list
     */
    List<T> searchByRoomNumber(Integer roomNumber);

    /**
     * Search booking by interval
     *
     * @param startDate date of arrival
     * @param endDate   date of departure
     * @return List<T> searched bookings list
     */
    List<T> searchByDate(Date startDate, Date endDate);

    /**
     * Search bookings by price
     *
     * @param price seached
     * @return List<T> searched bookings list
     */
    List<T> searchByPrice(Double price);

    /**
     * Search available rooms with given interval
     *
     * @param startDate Booking start date
     * @param endDate   Booking end date
     * @return A List of available rooms
     */
    List<Room> searchAvailableRoomsByDate(Date startDate, Date endDate);

    /**
     * Search by booking id
     *
     * @param bookingId id
     */
    T searchById(Integer bookingId);
}
