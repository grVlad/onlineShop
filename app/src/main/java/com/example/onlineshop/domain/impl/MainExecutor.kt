package com.example.onlineshop.domain.impl

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.MainStore
import com.example.onlineshop.domain.impl.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseExecutor<in Intent : Any, in Action : Any, in State : Any, Message : Any, Label : Any>(
    mainContext: CoroutineContext = Dispatchers.Main
) : CoroutineExecutor<Intent, Action, State, Message, Label>(mainContext = mainContext) {

    override fun executeIntent(intent: Intent, getState: () -> State) {
        scope.launch {
            suspendExecuteIntent(intent, getState)
        }
    }

    override fun executeAction(action: Action, getState: () -> State) {
        scope.launch {
            suspendExecuteAction(action, getState)
        }
    }

    open suspend fun suspendExecuteIntent(intent: Intent, getState: () -> State) {}
    open suspend fun suspendExecuteAction(action: Action, getState: () -> State) {}
}

class MainExecutor(
    private val repository: Repository
) : BaseExecutor<MainStore.Intent, Nothing, MainStore.State, MainStoreFactory.Message, MainStore.Label>() {

    override suspend fun suspendExecuteIntent(intent: MainStore.Intent, getState: () -> MainStore.State) =
        when (intent) {
            is MainStore.Intent.Load -> loadUserInfo()
            is MainStore.Intent.Help -> help()
        }

    private suspend fun loadUserInfo() {
        dispatch(MainStoreFactory.Message.SetLoading)

        when (val response = repository.getAllProducts()) {
            is Response.Success -> dispatch(MainStoreFactory.Message.SetAllProductList(response.data))
            is Response.Failed -> dispatch(MainStoreFactory.Message.SetError)
        }
    }

    private fun help() {
        publish(MainStore.Label.Help)
    }
}