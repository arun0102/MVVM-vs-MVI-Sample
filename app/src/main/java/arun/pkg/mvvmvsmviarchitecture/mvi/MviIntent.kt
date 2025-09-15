package arun.pkg.mvvmvsmviarchitecture.mvi

sealed class MviIntent {
    object LoadData : MviIntent()
    // Add other intents here, e.g., object RefreshData : MviIntent()
}