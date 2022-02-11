package com.example.todolist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.data.ItemToDo

@Dao
interface ItemDAO {

    @Query("SELECT * FROM todoList")
    fun getAllItemToDo(): LiveData<List<ItemToDo>>

    @Delete
    suspend fun DELETE(item: ItemToDo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: ItemToDo)

}