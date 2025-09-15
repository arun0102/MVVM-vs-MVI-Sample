package arun.pkg.mvvmvsmviarchitecture.mvi

sealed interface MviAction {
    object GoToDetails: MviAction
}