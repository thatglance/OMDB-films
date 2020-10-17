package com.example.omdbfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbapi.entity.FilmDetailsJson
import com.example.omdbfilms.model.SearchModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class SearchViewModel : ViewModel() {
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    private val model = SearchModel()

    private val _searchResults: MutableLiveData<List<FilmDetailsJson>> = MutableLiveData()
    val searchResults: LiveData<List<FilmDetailsJson>>
        get() = _searchResults

    fun search(searchString: String) {
        scope.launch {
            val films = model.getFilms(searchString)
            _searchResults.postValue(
                    films.search
            )
        }
    }

}