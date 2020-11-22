package com.example.omdbfilms.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.R

class FilmsAdapter :
    RecyclerView.Adapter<FilmViewHolder>() {

    private val films: MutableList<FilmDetails> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.film_card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.render(films[position])
    }

    override fun getItemCount(): Int = films.size

    fun setItems(newItems: List<FilmDetails>) {
        films.clear()
        films.addAll(newItems)
        notifyDataSetChanged()
    }

    fun clear() {
        films.clear()
        notifyDataSetChanged()
    }
}

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun render(item: FilmDetails) {
        itemView.findViewById<TextView>(R.id.film_title).text = item.title
        itemView.findViewById<TextView>(R.id.film_year).text = item.year
        itemView.findViewById<TextView>(R.id.film_type).text = item.type
    }
}
