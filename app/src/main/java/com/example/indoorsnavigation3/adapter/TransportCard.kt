package com.example.indoorsnavigation3.adapter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indoorsnavigation3.R
import com.example.indoorsnavigation3.data.ThreadInfo
import com.example.indoorsnavigation3.data.Transport

@Composable
fun TransportCard(transport: Transport) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row {
                // Иконка транспорта
                when (transport.transportType) {
                    "самолёт" -> Icon(painterResource(R.drawable.plane), contentDescription = null)
                    "поезд" -> Icon(painterResource(R.drawable.train), contentDescription = null)
                    "электричка" -> Icon(painterResource(R.drawable.electric_train), contentDescription = null)
                    "автобус" -> Icon(painterResource(R.drawable.bus), contentDescription = null)
                    else -> Icon(painterResource(R.drawable.any), contentDescription = null)
                }
                // Маршрут
                Text(text = "${transport.thread}", fontWeight = FontWeight.Bold)
            }
            Text(text = transport.transportType)
        }

        Column(modifier = Modifier.weight(1f)) {
            // Время отправления
            Text(text = "Отправление: ${transport.departure}  ")
            // Время прибытия
            Text(text = "Прибытие: ${transport.arrival}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransportCardPreview() {
    val sampleTransport = Transport(
        transportType = "самолёт",  // Тип транспорта
        thread = ThreadInfo(
            number = "6101/6102",  // Номер рейса
            title = "Калуга-1 — Москва (Киевский вокзал)"  // Название маршрута
        ),
        departure = "2024-09-18T06:00:00+03:00",  // Время отправления
        arrival = "2024-09-18T10:00:00+03:00",    // Время прибытия
        fromCode = "s9601907",  // Код станции отправления (Обнинское)
        toCode = "s2000007"     // Код станции прибытия (Киевский вокзал)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TransportCard(transport = sampleTransport)
    }
}