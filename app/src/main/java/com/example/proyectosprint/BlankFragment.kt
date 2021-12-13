package com.example.proyectosprint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.room.Room
import com.example.proyectosprint.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
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
        val fragmento: View=inflater.inflate(R.layout.fragment_detail,container, false)

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

        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewTipo: TextView = view.findViewById(R.id.textViewTipo)
        val textViewPrecio: TextView = view.findViewById(R.id.textViewPrecio)
        val textViewArea: TextView = view.findViewById(R.id.textViewArea)
        var id = requireArguments().getInt("id").toString()
        val room: ToDoDatabase = Room.databaseBuilder(context?.applicationContext!!,
            ToDoDatabase::class.java, "ToDoDatabaase").build()
        var todoDao = room.todoDao()
        runBlocking {
            launch {
                var resut = todoDao.findByid(id)

                textViewTipo.text = resut.TipoC
                textViewArea.text = resut.Ancho
                textViewPrecio.text = resut.Largo

            }
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}