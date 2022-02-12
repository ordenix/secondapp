package com.example.todolist.other


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.ItemToDo
import com.example.todolist.ui.ToDoLstViewModel
import kotlin.system.exitProcess


class ToDoItemAdapter (
    var items: List<ItemToDo>,
    private val viewModel: ToDoLstViewModel
        ): RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        val currentItem = items[position]

        holder.name.text = currentItem.name
        holder.description.text = currentItem.description

        if (currentItem.status) {
            holder.status.text = "Gotowe!"
        } else holder.status.text = "Nie gotowe!!!"

        holder.buttonDelete.setOnClickListener() {
            viewModel.delete(currentItem)
        }
        holder.buttonChangeState.setOnClickListener() {
            currentItem.status =! currentItem.status
            viewModel.update(currentItem)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val description: TextView
        val status: TextView
        val buttonDelete: Button
        val buttonChangeState: Button

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.Name)
            description = view.findViewById(R.id.description)
            status = view.findViewById(R.id.status)
            buttonDelete = view.findViewById(R.id.delete)
            buttonChangeState = view.findViewById(R.id.change_state)
        }
    }

}