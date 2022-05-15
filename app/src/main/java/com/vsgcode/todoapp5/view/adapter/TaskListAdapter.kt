package com.vsgcode.todoapp5.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vsgcode.todoapp5.R
import com.vsgcode.todoapp5.data.model.Priority
import com.vsgcode.todoapp5.data.model.Task

class TaskListAdapter() : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    private var taskList = emptyList<Task>()

    inner class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val taskTitleTextView: TextView = itemView.findViewById(R.id.taskTitleTextView);
        val taskDescriptionTextView : TextView = itemView.findViewById(R.id.taskDescriptionTextView);
        val priorityIndicator : CardView = itemView.findViewById(R.id.priorityIndicatorCardView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_view_holder, parent, false)
        return TaskViewHolder(view);
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskTitleTextView.text = taskList[position].title;
        holder.taskDescriptionTextView.text = taskList[position].description;
        setCardBackgroundColorByPriority(holder.priorityIndicator, taskList[position].priority)
    }

    private fun setCardBackgroundColorByPriority(priorityIndicator : CardView, priority: Priority){
        val context = priorityIndicator.context;
        when(priority){
            Priority.HIGH -> priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(context, R.color.red))
            Priority.MEDIUM -> priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
            Priority.LOW -> priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(context, R.color.green))
        }
    }

    override fun getItemCount(): Int {
        return taskList.size;
    }

    fun setTaskList(newTaskList : List<Task>){
        taskList = newTaskList;
        notifyDataSetChanged();
    }
}