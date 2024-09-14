package com.example.indoorsnavigation3.transportschedulescreen

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.indoorsnavigation3.R

class TransportScheduleViewModel : ViewModel() {
    // MutableState для хранения значений текстов
    var fromText = mutableStateOf("")
        private set
    var toText = mutableStateOf("")
        private set

    var selectedDate = mutableStateOf("Сегодня")
        private set
    var selectedTransport = mutableStateOf(R.drawable.any)
        private set

    // Обновление текстов
    fun updateFromText(newFromText: String) {
        fromText.value = newFromText
    }

    fun updateToText(newToText: String) {
        toText.value = newToText
    }

    // Обратная замена мест отправления и прибытия
    fun reverseFromTo() {
        val temp = fromText.value
        fromText.value = toText.value
        toText.value = temp
    }

    fun updateSelectedDate(newDate: String) {
        selectedDate.value = newDate
    }

    fun updateSelectedTransport(newTransport: Int) {
        selectedTransport.value = newTransport
    }
}

