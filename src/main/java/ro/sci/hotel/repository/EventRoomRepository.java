package ro.sci.hotel.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ro.sci.hotel.model.util.Price;

import java.util.Date;
import java.util.List;

public interface EventRoomRepository<T> {
    /**
     * read all the events from DB
     * @return List<T> events list
     */
    @Select("SELECT * FROM eventroom")
    List<T> getAll();

    /**
     * @param eventRoom
     * @param eventRoom
        */
    void createEvent(T eventRoom, Price price);

    /**
     *  delete an event entry from DB
     * @param t Event to be deleted
     */
    void delete(T t);

    /**
     * update an event in the DB
     * @param t Event to be updated
     */
    void update(T t);

    /**
     * search by event room name
     * @param eventRoomName
     * @return List<T> searched events List
     *     */
    List<T> searchByEventRoomName(String eventRoomName);

    /**
     * search an event Room by date
     * @param date search on a given date if the room is free or not
     * @return true or false
     */
    void searchedByDate(Date date);
    T searchByEventRoomId(Integer eventRoomId);
    /**
     * search an event Room by date
     * @param date search on a given date if the room is free or not
     * @return true or false
     */
}