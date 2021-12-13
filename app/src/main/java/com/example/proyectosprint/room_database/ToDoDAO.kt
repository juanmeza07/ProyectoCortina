package com.example.proyectosprint.room_database

import androidx.room.*

@Dao
interface ToDoDAO {
    @Query("SELECT * FROM ToDo")
    suspend fun getAllTasks(): List<ToDo>

    @Query("SELECT * FROM ToDo WHERE id = :id")
    suspend fun findByid(id: String): ToDo

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: ToDo): Long

    @Update
    suspend fun updateTask(task: ToDo)

    @Delete
    suspend fun DeleteTask(task: ToDo)
}
