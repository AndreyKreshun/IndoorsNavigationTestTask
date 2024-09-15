package com.example.indoorsnavigation3.data

data class Segment(
    val departure: String, // Время отправления
    val arrival: String, // Время прибытия
    val duration: Int, // Продолжительность в минутах
    val from: Station,
    val to: Station,
    val thread: Thread
)
