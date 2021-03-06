package ro.sci.hotel.service;

import java.util.Date;
import java.util.List;

import ro.sci.hotel.model.event.EventRoom;

/**
 * Interface for EventRoom Service used for repository manipulation
 * @param <T>
 */
public interface EventRoomService<T> {
    /**
     * read all the event Rooms from DB
     *
     * @return List<T> events list
     */

    List<T> getAll();

    /**
     *  @param eventRoom
     */
    void createEventRoom(EventRoom eventRoom);

    /**
     * delete an event entry from DB
     *
     * @param t Event to be deleted
     */
    void delete(T t);

    /**
     * update an event in the DB
     *
     * @param t Event to be updated
     */
    void update(T t);

    /**
     * search by event room name
     *
     * @return List<T> searched events List
     */
    List<T> searchByEventRoomName(String eventRoomName);

    /**
     * @return T searched event by Id *
     */
    T searchByEventRoomId(Integer eventRoomId);

    /**
     * search an event Room by date
     *
     * @param date search on a given date if the room is free or not
     * @return true or false
     */
    void searchedByDate(Date date);
}
