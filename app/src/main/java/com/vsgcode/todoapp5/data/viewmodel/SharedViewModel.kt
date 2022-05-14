package com.vsgcode.todoapp5.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.vsgcode.todoapp5.data.model.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    fun parsePriority(priority : String) : Priority {
        return when(priority){
            "High Priority" -> Priority.HIGH
            "Medium Priority" -> Priority.MEDIUM
            "Low Priority" -> Priority.LOW
            else -> Priority.LOW
        }
    }
}