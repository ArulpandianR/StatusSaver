package com.luralabs.statussaver.database.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ListTypeConverters {

    /*@TypeConverter
    public static List<WhatsAppHistoryInfo> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<WhatsAppHistoryInfo>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<WhatsAppHistoryInfo> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }*/
}
