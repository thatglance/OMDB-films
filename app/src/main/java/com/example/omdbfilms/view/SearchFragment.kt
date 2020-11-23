package com.example.omdbfilms.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbfilms.App
import com.example.omdbfilms.R
import com.example.omdbfilms.adapter.FilmsAdapter
import com.example.omdbfilms.viewmodel.SearchViewModel
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var filmsRecycler: RecyclerView
    private lateinit var filmsAdapter: FilmsAdapter

    private lateinit var searchQueryEditText: AppCompatEditText
    private lateinit var searchButton: AppCompatButton
    private lateinit var clearCacheButton: AppCompatButton

    private lateinit var emptyListTextView: TextView

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (context?.applicationContext as App).appComponent.inject(this)
        searchViewModel = viewModelFactory.create(SearchViewModel::class.java)
    }

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
        clearCacheButton = view.findViewById(R.id.clear_cache_button)
        emptyListTextView = view.findViewById(R.id.empty_list_text_view)

        searchButton.setOnClickListener {
            searchViewModel.search(searchQueryEditText.text.toString())
        }

        clearCacheButton.setOnClickListener {
            searchViewModel.clearCache()
        }

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        filmsRecycler.layoutManager = layoutManager
        filmsAdapter = FilmsAdapter()
        filmsRecycler.adapter = filmsAdapter

        observeLiveData()
    }

    private fun observeLiveData() {
        searchViewModel.searchResults.observe(viewLifecycleOwner) { films ->
            if (films.isNotEmpty()) {
                emptyListTextView.visibility = View.GONE
                filmsAdapter.setItems(films)
            } else {
                emptyListTextView.visibility = View.VISIBLE
                filmsAdapter.clear()
                Toast.makeText(context, R.string.no_result_message, Toast.LENGTH_LONG).show()
            }
        }
        searchViewModel.clearCacheResult.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(context, R.string.cache_cleared_message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
