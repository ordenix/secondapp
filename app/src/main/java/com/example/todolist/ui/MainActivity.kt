package com.example.todolist.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R
import com.example.todolist.ToDoApplication
import com.example.todolist.ui.fragments.AboutFragment
import com.example.todolist.ui.fragments.AddFragment
import com.example.todolist.ui.fragments.EmptyListFragment
import com.example.todolist.ui.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    var status = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val database = ToDoDatabase( this)
        //val repository = ToDoRepository(database)
        //val factory = ToDoLstViewModelFactory(repository)
        val buttonlist = findViewById<Button>(R.id.ButtonAddTask)
        buttonlist.setOnClickListener() {
            setListFragment()
        }

        if (supportFragmentManager.fragments.isEmpty()) {
                setListFragment()

        }


        //val viewModel = ViewModelProvider(this, (application as ToDoApplication).factory)[ToDoLstViewModel::class.java]

        //val adapter = ToDoItemAdapter(listOf(), viewModel)

        //val rv = findViewById<RecyclerView>(R.id.recyclerView)

        //rv.layoutManager = LinearLayoutManager(this)
        //rv.adapter = adapter

       // viewModel.all_data.observe(this, Observer {
        //    adapter.items = it
         //   adapter.notifyDataSetChanged()
        //})

    }
    fun setAboutFragment(view: View) {
        supportFragmentManager.commit {
            replace<AboutFragment>(R.id.fragmentContainerView2)
            setReorderingAllowed(true)
        }
        status = false
    }
    fun setAddFragment(view: View) {
        status = false
       // Log.d("TAG", "message")
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<AddFragment>(R.id.fragmentContainerView2)
        }
    }
    fun setListFragment() {
        val viewModel = ViewModelProvider(this, (application as ToDoApplication).factory)[ToDoLstViewModel::class.java]

        viewModel.all_data.observe(this, Observer {
            if (it.isEmpty()) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<EmptyListFragment>(R.id.fragmentContainerView2)
                }
                status = false
            } else {
                if (!status) {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<ListFragment>(R.id.fragmentContainerView2)
                    }
                    status = true
                }

            }

            })

    }
}