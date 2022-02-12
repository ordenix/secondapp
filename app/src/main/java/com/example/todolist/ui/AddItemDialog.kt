package com.example.todolist.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.R
import com.example.todolist.data.ItemToDo


class AddActivity(var addDialogListener: AddDialogListener): AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_form)

        val button = findViewById<Button>(R.id.add)
        button.setOnClickListener{
            val name = findViewById<EditText>(R.id.editName).text.toString()
            val description = findViewById<EditText>(R.id.editDescription).text.toString()
        val item = ItemToDo(0,name, description, false)
            addDialogListener.onClickAdd(item)

        }
    }
}