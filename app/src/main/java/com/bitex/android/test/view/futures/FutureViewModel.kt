package com.bitex.android.test.view.futures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitex.android.test.data.repositories.BitexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FutureViewModel @Inject constructor(val repository: BitexRepository) : ViewModel() {


    fun getDate(amount: Int) {
        viewModelScope.launch { repository.getData(amount) }
    }

}