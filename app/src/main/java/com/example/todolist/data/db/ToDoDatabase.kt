package com.example.todolist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.data.ItemToDo

@Database(
    entities = [ItemToDo::class],
    version = 1 //
)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun getItemDAO(): ItemDAO

    companion object {
        @Volatile
        private var instance: ToDoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ToDoDatabase::class.java, "ToDO_DB.db").build()
    }
}