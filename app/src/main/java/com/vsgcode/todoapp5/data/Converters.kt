package com.vsgcode.todoapp5.data

import androidx.room.TypeConverter
import com.vsgcode.todoapp5.data.model.Priority

class Converters {

    @TypeConverter
    fun fromPriority(priority : Priority) : String{
        return priority.name;
    }

    @TypeConverter
    fun toPriority(value : String) : Priority {
        return Priority.valueOf(value);
    }
}