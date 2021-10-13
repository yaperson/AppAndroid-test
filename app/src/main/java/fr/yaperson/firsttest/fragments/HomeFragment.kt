package fr.yaperson.firsttest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.yaperson.firsttest.CarModel
import fr.yaperson.firsttest.MainActivity
import fr.yaperson.firsttest.R
import fr.yaperson.firsttest.adapter.CarAdapter
import fr.yaperson.firsttest.adapter.CarItemDecoration

class HomeFragment(
    private val context: MainActivity
    ) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        val carList = arrayListOf<CarModel>()

        carList.add(CarModel(
            "991",
            "forgée dans l'histoire",
            "https://cdn.pixabay.com/photo/2020/10/18/16/45/porsche-5665390__340.jpg",
            true
        ))
        carList.add(CarModel(
            "PT cruiser",
            "Oui c'est moche...",
            "https://cdn.pixabay.com/photo/2017/04/20/00/12/chrysler-pt-cruiser-2244102__340.jpg",
            false
        ))
        carList.add(CarModel(
            "DB 11",
            "La classe a l'anglaise !",
            "https://cdn.pixabay.com/photo/2021/01/31/14/10/aston-martin-5967116__340.jpg",
            false
        ))
        carList.add(CarModel(
            "imprezia",
            "4RM BRAAAAPP STUTUTU !",
            "https://cdn.pixabay.com/photo/2015/05/03/10/29/sports-car-750949__340.jpg",
            true
        ))

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = CarAdapter(context, carList, R.layout.item_horizontal_car)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = CarAdapter(context, carList, R.layout.item_vertical_car)
        verticalRecyclerView.addItemDecoration(CarItemDecoration())

        return view
    }

}