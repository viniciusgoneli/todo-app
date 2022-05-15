package com.vsgcode.todoapp5.view.fragments.update

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vsgcode.todoapp5.R
import com.vsgcode.todoapp5.data.model.Task
import com.vsgcode.todoapp5.data.viewmodel.SharedViewModel
import com.vsgcode.todoapp5.data.viewmodel.TaskViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private val mSharedViewModel : SharedViewModel by viewModels();
    private val mTaskViewModel : TaskViewModel by viewModels();

    private lateinit var taskTitleEditText : AppCompatEditText
    private lateinit var taskDescriptionEditText : AppCompatEditText
    private lateinit var taskPrioritySpinner : AppCompatSpinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        taskTitleEditText = view .findViewById(R.id.update_taskTitleEditText)
        taskDescriptionEditText = view.findViewById(R.id.update_descriptionEditText)
        taskPrioritySpinner = view.findViewById(R.id.update_prioritySpinner);

        setHasOptionsMenu(true);

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskPrioritySpinner.onItemSelectedListener = mSharedViewModel.onSpinnerPriorityItemSelectListener;

        fillFieldsWithArgs(view);
    }

    private fun fillFieldsWithArgs(view : View){
        taskTitleEditText.setText(args.task.title);
        taskDescriptionEditText.setText(args.task.description)
        taskPrioritySpinner.setSelection(args.task.priority.ordinal);
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu, menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_save -> {
                args.task.title = taskTitleEditText.text.toString();
                args.task.priority = mSharedViewModel.parsePriority(taskPrioritySpinner.selectedItem.toString());
                args.task.description = taskDescriptionEditText.text.toString();

                if(args.task.title.isNotEmpty()){
                    mTaskViewModel.updateTask(args.task);
                    Toast.makeText( requireContext(),
                        "Task saved successfully!", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_updateFragment_to_listFragment);
                }
                else{
                    Toast.makeText( requireContext(),
                        "The task title cannot be empty!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}