package com.example.omdbfilms.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbfilms.R
import kotlinx.android.synthetic.main.film_view_holder.view.*

class FilmsAdapter(private val films: MutableList<FilmDetailsJson>) :
    RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.film_view_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.render(films[position])
    }

    override fun getItemCount(): Int = films.size

    fun updateItems(newItems: List<FilmDetailsJson>) {
        films.clear()
        films.addAll(newItems)
        notifyDataSetChanged()
    }
}

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun render(item: FilmDetailsJson) {
        itemView.findViewById<TextView>(R.id.film_title).text = item.title
        itemView.findViewById<TextView>(R.id.film_year).text = item.year
        itemView.findViewById<TextView>(R.id.film_type).text = item.type
    }
}
//TODO:  2) view holder class 3) implement all methods in adapter