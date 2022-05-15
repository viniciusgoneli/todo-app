package com.vsgcode.todoapp5.view.fragments.update

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.vsgcode.todoapp5.R

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

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
}