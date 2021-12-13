package com.example.proyectosprint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class Fragmento : Fragment() {

    //private lateinit var listRecyclerView: RecyclerView
    //private lateinit var myAdapter: RecyclerView.Adapter<Adapter.MyViewHolder>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val fragmento: View=inflater.inflate(R.layout.fragment_detail,container, false)
        return fragmento
    }
       /* var Cortina = requireArguments().getString("Cortina")
        var Precio = requireArguments().getString("Precio")
        var Area = requireArguments().getString("Area")
        val textViewTipo: TextView = fragmento.findViewById(R.id.textViewTipo)
        val textViewPrecio: TextView = fragmento.findViewById(R.id.textViewPrecio)
        val textViewArea: TextView = fragmento.findViewById(R.id.textViewArea)
        textViewTipo.text = Cortina
        textViewPrecio.text = Precio
        textViewArea.text = Area
        */


// archivo kt de fragmento fuera de la navegacion del drawer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerTodoList: RecyclerView = view.findViewById(R.id.recyclerToDoList)
        var datos: ArrayList<Task1> = ArrayList()
        val dbFirebase = FirebaseFirestore.getInstance()
        dbFirebase.collection("ToDo").get().addOnSuccessListener {
            for(todo in it) {
                datos.add(Task1( 0, todo.get("title") as String,
                        todo.get("Ancho") as String, todo.get("Largo") as String))
            }
            var taskadapter = Adapter (datos) {
                val datos = Bundle()
                datos.putInt("id", it.id)
                Navigation.findNavController(view).navigate(R.id.nav_details, datos)
        }
            recyclerTodoList.setHasFixedSize(true)
            recyclerTodoList.adapter = taskadapter
            recyclerTodoList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        }

    }



}

            /* val room: ToDoDatabase = Room.databaseBuilder(context?.applicationContext!!, ToDoDatabase::class.java, "ToDoDatabase").build()
             var todoDao = room.todoDao()
             runBlocking {
                 launch {
                     var result = todoDao.getAllTasks()
                     for (todo in result){
                         datos.add(Task1(todo.id, todo.Ancho, todo.Largo))
                     }
                 }
             }*/

/*
        datos.add(Task1(1,"Sheer elegance", "62.000$", "1m²", "Cortina", "0012"))
        datos.add(Task1(2,"Panel Japones", "74.000$", "1.4m²", "Cortina", "0024"))
        datos.add(Task1(3,"BlackOut", "81.000$", "1.3m²", "Cortina", "0036"))
*/


            /*datos.putString("Cortina", it.cortina)
            datos.putString("Area", it.area)
            datos.putString("Precio", it.valor)*/
            //datos.putString("cortina", it.codigo)
