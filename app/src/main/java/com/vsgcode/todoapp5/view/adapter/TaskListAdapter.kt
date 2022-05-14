package com.vsgcode.todoapp5.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vsgcode.todoapp5.R
import com.vsgcode.todoapp5.data.model.Task

class TaskListAdapter(private var taskList : List<Task>) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val taskTitleTextView: TextView = itemView.findViewById(R.id.taskTitleTextView);
        val taskDescriptionTextView : TextView = itemView.findViewById(R.id.taskDescriptionTextView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_view_holder, parent, false)
        return TaskViewHolder(view);
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskTitleTextView.text = taskList[position].title;
        holder.taskDescriptionTextView.text = taskList[position].description;

    }

    override fun getItemCount(): Int {
        return taskList.size;
    }

    fun setTaskList(newTaskList : List<Task>){
        taskList = newTaskList;
    }
}