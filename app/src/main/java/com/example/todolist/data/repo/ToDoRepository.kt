package com.example.todolist.data.repo

import com.example.todolist.data.ItemToDo
import com.example.todolist.data.db.ItemDAO
import com.example.todolist.data.db.ToDoDatabase
import kotlinx.coroutines.flow.Flow

class ToDoRepository(
    private val database: ToDoDatabase
) {
    val all_data: Flow<List<ItemToDo>> = database.getItemDAO().getAllItemToDo()

    suspend fun update(item: ItemToDo) = database.getItemDAO().update(item)

    suspend fun delete(item: ItemToDo) = database.getItemDAO().DELETE(item)

    //fun getAllItemToDo(item: ItemToDo) = database.getItemDAO().getAllItemToDo()
}