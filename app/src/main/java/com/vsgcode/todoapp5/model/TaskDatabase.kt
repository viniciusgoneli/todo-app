package com.vsgcode.todoapp5.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDAO

    companion object {
        @Volatile
        var INSTANCE : TaskDatabase? = null;

        fun getDatabase(context : Context): TaskDatabase {
            val tempInstance = INSTANCE;
            if(tempInstance != null){
                return tempInstance;
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    TaskDatabase::class.java,
                    "task_db").build();
                INSTANCE = instance;
                return instance;
            }
        }
    }
}