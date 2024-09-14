package com.example.indoorsnavigation3


import DateButton
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import com.example.indoorsnavigation.button.TransportButton
import com.example.indoorsnavigation3.button.TodayTomorrowButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportScheduleScreen() {
    var fromText by remember { mutableStateOf("Москва") }
    var toText by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("Сегодня") }
    var selectedTransport by remember { mutableStateOf(R.drawable.any) } // Начальное значение - "любой"


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Расписание пригородного и междугородного транспорта",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        SearchWithReverse()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TodayTomorrowButton(text = "Сегодня", selectedDate) {
                selectedDate = "Сегодня"
            }
            TodayTomorrowButton(text = "Завтра", selectedDate) {
                selectedDate = "Завтра"
            }
            DateButton("Дата", selectedDate) { selectedDate = "Дата" }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TransportButton(
                iconResId = R.drawable.any, // Иконка для "любой" (можете использовать текст или другую иконку)
                selectedTransport = selectedTransport,
                onClick = { selectedTransport = R.drawable.any } // Выбор "любой"
            )

            // Кнопка для самолёта
            TransportButton(
                iconResId = R.drawable.plane, // Иконка самолёта
                selectedTransport = selectedTransport,
                onClick = { selectedTransport = R.drawable.plane } // Выбор самолёта
            )
            TransportButton(
                iconResId = R.drawable.train, // Иконка поезда
                selectedTransport = selectedTransport,
                onClick = { selectedTransport = R.drawable.train }
            )
            TransportButton(
                iconResId = R.drawable.electric_train, // Иконка электропоезда
                selectedTransport = selectedTransport,
                onClick = { selectedTransport = R.drawable.electric_train }
            )
            TransportButton(
                iconResId = R.drawable.bus, // Иконка автобуса
                selectedTransport = selectedTransport,
                onClick = { selectedTransport = R.drawable.bus }
            )
        }

        Button(
            onClick = { /* Search logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
        ) {
            Text(text = "Найти", fontSize = 18.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TransportScheduleScreenPreview() {
    TransportScheduleScreen()
}
