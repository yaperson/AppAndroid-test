package fr.yaperson.firsttest.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.yaperson.firsttest.CarModel
import fr.yaperson.firsttest.MainActivity
import fr.yaperson.firsttest.R

class CarAdapter(
    private val context: MainActivity,
    private val carList: List<CarModel>,
    private val layoutId: Int) : RecyclerView.Adapter<CarAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val carImage = view.findViewById<ImageView>(R.id.image_item)
        val carName:TextView? = view.findViewById(R.id.name_item)
        val carDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCar = carList[position]

        // utiliser Glide pour recup l'img a partir de sont lien -> composant
        Glide.with(context).load(Uri.parse(currentCar.imageUrl)).into(holder.carImage)

        // mettre a jour le nom et description de la voiture
        holder.carName?.text = currentCar.name
        holder.carDescription?.text = currentCar.description

        // Verifier si like est appliqué
        if (currentCar.liked){
            holder.starIcon.setImageResource(R.drawable.ic_like)
        } else {
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }

    }

    override fun getItemCount(): Int = carList.size

}