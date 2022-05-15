package com.vsgcode.todoapp5.data.viewmodel

import android.app.Application
import android.graphics.Color.red
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.vsgcode.todoapp5.R
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

    val onSpinnerPriorityItemSelectListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            setSpinnerTextViewColorByPosition(position, parent?.getChildAt(0) as TextView)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}

        private fun setSpinnerTextViewColorByPosition(position: Int, textView: TextView?) {
            when (position) {
                0 -> textView?.setTextColor(ContextCompat.getColor(getApplication(), R.color.green))
                1 -> textView?.setTextColor(
                    ContextCompat.getColor(
                        getApplication(),
                        R.color.yellow
                    )
                )
                2 -> textView?.setTextColor(ContextCompat.getColor(getApplication(), R.color.red))
            }
        }
    }
}