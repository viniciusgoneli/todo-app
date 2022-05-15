package com.vsgcode.todoapp5.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vsgcode.todoapp5.data.model.Task

@Dao
interface TaskDAO {

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getAllTasks() : LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task : Task)

    @Update
    suspend fun updateTask(task : Task)

    @Delete
    suspend fun deleteTask(task : Task)
}