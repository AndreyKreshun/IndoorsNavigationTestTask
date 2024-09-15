package com.example.indoorsnavigation3.data

data class Transport(
    val transportType: String, // Тип транспорта (самолет, поезд, автобус)
    val thread: String,        // Название рейса или маршрут
    val departure: String,     // Время отправления
    val arrival: String        // Время прибытия
)

