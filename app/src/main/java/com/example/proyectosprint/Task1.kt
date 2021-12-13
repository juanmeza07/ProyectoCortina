package com.example.proyectosprint

data class Task1(val id: Int, val cortina: String, val Ancho: String,val Largo:String,/*, val area: String, val detalle: String, val codigo: String*/){
    override fun toString(): String {
        return cortina
    }
}
