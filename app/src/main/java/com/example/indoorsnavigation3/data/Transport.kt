package com.example.indoorsnavigation3.data

data class Transport(
    val transportType: String, // Тип транспорта (самолет, поезд, автобус)
    val thread: ThreadInfo,    // Данные о рейсе (номер и маршрут)
    val departure: String,     // Время отправления
    val arrival: String,       // Время прибытия
    val fromCode: String,      // Код станции отправления
    val toCode: String         // Код станции прибытия
)

data class ThreadInfo(
    val number: String,    // Номер рейса
    val title: String      // Полное название маршрута
)

