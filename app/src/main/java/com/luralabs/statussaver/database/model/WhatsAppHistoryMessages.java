package com.luralabs.statussaver.database.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

@Entity
public class WhatsAppHistoryMessages {

    @PrimaryKey(autoGenerate = true)
    private int historyId;
    @ColumnInfo(name = "mobile_no")
    private String mobileNo;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "message")
    private String message;
    @ColumnInfo(name = "message_created")
    private String messageCreatedTime;

    public WhatsAppHistoryMessages(String name, String mobileNo, String message, String messageCreatedTime) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.message = message;
        this.messageCreatedTime = messageCreatedTime;
    }

    public int getNote_id() {
        return historyId;
    }

    public void setNote_id(int note_id) {
        this.historyId = note_id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCreatedTime() {
        return messageCreatedTime;
    }

    public void setMessageCreatedTime(String messageCreatedTime) {
        this.messageCreatedTime = messageCreatedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }
}
