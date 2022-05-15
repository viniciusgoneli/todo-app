package com.vsgcode.todoapp5.data.repository

import androidx.lifecycle.LiveData
import com.vsgcode.todoapp5.data.TaskDAO
import com.vsgcode.todoapp5.data.model.Task

class TaskRepository(private val taskDao : TaskDAO) {

    fun getAllTasks() : LiveData<List<Task>> = taskDao.getAllTasks();

    suspend fun insertTask(task : Task){
        taskDao.insertTask(task);
    }

    suspend fun updateTask(task : Task){
        taskDao.updateTask(task);
    }

    suspend fun deleteTask(task : Task){
        taskDao.deleteTask(task);
    }
}