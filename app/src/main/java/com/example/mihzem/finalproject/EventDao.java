package com.example.mihzem.finalproject;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
//Persistence database, for the getFood class
// allows you to delete, add, update different ingredients to look up
// using the Download URL class as well

@Dao
public interface EventDao {

    @Query("SELECT * FROM " + Event.TABLE_NAME )
    List<Event> getEvents();

    @Insert
    void addEvent(Event event);

    @Delete
    void deleteEvent(Event event);

    @Update
    void updateEvent(Event event);

    @Query("DELETE FROM " + Event.TABLE_NAME)
    public void dropTheTable();

}
