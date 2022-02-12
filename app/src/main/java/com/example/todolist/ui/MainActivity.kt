package com.example.todolist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.db.ToDoDatabase
import com.example.todolist.data.repo.ToDoRepository
import com.example.todolist.other.ToDoItemAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ToDoDatabase( this)
        val repository = ToDoRepository(database)
        val factory = ToDoLstViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[ToDoLstViewModel::class.java]

        val adapter = ToDoItemAdapter(listOf(), viewModel)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        viewModel.all_data.observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

    }
    fun start2Act(view: View) {
        val activity2 = Intent(this, AddItemActivity::class.java).apply {
            //putExtra(TEXT_TO_SEND, input_text_name)
        }
        startActivity(activity2)
    }
}