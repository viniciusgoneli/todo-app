package com.vsgcode.todoapp5.view.fragments.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vsgcode.todoapp5.R
import com.vsgcode.todoapp5.data.model.Priority
import com.vsgcode.todoapp5.data.model.Task
import com.vsgcode.todoapp5.data.viewmodel.SharedViewModel
import com.vsgcode.todoapp5.data.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val mTaskViewModel : TaskViewModel by viewModels();
    private val mSharedViewModel : SharedViewModel by viewModels();

    private lateinit var taskTitleEditText : AppCompatEditText;
    private lateinit var taskPrioritySpinner : AppCompatSpinner;
    private lateinit var taskDescriptionEditText : AppCompatEditText;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        taskTitleEditText = view.findViewById(R.id.add_taskTitleEditText);
        taskPrioritySpinner = view.findViewById(R.id.add_prioritySpinner);
        taskDescriptionEditText = view.findViewById(R.id.add_descriptionEditText);

        setHasOptionsMenu(true);

        return view;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId === R.id.menu_save){
            val title = taskTitleEditText.text.toString();
            val priority = mSharedViewModel.parsePriority(taskPrioritySpinner.selectedItem.toString());
            val description = taskDescriptionEditText.text.toString();

            if(title.isNotEmpty()){
                val task = Task(0, title, priority, description);
                mTaskViewModel.insertTask(task);
                Toast.makeText( requireContext(),
                    "Task saved successfully!", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.action_addFragment_to_listFragment);
            }
            else{
                Toast.makeText( requireContext(),
                    "The task title cannot be empty!", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}