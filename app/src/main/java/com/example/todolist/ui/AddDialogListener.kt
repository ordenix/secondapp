package com.example.todolist.ui

import com.example.todolist.data.ItemToDo

interface AddDialogListener {
    fun onClickAdd(item: ItemToDo)
}