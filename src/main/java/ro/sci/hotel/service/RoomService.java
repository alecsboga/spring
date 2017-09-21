package ro.sci.hotel.service;

import ro.sci.hotel.model.room.BedType;
import ro.sci.hotel.model.room.Room;
import ro.sci.hotel.model.room.RoomType;
import ro.sci.hotel.repository.RoomRepository;

import java.sql.Date;
import java.util.List;

/**
 * Room service interface for repository manipulation
 */
public interface RoomService<T> {

    /**
     * Get all rooms from DB
     *
     * @return List<T> Room list
     */
    List<T> getAll();

    /**
     * Create a room
     *
     * @param t new room
     */
    void create(T t);

    /**
     * Detele a room entry from db
     *
     * @param t room to be deleted
     */
    void delete(T t);

    /**
     * Update a room entry in db
     *
     * @param t room to pe updated
     */
    void update(T t);

    /**
     * Search room by room number
     * @param roomNumber searched
     * @return List<T> searched room list
     */
    List<T> searchByRoomNumber(Integer roomNumber);

    /**
     * Search room by price
     * @param price seached
     * @return List<T> searched room list
     */
    List<T> searchByPrice(Double price);

    /**
     * Search room by type
     * @param roomType seached
     * @return List<T> searched room list
     */
    List<T> searchByType(RoomType roomType);

    void setRoomRepository(RoomRepository<T> roomRepository);
}
