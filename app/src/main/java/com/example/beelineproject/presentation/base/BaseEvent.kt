package com.example.beelineproject.presentation.base

import androidx.annotation.StringRes


sealed class BaseEvent {
    class ShowToast(val message: String): BaseEvent()
}


sealed class Event: BaseEvent() {
    object OnAuthSuccess: BaseEvent()
    class ShowTimer(val time: Long): BaseEvent()
    class ShowToast(@StringRes val resId: Int): BaseEvent()
    object ShowLoading: BaseEvent()
    object StopLoading: BaseEvent()
}