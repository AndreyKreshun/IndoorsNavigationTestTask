package com.example.indoorsnavigation3.adapter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.indoorsnavigation3.R
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
                    "plane" -> Icon(painterResource(R.drawable.plane), contentDescription = null)
                    "train" -> Icon(painterResource(R.drawable.train), contentDescription = null)
                    "suburban" -> Icon(painterResource(R.drawable.electric_train), contentDescription = null)
                    "bus" -> Icon(painterResource(R.drawable.bus), contentDescription = null)
                    else -> Icon(painterResource(R.drawable.any), contentDescription = null)
                }
                // Маршрут
                Text(text = "${transport.thread}", fontWeight = FontWeight.Bold)
            }
            Text(text = transport.transportType)
        }

        Column(modifier = Modifier.weight(1f)) {
            // Время отправления
            Text(text = "Отправление: ${transport.departure}")
            // Время прибытия
            Text(text = "Прибытие: ${transport.arrival}")
        }
    }
}
