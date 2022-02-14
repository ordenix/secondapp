package com.example.todolist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R
import com.example.todolist.ToDoApplication
import com.example.todolist.data.ItemToDo
import com.example.todolist.ui.MainActivity
import com.example.todolist.ui.ToDoLstViewModel


class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.add_form, container, false)
        val button = view?.findViewById<Button>(R.id.add)
        button?.setOnClickListener() {
            onClicked(view)
        }
        val edittext = view?.findViewById<EditText>(R.id.editDescription)
        edittext?.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onClicked(view)
            }
            false
        }
        return view
    }
    private fun onClicked(view: View) {
       val appCtx = activity?.application
        val viewModel = ViewModelProvider(this, (appCtx as ToDoApplication).factory)[ToDoLstViewModel::class.java]
        val name = view.findViewById<EditText>(R.id.editName)?.text.toString()
        val description = view.findViewById<EditText>(R.id.editDescription)?.text.toString()
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(activity, "Wprowadź nazwę lub opis!!", Toast.LENGTH_SHORT).show()
        } else {
            val item = ItemToDo(0,name, description, false)
            viewModel.update(item)
            (activity as MainActivity).setListFragment() //

        }

    }

}