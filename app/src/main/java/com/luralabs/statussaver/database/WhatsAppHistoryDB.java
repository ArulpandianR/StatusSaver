package com.luralabs.statussaver.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.luralabs.statussaver.database.model.WhatsAppHistory;
import com.luralabs.statussaver.database.model.WhatsAppHistoryMessages;
import com.luralabs.statussaver.util.WhatsAppSaverConstants;


@Database(entities = {WhatsAppHistory.class, WhatsAppHistoryMessages.class}, version = 1, exportSchema = false)
public abstract class WhatsAppHistoryDB extends RoomDatabase {

    private static WhatsAppHistoryDB whatsAppHistoryDB;

    public static WhatsAppHistoryDB getInstance(Context context) {
        if (null == whatsAppHistoryDB) {
            whatsAppHistoryDB = buildDatabaseInstance(context);
        }
        return whatsAppHistoryDB;
    }

    private static WhatsAppHistoryDB buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                WhatsAppHistoryDB.class,
                WhatsAppSaverConstants.DB_NAME)
                .allowMainThreadQueries().build();
    }

    public abstract WhatsAppDBHistoryDao getHistoryDao();

    public abstract WhatsAppDBHistoryMessageDao getMessageDao();

}