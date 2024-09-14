package com.example.indoorsnavigation3


import DateButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.indoorsnavigation.button.TransportButton
import com.example.indoorsnavigation3.button.TodayTomorrowButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportScheduleScreen(viewModel: TransportScheduleViewModel = viewModel()) {

    // Используем состояние из ViewModel
    val fromText by viewModel.fromText
    val toText by viewModel.toText
    val selectedDate by viewModel.selectedDate
    val selectedTransport by viewModel.selectedTransport

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
                viewModel.updateSelectedDate("Сегодня")
            }
            TodayTomorrowButton(text = "Завтра", selectedDate) {
                viewModel.updateSelectedDate("Завтра")
            }
            DateButton("Дата", selectedDate) { viewModel.updateSelectedDate("Дата") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TransportButton(
                iconResId = R.drawable.any, // Иконка для "любой"
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.any) }
            )
            TransportButton(
                iconResId = R.drawable.plane, // Иконка самолёта
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.plane) }
            )
            TransportButton(
                iconResId = R.drawable.train, // Иконка поезда
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.train) }
            )
            TransportButton(
                iconResId = R.drawable.electric_train, // Иконка электропоезда
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.electric_train) }
            )
            TransportButton(
                iconResId = R.drawable.bus, // Иконка автобуса
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.bus) }
            )
        }

        Button(
            onClick = { /* Логика поиска */ },
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
