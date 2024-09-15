package com.example.indoorsnavigation3.transportschedulescreen

import DateButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.indoorsnavigation.button.TransportButton
import com.example.indoorsnavigation3.R
import com.example.indoorsnavigation3.adapter.TransportCard
import com.example.indoorsnavigation3.button.TodayTomorrowButton
import com.example.indoorsnavigation3.search.SearchWithReverse
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportScheduleScreen(viewModel: TransportScheduleViewModel = viewModel()) {

    // Получаем состояния из ViewModel
    val fromText by viewModel.fromText
    val toText by viewModel.toText
    val selectedDate by viewModel.selectedDate
    val selectedTransport by viewModel.selectedTransport
    val transportData by viewModel.transportData // Данные о транспорте

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
        SearchWithReverse(viewModel)

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
                iconResId = R.drawable.any,
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.any) }
            )
            TransportButton(
                iconResId = R.drawable.plane,
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.plane) }
            )
            TransportButton(
                iconResId = R.drawable.train,
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.train) }
            )
            TransportButton(
                iconResId = R.drawable.electric_train,
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.electric_train) }
            )
            TransportButton(
                iconResId = R.drawable.bus,
                selectedTransport = selectedTransport,
                onClick = { viewModel.updateSelectedTransport(R.drawable.bus) }
            )
        }

        Button(
            onClick = {
                println("Текущие данные для запроса: fromText=$fromText, toText=$toText, selectedDate=$selectedDate, selectedTransport=$selectedTransport")
                viewModel.viewModelScope.launch {
                    // Указываем тип транспорта в зависимости от нажатой кнопки
                    val transportType = when (selectedTransport) {
                        R.drawable.plane -> "plane"
                        R.drawable.train -> "train"
                        R.drawable.electric_train -> "suburban"
                        R.drawable.bus -> "bus"
                        else -> ""
                    }

                    // Выполняем запрос с учетом фильтров
                    viewModel.fetchTransportSchedule(fromText, toText, selectedDate, transportType)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
        ) {
            Text(text = "Найти", fontSize = 18.sp)
        }

        // Вывод данных в табличном виде
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(transportData) { transport ->
                TransportCard(transport)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TransportScheduleScreenPreview() {
    TransportScheduleScreen()
}
