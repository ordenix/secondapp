package com.example.todolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R
import com.example.todolist.data.db.ToDoDatabase
import com.example.todolist.data.repo.ToDoRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ToDoDatabase( this)
        val repository = ToDoRepository(database)
        val factory = ToDoLstViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[ToDoLstViewModel::class.java]
    }
}