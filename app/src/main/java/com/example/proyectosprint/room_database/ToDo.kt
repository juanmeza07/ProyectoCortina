package com.example.proyectosprint.room_database

import androidx.room.*

@Entity
class ToDo (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val TipoC: String,
    val Ancho: String,
    val Largo: String
        )