package arun.pkg.mvvmvsmviarchitecture.mvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MviViewModel @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    var state by mutableStateOf(MviState())
        private set

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
            state = state.copy(isLoading = true)
            withContext(ioDispatcher) {
                delay(5.seconds) // Simulate network call or long-running task
            }
            state = state.copy(isLoading = false)
        }
    }
}