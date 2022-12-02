package com.example.beelineproject.presentation.base

import androidx.annotation.StringRes
import com.example.beelineproject.data.models.AlbumDto


sealed class BaseEvent {
    class ShowToast(val message: String): BaseEvent()
}

sealed class Event: BaseEvent() {
    class ShowTimer(val time: Long): BaseEvent()
    class ShowToast(@StringRes val resId: Int): BaseEvent()
    object ShowLoading: BaseEvent()
    object StopLoading: BaseEvent()
    class PhotosFetched(val albums: List<AlbumDto>) :Event()
}