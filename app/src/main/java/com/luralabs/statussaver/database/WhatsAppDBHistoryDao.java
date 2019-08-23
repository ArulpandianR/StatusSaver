package com.luralabs.statussaver.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.luralabs.statussaver.database.model.WhatsAppHistory;
import com.luralabs.statussaver.util.WhatsAppSaverConstants;

import java.util.List;

@Dao
public interface WhatsAppDBHistoryDao {
    @Query("SELECT * FROM " + WhatsAppSaverConstants.TABLE_NAME_HISTORY)
    List<WhatsAppHistory> getAll();

    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(WhatsAppHistory whatsAppHistory);

    /*
     * update the object in database
     * @param WhatsAppHistory, object to be updated
     */
    @Update
    void update(WhatsAppHistory repos);

    /*
     * delete the object from database
     * @param WhatsAppHistory, object to be deleted
     */
    @Delete
    void delete(WhatsAppHistory whatsAppHistory);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(WhatsAppHistory... note);      // Note... is varargs, here note is an array

    @Query("SELECT * FROM WhatsAppHistory WHERE name = :names or mobile_no = :mobile LIMIT 1")
    List<WhatsAppHistory> getMobileHistory(String names, String mobile);

}
