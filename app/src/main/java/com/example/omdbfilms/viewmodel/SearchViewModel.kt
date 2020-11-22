package com.example.omdbfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.domain.model.SearchModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val model: SearchModel) : ViewModel() {

    private val _searchResults: MutableLiveData<List<FilmDetails>?> = MutableLiveData()
    val searchResults: LiveData<List<FilmDetails>?>
        get() = _searchResults

    private val _clearCacheResult: MutableLiveData<Boolean> = MutableLiveData()
    val clearCacheResult: LiveData<Boolean>
        get() = _clearCacheResult

    fun search(searchString: String) {
        model.getFilms(searchString)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { films: List<FilmDetails>? ->
                _searchResults.postValue(films)
            }
    }

    fun getCachedFilms() {
        model.getCachedFilms()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { films: List<FilmDetails>? ->
                _searchResults.postValue(films)
            }
    }

    fun clearCache() {
        model.clearCache()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _clearCacheResult.postValue(true)
                },
                {
                    _clearCacheResult.postValue(false)
                }
            )
    }
}
