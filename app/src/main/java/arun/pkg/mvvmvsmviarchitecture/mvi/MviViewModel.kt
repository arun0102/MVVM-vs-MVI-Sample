package arun.pkg.mvvmvsmviarchitecture.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MviViewModel @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = MutableStateFlow(MviState())
    val state: StateFlow<MviState> = _state

    init {
        processIntent(MviIntent.LoadData) // Initial load
    }

    fun processIntent(intent: MviIntent) {
        when (intent) {
            is MviIntent.LoadData -> {
                loadData()
            }
            // Handle other intents
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            withContext(ioDispatcher) {
                delay(5.seconds) // Simulate network call or long-running task
            }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}