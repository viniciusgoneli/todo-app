package com.vsgcode.todoapp5.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vsgcode.todoapp5.data.TaskDatabase
import com.vsgcode.todoapp5.data.model.Task
import com.vsgcode.todoapp5.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskDao = TaskDatabase.getDatabase(application).taskDao();

    private val repository = TaskRepository(taskDao);
    private val getAllData : LiveData<List<Task>> = taskDao.getAllTasks();

    fun insertTask(task : Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTask(task);
        }
    }

}