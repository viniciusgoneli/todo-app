package com.vsgcode.todoapp5.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(@PrimaryKey(autoGenerate = true)
                var id: Int,
                var title : String,
                var priority: Priority,
                var description : String )
