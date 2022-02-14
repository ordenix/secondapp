package com.example.todolist.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.ToDoApplication
import com.example.todolist.other.ToDoItemAdapter
import com.example.todolist.ui.ToDoLstViewModel


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val appCtx = activity?.application
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(this, (appCtx as ToDoApplication).factory)[ToDoLstViewModel::class.java]

        val adapter = ToDoItemAdapter(listOf(), viewModel)

        val rv = view.findViewById<RecyclerView>(R.id.recyclerVw)

        rv.layoutManager = LinearLayoutManager(appCtx)
        rv.adapter = adapter

        viewModel.all_data.observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        return view
    }

}