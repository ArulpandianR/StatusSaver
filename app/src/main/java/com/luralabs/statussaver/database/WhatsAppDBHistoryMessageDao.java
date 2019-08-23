package com.luralabs.statussaver.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.luralabs.statussaver.database.model.WhatsAppHistoryMessages;
import com.luralabs.statussaver.util.WhatsAppSaverConstants;

import java.util.List;

@Dao
public interface WhatsAppDBHistoryMessageDao {
    @Query("SELECT * FROM " + WhatsAppSaverConstants.TABLE_NAME_MESSAGE)
    List<WhatsAppHistoryMessages> getAll();

    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(WhatsAppHistoryMessages WhatsAppHistoryMessages);

    /*
     * update the object in database
     * @param WhatsAppHistory, object to be updated
     */
    @Update
    void update(WhatsAppHistoryMessages repos);

    /*
     * delete the object from database
     * @param WhatsAppHistory, object to be deleted
     */
    @Delete
    void delete(WhatsAppHistoryMessages whatsAppHistory);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(WhatsAppHistoryMessages... note);      // Note... is varargs, here note is an array

    @Query("SELECT * FROM WhatsAppHistoryMessages WHERE name = :names or mobile_no = :mobile")
    List<WhatsAppHistoryMessages> getMessageList(String names, String mobile);

}
