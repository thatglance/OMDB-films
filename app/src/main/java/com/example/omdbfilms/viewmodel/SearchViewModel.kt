package com.example.omdbfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbfilms.domain.entity.FilmDetails
import com.example.omdbfilms.domain.interactor.SearchInteractor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val interactor: SearchInteractor) : ViewModel() {

    private val _searchResults: MutableLiveData<List<FilmDetails>> = MutableLiveData()
    val searchResults: LiveData<List<FilmDetails>>
        get() = _searchResults

    private val _clearCacheResult: MutableLiveData<Boolean> = MutableLiveData()
    val clearCacheResult: LiveData<Boolean>
        get() = _clearCacheResult

    init {
        getCachedFilms()
    }

    fun search(searchString: String) {
        interactor.getFilms(searchString)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { films: List<FilmDetails>? ->
                _searchResults.postValue(films ?: listOf())
            }
    }

    fun getCachedFilms() {
        interactor.getCachedFilms()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { films: List<FilmDetails>? ->
                _searchResults.postValue(films ?: listOf())
            }
    }

    fun clearCache() {
        interactor.clearCache()
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
