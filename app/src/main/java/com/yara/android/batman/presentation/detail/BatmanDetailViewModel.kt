package com.yara.android.batman.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yara.android.batman.domain.model.MovieDetail
import com.yara.android.batman.domain.use_case.GetMovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatmanDetailViewModel @Inject constructor(private val getMovieDetail: GetMovieDetail) :
    ViewModel() {

    private val _movieDetailState = MutableStateFlow(MovieDetail())
    val movieDetailState: StateFlow<MovieDetail> = _movieDetailState

    fun getMovieDetail(imdbID: String) {
        viewModelScope.launch {
            getMovieDetail.invoke(imdbID).onEach {
                _movieDetailState.value = it
            }.launchIn(this)
        }
    }

}