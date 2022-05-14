package com.vsgcode.todoapp5.view.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vsgcode.todoapp5.R
import com.vsgcode.todoapp5.data.model.Task
import com.vsgcode.todoapp5.data.viewmodel.TaskViewModel
import com.vsgcode.todoapp5.view.adapter.TaskListAdapter

class ListFragment : Fragment() {

    private val mTaskViewModel : TaskViewModel by  viewModels()

    private lateinit var taskList : RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false);

        taskList = view.findViewById(R.id.recyclerView);

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTaskViewModel.getAllData.observe(this, Observer {
            setupRecyclerView(it);
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment);
        }

        view.findViewById<ConstraintLayout>(R.id.listLayout).setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment);
        }

        setHasOptionsMenu(true);
    }

    private fun setupRecyclerView(list : List<Task>) {
        val layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        taskList.adapter = TaskListAdapter(list);
        taskList.layoutManager = layoutManager;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu);
    }
}