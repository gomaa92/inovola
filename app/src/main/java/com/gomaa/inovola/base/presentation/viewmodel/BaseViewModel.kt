package com.gomaa.inovola.base.presentation.viewmodel

import androidx.lifecycle.*
import com.gomaa.inovola.base.data.extensions.toSingleLiveEvent


/**
 * Abstract class used to define Base View model
 * [ViewState] represents the state of the view returned from [reduce]
 * [Action] represents the action of the view to be handled by [handle]
 * [Result] results returned from Use cases to be reduced in viewMode class using [reduce]
 */
abstract class BaseViewModel<S : ViewState, A : Action, R : Result> : ViewModel() {
    /**
     * loaderLiveData [MutableLiveData]<[Boolean]> used to toggle progress loader visibility
     */
    val loaderLiveData = MutableLiveData<Boolean>()

    /**
     * internalViewState instance [ViewState] holds default/initial state of the view
     */
    abstract val internalViewState: S

    /**
     * nextAction [MutableLiveData]<[Action]> used to observe if any action is called
     */
    private val nextAction = MutableLiveData<A>()

    /**
     * Abstract function need to be implemented in order to handle actions from the view
     *
     * @param action the action taken by the user or the system to be handled
     * @return [LiveData]<[Result]> the result of the handled action
     */
    abstract fun handle(action: A): LiveData<R>

    /**
     * Abstract function need to be implemented in order to reduce [Result] to [ViewState]
     *
     * @param result the result returned from handle function
     * @return [ViewState] the view state reduced according to the result
     */
    abstract fun reduce(result: R): S

    /**
     * viewState [LiveData]<[ViewState]>
     */
    val viewState: LiveData<S> = nextAction
        .switchMap {
            loaderLiveData.value = true
            handle(it)
        }.map {
            loaderLiveData.value = false
            reduce(it)
        }.distinctUntilChanged().toSingleLiveEvent()

    /**
     * Function used to be called from the view to dispatch action to viewModel to be handled
     * infix function so you can call it ex: "viewModel dispatch action"
     * @param action [Action] used to set value of [nextAction] to be handled using [viewState] implementation
     */
    infix fun dispatch(action: A) {
        nextAction.value = action
    }

    /**
     * holds current viewState at any given time
     */
    private val currentState: S
        get() = viewState.value ?: internalViewState


}