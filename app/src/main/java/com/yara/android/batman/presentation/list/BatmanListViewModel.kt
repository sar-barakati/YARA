package com.yara.android.batman.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.yara.android.batman.domain.model.Movie
import com.yara.android.batman.domain.use_case.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatmanListViewModel @Inject constructor(private val getMovies: GetMovies) : ViewModel() {

    init {
        getMovies()
    }

    private val _moviesState = MutableStateFlow<List<Movie>>(emptyList())
    val movieState: StateFlow<List<Movie>> = _moviesState

    private fun getMovies() {
        viewModelScope.launch {
            getMovies.invoke().onEach {
                _moviesState.value = it
            }.launchIn(this)
        }
    }

}