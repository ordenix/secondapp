package com.example.todolist

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.data.db.ToDoDatabase
import com.example.todolist.data.repo.ToDoRepository
import com.example.todolist.ui.ToDoLstViewModel
import com.example.todolist.ui.ToDoLstViewModelFactory

class ToDoApplication: Application() {
    private val database by lazy {ToDoDatabase( this)}
    private val repository by lazy { ToDoRepository(database) }
    val factory by lazy { ToDoLstViewModelFactory(repository) }
}