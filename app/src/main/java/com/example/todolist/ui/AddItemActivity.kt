package com.example.todolist.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R
import com.example.todolist.data.ItemToDo
import com.example.todolist.data.db.ToDoDatabase
import com.example.todolist.data.repo.ToDoRepository

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_form)
        //var addDialogListener: AddDialogListener
    }

    fun onClick(view: View) {
        val database = ToDoDatabase( this)
        val repository = ToDoRepository(database)
        val factory = ToDoLstViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ToDoLstViewModel::class.java]
        val name = findViewById<EditText>(R.id.editName).text.toString()
        val description = findViewById<EditText>(R.id.editDescription).text.toString()
        val item = ItemToDo(0,name, description, false)
        viewModel.update(item)
    }
}