package com.example.onlineshop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.example.onlineshop.LiveEvent
import com.example.onlineshop.common.Mapper
import com.example.onlineshop.domain.api.MainStore
import com.example.onlineshop.presentation.model.UiMainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class MainViewModel constructor(
    private val store: MainStore,
    private val stateMapper: Mapper<MainStore.State, UiMainState>,
) : ViewModel() {

    private val _label = LiveEvent<String>()
    val label: LiveData<String> = _label

    val state: StateFlow<UiMainState>
        get() = mutableState.asStateFlow()

    private val initialState = UiMainState()

    private val mutableState = MutableStateFlow(initialState)

    private val binder: Binder

    init {
        binder = bind(Dispatchers.Main.immediate) {
            store.states.map(stateMapper::map) bindTo (::acceptState)
            store.labels.bindTo(::acceptLabel)
        }
        binder.start()

        load()
    }

    override fun onCleared() {
        super.onCleared()
        binder.stop()
        store.dispose()
    }

    fun load() = store.accept(MainStore.Intent.Load)

    fun help() = store.accept(MainStore.Intent.Help)

    private fun acceptState(state: UiMainState) {
        mutableState.value = state
    }

    private fun acceptLabel(label: MainStore.Label) {
        when (label) {
            is MainStore.Label.Help -> _label.value = "Функция в разработке"
        }
    }
}