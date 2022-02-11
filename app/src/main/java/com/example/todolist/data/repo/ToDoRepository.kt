package com.example.todolist.data.repo

import com.example.todolist.data.ItemToDo
import com.example.todolist.data.db.ToDoDatabase

class ToDoRepository(
    private val database: ToDoDatabase
) {
    suspend fun update(item: ItemToDo) = database.getItemDAO().update(item)

    suspend fun delete(item: ItemToDo) = database.getItemDAO().DELETE(item)

    fun getAllItemToDo(item: ItemToDo) = database.getItemDAO().getAllItemToDo()
}