package com.vsgcode.todoapp5.model

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromPriority(priority : Priority) : String{
        return priority.name;
    }

    @TypeConverter
    fun toPriority(value : String) : Priority{
        return Priority.valueOf(value);
    }
}