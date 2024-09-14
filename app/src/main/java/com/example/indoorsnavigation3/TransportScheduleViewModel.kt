package com.example.indoorsnavigation3

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class TransportScheduleViewModel : ViewModel() {

    // Поля для управления состоянием экрана
    private val _fromText = mutableStateOf("Москва")
    val fromText: State<String> = _fromText

    private val _toText = mutableStateOf("")
    val toText: State<String> = _toText

    private val _selectedDate = mutableStateOf("Сегодня")
    val selectedDate: State<String> = _selectedDate

    private val _selectedTransport = mutableStateOf(R.drawable.any)
    val selectedTransport: State<Int> = _selectedTransport

    // Методы для обновления состояния
    fun updateFromText(newFromText: String) {
        _fromText.value = newFromText
    }

    fun updateToText(newToText: String) {
        _toText.value = newToText
    }

    fun updateSelectedDate(newDate: String) {
        _selectedDate.value = newDate
    }

    fun updateSelectedTransport(newTransport: Int) {
        _selectedTransport.value = newTransport
    }
}
