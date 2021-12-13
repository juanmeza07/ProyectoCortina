package com.example.proyectosprint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.example.proyectosprint.room_database.ToDoDatabase
import androidx.room.*
import com.example.proyectosprint.room_database.ToDo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewTaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewTaskFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spiTask: Spinner = view.findViewById(R.id.spiTask)
        val edtAncho: EditText = view.findViewById(R.id.edtAncho)
        val edtLargo: EditText = view.findViewById(R.id.edtLargo)
        val btnNewTask: Button = view.findViewById(R.id.btnNewTask)
        // var cortinas = arrayOf("Sheer elegance", "Panel japones", "Blackout")
        var cortinas: ArrayList<Task1> = ArrayList()
        cortinas.add(Task1(1, "Sheer elegance", "65.000$", "1.7m²"))
        cortinas.add(Task1(2, "Panel japones", "74.000$", "1.9m²"))
        cortinas.add(Task1(3, "Blackout", "83.000$", "1.4m²"))
        val taskAdapter = ArrayAdapter(context?.applicationContext!!, android.R.layout.simple_spinner_item, cortinas)
        taskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiTask.adapter = taskAdapter
        btnNewTask.setOnClickListener{
            var cortinaselec: Task1 = spiTask.selectedItem as Task1
            val room: ToDoDatabase = Room.databaseBuilder(context?.applicationContext!!, ToDoDatabase::class.java, "ToDoDatabase").build()
            var TodoDao = room.todoDao()
            var cortina = ToDo(0, cortinaselec.cortina, edtAncho.text.toString(), edtLargo.text.toString())
            val dbFirebase = FirebaseFirestore.getInstance()
            runBlocking {
                launch {
                    var result = TodoDao.insertTask(cortina)
                    if (result != -1L){
                        dbFirebase.collection("ToDo").document(result.toString())
                            .set(
                                hashMapOf(
                                    "title" to cortinaselec.cortina,
                                    "Ancho" to edtAncho.text.toString(),
                                    "largo" to edtLargo.text.toString()
                                )
                            )
                    }



                }
                //Toast.makeText(context?.applicationContext!!, ""+result, Toast.LENGTH_LONG).show()
            }
            Navigation.findNavController(view).navigate(R.id.nav_fragmento)

          //  Toast.makeText(context?.applicationContext!!, cortinaselec.area, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewTaskFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewTaskFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}