package com.example.todolist.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.ItemToDo
import com.example.todolist.data.repo.ToDoRepository
import kotlinx.coroutines.launch

class ToDoLstViewModel (
    private val repository: ToDoRepository
        ): ViewModel() {

    val all_data: LiveData<List<ItemToDo>> = repository.all_data.asLiveData()


    fun update(item: ItemToDo) = viewModelScope.launch {
        repository.update(item)
    }

    fun delete(item: ItemToDo) = viewModelScope.launch {
        repository.delete(item)
    }

            //fun getAllItemToDo(item: ItemToDo) = viewModelScope.launch {
         //       repository.getAllItemToDo(item)
          //  }
}