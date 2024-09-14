package com.example.indoorsnavigation3


import DateButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    var selectedTransport by remember { mutableStateOf("любой") }

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
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = toText,
                onValueChange = { toText = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            /*Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = "Change Direction",
                modifier = Modifier.size(24.dp)
            )*/
        }

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
            TransportButton("любой", selectedTransport) { selectedTransport = "любой" }
            TransportButton("самолёт", selectedTransport) { selectedTransport = "самолёт" }
            TransportButton("поезд", selectedTransport) { selectedTransport = "поезд" }
            TransportButton("электричка", selectedTransport) { selectedTransport = "электричка" }
            //TransportButton("автобус", selectedTransport) { selectedTransport = "автобус" }
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
