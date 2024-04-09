package dev.lkeey.kmm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.Repository
import data.CountModel
import io.ktor.client.call.body
import io.ktor.util.InternalAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeModel : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val count = _state.asStateFlow()

    private val repository = Repository()

    init {
        viewModelScope.launch {
            repository.getReceiptsFlow("spagetti").collect { result->
                _state.update {
                    it.copy(
                        receipts = result.receipts
                    )
                }
            }
        }
    }
}
