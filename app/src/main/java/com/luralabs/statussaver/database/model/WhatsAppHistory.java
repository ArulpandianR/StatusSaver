package com.luralabs.statussaver.database.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WhatsAppHistory {

    @PrimaryKey(autoGenerate = true)
    private int note_id;
    @ColumnInfo(name = "mobile_no")
    private String mobileNo;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "updated_date")
    private String updateDate;

    public WhatsAppHistory(String name, String mobileNo, String updateDate) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.updateDate = updateDate;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
