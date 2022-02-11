package com.example.todolist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.data.repo.ToDoRepository

class ToDoLstViewModelFactory(
    private val repository: ToDoRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDoLstViewModel(repository) as T
    }
}