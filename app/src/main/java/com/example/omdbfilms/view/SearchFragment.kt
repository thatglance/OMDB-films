package com.example.omdbfilms.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbfilms.R
import com.example.omdbfilms.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var filmsRecycler: RecyclerView
    private lateinit var filmsAdapter: FilmsAdapter

    private lateinit var searchQueryEditText: AppCompatEditText
    private lateinit var searchButton: AppCompatButton

    private val searchViewModel = SearchViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmsRecycler = view.findViewById(R.id.films_recycler)
        searchQueryEditText = view.findViewById(R.id.search_query)
        searchButton = view.findViewById(R.id.perform_search_button)

        searchButton.setOnClickListener {
            searchViewModel.search(searchQueryEditText.text.toString())
        }

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        filmsRecycler.layoutManager = layoutManager
        filmsAdapter = FilmsAdapter(
            mutableListOf(
                FilmDetailsJson(
                    imdbID = "1",
                    title = "Aladdin",
                    year = "2019",
                    type = "supermovie",
                    null,
                    null,
                    "true"
                )
            )
        )
        filmsRecycler.adapter = filmsAdapter

        observeLiveData()
    }

    private fun observeLiveData() {
        searchViewModel.searchResults.observe(viewLifecycleOwner) {
            filmsAdapter.updateItems(it)
        }
    }
}