package com.fineteklabs.spacetutorial

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fineteklabs.spacetutorial.entity.RocketLaunch
import kotlinx.coroutines.launch

class RocketLaunchViewModel(private val sdk: SpaceXSDK) : ViewModel() {
    private val _state = mutableStateOf(RocketLaunchScreenState())
    val state: State<RocketLaunchScreenState> = _state

    fun loadLaunches() {
        viewModelScope.launch {
            //pending
            _state.value = _state.value.copy(isLoading = true, launches = emptyList())
            try {
                //fulfilled
                val launches = sdk.getLaunches(forceReload = true)
                _state.value = _state.value.copy(isLoading = false, launches = launches)
            } catch (e: Exception) {
                println(e)
                //rejected
                _state.value = _state.value.copy(isLoading = false, launches = emptyList())
            }
        }
    }
    init {
        loadLaunches()
    }

}

data class RocketLaunchScreenState(
    val isLoading: Boolean = false,
    val launches: List<RocketLaunch> = emptyList()
)